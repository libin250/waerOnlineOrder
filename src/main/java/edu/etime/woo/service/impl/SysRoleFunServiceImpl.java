package edu.etime.woo.service.impl;

import edu.etime.woo.dao.SysRoleFunMapper;
import edu.etime.woo.dto.SysFunDto;
import edu.etime.woo.pojo.SysRoleFun;
import edu.etime.woo.service.interfaces.SysRoleFunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限分配
 *
 * @author：yjh
 * @date：2019/10/28 9:50
 */

@Service
public class SysRoleFunServiceImpl implements SysRoleFunService {

    @Autowired
    private SysRoleFunMapper mapper;

    @Override
    public List<SysFunDto> selectByRoleId(String roleid) {
        return mapper.selectByRoleId(roleid);
    }

    @Override
    public int update(List<SysRoleFun> sysRoleFunList) {

        int rst = 0;

        //首先删除对应角色的权限信息
        rst += mapper.deleteByRoleId(sysRoleFunList.get(0).getRoleid());

        System.out.println(sysRoleFunList.get(0).getRoleid());
        System.out.println("删除："+rst);

        //然后增加数据
        for (SysRoleFun item:sysRoleFunList) {
            rst += mapper.insert(item);
        }

        System.out.println("增加："+rst);

        return rst;
    }
}
