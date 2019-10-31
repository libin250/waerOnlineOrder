package edu.etime.woo.controller.webcontroller;

import edu.etime.woo.dto.OrdersDto;
import edu.etime.woo.service.interfaces.OrdersService;
import edu.etime.woo.tools.DateConvert;
import edu.etime.woo.tools.Pagers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: lb
 * @datetime: 2019-10-28  09:09:24
 * 订单controller类
 */
@Controller
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;


//    /**
//     * 查看订单
//     * 初始化订单列表
//     * @param model
//     * @param odto
//     * @return
//     */
//    @RequestMapping("/list")
//    public String list(Model model, OrdersDto odto) {
//        if (odto != null && odto.getNickname() != null && !odto.getNickname().equals("")) {
//            odto.setNickname("%" + odto.getNickname() + "%");
//        }
//        List<OrdersDto> list = ordersService.selectList(odto);
//        model.addAttribute("list", list);
//        return "orders/list";
//    }

    /**
     * 初始化订单列表
     * 带分页的查询
     * @param model
     * @param odto
     * @return
     */
    @RequestMapping("/list")
    public String list(Integer index, Model model, OrdersDto odto) {
        if (index == null) {
            index = 1;
        }
        // 构建参数，加上模糊查询的通配符%
        if (odto!= null && odto.getNickname() != null && !odto.getNickname().equals("")) {
            odto.setNickname("%" + odto.getNickname() + "%");
        }
        Pagers<OrdersDto> p = ordersService.selectListPage(odto,index,10);
        model.addAttribute("p", p);
        return "orders/list";
    }


}
