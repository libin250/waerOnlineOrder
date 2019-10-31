package edu.etime.woo.controller.webcontroller;


import edu.etime.woo.pojo.Customer;
import edu.etime.woo.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /**
     * 初始化客户列表，包括cusid，openid，昵称
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list( Model model){
        List<Customer> list = customerService.findAllCustomer();
        model.addAttribute("list",list);
        return "/customer/list";
    }
}
