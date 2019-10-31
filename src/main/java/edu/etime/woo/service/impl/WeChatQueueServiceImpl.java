package edu.etime.woo.service.impl;

import edu.etime.woo.dao.CustomerMapper;
import edu.etime.woo.dao.OrderDetailMapper;
import edu.etime.woo.dto.OrderDetailDto;
import edu.etime.woo.dto.QueueDto;
import edu.etime.woo.pojo.Customer;
import edu.etime.woo.service.interfaces.WeChatQueueService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class WeChatQueueServiceImpl implements WeChatQueueService {
    @Autowired
    private CustomerMapper cusmapper;

    @Autowired
    private OrderDetailMapper detailmapper;

    @Override
    public QueueDto selectQueue(String openid) {

        QueueDto dto = null;

        //用户位置
        int location = 0;

        //用于计算等待时间的订单信息列表
        List<OrderDetailDto> list = new ArrayList<>();

        //暂定"2"为未完成的订单
        String[] orderids = detailmapper.selectorderDetail(null,2);
        for (int i = 0; i < orderids.length; ++i) {
            list.add(detailmapper.selectList(orderids[i]).get(0));
        }

        //目标订单
        OrderDetailDto odd = detailmapper.selectList(detailmapper.selectorderDetail(openid,2)[0]).get(0);

        //等待时间初始化
        int wtime = 0;

        //计算等待时间
        for(int i = 0; i < list.size(); ++i){
            if (list.get(i).getOrdertime().compareTo(odd.getOrdertime())==-1){
                wtime += list.get(i).getOdcount() * list.get(i).getGtime();
            }
        }
        dto.setQueuetime(wtime);

        //获取位置
        dto.setQueuecount(detailmapper.selectLocation(openid));

        return dto;
    }
}
