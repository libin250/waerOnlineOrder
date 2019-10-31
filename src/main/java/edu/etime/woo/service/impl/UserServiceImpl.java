package edu.etime.woo.service.impl;

import com.github.pagehelper.PageHelper;
import edu.etime.woo.dao.SysUserMapper;
import edu.etime.woo.dto.SysUserDto;
import edu.etime.woo.pojo.SysFun;
import edu.etime.woo.pojo.SysUser;
import edu.etime.woo.service.interfaces.UserService;
import edu.etime.woo.tools.Pagers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    //通过id获取user
    @Override
    public SysUser getuserbyid(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }
    //
    @Override
    public SysUser findUserByUserName(SysUser user) {
        return this.sysUserMapper.selectUserByUserName(user);
    }


//    @Override
//    public List<SysUser> findAll() {
//        return sysUserMapper.findAll();
//    }

    //根据用户的角色Id查询功能列表
    @Override
    public List<SysFun> selectFunByRoleId(String roleid) {
        return sysUserMapper.selectFunByRoleId(roleid);
    }
    //编辑用户
    @Override
    public int editUser(SysUser user) {
        return sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    //增加用户
    public int addUser(SysUser user) {
        return sysUserMapper.insertSelective(user);
    }
    //分页
    @Override
    public Pagers<SysUser> userlist(SysUser user, int pagenum, int pagesize) {
        PageHelper.startPage(pagenum, pagesize);
        List<SysUser> list = sysUserMapper.selectList(user);
        Pagers<SysUser> p = new Pagers<>(list);
        return p;
    }
    //角色列表
    @Override
    public Pagers<SysUserDto> rolenamelist(SysUserDto userdto, int pagenum, int pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<SysUserDto> list = sysUserMapper.rolenamelist(userdto);
        Pagers<SysUserDto> p = new Pagers<>(list);
        return p;
    }


}
