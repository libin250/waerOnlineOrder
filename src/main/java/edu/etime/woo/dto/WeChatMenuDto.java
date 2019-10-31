package edu.etime.woo.dto;

import edu.etime.woo.pojo.GoodsType;

import java.util.List;

/**
 * 微信小程序菜单数据传输对象
 * 包含商品类型列表，和商品列表
 * @author zm
 *
 */
public class WeChatMenuDto {
    private List<GoodsType> goodstypelist;

    private List<GoodsDto> goodslist;

    public List<GoodsType> getGoodstypelist() {
        return goodstypelist;
    }

    public void setGoodstypelist(List<GoodsType> goodstypelist) {
        this.goodstypelist = goodstypelist;
    }

    public List<GoodsDto> getGoodslist() {
        return goodslist;
    }

    public void setGoodslist(List<GoodsDto> goodslist) {
        this.goodslist = goodslist;
    }
}
