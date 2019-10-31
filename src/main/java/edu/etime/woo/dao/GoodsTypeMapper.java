package edu.etime.woo.dao;

import edu.etime.woo.pojo.GoodsType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoodsTypeMapper {
    int deleteByPrimaryKey(String gtid);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(String gtid);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);

    /**
     * 查询功能
     * @param gt
     * @return
     */
    List<GoodsType> selectList(GoodsType gt);

    /**
     * 根据名称查询
     * @param gtname
     * @return
     */
    GoodsType selectByGtname(String gtname);

}