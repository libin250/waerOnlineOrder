package edu.etime.woo.service.impl;

import com.github.pagehelper.PageHelper;
import edu.etime.woo.dao.OrdersMapper;
import edu.etime.woo.dto.OrdersDto;
import edu.etime.woo.pojo.Orders;
import edu.etime.woo.service.interfaces.OrdersService;
import edu.etime.woo.tools.Pagers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lb
 * @datetime: 2019-10-28  09:28:29
 * 订单实现类
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;


    @Override
    public List<OrdersDto> selectList(OrdersDto odto) {
        return ordersMapper.selectList(odto);
    }

    @Override
    public Pagers<OrdersDto> selectListPage(OrdersDto odto, int pagenum, int pagesize) {
        PageHelper.startPage(pagenum, pagesize);
        List<OrdersDto> list = ordersMapper.selectList(odto);
        Pagers<OrdersDto> p = new Pagers<>(list);
        return p;
    }

    @Override
    public int insert(Orders orders) {
        return ordersMapper.insert(orders);
    }
}
