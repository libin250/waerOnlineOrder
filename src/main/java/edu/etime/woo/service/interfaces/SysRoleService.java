package edu.etime.woo.service.interfaces;

import edu.etime.woo.pojo.SysRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author：yjh
 * @date：2019/10/25 15:25
 */

public interface SysRoleService {

    //查询角色列表方法
    List<SysRole> selectList(SysRole sysRole);

    //查询所有角色名称
    List<String> selectRoleName();

    //插入角色
    int insert(SysRole sysRole);

    //
    SysRole selectById(String roleid);

    //
    int update(SysRole sysRole);
}
