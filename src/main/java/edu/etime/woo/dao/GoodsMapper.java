package edu.etime.woo.dao;

import edu.etime.woo.dto.GoodsDto;
import edu.etime.woo.pojo.Goods;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public interface GoodsMapper {
    int deleteByPrimaryKey(String gid);

    int insert(Goods record);

    int insertSelective(Goods record);

    GoodsDto selectByPrimaryKey(String gid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    /**
     * 查询goods信息  可以查询全部，安状态查询，按那么查询
     * @param gdto
     * @return
     */
    List<GoodsDto> selectList(GoodsDto gdto);


    /**
     * 根据id和name查询，条件放在map中
     * @param map
     * @return
     */
    Goods selectByGname(HashMap map);
}