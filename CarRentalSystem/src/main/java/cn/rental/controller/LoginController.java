/*
  @author: 肖林航
  @date: 2021/09/12 10:55:25
*/
package cn.rental.controller;

import cn.rental.bean.*;
import cn.rental.service.HirerService;
import cn.rental.service.LoginService;

import cn.rental.service.OwnerService;
import cn.rental.util.BASE64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//登录跳转的相关控制信息

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private HirerService hirerService;

    @Autowired
    private OwnerService ownerService;

    //前往登录页
    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    //验证登录,与ajax交互
    @RequestMapping("/toIndex")
    @ResponseBody
    public String toIndex(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        String user_name = (String) httpServletRequest.getParameter("user_name");
        String user_type = httpServletRequest.getParameter("user_type");
        String password = httpServletRequest.getParameter("password");
        String name = httpServletRequest.getParameter("name");
        //type记录用户类型，0为管理员，1为租车人，2为车主
        int type;
        if ("管理员".equals(user_type)) {
            type = 0;
        } else if ("租车人".equals(user_type)) {
            type = 1;
        } else {
            type = 2;
        }
        System.out.println("解密前：" + user_name + password + user_type + name);
        //对密码进行解密
        password = BASE64Util.decode(password);
        System.out.println("解密后：" + user_name + password + user_type + name);
        //数据库进行查询该用户
        Login one = loginService.findOne(user_name);
        System.out.println(one);
        if (one != null && one.getUSER_NAME().equals(user_name) && one.getPASSWORD().equals(password) && one.getUSER_TYPE() == type) {
            //登录成功,在会话中进行标记
            httpSession.setAttribute("user_status", "1");
            httpSession.setAttribute("user_type", String.valueOf(type));
            httpSession.setAttribute("user_name", String.valueOf(user_name));
            //更新后台log
            Login login = new Login();
            login.setUSER_NAME((String) httpSession.getAttribute("user_name"));
            login.setLAST_TIME(new Date());
            Login login1 = loginService.findOne((String) httpSession.getAttribute("user_name"));
            login.setTIMES(login1.getTIMES() + 1);
            login.setSTATE(1);
            loginService.updateLog(login);
            return "true";
        } else {
            //登录失败
            httpSession.setAttribute("user_status", "0");
            return "false";
        }
    }

    //登录成功
    @RequestMapping("/login_success")
    public ModelAndView login_success(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        //判断已经登录验证通过
        if ("1".equals((String) httpSession.getAttribute("user_status"))) {
            //管理员
            if ("0".equals(httpSession.getAttribute("user_type"))) {
                //传参并跳转
                List<UserInfo> hirer_list = loginService.getHirerOfVehicle();
                List<UserInfo> owner_list = loginService.getOwnerOfVehicleInfo();
                List<UserInfo> user_list = new ArrayList<UserInfo>();
                user_list.addAll(hirer_list);
                user_list.addAll(owner_list);
                modelAndView.addObject("user_list", user_list);
                modelAndView.addObject("user_name", httpSession.getAttribute("user_name"));
                modelAndView.setViewName("admin_index");
            }
            //租车人
            else if ("1".equals((String) httpSession.getAttribute("user_type"))) {
                List<Vehicle> vehicleList = hirerService.getRentingVehicle();
                modelAndView.addObject("vehicle_list", vehicleList);
                modelAndView.setViewName("hirer_index");
            } else {
                Owner owner = new Owner();
                owner.setUSER_NAME((String) httpSession.getAttribute("user_name"));
                List<Order> orderList = ownerService.getAllOrders(owner);
                modelAndView.addObject("orderList", orderList);
                modelAndView.setViewName("owner_index");
            }
        } else {
            //未通过验证
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    //退出登录
    @GetMapping("/signOut")
    public ModelAndView signOut(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        //更新后台数据
        Login login = new Login();
        login.setUSER_NAME((String) httpSession.getAttribute("user_name"));
        login.setSTATE(0);
        loginService.updateStatus(login);
        httpSession.invalidate();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    // 修改密码
    @RequestMapping("/modify")
    @ResponseBody
    public String modify(HttpServletRequest httpServletRequest) {
        //System.out.println("00000");
        String inputEmail = (String) httpServletRequest.getParameter("inputEmail");
        String password = (String) httpServletRequest.getParameter("inputPwd");
        String inputName = (String) httpServletRequest.getParameter("inputName");
        password = BASE64Util.decode(password);
        UserInfo userInfo = new UserInfo();
        userInfo.setUSER_NAME(inputName);
        userInfo.setPASSWORD(password);
        Login one = loginService.findOne(inputName);
        if (one == null) {
            return "false";
        }
        loginService.modify(userInfo);
        return "true";
    }

    //前往修改密码
    @RequestMapping("/toModify")
    public String toModify() {
        return "password";
    }


}
