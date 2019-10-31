package edu.etime.woo.dto;

import edu.etime.woo.pojo.SysUser;

public class SysUserDto extends SysUser{

    private String rolename;

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
