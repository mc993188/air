package org.example.springclass.demos.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;

@Controller
public class ComeController {
    @GetMapping("/come")
    public String toLoginPage(Model model){
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }
}
