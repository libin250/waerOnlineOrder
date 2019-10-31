package edu.etime.woo.service.interfaces;

import edu.etime.woo.dto.OrdersDto;
import edu.etime.woo.pojo.Orders;
import edu.etime.woo.tools.Pagers;

import java.util.List;

/**
 * @author: lb
 * @datetime: 2019-10-28  09:26:48
 * 订单接口
 */
public interface OrdersService {

    /**
     * 查看订单
     * @param odto
     * @return
     */
     List<OrdersDto>  selectList(OrdersDto odto);

    /**
     * 带分页的查询方法
     * @param odto
     * @param pagenum
     * @param pagesize
     * @return
     */
    Pagers<OrdersDto> selectListPage(OrdersDto odto, int pagenum, int pagesize);


    /**
     * 添加订单
     * @param orders
     * @return
     */
    int insert(Orders orders);
}
