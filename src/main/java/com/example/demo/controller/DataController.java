package com.example.demo.controller;

import com.example.demo.dao.InfoDao;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class DataController {

    @PostMapping("/commitInfo")
    public String commitInfo(InfoDao info){
        info.setDate(new Date());
        return "success!!!";
    }

}
