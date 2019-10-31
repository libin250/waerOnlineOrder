package edu.etime.woo.dao;

import edu.etime.woo.dto.SysFunDto;
import edu.etime.woo.pojo.SysRoleFun;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface SysRoleFunMapper {
    int deleteByPrimaryKey(String rolefunid);

    int insert(SysRoleFun record);

    int insertSelective(SysRoleFun record);

    SysRoleFun selectByPrimaryKey(String rolefunid);

    int updateByPrimaryKeySelective(SysRoleFun record);

    int updateByPrimaryKey(SysRoleFun record);

    //根据RoleId查询功能列表
    List<SysFunDto> selectByRoleId(String roleid);

    //根据roleid删除权限
    int deleteByRoleId(String roleid);
}