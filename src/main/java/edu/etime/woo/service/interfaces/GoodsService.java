package edu.etime.woo.service.interfaces;

import edu.etime.woo.dto.GoodsDto;
import edu.etime.woo.pojo.Goods;
import edu.etime.woo.pojo.GoodsType;
import edu.etime.woo.tools.Pagers;

import java.util.HashMap;
import java.util.List;

/**
 * 菜品信息服务层接口
 * @author: lb
 * @datetime: 2019-10-22  20:43:29
 * 菜品信息服务层接口
 */
public interface GoodsService {

    /**
     * 查看菜品信息
     * 初始化列表
     * @param gdto
     * @return
     */
    List<GoodsDto> selectList(GoodsDto gdto);



    /**
     * 添加菜品类型
     * @param goods
     * @return
     */
    int insert(Goods goods);

    /**
     * 修改菜品类型
     * @param goods
     * @return
     */
    int update(Goods goods);



    /**
     * 根据id查询一条信息
     * @param gid
     * @return
     */
    GoodsDto selectById(String gid);


    /**
     * 处理ajax请求
     * 根据类型id和菜品名称查询
     * @param map
     * @return
     */
    Goods selectByGname(HashMap map);


    /**
     * 初始化类型下拉列表
     * @param gt
     * @return
     */
    List<GoodsType> selectListGoodsType(GoodsType gt);



    /**
     * 带分页的查询方法
     * @param gdto
     * @param pagenum
     * @param pagesize
     * @return
     */
    Pagers<GoodsDto> selectListPage(GoodsDto gdto, int pagenum, int pagesize);
}

