package edu.etime.woo.service.interfaces;

import edu.etime.woo.pojo.Customer;

import java.util.List;


public interface CustomerService {
    //后台显示列表
    List<Customer> findAllCustomer();
    //客户登录
    public List<Customer> selectCustomerByOpenid(String openid);
    //增加客户
    public int insertCustomer(Customer cus);

}
