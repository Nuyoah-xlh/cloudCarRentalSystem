package cn.rental.service;

import cn.rental.bean.Login;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LoginService {
    public Login findOne(String USER_NAME);

}
