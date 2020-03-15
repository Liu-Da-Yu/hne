package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //返回主页面
    @RequestMapping("/index")
    public String home (){
        return "index";
    }

    @GetMapping("/search")
    public String search(){

        return "search";
    }

}
