package cn.rental.service;

import cn.rental.bean.Hirer;
import cn.rental.bean.Message;
import cn.rental.bean.Order;
import cn.rental.bean.Vehicle;

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

}
