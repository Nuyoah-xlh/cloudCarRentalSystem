package cn.rental.service.impl;

import cn.rental.bean.Hirer;
import cn.rental.bean.Message;
import cn.rental.bean.Order;
import cn.rental.bean.Vehicle;
import cn.rental.mapper.HirerMapper;
import cn.rental.service.HirerService;
import org.apache.ibatis.executor.ReuseExecutor;
import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HirerServiceImpl implements HirerService {

    @Autowired
    private HirerMapper hirerMapper;

    @Override
    public List<Vehicle> getRentingVehicle() {
        try {
            return hirerMapper.getRentingVehicle();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Order> getOrdersByStatus(Order order) {
        try {
            return hirerMapper.getOrdersByStatus(order);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void addOneOrder(Order order) {
        try {
            hirerMapper.addOneOrder(order);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Order> getAllOrders(Hirer hirer) {
        try {
            return hirerMapper.getAllOrders(hirer);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Order> getCurrentOrders(Hirer hirer) {
        try {
            return hirerMapper.getCurrentOrders(hirer);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void cancel(Order order) {
        try {
            hirerMapper.cancel(order);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void over(Order order) {
        try {
            hirerMapper.over(order);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Order getOrderById(Order order) {
        try {
            return hirerMapper.getOrderById(order);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Vehicle getVehicleById(Vehicle vehicle) {
        try {
            return hirerMapper.getVehicleById(vehicle);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Message> getMessageList(Hirer hirer) {
        try {
            return hirerMapper.getMessageList(hirer);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void updateMsgStatus(Message message) {
        try {
            hirerMapper.updateMsgStatus(message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void addMsg(Message message) {
        try {
            hirerMapper.addMsg(message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
