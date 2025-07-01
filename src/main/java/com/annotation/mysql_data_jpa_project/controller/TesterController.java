package com.annotation.mysql_data_jpa_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TesterController {

    @RequestMapping("/tester")
    public String getTester() {
        return "index.html";
    }

}
