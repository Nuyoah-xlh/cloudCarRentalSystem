package cn.rental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    //前往注册
    @GetMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
}
