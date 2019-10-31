package edu.etime.woo.controller.webcontroller;

import edu.etime.woo.pojo.GoodsType;
import edu.etime.woo.service.interfaces.GoodsTypeService;
import edu.etime.woo.tools.Pagers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.UUID;

/**
 * @author: lb
 * @datetime: 2019-10-24  21:43:24
 */
@Controller
@RequestMapping("goodstype")
public class GoodsTypeController {


    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * 进入添加页面
     * @return
     */
    @RequestMapping("/toadd")
    public String toadd(){
        return "/goodstype/add";
    }

    /**
     * 添加
     * @param gt
     * @return
     */
    @RequestMapping("/add")
    public  String add(Model model,GoodsType gt){
        gt.setGtid(UUID.randomUUID().toString());
        int i=goodsTypeService.insert(gt);
        if(i>0){
            return  "redirect:/goodstype/list";
        }else{
            model.addAttribute("msg", "添加类型失败");
            return  "/goodstype/add";
        }
    }


//    /**
//     * 初始化列表
//     * 按条件查询
//     * @param model
//     * @param gt
//     * @return
//     */
//    @RequestMapping("/list")
//    public String list(Model model,GoodsType gt){
//        if(gt!=null && gt.getGtname()!=null && !gt.getGtname().equals("")){
//            gt.setGtname("%"+gt.getGtname()+"%");
//        }
//        List<GoodsType> list=goodsTypeService.selectList(gt);
//        model.addAttribute("list",list);
//        return "/goodstype/list";
//    }


    /**
     * 带分页查询
     * @param index
     * @param model
     * @param gt
     * @return
     */
    @RequestMapping("/list")
    public String list(Integer index, Model model, GoodsType gt) {
        if (index == null) {
            index = 1;
        }
        // 构建参数，加上模糊查询的通配符%
        if (gt!= null && gt.getGtname() != null && !gt.getGtname().equals("")) {
            gt.setGtname("%" + gt.getGtname() + "%");
        }
        Pagers<GoodsType> p = goodsTypeService.selectListPage(gt,index,10);
        model.addAttribute("p", p);
        return "/goodstype/list";
    }




    /**
     * 初始化修改页
     * @param gtid
     * @param model
     * @return
     */
    @RequestMapping("/toedit/{gtid}")
    public String toedit(@PathVariable("gtid")String gtid, Model model){
        GoodsType gtype=goodsTypeService.selectById(gtid);
        model.addAttribute("gtype",gtype);
        return "/goodstype/edit";
    }

    /**
     * 修改
     * @param gt
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Model model,GoodsType gt){
        int i=goodsTypeService.update(gt);
        if(i>0){
            return "redirect:/goodstype/list";
        }else{
            model.addAttribute("msg","修改失败");
            return "goodstype/toedit";
        }
    }

    /**
     * 页面ajax编辑请求
     * 如果名称存在返回t，不存在返回f，排除自己
     * @param gtname
     * @throws Exception
     */
    @RequestMapping("/ajaxedit")
    @ResponseBody
    public String ajaxedit(String gtname,String gtid) throws Exception {
        GoodsType gt=goodsTypeService.selectByGtname(gtname);
        GoodsType gt1=goodsTypeService.selectById(gtid);
        if(gt!=null  && gt1.getGtname().equals(gt.getGtname()) && gtname.equals(gt1.getGtname())){
            return "f";
        }else if(gt==null){
            return "f";
        }else{
            return "t";
        }
    }


    /**
     * 页面ajax添加请求
     * 如果名称存在返回t，不存在返回f
     * @param gtname
     * @throws Exception
     */
    @RequestMapping("/ajaxadd")
    @ResponseBody
    public String ajaxadd(String gtname) throws Exception {
        GoodsType gt=goodsTypeService.selectByGtname(gtname);
        if(gt!=null){
            return "t";
        }else{
            return "f";
        }
    }
}
