package edu.etime.woo.controller.wechatcontroller;


import edu.etime.woo.pojo.Customer;
import edu.etime.woo.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public ModelAndView list(Customer customer, Model model, Integer index){
//        if(index==null){
//            index = 1;
//        }
//        Pagers<SysUserDto> p = userService.rolenamelist(userdto,index,10);
//        model.addAttribute("p", p);
        List<Customer> list = customerService.findAllCustomer();
        ModelAndView mav = new ModelAndView();
        mav.addObject("list",list);
        mav.setViewName("/customer/list");
        return mav;
    }
}
