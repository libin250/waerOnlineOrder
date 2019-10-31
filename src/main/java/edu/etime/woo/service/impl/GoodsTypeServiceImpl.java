package edu.etime.woo.service.impl;

import com.github.pagehelper.PageHelper;
import edu.etime.woo.dao.GoodsTypeMapper;
import edu.etime.woo.pojo.GoodsType;
import edu.etime.woo.service.interfaces.GoodsTypeService;
import edu.etime.woo.tools.Pagers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lb
 * @datetime: 2019-10-25  19:47:05
 * 菜品类型实现类
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
    @Override
    public int insert(GoodsType gt) {
        return goodsTypeMapper.insert(gt);
    }

    @Override
    public int update(GoodsType gt) {
        return goodsTypeMapper.updateByPrimaryKey(gt);
    }

    @Override
    public List<GoodsType> selectList(GoodsType gt) {
        return goodsTypeMapper.selectList(gt);
    }

    @Override
    public GoodsType selectById(String gtid) {
        return goodsTypeMapper.selectByPrimaryKey(gtid);
    }

    @Override
    public GoodsType selectByGtname(String gtname) {
        return goodsTypeMapper.selectByGtname(gtname);
    }

    @Override
    public Pagers<GoodsType> selectListPage(GoodsType gt, int pagenum, int pagesize) {
        PageHelper.startPage(pagenum, pagesize);
        List<GoodsType> list = goodsTypeMapper.selectList(gt);
        Pagers<GoodsType> p = new Pagers<>(list);
        return p;
    }
}
