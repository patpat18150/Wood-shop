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
public class OtherController {
    private CustomerService customerService;
    private AddwoodService addwoodService;
    public OtherController(CustomerService customerService,AddwoodService addwoodService){this.customerService = customerService;
        this.addwoodService = addwoodService;}
    private List<Wood> osmo;
    private List<Wood> coconut;
    private List<Wood> pot;
    private List<Wood> wire;
    @RequestMapping("/others")
    public String getUmbrophilePage(Model model) {
        if(addwoodService.woodInStock("osmo")!=null) {
            this.osmo = addwoodService.woodInStock("osmo");
            model.addAttribute("soldout1", addwoodService.woodInStock("osmo").size());
            if(addwoodService.woodInStock("osmo").size()==0){
                model.addAttribute("soldout1","sold out");
            }else{}
        }else{model.addAttribute("soldout1","sold out");}
        if(addwoodService.woodInStock("coconut")!=null) {
            this.coconut = addwoodService.woodInStock("coconut");
            model.addAttribute("soldout2", addwoodService.woodInStock("coconut").size());
            if(addwoodService.woodInStock("coconut").size()==0){
                model.addAttribute("soldout2","sold out");
            }else{}
        }else{model.addAttribute("soldout2","sold out");}
        if(addwoodService.woodInStock("pot")!=null) {
            this.pot = addwoodService.woodInStock("pot");
            model.addAttribute("soldout3", addwoodService.woodInStock("pot").size());
            if(addwoodService.woodInStock("pot").size()==0){
                model.addAttribute("soldout3","sold out");
            }else{}
        }else{model.addAttribute("soldout3","sold out");}

        if(addwoodService.woodInStock("wire")!=null) {
            this.wire = addwoodService.woodInStock("wire");
            model.addAttribute("soldout4", addwoodService.woodInStock("wire").size());
            if(addwoodService.woodInStock("wire").size()==0){
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
        return "others";
    }
    @PostMapping("/osmo")
    public String BuyOsmo(Model model){
        if(customerService.getLogined()!=null){
            if( this.osmo!=null && this.osmo.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.osmo.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.osmo.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "others";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "others";
        }

    }
    @PostMapping("/coconut")
    public String BuyCoconut(Model model){
        if(customerService.getLogined()!=null){
            if( this.coconut!=null && this.coconut.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.coconut.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.coconut.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "others";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "others";
        }

    }
    @PostMapping("/pot")
    public String BuyPot(Model model){
        if(customerService.getLogined()!=null){
            if( this.pot!=null && this.pot.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.pot.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.pot.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "others";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "others";
        }

    }
    @PostMapping("/wire")
    public String BuyWire(Model model){
        if(customerService.getLogined()!=null){
            if( this.wire!=null && this.wire.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.wire.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.wire.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "others";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "others";
        }

    }
}
