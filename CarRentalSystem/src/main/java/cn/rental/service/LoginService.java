package cn.rental.service;

import cn.rental.bean.Login;
import cn.rental.bean.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface LoginService {
    //根据用户名查询一个数据
    public Login findOne(String USER_NAME);

    //查询所有车主的当前状态信息用于admin_index显示
    public List<UserInfo> getOwnerOfVehicleInfo();

    //查询所有租车人的当前状态信息用于admin_index显示
    public List<UserInfo> getHirerOfVehicle();
}
