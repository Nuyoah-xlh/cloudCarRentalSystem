/*
  @author: 肖林航
  @date: 2021/09/12 10:57:15
*/

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

    // 修改密码
    public void modify(UserInfo userInfo);

    // 更新log
    public void updateLog(Login login);

    //更新log的status
    public void updateStatus(Login login);

}
