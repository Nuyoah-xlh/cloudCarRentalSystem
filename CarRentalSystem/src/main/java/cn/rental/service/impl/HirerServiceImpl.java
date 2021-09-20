package cn.rental.service.impl;

import cn.rental.bean.Vehicle;
import cn.rental.mapper.HirerMapper;
import cn.rental.service.HirerService;
import org.apache.ibatis.executor.ReuseExecutor;
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
}
