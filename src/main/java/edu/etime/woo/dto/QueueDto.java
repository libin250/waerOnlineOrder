package edu.etime.woo.dto;

import edu.etime.woo.pojo.Customer;

import java.util.List;

/**
 * 订单队列数据传输对象
 * @author zm
 */
public class QueueDto {

    //队列位置
    private Integer queuecount;
    //等待时间
    private Integer queuetime;

    public Integer getQueuecount() {
        return queuecount;
    }

    public void setQueuecount(Integer queuecount) {
        this.queuecount = queuecount;
    }

    public Integer getQueuetime() {
        return queuetime;
    }

    public void setQueuetime(Integer queuetime) {
        this.queuetime = queuetime;
    }
}
