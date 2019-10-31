package edu.etime.woo.controller.webcontroller;

import edu.etime.woo.dto.SysUserDto;
import edu.etime.woo.pojo.SysRole;
import edu.etime.woo.pojo.SysUser;
import edu.etime.woo.service.interfaces.SysRoleService;
import edu.etime.woo.service.interfaces.UserService;
import edu.etime.woo.tools.Pagers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserService userService;

    @Autowired
    SysRoleService roleService;


    /**
     * 初始化用户列表
     */
//
//    public ModelAndView findAll(SysUser user,Model model,Integer index,SysUserDto userdto) {
//        if (index == null){
//            index = 1;
//        }
//       Pagers<SysUserDto> p = userService.rolenamelist(userdto,index,10);
//        model.addAttribute("p",p);
//        List<SysUser> userInfos = userService.findAll();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("userInfos", userInfos);
//        mav.setViewName("user/allUser");
//        return mav;
//    }

    /**
     * 进入增加用户界面
     */
    @RequestMapping("/toadd")
    public String toadd(Model m) {
        SysRole role = new SysRole();
        role.setRolestate(1);
        List<SysRole> list = roleService.selectList(role);
        m.addAttribute("list", list);
        return "user/addUser";

    }

    /**
     * 增加用户
     * @param user
     * @param model
     * @return
     */
        @RequestMapping("/add")
    public String add(SysUser user, Model model) {
        user.setUserid(UUID.randomUUID().toString());
        int rtn = userService.addUser(user);
//        System.out.println(rtn);
        if (rtn > 0) {
            return "redirect:/user/allUser";
        } else {
            model.addAttribute("msg", "增加用户失败");
            return "user/addUser";
        }
    }

    /**查询用户列表
     * 分页显示
     * @param user
     * @param model
     * @param index
     * @param userdto
     * @return
     */
    @RequestMapping("/allUser")
    public String list(SysUser user,Model model,Integer index,SysUserDto userdto){
        if(index==null){
            index = 1;
        }
        Pagers<SysUserDto> p = userService.rolenamelist(userdto,index,10);
        model.addAttribute("p", p);
        model.addAttribute("url", "/user/allUser");
        return "/user/allUser";
    }

    /**
     * 初始化修改用户界面
     */
    @RequestMapping("/toedit/{id}")
    public String toedit(@PathVariable("id") String id,Model model){
        SysRole role = new SysRole();
        role.setRolestate(1);
        SysUser user = userService.getuserbyid(id);
        List<SysRole> list = roleService.selectList(role);
        model.addAttribute("list", list);
        model.addAttribute("user", user);
        return "/user/editUser";
    }

    /**
     * 修改用户
     */
    @RequestMapping("/edit")
    public String edit(SysUser user,Model model){
        int rtn = userService.editUser(user);
        //List<SysRole> list = roleService.rolelist();
        //  model.addAttribute("list", list);
        if(rtn>0){
            return "redirect:/user/allUser";
        }else{
            model.addAttribute("msg", "修改角色失败");
            return "user/editUser";
        }
    }




}