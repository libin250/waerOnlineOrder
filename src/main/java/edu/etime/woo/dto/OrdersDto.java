package edu.etime.woo.dto;

import edu.etime.woo.pojo.Orders;

/**
 * @author: lb
 * @datetime: 2019-10-28  09:06:35
 * 订单扩展类
 */
public class OrdersDto extends Orders{

    private String nickname;
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }
}
