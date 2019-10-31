package edu.etime.woo.controller.webcontroller;

import edu.etime.woo.pojo.SysRole;
import edu.etime.woo.service.interfaces.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * 角色管理
 *
 * @author：yjh
 * @date：2019/10/25 15:27
 */
@Controller
@RequestMapping("/SysRole")
public class SysRoleController {

    //自动注入Service层
    @Autowired
    private SysRoleService service;

    /**
     * 处理获取SysRole列表请求
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request) {

        //获取页面表单数据
        String rolename = request.getParameter("rolename");
        String str_rolestate = request.getParameter("rolestate");
        Integer rolestate = null;
        if (str_rolestate != null && !str_rolestate.equals("-1")) {
            rolestate = Integer.valueOf(str_rolestate);
        }

        //将数据封装到SysRole对象中
        SysRole sysRole = new SysRole(rolename, rolestate);

        //service层处理查询SysRole列表业务逻辑，接收返回值
        List<SysRole> list = service.selectList(sysRole);

        //将得到的目标列表通过model发送到sys/role/list.jsp
        model.addAttribute("list", list);
        return "/sys/role/list";
    }

    /**
     * 初始化角色列表，并返回所有角色名称
     *
     * @param model
     * @return
     */
    @RequestMapping("/toadd")
    public String toadd(Model model) {
        List<String> namelist = service.selectRoleName();
        model.addAttribute("namelist", namelist);
        return "/sys/role/add";
    }

    /**
     * 增加角色
     *
     * @param request
     * @return
     */
    @RequestMapping("/add")
    public String add(HttpServletRequest request) {

        //获取表单数据
        String rolename = request.getParameter("rolename");
        String str_rolestate = request.getParameter("rolestate");

        //生成UUID
        String roleid = UUID.randomUUID().toString();
        //将数据封装到SysRole对象中
        SysRole sysRole = new SysRole(roleid, rolename, Integer.valueOf(str_rolestate));
        int rst = service.insert(sysRole);
        return "redirect:/SysRole/list";
    }

    /**
     * 初始化修改页面
     *
     * @param roleid
     * @param model
     * @return
     */
    @RequestMapping("/toedit/{roleid}")
    public String toedit(@PathVariable String roleid, Model model) {
        SysRole sysRole = service.selectById(roleid);
        model.addAttribute("sysrole", sysRole);
        return "/sys/role/edit";
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, Model model) {
        //获取
        String roleid = request.getParameter("roleid");
        String rolename = request.getParameter("rolename");
        String str_rolestate = request.getParameter("rolestate");

        //封装
        SysRole sysRole = new SysRole(roleid, rolename, Integer.valueOf(str_rolestate));
        //service
        int rst = service.update(sysRole);
        //
        if (rst > 0) {
            return this.list(model, request);
        } else {
            return this.toedit(roleid, model);
        }

    }
}