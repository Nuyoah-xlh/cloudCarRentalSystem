/*
  @author: 夏天
  @date: 2021/09/14 15:20:31
*/

package cn.rental.service;

import cn.rental.bean.*;

import java.util.List;

public interface HirerService {
    //获取所有在租车辆信息
    public List<Vehicle> getRentingVehicle();

    //获取租车人已有的订单（根据状态）
    public List<Order> getOrdersByStatus(Order order);

    //创建一个订单
    public void addOneOrder(Order order);

    //查询某人所有订单
    public List<Order> getAllOrders(Hirer hirer);

    //查询某人的当前订单
    public List<Order> getCurrentOrders(Hirer hirer);

    //取消订单（未开始的订单）
    public void cancel(Order order);

    //请求还车
    public void over(Order order);

    //查询某个订单
    public Order getOrderById(Order order);

    // 查询某个车辆信息
    public Vehicle getVehicleById(Vehicle vehicle);

    //查询所有留言信息
    public List<Message> getMessageList(Hirer hirer);

    //更新留言状态信息
    public void updateMsgStatus(Message message);

    //添加一条留言
    public void addMsg(Message message);

    //查询某人信息
    public UserInfo getInfo(String USER_NAME);

    // 扣除一定信用分
    public void updateCredit(Hirer hirer);

    //更新车辆运行时长
    public void updateDuration(Vehicle vehicle);
}
