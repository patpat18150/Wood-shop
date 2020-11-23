package ku.th.wood.controller;

import ku.th.wood.model.Wood;
import ku.th.wood.service.AddwoodService;
import ku.th.wood.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class HeliophyteController {
    private CustomerService customerService;
    private AddwoodService addwoodService;
    public HeliophyteController(CustomerService customerService,AddwoodService addwoodService){this.customerService = customerService;
        this.addwoodService = addwoodService;}
    private List<Wood> adenium;
    private List<Wood> shoe;
    @RequestMapping("/heliophyte")
    public String getAquaticPage(Model model) {
        if(addwoodService.woodInStock("adenium")!=null) {
            this.adenium = addwoodService.woodInStock("adenium");
            model.addAttribute("soldout1", addwoodService.woodInStock("adenium").size());
            if(addwoodService.woodInStock("adenium").size()==0){
                model.addAttribute("soldout1","sold out");
            }else{}
        }else{model.addAttribute("soldout1","sold out");}
        if(addwoodService.woodInStock("shoe")!=null) {
            this.shoe = addwoodService.woodInStock("shoe");
            model.addAttribute("soldout2", addwoodService.woodInStock("shoe").size());
            if(addwoodService.woodInStock("lotus").size()==0){
                model.addAttribute("soldout2","sold out");
            }else{}
        }else{model.addAttribute("soldout2","sold out");}

        if(customerService.getLogined()!=null){
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
        }else{
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
        }
        return "heliophyte";
    }
    @PostMapping("/adenium")
    public String BuyAdenium(Model model){
        if(customerService.getLogined()!=null){
            if( this.adenium!=null && this.adenium.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.adenium.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.adenium.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "heliophyte";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "heliophyte";
        }

    }
    @PostMapping("/shoe")
    public String BuyShoe(Model model){
        if(customerService.getLogined()!=null){
            if( this.shoe!=null && this.shoe.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.shoe.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.shoe.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "heliophyte";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "heliophyte";
        }

    }
}
