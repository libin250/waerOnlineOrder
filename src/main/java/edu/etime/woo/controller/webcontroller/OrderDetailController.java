package edu.etime.woo.controller.webcontroller;

import edu.etime.woo.dto.OrderDetailDto;
import edu.etime.woo.service.impl.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: lb
 * @datetime: 2019-10-28  10:55:09
 */
@Controller
@RequestMapping("orderdetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailServiceImpl orderDetailService;


    /**
     * 查看订单详细信息
     * @param orderid
     * @param model
     * @return
     */
    @RequestMapping("/list/{orderid}")
    public String list(@PathVariable("orderid") String orderid, Model model){
        List<OrderDetailDto> list=orderDetailService.selectList(orderid);
        model.addAttribute("list",list);
        return "/orderdetail/list";
    }


}
