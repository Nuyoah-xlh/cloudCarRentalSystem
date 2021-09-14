package cn.rental.service.impl;

import cn.rental.bean.Login;
import cn.rental.mapper.LoginMapper;
import cn.rental.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Login findOne(String USER_NAME) {
        return loginMapper.findOne(USER_NAME);
    }

}
