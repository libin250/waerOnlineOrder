package edu.etime.woo.controller.webcontroller;

import edu.etime.woo.dto.SysFunDto;
import edu.etime.woo.pojo.SysRoleFun;
import edu.etime.woo.service.interfaces.SysRoleFunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 权限管理
 *
 * @author：yjh
 * @date：2019/10/28 9:40
 */

@Controller
@RequestMapping("/SysRoleFun")
public class SysRoleFunController {

    @Autowired
    private SysRoleFunService service;

    /**
     * 初始化
     * @param roleid
     * @param model
     * @return
     */
    @RequestMapping("/init/{roleid}")
    public String initRoleFun(@PathVariable String roleid, Model model,String msg){

        List<SysFunDto> funlist = service.selectByRoleId(roleid);
        model.addAttribute("msg",msg);
        model.addAttribute("funlist",funlist);
        System.out.println(funlist.size());
        return "sys/role/distribute";
    }

    @RequestMapping("/distribute")
    public String distribute(String[] ids,String roleid,Model model){

        List<SysRoleFun> sysRoleFunList = new ArrayList<>();
        for (int i = 0; i < ids.length; ++i){
            //将数据打包成SysRoleFun列表
            sysRoleFunList.add(new SysRoleFun(UUID.randomUUID().toString(),roleid,ids[i]));
        }
        int rst = service.update(sysRoleFunList);
        String msg = "1";
        if (rst > 0){
            msg = "2";
        }
        return initRoleFun(roleid,model,msg);
    }

}
