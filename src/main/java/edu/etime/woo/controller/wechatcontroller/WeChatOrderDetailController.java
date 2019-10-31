package edu.etime.woo.controller.wechatcontroller;

import edu.etime.woo.dto.OrderDetailDto;
import edu.etime.woo.service.interfaces.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信查询订单详情
 * @author zm
 */
@Controller
@RequestMapping("/wechat")
public class WeChatOrderDetailController {
    @Autowired
    private OrderDetailService service;

    /**
     * 查询微信订单详情方法
     * @param openid
     * @return
     */
    @RequestMapping("/orderDetail")
    @ResponseBody
    public List<OrderDetailDto> selectOrderDetail(String openid) {
        List<OrderDetailDto> list = new ArrayList<>();
        String[] orderids = service.selectorderDetail(openid);
        for (int i = 0; i < orderids.length; ++i) {
            String orderid = orderids[i];
            list.add(service.selectList(orderids[i]).get(0));
        }
        return list;
    }

}
