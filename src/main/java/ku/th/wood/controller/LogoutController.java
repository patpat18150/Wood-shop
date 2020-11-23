package ku.th.wood.controller;

import ku.th.wood.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    private CustomerService customerService;
    public  LogoutController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping
    public String getLogoutPage(){
        return "logout";
    }
    @PostMapping
    public String Logout(Model model){
        System.out.println("try to logout 1");
        if(customerService.getLogined()!=null){
            customerService.getLogout(customerService.getLogined().getUsername());
        }else{
            model.addAttribute("alert","You are not logined yet");
            return "logout";
        }
        model.addAttribute("greeting","Thank you" + ",   " + "See you again");
        return "home";
    }
}
