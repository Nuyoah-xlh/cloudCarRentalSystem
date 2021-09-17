package cn.rental.controller;

import cn.rental.bean.AdminInfo;
import cn.rental.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
}
