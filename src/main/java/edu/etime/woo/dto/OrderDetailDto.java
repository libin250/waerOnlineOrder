package edu.etime.woo.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: lb
 * @datetime: 2019-10-28  11:01:46
 */
public class OrderDetailDto {

    //微信昵称
    private String nickname;
    //菜名
    private String gname;
    //需要时间
    private Integer gtime;
    //卖价
    private BigDecimal odprice;
    //数量
    private Integer odcount;
    //结算金额
    private BigDecimal ordertotleprice;
    //下单时间
    private Date ordertime;
    //订单状态
    private Integer orderstate;


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getGtime() {
        return gtime;
    }

    public void setGtime(Integer gtime) {
        this.gtime = gtime;
    }

    public BigDecimal getOdprice() {
        return odprice;
    }

    public void setOdprice(BigDecimal odprice) {
        this.odprice = odprice;
    }

    public Integer getOdcount() {
        return odcount;
    }

    public void setOdcount(Integer odcount) {
        this.odcount = odcount;
    }

    public BigDecimal getOrdertotleprice() {
        return ordertotleprice;
    }

    public void setOrdertotleprice(BigDecimal ordertotleprice) {
        this.ordertotleprice = ordertotleprice;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }
}
