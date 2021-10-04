/*
  @author: 肖林航
  @date: 2021/09/14 09:35:25
*/

package cn.rental.controller;

import cn.rental.bean.Owner;
import cn.rental.bean.UserInfo;
import cn.rental.service.AdminService;
import cn.rental.service.HirerService;
import cn.rental.util.BASE64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Base64;

//页面通用的基本跳转控制

@Controller
@RequestMapping("/basic")
public class BasicController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private HirerService hirerService;


    //跳转到个人信息页
    @GetMapping("/perInfo")
    public ModelAndView perInfo(HttpSession httpSession) {
        System.out.println("进入perInfo");
        ModelAndView modelAndView = new ModelAndView();
        //判断是否已登录
        if ("1".equals(httpSession.getAttribute("user_status"))) {
            Integer user_type = Integer.valueOf((String) httpSession.getAttribute("user_type"));
            //是管理员
            UserInfo userInfo;
            if (user_type == 0) {
                //获取个人详细信息
                userInfo = adminService.getPerInfo_Admin((String) httpSession.getAttribute("user_name"));
            } else if (user_type == 1) {
                // 获取租车人信息
                userInfo = adminService.getPerInfo_Hirer((String) httpSession.getAttribute("user_name"));
                System.out.println(userInfo + " ----- " + user_type);
            } else {
                //获取车主信息（待填充)
                userInfo = adminService.getPerInfo_Owner((String) httpSession.getAttribute("user_name")).get(0);
                System.out.println(userInfo);
            }
            userInfo.setUSER_TYPE(user_type);
            modelAndView.addObject("personInfo", userInfo);
            modelAndView.setViewName("person_info");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    ////修改个人信息，并返回主页
    //@RequestMapping("revise")
    //public ModelAndView revise(HttpSession httpSession, HttpServletRequest httpServletRequest) {
    //    ModelAndView modelAndView = new ModelAndView();
    //    if ("1".equals(httpSession.getAttribute("user_status"))) {
    //        //管理员
    //        if ("0".equals(httpSession.getAttribute("user_type"))) {
    //            modelAndView.setViewName("admin_index");
    //        } else {
    //            modelAndView.setViewName("admin_index");
    //        }
    //    }
    //    return modelAndView;
    //}


}
