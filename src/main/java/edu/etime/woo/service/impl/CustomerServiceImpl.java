package edu.etime.woo.service.impl;

import edu.etime.woo.dao.CustomerMapper;
import edu.etime.woo.pojo.Customer;
import edu.etime.woo.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerMapper mapper;

    @Override
    public List<Customer> findAllCustomer() {
        return mapper.findAllCustomer();
    }

    @Override
    public List<Customer> selectCustomerByOpenid(String openid) {
        return mapper.selectCustomerByOpenid(openid);
    }

    @Override
    public int insertCustomer(Customer cus) {
        return mapper.insert(cus);
    }
}
