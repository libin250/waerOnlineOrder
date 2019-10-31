package edu.etime.woo.controller.webcontroller;

import edu.etime.woo.dto.SysFunDto;
import edu.etime.woo.pojo.SysFun;
import edu.etime.woo.service.impl.SysFunServiceImpl;
import edu.etime.woo.service.interfaces.SysFunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * 功能管理
 *
 * @author：yjh
 * @date：2019/10/26 9:13
 */
@Controller
@RequestMapping("/SysFun")
public class SysFunController {

    @Autowired
    private SysFunService service;


    /**
     * 初始化列表
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model){

        //service层进一步处理，接收返回值
        List<SysFunDto> funlist = service.selectList();
        //model 向页面传递数据
        model.addAttribute("funlist",funlist);

        return "sys/fun/list";
    }

    /**
     * 编辑功能
     * @param sysFun
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Integer edit(SysFun sysFun){
        return service.update(sysFun);
    }

    /**
     * 增加功能
     * @param sysFun       System.out.println(sysFun.getFunname());
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Integer add(SysFun sysFun){
        sysFun.setFunid(UUID.randomUUID().toString());
        return service.insert(sysFun);
    }
}
