package cn.rental.controller;

import cn.rental.bean.Login;
import cn.rental.bean.UserInfo;
import cn.rental.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

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
        System.out.println(user_name + password + user_type + name);
        //数据库进行查询该用户
        Login one = loginService.findOne(user_name);
        System.out.println(one);
        if (one != null && one.getUSER_NAME().equals(user_name) && one.getPASSWORD().equals(password) && one.getUSER_TYPE() == type) {
            //登录成功,在会话中进行标记
            httpSession.setAttribute("user_status", "1");
            httpSession.setAttribute("user_type", String.valueOf(type));
            httpSession.setAttribute("user_name", String.valueOf(user_name));
            return "true";
        } else {
            //登录失败
            httpSession.setAttribute("user_status", "0");
            return "false";
        }
    }

    @RequestMapping("/login_success")
    public ModelAndView login_success(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        //判断已经登录验证通过
        if ("1".equals((String) httpSession.getAttribute("user_status"))) {
            if ("0".equals(httpSession.getAttribute("user_type"))) {
                List<UserInfo> hirer_list = loginService.getHirerOfVehicle();
                List<UserInfo> owner_list = loginService.getOwnerOfVehicleInfo();
                List<UserInfo> user_list = new ArrayList<>();
                user_list.addAll(hirer_list);
                user_list.addAll(owner_list);
                modelAndView.addObject("user_list", user_list);
                modelAndView.addObject("user_name",httpSession.getAttribute("user_name") );
                modelAndView.setViewName("admin_index");
            } else {
                modelAndView.setViewName("404");
            }
        } else {
            //未通过验证
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }


}
