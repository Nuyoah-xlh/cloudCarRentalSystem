package cn.rental.service;

import cn.rental.bean.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {
    //获取所有管理员信息
    public List<AdminInfo> getAdminInfos();

    //根据用户名查询个人信息
    public UserInfo getPerInfo(String USER_NAME);

    //查询所有租车人信息
    public List<Hirer> getHirerList();

    //查询所有车主信息
    public List<Owner> getOwnerList();

    //查询被列入黑名单的租车人
    public List<UserInfo> getBlackList_Hirer();

    //查询被列入黑名单的车主
    public List<UserInfo> getBlackList_Owner();

    //查询所有车辆信息
    public List<Vehicle> getVehicleList();


}
