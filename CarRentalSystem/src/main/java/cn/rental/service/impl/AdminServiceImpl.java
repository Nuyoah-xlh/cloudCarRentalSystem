package cn.rental.service.impl;

import cn.rental.bean.AdminInfo;
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
}
