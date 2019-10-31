package edu.etime.woo.controller.wechatcontroller;

import edu.etime.woo.dto.GoodsDto;
import edu.etime.woo.service.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 微信订单接口
 * @author zm
 */
@Controller
@RequestMapping("/wechat")
public class WeChatOrderController {

    @Autowired
    private OrdersService service;

    /**
     * 新增订单方法
     * @param list
     * @param openid
     * @param totleprice
     * @return
     */
    @RequestMapping(method={RequestMethod.POST},value="/order")
    @ResponseBody
    public int addorder(@RequestBody List<GoodsDto> list, String openid, String totleprice){
        return service.insertOrder(list, openid, Double.parseDouble(totleprice));
    }
}
