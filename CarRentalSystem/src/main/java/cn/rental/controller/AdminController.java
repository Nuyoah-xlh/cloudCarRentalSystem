package cn.rental.controller;

import cn.rental.bean.*;
import cn.rental.service.AdminService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.management.openmbean.TabularType;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//该类负责admin在管理后台时所发出的请求处理

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    //返回管理员的相关信息
    @GetMapping("/admin_list")
    public ModelAndView getAdminList(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        //检测到未登录就返回登录,否则正常返回数据
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            List<AdminInfo> adminInfoList = adminService.getAdminInfos();
            modelAndView.addObject("adminInfoList", adminInfoList);
            modelAndView.setViewName("admin_list");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    //获取所有租车人信息
    @GetMapping("/hirer_list")
    public ModelAndView hirer_list(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            List<Hirer> hirerList = adminService.getHirerList();
            modelAndView.addObject("hirerList", hirerList);
            modelAndView.setViewName("hirer");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    //获取车主信息
    @GetMapping("/owner_list")
    public ModelAndView owner_list(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            List<Owner> ownerList = adminService.getOwnerList();
            modelAndView.addObject("ownerList", ownerList);
            modelAndView.setViewName("owner");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    //获取黑名单信息
    @GetMapping("/blacklist")
    public ModelAndView blacklist(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            List<UserInfo> userInfoList = new ArrayList<>();
            userInfoList.addAll(adminService.getBlackList_Hirer());
            userInfoList.addAll(adminService.getBlackList_Owner());
            modelAndView.addObject("blacklist", userInfoList);
            modelAndView.setViewName("blacklist");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    //获取所有车辆信息
    @GetMapping("/vehicle_list")
    public ModelAndView vehicleList(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            List<Vehicle> vehicleList = adminService.getVehicleList();
            modelAndView.addObject("vehicle_list", vehicleList);
            modelAndView.setViewName("vehicleList");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    //获取所有车辆信息
    @GetMapping("/vehicle_list_rent")
    public ModelAndView vehicle_list_rent(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            Integer STATUS = Integer.valueOf((String) httpServletRequest.getParameter("status"));
            List<Vehicle> vehicleList = adminService.getVehicleListByStatus(STATUS);
            if (httpServletRequest.getParameter("opt") != null) {
                String opt = (String) httpServletRequest.getParameter("opt");
                if ("up".equals(opt)) {
                    modelAndView.addObject("opt", "up");
                } else if ("down".equals(opt)) {
                    modelAndView.addObject("opt", "down");
                }
            }
            modelAndView.addObject("vehicle_list", vehicleList);
            modelAndView.setViewName("vehicleList");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    @GetMapping("/updateVehById")
    public ModelAndView updateVehById(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            //获取要修改数据的车牌号和要更改到的状态
            String VEHICLE_ID = (String) httpServletRequest.getParameter("VEHICLE_ID");
            Integer veh_status = Integer.valueOf((String) httpServletRequest.getParameter("veh_status"));
            Vehicle vehicle = new Vehicle();
            vehicle.setVEHICLE_ID(VEHICLE_ID);
            vehicle.setSTATUS(veh_status);
            adminService.setVehicleStatusById(vehicle);
            if (httpServletRequest.getParameter("opt") != null) {
                String opt = (String) httpServletRequest.getParameter("opt");
                List<Vehicle> vehicleList = null;
                if ("up".equals(opt)) {
                    modelAndView.addObject("opt", "up");
                    vehicleList = adminService.getVehicleListByStatus(2);
                } else if ("down".equals(opt)) {
                    modelAndView.addObject("opt", "down");
                    vehicleList = adminService.getVehicleListByStatus(0);
                }
                modelAndView.addObject("vehicle_list", vehicleList);
                modelAndView.setViewName("vehicleList");
            } else {
                modelAndView.setViewName("404");
            }
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    //返回所有订单信息
    @GetMapping("/all_order")
    public ModelAndView all_order(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            List<Order> orderList = adminService.getAllOrders();
            modelAndView.addObject("orderList", orderList);
            modelAndView.setViewName("orderList");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    //返回当前订单信息
    @GetMapping("/current_order")
    public ModelAndView current_order(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            List<Order> orderList = adminService.getCurrentOrders();
            modelAndView.addObject("orderList", orderList);
            modelAndView.setViewName("orderList");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    //返回本人相关的所有留言信息
    @GetMapping("/message_list")
    public ModelAndView message_list(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            AdminInfo adminInfo = new AdminInfo();
            adminInfo.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Message> messageList = adminService.getMessageList(adminInfo);
            modelAndView.addObject("messageList", messageList);
            modelAndView.setViewName("message_list");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    //更新留言状态
    @GetMapping("/updateMsgStatus")
    @ResponseBody
    public String updateMsgStatus(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            Integer MESSAGE_ID = Integer.valueOf((String) httpServletRequest.getParameter("MESSAGE_ID"));
            String send = (String) httpServletRequest.getParameter("send");
            String username = (String) httpSession.getAttribute("user_name");
            if (username.equals(send)) {
                return "true";
            }
            Message message = new Message();
            message.setMESSAGE_ID(MESSAGE_ID);
            adminService.updateMsgStatus(message);
            return "true";
        } else {
            return "false";
        }
    }

    //跳转去回复用户
    @GetMapping("/toMsgReply")
    public ModelAndView toMsgReply(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            String receive = (String) httpServletRequest.getParameter("receive");
            modelAndView.addObject("receive", receive);
            modelAndView.setViewName("msg_reply");
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
            String send = (String) httpServletRequest.getParameter("send");
            String receive = (String) httpServletRequest.getParameter("receive");
            String content = (String) httpServletRequest.getParameter("content");
            Message message = new Message();
            message.setSEND_NAME(send);
            message.setRECEIVE_NAME(receive);
            message.setDETAIL(content);
            message.setSEND_TIME(new Date());
            message.setSTATUS(0);
            adminService.addMsg(message);
            //获取留言列表返回列表页面
            AdminInfo adminInfo = new AdminInfo();
            adminInfo.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            List<Message> messageList = adminService.getMessageList(adminInfo);
            modelAndView.addObject("messageList", messageList);
            modelAndView.setViewName("message_list");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }


}
