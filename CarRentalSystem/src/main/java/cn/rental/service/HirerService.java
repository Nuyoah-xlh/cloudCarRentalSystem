package cn.rental.service;

import cn.rental.bean.Vehicle;

import java.util.List;

public interface HirerService {
    //获取所有在租车辆信息
    public List<Vehicle> getRentingVehicle();
}
