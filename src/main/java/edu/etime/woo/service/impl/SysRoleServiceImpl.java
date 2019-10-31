package edu.etime.woo.service.impl;

import edu.etime.woo.dao.SysRoleMapper;
import edu.etime.woo.pojo.SysRole;
import edu.etime.woo.service.interfaces.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author：yjh
 * @date：2019/10/25 16:24
 */

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper mapper;

    /**
     * 查询角色列表
     * @param sysRole 可能参数
     * @return 目标角色列表
     */
    @Override
    public List<SysRole> selectList(SysRole sysRole) {
        return mapper.selectList(sysRole);
    }

    /**
     * 查询所有角色名称
     * @return
     */
    @Override
    public List<String> selectRoleName() {
        return mapper.selectRoleName();
    }

    /**
     * 插入新角色
     * @param sysRole
     */
    @Override
    public int insert(SysRole sysRole) {
        return mapper.insert(sysRole);
    }

    /**
     *
     * @param roleid
     * @return
     */
    @Override
    public SysRole selectById(String roleid) {
        return mapper.selectByPrimaryKey(roleid);
    }

    /**
     *
     * @param sysRole
     * @return
     */
    @Override
    public int update(SysRole sysRole) {
        return mapper.updateByPrimaryKeySelective(sysRole);
    }
}
