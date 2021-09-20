package cn.rental.mapper;

import cn.rental.bean.Vehicle;

import java.util.List;

public interface HirerMapper {
    //获取所有在租车辆信息
    public List<Vehicle> getRentingVehicle();
}
