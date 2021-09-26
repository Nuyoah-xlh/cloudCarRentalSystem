package cn.rental.service.impl;

import cn.rental.bean.*;
import cn.rental.mapper.AdminMapper;
import cn.rental.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<AdminInfo> getAdminInfos() {
        try {
            return adminMapper.getAdminInfos();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public UserInfo getPerInfo_Admin(String USER_NAME) {
        try {
            return adminMapper.getPerInfo_Admin(USER_NAME);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Hirer> getHirerList() {
        try {
            return adminMapper.getHirerList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Owner> getOwnerList() {
        try {
            return adminMapper.getOwnerList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<UserInfo> getBlackList_Hirer() {
        try {
            return adminMapper.getBlackList_Hirer();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<UserInfo> getBlackList_Owner() {
        try {
            return adminMapper.getBlackList_Owner();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Vehicle> getVehicleList() {
        try {
            return adminMapper.getVehicleList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Vehicle> getVehicleListByStatus(Integer STATUS) {
        try {
            return adminMapper.getVehicleListByStatus(STATUS);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void setVehicleStatusById(Vehicle vehicle) {
        try {
            adminMapper.setVehicleStatusById(vehicle);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        try {
            return adminMapper.getAllOrders();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Order> getCurrentOrders() {
        try {
            return adminMapper.getCurrentOrders();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Message> getMessageList(AdminInfo adminInfo) {
        try {
            return adminMapper.getMessageList(adminInfo);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void updateMsgStatus(Message message) {
        try {
            adminMapper.updateMsgStatus(message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void addMsg(Message message) {
        try {
            adminMapper.addMsg(message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Login> getLoginLog() {
        try {
            return adminMapper.getLoginLog();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void toBlackList1(Hirer hirer) {
        try {
            adminMapper.toBlackList1(hirer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void toBlackList2(Owner owner) {
        try {
            adminMapper.toBlackList2(owner);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void outBlackList1(Hirer hirer) {
        try {
            adminMapper.outBlackList1(hirer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void outBlackList2(Owner owner) {
        try {
            adminMapper.outBlackList2(owner);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public UserInfo getPerInfo_Hirer(String USER_NAME) {
        try {
            return adminMapper.getPerInfo_Hirer(USER_NAME);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<UserInfo> getPerInfo_Owner(String USER_NAME) {
        try {
            return adminMapper.getPerInfo_Owner(USER_NAME);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
