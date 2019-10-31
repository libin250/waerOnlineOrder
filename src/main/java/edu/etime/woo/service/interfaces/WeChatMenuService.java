package edu.etime.woo.service.interfaces;

import edu.etime.woo.dto.GoodsDto;
import edu.etime.woo.dto.WeChatMenuDto;
import edu.etime.woo.pojo.GoodsType;

public interface WeChatMenuService {
    /**
     * 查询微信菜单接口方法
     * @param goodstype 包含gtstate=1
     * @param gdto 包含gstate=1
     * @return
     */
    public WeChatMenuDto selectMenu(GoodsType goodstype, GoodsDto gdto);
}
