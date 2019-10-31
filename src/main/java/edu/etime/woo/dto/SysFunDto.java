package edu.etime.woo.dto;

import edu.etime.woo.pojo.SysFun;

/**
 * 系统功能拓展类，用于权限分配初始化列表
 *
 * @author：yjh
 * @date：2019/10/25 15:12
 */

public class SysFunDto extends SysFun {
    private String funpname;
    private String rolefunid;
    private String roleid;

    public String getRolefunid() {
        return rolefunid;
    }

    public void setRolefunid(String rolefunid) {
        this.rolefunid = rolefunid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getFunpname() {
        return funpname;
    }

    @Override
    public String getFunid() {
        return super.getFunid();
    }

    @Override
    public void setFunid(String funid) {
        super.setFunid(funid);
    }

    @Override
    public String getFunname() {
        return super.getFunname();
    }

    @Override
    public void setFunname(String funname) {
        super.setFunname(funname);
    }

    @Override
    public String getFunpid() {
        return super.getFunpid();
    }

    @Override
    public void setFunpid(String funpid) {
        super.setFunpid(funpid);
    }

    @Override
    public String getFunurl() {
        return super.getFunurl();
    }

    @Override
    public void setFunurl(String funurl) {
        super.setFunurl(funurl);
    }

    @Override
    public Integer getFunstate() {
        return super.getFunstate();
    }

    @Override
    public void setFunstate(Integer funstate) {
        super.setFunstate(funstate);
    }

    public void setFunpname(String funpname) {
        this.funpname = funpname;
    }
}
