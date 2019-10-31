package edu.etime.woo.service.interfaces;

import edu.etime.woo.pojo.GoodsType;
import edu.etime.woo.tools.Pagers;

import java.util.List;

/**
 * @author: lb
 * @datetime: 2019-10-25  19:42:49
 * 菜品类型接口
 */
public interface GoodsTypeService {

    /**
     * 添加菜品类型
     * @param gt
     * @return
     */
    int insert(GoodsType gt);

    /**
     * 修改菜品类型
     * @param gt
     * @return
     */
    int update(GoodsType gt);

    /**
     * 查询菜品类型 可以按条件查询
     * @param gt
     * @return
     */
    List<GoodsType> selectList(GoodsType gt);


    /**
     * 根据id查询一条信息
     * @param gtid
     * @return
     */
    GoodsType selectById(String gtid);

    /**
     * 根据名称查询 处理ajax请求
     * @param gtname
     * @return
     */
    GoodsType selectByGtname(String gtname);


    /**
     * 带分页的查询
     * @param gt
     * @param pagenum
     * @param pagesize
     * @return
     */
    Pagers<GoodsType> selectListPage(GoodsType gt, int pagenum, int pagesize);
}
