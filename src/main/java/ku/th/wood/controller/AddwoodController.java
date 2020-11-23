package ku.th.wood.controller;

import ku.th.wood.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ku.th.wood.model.*;

@Controller
@RequestMapping("/addwood")
public class AddwoodController {
    private int count = 0 ;
    private AddwoodService addwoodService;

    public AddwoodController(AddwoodService addwoodService) {
        this.addwoodService = addwoodService;
    }

    @RequestMapping
    public String getAddwoodPage(Model model) {
        return "addwood";
    }
    @PostMapping
    public String registerWood(@ModelAttribute Wood wood, Model model) {
        for( int i = 0 ;i<addwoodService.getWoods().size(); i++){
            if(addwoodService.getWoods().get(i).getWoodId().equals(wood.getWoodId())){
                count = count+1 ;
                break;
            }
        }
        if(count > 0 ){
            System.out.println("This woodId has been used");
            model.addAttribute("AddWoodAlert","This woodId has been used");
        }else{
            addwoodService.createWood(wood);
            model.addAttribute("AddWoodAlert","Add wood Success");
        }
        count = 0;
        return "addwood";
    }
}
