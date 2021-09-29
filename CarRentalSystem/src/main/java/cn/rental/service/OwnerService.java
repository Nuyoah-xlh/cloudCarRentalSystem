package cn.rental.service;

import cn.rental.bean.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OwnerService {
    //查询历史订单
    public List<Order> getAllOrders(Owner owner);

    // 查询指定状态的0状态订单
    public List<Order> getOrders_0(Owner owner);

    // 查询指定状态的0状态订单
    public List<Order> getOrders_2(Owner owner);

    //确认租车
    public void confirm_1(Order order);

    //确认还车
    public void confirm_2(Order order);

    //拒绝租车
    public void refuse(Order order);

    //查询所有留言信息
    public List<Message> getMessageList(Owner owner);

    //更新留言状态信息
    public void updateMsgStatus(Message message);

    //添加一条留言
    public void addMsg(Message message);

    //查看信息
    public UserInfo getInfo(String USER_NAME);

    //查询车辆信息
    public Vehicle getVehicleById(Vehicle vehicle);

    // 新增车辆
    public void addVehicle(Vehicle vehicle);

    // 修改车辆信息
    public void modify(Vehicle vehicle);

    //更新车辆状态
    public void updateVehicleStatus(Vehicle vehicle);

    //更新frequency
    public void updateFrequency1(Owner owner);

    //更新frequency
    public void updateFrequency2(Hirer hirer);

    //更新车辆运行时长
    public void updateDuration(Vehicle vehicle);

    //查看信息
    public UserInfo getInfo2(String USER_NAME);

    //查询自己的所有车辆
    public List<Vehicle> getVeh(Owner owner);

}
