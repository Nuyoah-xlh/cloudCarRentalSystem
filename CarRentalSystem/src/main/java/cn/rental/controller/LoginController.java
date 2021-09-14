package cn.rental.controller;

import cn.rental.bean.Login;
import cn.rental.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("toLogin")
    public String toLogin() {
        return "login";
    }


    ////登录验证
    //@GetMapping("/login")
    //public ModelAndView login(){
    //
    //}

    ////注册
    //@PostMapping("/register")
    //public ModelAndView register(){
    //
    //}

    //@GetMapping("/findAll")
    //public ModelAndView findAll() {
    //    System.out.println("findAll被执行");
    //    ModelAndView modelAndView = new ModelAndView();
    //    modelAndView.setViewName("index");
    //    System.out.println("findAll执行完毕");
    //    return modelAndView;
    //}
}
