package edu.etime.woo.service.interfaces;

import edu.etime.woo.dto.OrderDetailDto;

import java.util.List;

/**
 * @author: lb
 * @datetime: 2019-10-28  14:35:26
 * 订单详细信息服务层接口
 */
public interface OrderDetailService {
    /**
     * 查询详细信息
     * 微信昵称，菜品名称，菜品价格，数量，需要时间，下单时间，订单状态
     * @param orderid
     * @return
     */
    List<OrderDetailDto> selectList(String orderid);

    /**
     * 查询一个用户的所有订单的id
     * @param openid
     * @return
     */
    String[] selectorderDetail(String openid);
}
