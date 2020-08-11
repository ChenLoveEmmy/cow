package com.alan.cow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String index(){
        return "login";
    }

    @RequestMapping(value = "/index")
    public String mainFrame() {
        return "/mainFrame";
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "index2";
    }
}
