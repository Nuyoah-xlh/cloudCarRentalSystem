package cn.rental.controller;

import cn.rental.bean.Vehicle;
import cn.rental.service.HirerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/hirer")
public class HirerController {
    @Autowired
    private HirerService hirerService;

    //点击“待租车辆”,返回到主页面，即hirer_index.html
    @GetMapping("/index")
    public ModelAndView index(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        if ("1".equals((String) httpSession.getAttribute("user_status"))) {
            List<Vehicle> vehicleList = hirerService.getRentingVehicle();
            modelAndView.addObject("vehicle_list", vehicleList);
            modelAndView.setViewName("hirer_index");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }
}
