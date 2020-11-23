package ku.th.wood.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import ku.th.wood.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ku.th.wood.model.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private int count = 0 ;
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping
    public String getCustomerPage(Model model) { ;
        return "customer";
    }
    @PostMapping
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        for( int i = 0 ;i<customerService.getCustomers().size(); i++){
            if(customerService.getCustomers().get(i).getUsername().equals(customer.getUsername())){
                count = count+1 ;
                break;
            }
        }
        if(count > 0 ){

        }else{
        customerService.createCustomer(customer);

        }
        count = 0;
        model.addAttribute("allCustomers", "register success");
        return "customer";
    }
}


