package com.example.demo.controller;

import com.example.demo.dao.Info;
import com.example.demo.dao.InfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    InfoDao infoDao;

    //返回主页面
    @RequestMapping("/index")
    public String home (){
        return "index";
    }

    @GetMapping("/search")
    public String search(){
        return "search";
    }

    @GetMapping("/addProduct")
    public String add(){
        return "add";
    }
}
