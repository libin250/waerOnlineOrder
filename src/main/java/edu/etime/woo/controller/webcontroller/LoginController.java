package edu.etime.woo.controller.webcontroller;


import edu.etime.woo.pojo.SysFun;
import edu.etime.woo.pojo.SysUser;
import edu.etime.woo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String login(SysUser user, HttpSession session, Model m) {
        Map<String,Object> map = new HashMap<String, Object>();

        user = userService.findUserByUserName(user);


        if (user == null) {
            //m.addAttribute("error", "用户名或密码错误");

            return "/login";
        } else {
            session.setAttribute("LOGIN_USER", user);

            return "../index";
        }
    }


    @RequestMapping("/initleft")
    public String initLeft(Model model,HttpSession session){
        SysUser user = (SysUser) session.getAttribute("LOGIN_USER");
        //根据当前角色查询权限
        List<SysFun> list = userService.selectFunByRoleId(user.getRoleid());
        System.out.println(list.size());
        model.addAttribute("funlist",list);
        return "/left";
    }

    @RequestMapping("/tologin")
    public String tologin(){
        return "/login";
    }


    //        }
    //            return "1";
    //        }else {
    //            return  "0";
    //        if (user== null || "".equals(user)){
    //        user = userService.findUserByUserName(username);
//    public String checkLogin(SysUser user){

//    }



//    @RequestMapping("/login")
//    public Map loginCheck(HttpServletRequest request,SysUser user){
//        Map<String,Object> map = new HashMap<>();
//        user = userService.findUserByUserName(user);
//        if (user == null){
//            map.put("code",0);
//        }else {
//            map.put("errorInfo","密码或账号错误");
//        }
//        return map;
//    }



//    @RequestMapping("logout")
//    public String logout(HttpSession session){
//        session.invalidate();
//        return "redirect:/login.html";
//    }
}
