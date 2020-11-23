package ku.th.wood.controller;

import ku.th.wood.data.CustomerRepository;
import ku.th.wood.model.Customer;
import ku.th.wood.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/shop1")
@Controller
public class Shop1Controller {
    private CustomerService customerService;
    public Shop1Controller(CustomerService customerService) {
        this.customerService = customerService;
    }
    @RequestMapping
    public String getShop1Page(Model model) {
        if(customerService.getLogined()!= null){
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
        }else{
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
        }
        return "shop1";
    }
}
