package cn.rental.mapper;

import cn.rental.bean.Login;

import java.util.List;

public interface LoginMapper {
    public Login findOne(String USER_NAME);
}
