package com.demo.i18n.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
    @GetMapping("/i18n")
    public String getInternationalPage() {
        return "international";
    }

}
