package edu.etime.woo.service.impl;

import edu.etime.woo.dao.OrderDetailMapper;
import edu.etime.woo.dto.OrderDetailDto;
import edu.etime.woo.service.interfaces.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lb
 * @datetime: 2019-10-28  14:41:30
 * 订单详细信息服务层实现类
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDetailDto> selectList(String orderid) {
        return orderDetailMapper.selectList(orderid);
    }

    @Override
    public String[] selectorderDetail(String openid) {
        return orderDetailMapper.selectorderDetail(openid,null);
    }


}
