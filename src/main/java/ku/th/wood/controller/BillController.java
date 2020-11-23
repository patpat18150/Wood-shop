package ku.th.wood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BillController {
    @RequestMapping("/bill")
    public String getBillPage(Model model) {
        // return home.html
        return "bill";
    }
    @PostMapping("gotoshop1")
    public String goToHomePage(Model model){
        return "umbrophile";
    }
}
