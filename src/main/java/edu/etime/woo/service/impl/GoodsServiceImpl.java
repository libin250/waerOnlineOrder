package edu.etime.woo.service.impl;

import com.github.pagehelper.PageHelper;
import edu.etime.woo.dao.GoodsMapper;
import edu.etime.woo.dao.GoodsTypeMapper;
import edu.etime.woo.dto.GoodsDto;
import edu.etime.woo.pojo.Goods;
import edu.etime.woo.pojo.GoodsType;
import edu.etime.woo.service.interfaces.GoodsService;
import edu.etime.woo.tools.Pagers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 菜品信息服务层实现
 *
 * @author: lb
 * @datetime: 2019-10-22  20:46:41
 */
@Service
public class GoodsServiceImpl  implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public List<GoodsDto> selectList(GoodsDto gdto) {
        return goodsMapper.selectList(gdto);
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int update(Goods goods) {
        return goodsMapper.updateByPrimaryKey(goods);
    }


    @Override
    public GoodsDto selectById(String gid) {
        return goodsMapper.selectByPrimaryKey(gid);
    }

    @Override
    public Goods selectByGname(HashMap map) {
        return goodsMapper.selectByGname(map);
    }

    @Override
    public List<GoodsType> selectListGoodsType(GoodsType gt) {
        return goodsTypeMapper.selectList(gt);
    }

    @Override
    public Pagers<GoodsDto> selectListPage(GoodsDto gdto, int pagenum, int pagesize) {
        PageHelper.startPage(pagenum, pagesize);
        List<GoodsDto> list = goodsMapper.selectList(gdto);
        Pagers<GoodsDto> p = new Pagers<>(list);
        return p;
    }
}
