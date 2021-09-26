package cn.rental.service.impl;

import cn.rental.bean.Login;
import cn.rental.bean.UserInfo;
import cn.rental.mapper.LoginMapper;
import cn.rental.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Login findOne(String USER_NAME) {
        try {
            return loginMapper.findOne(USER_NAME);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<UserInfo> getOwnerOfVehicleInfo() {
        try {
            return loginMapper.getOwnerOfVehicleInfo();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public List<UserInfo> getHirerOfVehicle() {
        try {
            return loginMapper.getHirerOfVehicle();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void modify(UserInfo userInfo) {
        try {
            loginMapper.modify(userInfo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateLog(Login login) {
        try {
            loginMapper.updateLog(login);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateStatus(Login login) {
        try {
            loginMapper.updateStatus(login);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
