package cn.rental.service.impl;

import cn.rental.bean.*;
import cn.rental.mapper.AdminMapper;
import cn.rental.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<AdminInfo> getAdminInfos() {
        try {
            return adminMapper.getAdminInfos();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public UserInfo getPerInfo(String USER_NAME) {
        try {
            return adminMapper.getPerInfo(USER_NAME);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Hirer> getHirerList() {
        try {
            return adminMapper.getHirerList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Owner> getOwnerList() {
        try {
            return adminMapper.getOwnerList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<UserInfo> getBlackList_Hirer() {
        try {
            return adminMapper.getBlackList_Hirer();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<UserInfo> getBlackList_Owner() {
        try {
            return adminMapper.getBlackList_Owner();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Vehicle> getVehicleList() {
        try {
            return adminMapper.getVehicleList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
