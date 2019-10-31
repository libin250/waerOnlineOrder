package edu.etime.woo.service.impl;

import edu.etime.woo.dao.GoodsMapper;
import edu.etime.woo.dao.GoodsTypeMapper;
import edu.etime.woo.dto.GoodsDto;
import edu.etime.woo.dto.WeChatMenuDto;
import edu.etime.woo.pojo.GoodsType;
import edu.etime.woo.service.interfaces.WeChatMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class WeChatMenuServiceImpl implements WeChatMenuService {

    @Autowired
    private GoodsTypeMapper goodstypemapper;
    @Autowired
    private GoodsMapper goodsmapper;
    @Override

    public WeChatMenuDto selectMenu(GoodsType goodstype, GoodsDto gdto) {

        List<GoodsType> goodstypelist = goodstypemapper.selectList(goodstype);
        List<GoodsDto> goodslist = goodsmapper.selectList(gdto);
        WeChatMenuDto dto = new WeChatMenuDto();
        dto.setGoodstypelist(goodstypelist);
        dto.setGoodslist(goodslist);
        return dto;
    }
}
