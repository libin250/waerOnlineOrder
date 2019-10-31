package edu.etime.woo.dao;

import edu.etime.woo.dto.OrderDetailDto;
import edu.etime.woo.pojo.OrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDetailMapper {
    int deleteByPrimaryKey(String odid);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String odid);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    /**
     * 查询订单详细信息
     * @param orderid
     * @return
     */
    List<OrderDetailDto> selectList(String orderid);

    /**
     * 查询一个用户的所有订单的id
     * @param openid
     * @return
     */
    String[] selectorderDetail(@Param("openid") String openid, @Param("orderstate") Integer orderstate);

    //获取位置
    Integer selectLocation(String openid);
}