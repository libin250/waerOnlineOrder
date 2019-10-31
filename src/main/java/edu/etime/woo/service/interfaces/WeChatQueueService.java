package edu.etime.woo.service.interfaces;

import edu.etime.woo.dto.QueueDto;

/**
 * 客户队列接口
 * @author zm
 */
public interface WeChatQueueService {
    /**
     * 获取客户的订单队列信息
     * @param openid
     * @return 如果返回null,那么说明用户还没有订单在队列中
     */
    public QueueDto selectQueue(String openid);
}
