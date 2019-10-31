package edu.etime.woo.controller.wechatcontroller;

import edu.etime.woo.dto.QueueDto;
import edu.etime.woo.service.interfaces.WeChatQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 微信排队接口
 * @author zm
 */
@Controller
@RequestMapping("/wechat")
public class WeChatQueueController {

    @Autowired
    private WeChatQueueService queueservice;

    /**
     * 获取订单队列
     * @param openid
     * @return
     */
    @RequestMapping("/queue")
    @ResponseBody
    public QueueDto queue(String openid){
        return queueservice.selectQueue(openid);
    }
}
