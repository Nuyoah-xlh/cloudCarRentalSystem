package cn.rental.service;

import cn.rental.bean.AdminInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {
    public List<AdminInfo> getAdminInfos();
}
