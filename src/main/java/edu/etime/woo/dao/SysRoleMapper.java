package edu.etime.woo.dao;

import edu.etime.woo.pojo.SysRole;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface SysRoleMapper {
    int deleteByPrimaryKey(String roleid);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String roleid);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    //查询角色列表
    List<SysRole> selectList(SysRole sysRole);


    //查询所有角色名称
    List<String> selectRoleName();
}