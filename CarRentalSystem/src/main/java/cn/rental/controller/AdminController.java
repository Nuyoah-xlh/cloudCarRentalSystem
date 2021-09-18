package cn.rental.controller;

import cn.rental.bean.*;
import cn.rental.service.AdminService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
}
