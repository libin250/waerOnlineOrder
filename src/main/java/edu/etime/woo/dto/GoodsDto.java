package edu.etime.woo.dto;

import edu.etime.woo.pojo.Goods;

/**
 * 菜品信息扩展
 * @author: lb
 * @datetime: 2019-10-24  18:32:42
 */
public class GoodsDto extends Goods {
    private String gtname;

    //客户点菜的数量，默认值为0份
    private Integer gcount = 0;

    public String getGtname() {
        return gtname;
    }

    public void setGtname(String gtname) {
        this.gtname = gtname == null ? null : gtname.trim();
    }

    public Integer getGcount() {
        return gcount;
    }

    public void setGcount(Integer gcount) {
        this.gcount = gcount;
    }
}
