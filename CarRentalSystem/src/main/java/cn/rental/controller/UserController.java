package cn.rental.controller;

import cn.rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        System.out.println("findAll被执行");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list", userService.findAll());
        System.out.println("findAll执行完毕");
        return modelAndView;
    }
}
