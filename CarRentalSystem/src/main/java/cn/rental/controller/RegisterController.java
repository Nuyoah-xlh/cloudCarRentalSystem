package cn.rental.controller;

import cn.rental.bean.AdminInfo;
import cn.rental.bean.Hirer;
import cn.rental.bean.Login;
import cn.rental.bean.Owner;
import cn.rental.mapper.RegisterMapper;
import cn.rental.service.LoginService;
import cn.rental.service.RegisterService;
import cn.rental.util.BASE64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


//注册的相关控制信息

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    //前往注册
    @GetMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    //注册交互
    @RequestMapping("/add")
    @ResponseBody
    public String toIndex(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        String user_name = (String) httpServletRequest.getParameter("user_name");//用户名查重
        String user_type = (String) httpServletRequest.getParameter("user_type");
        String password = (String) httpServletRequest.getParameter("password");
        password = BASE64Util.decode(password);
        String name = httpServletRequest.getParameter("name");
        int sex = Integer.parseInt((String) httpServletRequest.getParameter("sex"));
        String tel = httpServletRequest.getParameter("tel");
        String id = httpServletRequest.getParameter("id");
        String email = httpServletRequest.getParameter("email");
//        type记录用户类型，0为管理员，1为租车人，2为车主
        int type;
        if ("1".equals(user_type)) {
            type = 1;
        } else {
            type = 2;
        }
        System.out.println(user_name);
        //根据用户名在数据库进行查询
        Login one = loginService.findOne(user_name);
        System.out.println(one);
        if (one != null && one.getUSER_NAME().equals(user_name)) {
            //用户存在
//            httpSession.setAttribute("user_status", "1");
//            httpSession.setAttribute("user_type", String.valueOf(type));
//            httpSession.setAttribute("user_name", String.valueOf(user_name));
//            return "true";
            return "false";
        } else {
            //用户名不一致，可注册
//            httpSession.setAttribute("user_status", "0");
            System.out.println("可以注册");
            Login login = new Login(user_name, password, null, 0, 0, new Date(), type);
            registerService.addOne(login);
            System.out.println(type);
            if (type == 1) {
                Hirer hirer = new Hirer(user_name, name, sex, id, 100, 0, email, tel);
                registerService.addOneHirer(hirer);
            } else {
                Owner owner = new Owner(user_name, name, sex, id, 100, 0, email, tel, 0);
                registerService.addOneOwner(owner);
            }
            return "true";
        }
    }
}

