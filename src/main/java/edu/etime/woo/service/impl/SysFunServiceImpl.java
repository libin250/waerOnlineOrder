package edu.etime.woo.service.impl;

import edu.etime.woo.dao.SysFunMapper;
import edu.etime.woo.dto.SysFunDto;
import edu.etime.woo.pojo.SysFun;
import edu.etime.woo.service.interfaces.SysFunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统功能管理
 *
 * @author：yjh
 * @date：2019/10/26 9:32
 */

@Service
public class SysFunServiceImpl implements SysFunService {

    @Autowired
    private SysFunMapper mapper;

    /**
     * 查询功能列表
     * @return
     */
    @Override
    public List<SysFunDto> selectList() {
        return mapper.selectList();
    }

    /**
     * 增加新功能
     * @param sysFun
     * @return
     */
    @Override
    public int insert(SysFun sysFun) {
        return mapper.insert(sysFun);
    }

    /**
     * 修改功能
     * @param sysFun
     * @return
     */
    @Override
    public int update(SysFun sysFun) {
        return mapper.updateByPrimaryKey(sysFun);
    }

    @Override
    public SysFun selectById(String funid) {
        return null;
    }


}
