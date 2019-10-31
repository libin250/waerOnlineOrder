package edu.etime.woo.service.interfaces;

import edu.etime.woo.dto.SysUserDto;
import edu.etime.woo.pojo.SysFun;
import edu.etime.woo.pojo.SysUser;
import edu.etime.woo.tools.Pagers;

import java.util.List;

public interface UserService {

    SysUser findUserByUserName(SysUser user);

    //找到用户列表
    //List<SysUser> findAll();

    //根据用户的角色Id查询功能列表
    List<SysFun> selectFunByRoleId(String roleid);

    public SysUser getuserbyid(String id);

    //编辑用户
    public int editUser(SysUser user);

    //增加用户
    public int addUser(SysUser user);

    public Pagers<SysUser> userlist(SysUser user, int pagenum, int pagesize);

    public Pagers<SysUserDto> rolenamelist(SysUserDto userdto, int pagenum, int pagesize);


}
