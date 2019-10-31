package edu.etime.woo.service.interfaces;

import edu.etime.woo.dto.SysFunDto;
import edu.etime.woo.pojo.SysFun;

import java.util.List;

/**
 * TODO
 *
 * @author：yjh
 * @date：2019/10/26 9:20
 */
public interface SysFunService {

    //查询功能列表
    List<SysFunDto> selectList();

    //插入单个功能数据
    int insert(SysFun sysFun);

    //修改数据
    int update(SysFun sysFun);

    //根据id查询功能信息
    SysFun selectById(String funid);

}
