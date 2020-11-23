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
public class AquaticController {
    private CustomerService customerService;
    private AddwoodService addwoodService;
    public AquaticController(CustomerService customerService,AddwoodService addwoodService){this.customerService = customerService;
        this.addwoodService = addwoodService;}
    private List<Wood> pennywort;
    private List<Wood> lotus;
    private List<Wood> hydrilla;
    private List<Wood> loosestrife;
    @RequestMapping("/aquatic")
    public String getAquaticPage(Model model) {
        if(addwoodService.woodInStock("pennywort")!=null) {
            this.pennywort = addwoodService.woodInStock("pennywort");
            model.addAttribute("soldout1", addwoodService.woodInStock("pennywort").size());
            if(addwoodService.woodInStock("pennywort").size()==0){
                model.addAttribute("soldout1","sold out");
            }else{}
        }else{model.addAttribute("soldout1","sold out");}
        if(addwoodService.woodInStock("lotus")!=null) {
            this.lotus = addwoodService.woodInStock("lotus");
            model.addAttribute("soldout2", addwoodService.woodInStock("lotus").size());
            if(addwoodService.woodInStock("lotus").size()==0){
                model.addAttribute("soldout2","sold out");
            }else{}
        }else{model.addAttribute("soldout2","sold out");}
        if(addwoodService.woodInStock("hydrilla")!=null) {
            this.hydrilla = addwoodService.woodInStock("hydrilla");
            model.addAttribute("soldout3", addwoodService.woodInStock("hydrilla").size());
            if(addwoodService.woodInStock("hydrilla").size()==0){
                model.addAttribute("soldout3","sold out");
            }else{}
        }else{model.addAttribute("soldout3","sold out");}

        if(addwoodService.woodInStock("loosestrife")!=null) {
            this.loosestrife = addwoodService.woodInStock("loosestrife");
            model.addAttribute("soldout4", addwoodService.woodInStock("loosestrife").size());
            if(addwoodService.woodInStock("loosestrife").size()==0){
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
        return "aquatic";
    }
    @PostMapping("/pennywort")
    public String BuyPennywort(Model model){
        if(customerService.getLogined()!=null){
            if( this.pennywort!=null && this.pennywort.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.pennywort.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.pennywort.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "aquatic";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "aquatic";
        }

    }
    @PostMapping("/lotus")
    public String BuyLotus(Model model){
        if(customerService.getLogined()!=null){
            if( this.lotus!=null && this.lotus.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.lotus.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.lotus.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "aquatic";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "aquatic";
        }

    }
    @PostMapping("/hydrilla")
    public String BuyHydrilla(Model model){
        if(customerService.getLogined()!=null){
            if( this.hydrilla!=null && this.hydrilla.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.hydrilla.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.hydrilla.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "aquatic";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "aquatic";
        }

    }
    @PostMapping("/loosestrife")
    public String BuyLoosestrife(Model model){
        if(customerService.getLogined()!=null){
            if( this.loosestrife!=null && this.loosestrife.get(0).getPrice()<customerService.getLogined().getBalance()){
                Double update = customerService.getLogined().getBalance() - this.loosestrife.get(0).getPrice();
                customerService.Finan(customerService.getLogined().getUsername(),update);
                addwoodService.deleteWoodByWoodId(this.loosestrife.get(0).getWoodId());
                return "bill";
            }
            model.addAttribute("notlogin","not enough balance");
            model.addAttribute("balance",customerService.getLogined().getBalance());
            model.addAttribute("fname",customerService.getLogined().getFname());
            return "aquatic";
        }else {
            model.addAttribute("notlogin","You are offline");
            model.addAttribute("balance","You are offline");
            model.addAttribute("fname","You are offline");
            return "aquatic";
        }

    }
}
