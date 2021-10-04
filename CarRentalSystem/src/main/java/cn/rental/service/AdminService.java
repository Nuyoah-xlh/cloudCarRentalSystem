/*
  @author: 肖林航
  @date: 2021/09/15 13:26:20
*/

package cn.rental.service;

import cn.rental.bean.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {
    //获取所有管理员信息
    public List<AdminInfo> getAdminInfos();

    //根据用户名查询个人信息
    public UserInfo getPerInfo_Admin(String USER_NAME);

    //根据用户名查询个人信息
    public UserInfo getPerInfo_Hirer(String USER_NAME);

    //根据用户名查询个人信息
    public List<UserInfo> getPerInfo_Owner(String USER_NAME);

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

    //根据车辆状态查询所有车辆信息
    public List<Vehicle> getVehicleListByStatus(Integer STATUS);

    //修改选中的车辆信息
    public void setVehicleStatusById(Vehicle vehicle);

    //查询历史订单
    public List<Order> getAllOrders();

    //查询当前订单
    public List<Order> getCurrentOrders();

    //查询某人的留言记录
    public List<Message> getMessageList(AdminInfo adminInfo);

    //更新留言状态
    public void updateMsgStatus(Message message);

    //插入一条留言
    public void addMsg(Message message);

    //获取登录历史
    public List<Login> getLoginLog();

    //加入黑名单
    public void toBlackList1(Hirer hirer);

    //加入黑名单
    public void toBlackList2(Owner owner);

    //取出黑名单
    public void outBlackList1(Hirer hirer);

    //取出黑名单
    public void outBlackList2(Owner owner);

}
