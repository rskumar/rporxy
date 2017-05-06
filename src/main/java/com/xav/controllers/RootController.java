package com.xav.controllers;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ravi on 5/6/2017.
 */
@Controller
public class RootController {

    @RequestMapping("/")
    String index(Model model){
        model.addAttribute("now", LocalDateTime.now());
        return "index";
    }
}
