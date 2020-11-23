package ku.th.wood.controller;

import ku.th.wood.model.Customer;
import ku.th.wood.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
public class RefillController {
    private CustomerService customerService ;
    public RefillController(CustomerService customerService){this.customerService =customerService;}
    @RequestMapping("/refill")
    public String getRefillPage(Model model){
        return "refill";
    }
    @PostMapping("refill")
    public String refill(@ModelAttribute("balance") Double balance, Model model){
        if(customerService.getLogined()!=null){
            Double update = balance + customerService.getLogined().getBalance();
            customerService.Finan(customerService.getLogined().getUsername(),update);
            model.addAttribute("fname",customerService.getLogined().getFname());
            model.addAttribute("balance",customerService.getLogined().getBalance());
            return "shop1";
        }else{
            return "login";
        }
    }
}
