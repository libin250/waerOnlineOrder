package edu.etime.woo.controller.wechatcontroller;

import edu.etime.woo.dto.GoodsDto;
import edu.etime.woo.dto.WeChatMenuDto;
import edu.etime.woo.pojo.GoodsType;
import edu.etime.woo.service.interfaces.WeChatMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 微信菜单显示控制类
 * @author zm
 */
@Controller
@RequestMapping("/wechat")
public class MenuController {

    @Autowired
    private WeChatMenuService service;

    /**
     * 查询菜单方法
     * @return
     */
    @RequestMapping("/menu")
    @ResponseBody
    public WeChatMenuDto menu(){
        //1、组织参数
        GoodsType goodstype = new GoodsType();
        goodstype.setGtstate(1);
        GoodsDto gdto = new GoodsDto();
        gdto.setGstate(1);
        WeChatMenuDto dto = service.selectMenu(goodstype, gdto);
        return dto;
    }

}
