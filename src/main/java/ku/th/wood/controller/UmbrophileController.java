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
public class UmbrophileController {
    private CustomerService customerService;
    private AddwoodService addwoodService;
    public UmbrophileController(CustomerService customerService,AddwoodService addwoodService){this.customerService = customerService;
    this.addwoodService = addwoodService;}
    private List<Wood> dracaena;
    private List<Wood> croton;
    private List<Wood> philodendron;
    private List<Wood> variegata;
    @RequestMapping("/umbrophile")
    public String getUmbrophilePage(Model model) {
        if(addwoodService.woodInStock("dracaena")!=null) {
            this.dracaena = addwoodService.woodInStock("dracaena");
            model.addAttribute("soldout1", addwoodService.woodInStock("dracaena").size());
            if(addwoodService.woodInStock("dracaena").size()==0){
                model.addAttribute("soldout1","sold out");
            }else{}
        }else{model.addAttribute("soldout1","sold out");}
        if(addwoodService.woodInStock("philodendron")!=null) {
            this.philodendron = addwoodService.woodInStock("philodendron");
            model.addAttribute("soldout2", addwoodService.woodInStock("philodendron").size());
            if(addwoodService.woodInStock("philodendron").size()==0){
                model.addAttribute("soldout2","sold out");
            }else{}
        }else{model.addAttribute("soldout2","sold out");}
        if(addwoodService.woodInStock("croton")!=null) {
            this.croton = addwoodService.woodInStock("croton");
            model.addAttribute("soldout3", addwoodService.woodInStock("croton").size());
            if(addwoodService.woodInStock("croton").size()==0){
                model.addAttribute("soldout3","sold out");
            }else{}
        }else{model.addAttribute("soldout3","sold out");}

        if(addwoodService.woodInStock("variegata")!=null) {
            this.variegata = addwoodService.woodInStock("variegata");
            model.addAttribute("soldout4", addwoodService.woodInStock("variegata").size());
            if(addwoodService.woodInStock("variegata").size()==0){
                model.addAttribute("soldout4","sold out");
            }else{}
        }else{model.addAttribute("soldout4","sold out");}
        if(customerService.getLogined()!=null){
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
        }else{
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
        }
        return "umbrophile";
    }
    @PostMapping("/dracaena")
    public String BuyDracaena(Model model){
        if(customerService.getLogined()!=null){
            if( this.dracaena!=null && this.dracaena.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.dracaena.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.dracaena.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "umbrophile";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "umbrophile";
        }

    }
    @PostMapping("/philodendron")
    public String BuyPhilodendron(Model model){
        if(customerService.getLogined()!=null){
            if( this.philodendron!=null && this.philodendron.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.philodendron.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.philodendron.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "umbrophile";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "umbrophile";
        }

    }
    @PostMapping("/croton")
    public String BuyCroton(Model model){
        if(customerService.getLogined()!=null){
            if( this.croton!=null && this.croton.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.croton.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.croton.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "umbrophile";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "umbrophile";
        }

    }
    @PostMapping("/variegata")
    public String BuyVariegata(Model model){
        if(customerService.getLogined()!=null){
            if( this.variegata!=null && this.variegata.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.variegata.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.variegata.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "umbrophile";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "umbrophile";
        }

    }
}