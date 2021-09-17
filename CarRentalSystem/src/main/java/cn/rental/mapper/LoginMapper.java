package cn.rental.mapper;

import cn.rental.bean.Login;
import cn.rental.bean.UserInfo;

import java.util.List;

public interface LoginMapper {
    //根据用户名查询一个数据
    public Login findOne(String USER_NAME);
    //查询所有车主的当前状态信息用于admin_index显示
    public List<UserInfo> getOwnerOfVehicleInfo();
    //查询所有租车人的当前状态信息用于admin_index显示
    public List<UserInfo> getHirerOfVehicle();
}
