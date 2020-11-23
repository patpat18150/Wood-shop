package ku.th.wood.controller;

import ku.th.wood.model.Customer;
import ku.th.wood.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    private CustomerService customerService;
    public LoginController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping
    public String getLoginPage(){
        return "login";
    }
    @PostMapping
    public String login(@ModelAttribute Customer customer,Model model){
        Customer matchingCustomer = customerService.checkPin(customer);
        if (matchingCustomer != null) {
            model.addAttribute("fname",matchingCustomer.getFname());
            model.addAttribute("balance",matchingCustomer.getBalance());
            return "shop1" ;
        } else {
            model.addAttribute("greeting", "Can't find customer");
            return "home";
        }
    }

}
