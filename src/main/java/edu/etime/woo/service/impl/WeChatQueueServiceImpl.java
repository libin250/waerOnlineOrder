package edu.etime.woo.service.impl;

import edu.etime.woo.dao.CustomerMapper;
import edu.etime.woo.dao.OrderDetailMapper;
import edu.etime.woo.dto.OrderDetailDto;
import edu.etime.woo.dto.QueueDto;
import edu.etime.woo.pojo.Customer;
import edu.etime.woo.service.interfaces.WeChatQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeChatQueueServiceImpl implements WeChatQueueService {


    @Autowired
    private OrderDetailMapper detailmapper;

    @Override
    public QueueDto selectQueue(String openid) {

        QueueDto dto = new QueueDto();

        //用户位置
        int location = 0;

        //用于计算等待时间的订单信息列表
        List<OrderDetailDto> list = new ArrayList<>();

        //暂定"2"为未完成的订单
        String[] orderids = detailmapper.selectorderDetail(null,1);
        for (int i = 0; i < orderids.length; ++i) {
            List<OrderDetailDto> l = new ArrayList<>();
            l = detailmapper.selectList(orderids[i]);
            for (int j = 0; j < l.size(); ++j){

                list.add(l.get(j));
            }
            //list.add(detailmapper.selectList(orderids[i]).get(0));
        }
        System.out.println(orderids.length);

        //目标订单
        OrderDetailDto odd = detailmapper.selectList(detailmapper.selectorderDetail(openid,1)[0]).get(0);

        //等待时间初始化
        int wtime = 0;

        //计算等待时间
        for(int i = 0; i < list.size(); ++i){
            if (list.get(i).getOrdertime().compareTo(odd.getOrdertime())==1){
                wtime += list.get(i).getOdcount() * list.get(i).getGtime();
            }
        }


        dto.setQueuetime(wtime);

        //获取位置
        System.out.println(openid);
        String orderid = detailmapper.selectorderDetail(openid,1)[0];
        dto.setQueuecount(detailmapper.selectLocation(orderid));
        return dto;
    }
}
