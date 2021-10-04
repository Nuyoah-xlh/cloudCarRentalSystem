/*
  @author: 刘伟强
  @date: 2021/09/15 17:28:31
*/

package cn.rental.service.impl;

import cn.rental.bean.*;
import cn.rental.mapper.OwnerMapper;
import cn.rental.service.OwnerService;
import org.apache.ibatis.executor.ReuseExecutor;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public List<Order> getAllOrders(Owner owner) {
        try {
            return ownerMapper.getAllOrders(owner);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Order> getOrders_0(Owner owner) {
        try {
            return ownerMapper.getOrders_0(owner);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Order> getOrders_2(Owner owner) {
        try {
            return ownerMapper.getOrders_2(owner);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void confirm_1(Order order) {
        try {
            ownerMapper.confirm_1(order);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void confirm_2(Order order) {
        try {
            ownerMapper.confirm_2(order);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void refuse(Order order) {
        try {
            ownerMapper.refuse(order);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Message> getMessageList(Owner owner) {
        try {
            return ownerMapper.getMessageList(owner);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void updateMsgStatus(Message message) {
        try {
            ownerMapper.updateMsgStatus(message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void addMsg(Message message) {
        try {
            ownerMapper.addMsg(message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public UserInfo getInfo(String USER_NAME) {
        try {
            return ownerMapper.getInfo(USER_NAME);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Vehicle getVehicleById(Vehicle vehicle) {
        try {
            return ownerMapper.getVehicleById(vehicle);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        try {
            ownerMapper.addVehicle(vehicle);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void modify(Vehicle vehicle) {
        try {
            ownerMapper.modify(vehicle);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateVehicleStatus(Vehicle vehicle) {
        try {
            ownerMapper.updateVehicleStatus(vehicle);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateFrequency1(Owner owner) {
        try {
            ownerMapper.updateFrequency1(owner);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateFrequency2(Hirer hirer) {
        try {
            ownerMapper.updateFrequency2(hirer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateDuration(Vehicle vehicle) {
        try {
            ownerMapper.updateDuration(vehicle);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public UserInfo getInfo2(String USER_NAME) {
        try {
            return ownerMapper.getInfo2(USER_NAME);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Vehicle> getVeh(Owner owner) {
        try {
            return ownerMapper.getVeh(owner);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
