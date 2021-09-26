package cn.rental.controller;

import cn.rental.bean.*;
import cn.rental.service.AdminService;
import cn.rental.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

//该类负责owner所发出的请求处理

@Controller
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @Autowired
    private AdminService adminService;

    //获取所有订单
    @RequestMapping("/index")
    public ModelAndView index(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals((String) httpSession.getAttribute("user_status"))) {
            Owner owner = new Owner();
            owner.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Order> orderList = ownerService.getAllOrders(owner);
            modelAndView.addObject("orderList", orderList);
            modelAndView.setViewName("owner_index");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    //获取需要确认的订单
    @RequestMapping("/orders_0")
    public ModelAndView orders_0(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals((String) httpSession.getAttribute("user_status"))) {
            Owner owner = new Owner();
            owner.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Order> orderList = ownerService.getOrders_0(owner);
            modelAndView.addObject("orderList", orderList);
            modelAndView.addObject("opt", 1);
            modelAndView.setViewName("owner_index");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    //获取需要确认还车的订单
    @RequestMapping("/orders_2")
    public ModelAndView orders_2(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals((String) httpSession.getAttribute("user_status"))) {
            Owner owner = new Owner();
            owner.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Order> orderList = ownerService.getOrders_2(owner);
            modelAndView.addObject("orderList", orderList);
            modelAndView.addObject("opt", 2);
            modelAndView.setViewName("owner_index");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    //确认租车/还车
    @RequestMapping("/confirm")
    public ModelAndView confirm_1(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals((String) httpSession.getAttribute("user_status"))) {
            String ORDER_ID = (String) httpServletRequest.getParameter("ORDER_ID");
            String opt = (String) httpServletRequest.getParameter("opt");
            String VEHICLE_ID = (String) httpServletRequest.getParameter("VEHICLE_ID");
            Order order = new Order();
            order.setORDER_ID(Integer.parseInt(ORDER_ID));
            //更新车辆状态
            Vehicle vehicle = new Vehicle();
            vehicle.setVEHICLE_ID(VEHICLE_ID);
            if ("1".equals(opt)) {
                order.setSTART_TIME(new Date());
                ownerService.confirm_1(order);
                //变为已租
                vehicle.setSTATUS(1);
                ownerService.updateVehicleStatus(vehicle);
            } else if ("2".equals(opt)) {
                order.setEND_TIME(new Date());
                ownerService.confirm_2(order);
                //变为在租
                vehicle.setSTATUS(0);
                ownerService.updateVehicleStatus(vehicle);
            }
            Owner owner = new Owner();
            owner.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Order> orderList = ownerService.getAllOrders(owner);
            modelAndView.addObject("orderList", orderList);
            modelAndView.setViewName("owner_index");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    //拒绝租车
    @RequestMapping("/refuse")
    public ModelAndView refuse(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals((String) httpSession.getAttribute("user_status"))) {
            String ORDER_ID = (String) httpServletRequest.getParameter("ORDER_ID");
            Order order = new Order();
            order.setORDER_ID(Integer.parseInt(ORDER_ID));
            ownerService.refuse(order);
            Owner owner = new Owner();
            owner.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Order> orderList = ownerService.getAllOrders(owner);
            modelAndView.addObject("orderList", orderList);
            modelAndView.setViewName("owner_index");
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
            Owner owner = new Owner();
            owner.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Message> messageList = ownerService.getMessageList(owner);
            modelAndView.addObject("messageList", messageList);
            modelAndView.setViewName("owner_message");
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
            Message message = new Message();
            message.setMESSAGE_ID(MESSAGE_ID);
            ownerService.updateMsgStatus(message);
            System.out.println(message + "------------");
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
            modelAndView.setViewName("owner_reply_msg");
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
            ownerService.addMsg(message);
            //获取留言列表返回列表页面
            Owner owner = new Owner();
            owner.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Message> messageList = ownerService.getMessageList(owner);
            modelAndView.addObject("messageList", messageList);
            modelAndView.setViewName("owner_message");
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
            modelAndView.setViewName("owner_reply_msg");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    //去添加、修改车辆信息
    @RequestMapping("/modify")
    public String modify(HttpSession httpSession) {
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            return "add_vehicle";
        } else {
            return "login";
        }
    }

    // 添加/修改车辆信息
    @RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            String VEHICLE_ID = (String) httpServletRequest.getParameter("VEHICLE_ID");
            String VEHICLE_BRAND = (String) httpServletRequest.getParameter("VEHICLE_BRAND");
            String VEHICLE_TYPE = (String) httpServletRequest.getParameter("VEHICLE_TYPE");
            String time = (String) httpServletRequest.getParameter("time");
            String RENTAL_PRICE = (String) httpServletRequest.getParameter("RENTAL_PRICE");
            String LOCATION = (String) httpServletRequest.getParameter("LOCATION");
            //时间转换
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.parse(time.replaceAll("T", " ") + ":00", df);
            System.out.println(localDateTime + "   localDateTime格式的时间");
            Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
            //查询车辆是否已存在
            Vehicle vehicle0 = new Vehicle();
            vehicle0.setVEHICLE_ID(VEHICLE_ID);
            Vehicle vehicle = ownerService.getVehicleById(vehicle0);
            //不存在,则增加
            if (vehicle == null) {
                vehicle0.setVEHICLE_ID(VEHICLE_ID);
                vehicle0.setVEHICLE_TYPE(VEHICLE_TYPE);
                vehicle0.setVEHICLE_BRAND(VEHICLE_BRAND);
                vehicle0.setOWNER_ID((String) httpSession.getAttribute("user_name"));
                vehicle0.setDURATION(0);
                vehicle0.setSTATUS(0);
                vehicle0.setRENTAL_PRICE(Double.parseDouble(RENTAL_PRICE));
                vehicle0.setDEADLINE(date);
                vehicle0.setLOCATION(LOCATION);
                ownerService.addVehicle(vehicle0);
            }
            //存在，则更新
            else {
                vehicle0.setVEHICLE_ID(VEHICLE_ID);
                vehicle0.setVEHICLE_TYPE(VEHICLE_TYPE);
                vehicle0.setVEHICLE_BRAND(VEHICLE_BRAND);
                vehicle0.setRENTAL_PRICE(Double.parseDouble(RENTAL_PRICE));
                vehicle0.setDEADLINE(date);
                vehicle0.setLOCATION(LOCATION);
                ownerService.modify(vehicle0);
            }
            return "true";
        } else {
            return "false";
        }
    }

    // 联系管理员
    @RequestMapping("/toAdmin")
    public ModelAndView toAdmin(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            List<AdminInfo> adminInfoList = adminService.getAdminInfos();
            modelAndView.addObject("adminInfoList", adminInfoList);
            modelAndView.setViewName("owner_with_admin");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }


}
