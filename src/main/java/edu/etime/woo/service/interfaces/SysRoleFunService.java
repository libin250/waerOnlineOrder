package edu.etime.woo.service.interfaces;

import edu.etime.woo.dto.SysFunDto;
import edu.etime.woo.pojo.SysRoleFun;

import java.util.List;

/**
 * 权限分配
 *
 * @author：yjh
 * @date：2019/10/28 9:50
 */
public interface SysRoleFunService {

    //根据roleid查询功能列表
    List<SysFunDto> selectByRoleId(String roleid);


    //更新权限数据
    int update(List<SysRoleFun> sysRoleFunList);
}
