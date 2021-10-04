/*
  @author: 夏天
  @date: 2021/09/14 11:23:30
*/

package cn.rental.controller;

import cn.rental.bean.*;
import cn.rental.service.AdminService;
import cn.rental.service.HirerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/hirer")
public class HirerController {
    @Autowired
    private HirerService hirerService;

    @Autowired
    private AdminService adminService;

    //点击“待租车辆”,返回到主页面，即hirer_index.html
    @GetMapping("/index")
    public ModelAndView index(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals((String) httpSession.getAttribute("user_status"))) {
            List<Vehicle> vehicleList = hirerService.getRentingVehicle();
            modelAndView.addObject("vehicle_list", vehicleList);
            modelAndView.setViewName("hirer_index");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    //点击租车发送请求，创建订单
    @PostMapping("/to_rent")
    @ResponseBody
    public String to_rent(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            String vehicle_id = (String) httpServletRequest.getParameter("v_id");
            String vehicle_type = (String) httpServletRequest.getParameter("tp");
            String vehicle_brand = (String) httpServletRequest.getParameter("brand");
            String owner_name = (String) httpServletRequest.getParameter("owner");
            System.out.println(vehicle_brand + vehicle_id + owner_name + vehicle_type);
            //首先查询是否已有订单正在进行
            Order order = new Order();
            order.setHIRER_NAME((String) httpSession.getAttribute("user_name"));
            order.setVEHICLE_ID(vehicle_id);
            order.setSTATUS(0);
            List<Order> orderList = hirerService.getOrdersByStatus(order);
            order.setSTATUS(1);
            orderList.addAll(hirerService.getOrdersByStatus(order));
            //如果没有正在进行的订单，则创建订单
            if (orderList == null || orderList.size() == 0) {
                Order order1 = new Order();
                order1.setOWNER_NAME(owner_name);
                order1.setHIRER_NAME((String) httpSession.getAttribute("user_name"));
                order1.setVEHICLE_TYPE(vehicle_type);
                order1.setSTATUS(0);
                order1.setVEHICLE_ID(vehicle_id);
                order1.setVEHICLE_BRAND(vehicle_brand);
                hirerService.addOneOrder(order1);
                return "true";
            } else {
                return "false";
            }
        } else {
            return "false";
        }
    }

    //查看所有订单
    @RequestMapping("/all_orders")
    public ModelAndView allOrders(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            Hirer hirer = new Hirer();
            hirer.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Order> orderList = hirerService.getAllOrders(hirer);
            modelAndView.addObject("orderList", orderList);
            modelAndView.addObject("para", 0);
            modelAndView.setViewName("hirer_orders");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    //查看当前订单
    @RequestMapping("/current_orders")
    public ModelAndView current(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            Hirer hirer = new Hirer();
            hirer.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Order> orderList = hirerService.getCurrentOrders(hirer);
            modelAndView.addObject("orderList", orderList);
            modelAndView.addObject("para", 1);
            modelAndView.setViewName("hirer_orders");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    //结束订单
    @RequestMapping("/cancel")
    public ModelAndView cancel(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        System.out.println("进入cancel");
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            Order order = new Order();
            Vehicle vehicle = new Vehicle();
            int order_id = Integer.valueOf((String) httpServletRequest.getParameter("ORDER_ID"));
            String status = httpServletRequest.getParameter("STATUS");
            String vehicle_id = httpServletRequest.getParameter("VEHICLE_ID");
            order.setORDER_ID(order_id);
            System.out.println(order_id);
            vehicle.setVEHICLE_ID(vehicle_id);
            System.out.println(vehicle_id);
            Order order1 = hirerService.getOrderById(order);
            Vehicle vehicle1 = hirerService.getVehicleById(vehicle);
            Date date = order1.getSTART_TIME();
            System.out.println(order1.toString());
            //表示还未得到车主确认，可直接取消
            if ("0".equals(status)) {
                System.out.println("进入0");
                order.setORDER_ID(order_id);
                hirerService.cancel(order);
            }
            //正在进行，则申请还车
            else if ("1".equals(status)) {
                System.out.println("进入1");
                order.setORDER_ID(order_id);
                Date current = new Date();
                double hour = (int) ((current.getTime() - date.getTime()) / (1000 * 60 * 60));
                System.out.println(hour);
                double income = hour * vehicle1.getRENTAL_PRICE() * 1.0;
                System.out.println(income);
                Order order2 = new Order();
                order2.setORDER_ID(order_id);
                order2.setAMOUNT(income);
                order2.setEND_TIME(current);
                hirerService.over(order2);
                //如果超时，则扣除10分信誉分
                Date deadline = vehicle1.getDEADLINE();
                if (current.after(deadline)) {
                    Hirer hirer = new Hirer();
                    hirer.setUSER_NAME((String) httpSession.getAttribute("user_name"));
                    UserInfo userInfo = hirerService.getInfo((String) httpSession.getAttribute("user_name"));
                    int credit = (userInfo.getCREDIT() - 10) > 0 ? (userInfo.getCREDIT() - 10) : 0;
                    hirer.setCREDIT(credit);
                    hirerService.updateCredit(hirer);
                }
                // 更新车辆租赁时长数
                int duration = vehicle1.getDURATION() + (int) hour;
                vehicle1.setDURATION(duration);
                hirerService.updateDuration(vehicle1);
            }
            Hirer hirer = new Hirer();
            hirer.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Order> orderList = hirerService.getCurrentOrders(hirer);
            modelAndView.addObject("orderList", orderList);
            modelAndView.addObject("para", 1);
            modelAndView.setViewName("hirer_orders");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    // 到留言列表
    @RequestMapping("/message_list")
    public ModelAndView message_list(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            Hirer hirer = new Hirer();
            hirer.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Message> messageList = hirerService.getMessageList(hirer);
            modelAndView.addObject("messageList", messageList);
            modelAndView.setViewName("hirer_message");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    //更新留言状态
    @RequestMapping("/updateMsgStatus")
    @ResponseBody
    public String updateMsgStatus(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            Integer MESSAGE_ID = Integer.valueOf((String) httpServletRequest.getParameter("MESSAGE_ID"));
            String send = (String) httpServletRequest.getParameter("send");
            String username = (String) httpSession.getAttribute("user_name");
            //自己是发送方则不改变
            if (username.equals(send)) {
                return "true";
            }
            Message message = new Message();
            message.setMESSAGE_ID(MESSAGE_ID);
            hirerService.updateMsgStatus(message);
            return "true";
        } else {
            return "false";
        }
    }

    // 回复留言
    @RequestMapping("/toMsgReply")
    public ModelAndView toMsgReply(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            String receive = (String) httpServletRequest.getParameter("receive");
            System.out.println("---here---" + receive);
            modelAndView.addObject("receive", receive);
            modelAndView.setViewName("hirer_reply_msg");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    //发送留言
    @PostMapping("/msgReply")
    public ModelAndView msgReply(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            //获取参数并去插入一条留言
            String send = (String) httpSession.getAttribute("user_name");
            String receive = (String) httpServletRequest.getParameter("receive");
            String content = (String) httpServletRequest.getParameter("content");
            System.out.println("----" + send + receive + content + (String) httpServletRequest.getParameter("send"));
            Message message = new Message();
            message.setSEND_NAME(send);
            message.setRECEIVE_NAME(receive);
            message.setDETAIL(content);
            message.setSEND_TIME(new Date());
            message.setSTATUS(0);
            hirerService.addMsg(message);
            //获取留言列表返回列表页面
            Hirer hirer = new Hirer();
            hirer.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Message> messageList = hirerService.getMessageList(hirer);
            modelAndView.addObject("messageList", messageList);
            modelAndView.setViewName("hirer_message");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    // 发留言
    @RequestMapping("/to_send")
    public ModelAndView to_send(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            modelAndView.setViewName("hirer_reply_msg");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    // 联系管理员
    @RequestMapping("/toAdmin")
    public ModelAndView toAdmin(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            List<AdminInfo> adminInfoList = adminService.getAdminInfos();
            modelAndView.addObject("adminInfoList", adminInfoList);
            modelAndView.setViewName("hirer_with_admin");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }


}
