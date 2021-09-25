package cn.rental.service.impl;

import cn.rental.bean.AdminInfo;
import cn.rental.bean.Hirer;
import cn.rental.bean.Login;
import cn.rental.bean.Owner;
import cn.rental.mapper.RegisterMapper;
import cn.rental.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public void addOne(Login login) {
        try {
            registerMapper.addOne(login);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void addOneOwner(Owner owner) {
        try {
            registerMapper.addOneOwner(owner);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void addOneHirer(Hirer hirer) {
        try {
            registerMapper.addOneHirer(hirer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
