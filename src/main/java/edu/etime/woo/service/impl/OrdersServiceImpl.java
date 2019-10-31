package edu.etime.woo.service.impl;

import com.github.pagehelper.PageHelper;
import edu.etime.woo.dao.CustomerMapper;
import edu.etime.woo.dao.OrderDetailMapper;
import edu.etime.woo.dao.OrdersMapper;
import edu.etime.woo.dto.GoodsDto;
import edu.etime.woo.dto.OrdersDto;
import edu.etime.woo.pojo.Customer;
import edu.etime.woo.pojo.OrderDetail;
import edu.etime.woo.pojo.Orders;
import edu.etime.woo.service.interfaces.OrdersService;
import edu.etime.woo.tools.Pagers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author: lb
 * @datetime: 2019-10-28  09:28:29
 * 订单实现类
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private CustomerMapper cusmapper;

    @Autowired
    private OrderDetailMapper orderdetailmapper;

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

    /**
     * 下订单实现 1、根据openid获取cusid 2、保存订单信息cusorders 3、遍历保存orderdetail
     * 4、返回值：1-成功；0-失败，2-用户未注册
     */
    @Override
    public int insertOrder(List<GoodsDto> goodslist, String openid, double totalprice) {

        int rtn = 1;

        // 1、根据openid获取cusid
        List<Customer> cuslist = cusmapper.selectCustomerByOpenid(openid);
        if (cuslist.size() > 0) {
            Customer cus = cuslist.get(0);
            String cusid = cus.getCusid();
            String orderid = UUID.randomUUID().toString();
            // 2、保存订单信息
            Orders orders = new Orders();
            orders.setOrderid(orderid);
            orders.setCusid(cusid);
            orders.setOrderstate(1);
            orders.setOrdertotleprice(new BigDecimal(totalprice));
            orders.setOrdertime(new Date());
            rtn = ordersMapper.insert(orders);
            if (rtn > 0) {
                // 3、保存订单明细
                for (GoodsDto goods : goodslist) {
                    if (goods.getGcount()>0) {
                        OrderDetail detail = new OrderDetail();
                        detail.setOdid(UUID.randomUUID().toString());
                        detail.setGid(goods.getGid());
                        detail.setOdcount(goods.getGcount());
                        detail.setOdprice(goods.getGprice());
                        detail.setOrderid(orderid);
                        rtn = orderdetailmapper.insert(detail);
                        if (rtn < 1) {
                            break;
                        }
                    }
                }
            }
        } else {
            // 没有用户
            rtn = 2;
        }
        return rtn;
    }
}
