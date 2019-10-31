package edu.etime.woo.service.interfaces;

import edu.etime.woo.dto.GoodsDto;
import edu.etime.woo.dto.OrdersDto;
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
     * 下订单接口
     * @param goodslist 订单商品明细
     * @param openid 客户的openid
     * @param totalprice 订单总价
     * @return
     */
    public int insertOrder(List<GoodsDto> goodslist, String openid, double totalprice);
}
