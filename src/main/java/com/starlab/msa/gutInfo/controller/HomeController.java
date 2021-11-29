package com.starlab.msa.gutInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/microbiome")
public class HomeController {

    @GetMapping("/inputpage")
    public String gotoInputPage() {
        return "inputpage";
    }
}
