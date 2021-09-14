package cn.carrental;

import cn.rental.bean.Login;
import cn.rental.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mvc.xml", "classpath:mybatis-config.xml"})
public class Test01 {
    @Autowired
    private LoginService loginService;

    //测试根据用户名从数据库查询一条数据
    @Test
    public void test_demo() {
        System.out.println("111");
        Login anfanzhen = loginService.findOne("anfanzhen");
        System.out.println(anfanzhen);
    }

}
