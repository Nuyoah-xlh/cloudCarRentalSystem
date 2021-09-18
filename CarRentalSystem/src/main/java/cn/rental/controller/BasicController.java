package cn.rental.controller;

import cn.rental.bean.UserInfo;
import cn.rental.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//页面通用的基本跳转控制

@Controller
@RequestMapping("/basic")
public class BasicController {
    @Autowired
    private AdminService adminService;

    //跳转到个人信息页
    @GetMapping("perInfo")
    public ModelAndView perInfo(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        //判断是否已登录
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            Integer user_type = Integer.valueOf((String) httpSession.getAttribute("user_type"));
            //是管理员
            UserInfo userInfo;
            if ("0".equals(user_type)) {
                //获取个人详细信息
                userInfo = adminService.getPerInfo((String) httpSession.getAttribute("user_name"));
            } else if ("1".equals(user_type)) {
                // 获取租车人信息(待填充)
                userInfo = adminService.getPerInfo((String) httpSession.getAttribute("user_name"));
            } else {
                //获取车主信息（待填充)
                userInfo = adminService.getPerInfo((String) httpSession.getAttribute("user_name"));
            }
            userInfo.setUSER_TYPE(user_type);
            modelAndView.addObject("personInfo", userInfo);
            modelAndView.setViewName("person_info");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    //修改个人信息，并返回主页
    @RequestMapping("revise")
    public ModelAndView revise(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            //管理员
            if ("0".equals(httpSession.getAttribute("user_type"))) {
                modelAndView.setViewName("admin_index");
            } else {
                modelAndView.setViewName("admin_index");
            }
        }
        return modelAndView;
    }
}
