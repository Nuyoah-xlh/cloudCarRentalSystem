/*
  @author: 肖林航
  @date: 2021/09/13 11:27:52
*/

package cn.rental.mapper;


import cn.rental.bean.Hirer;
import cn.rental.bean.Login;
import cn.rental.bean.Owner;

public interface RegisterMapper {
    //增加一个用户信息
    public void addOne(Login login);

    //增加一个车主信息
    public void addOneOwner(Owner owner);

    //增加一个租车人信息
    public void addOneHirer(Hirer hirer);
}
