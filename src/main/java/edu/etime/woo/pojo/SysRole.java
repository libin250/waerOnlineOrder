package edu.etime.woo.pojo;

public class SysRole {
    private String roleid;

    private String rolename;

    private Integer rolestate;

    public SysRole() {
    }

    public SysRole(String roleid, String rolename, Integer rolestate) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.rolestate = rolestate;
    }

    public SysRole(String rolename, Integer rolestate) {
        this.rolename = rolename;
        this.rolestate = rolestate;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Integer getRolestate() {
        return rolestate;
    }

    public void setRolestate(Integer rolestate) {
        this.rolestate = rolestate;
    }
}