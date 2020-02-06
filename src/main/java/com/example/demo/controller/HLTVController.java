package com.example.demo.controller;

import com.example.demo.service.hltv.HLTVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class HLTVController {
    @Autowired
    private HLTVService hltvService;

    @GetMapping("/hltv/show")
    @ResponseBody
    public String show(){
        try {
            return hltvService.parse();
        } catch (IOException e) {
           e.printStackTrace();
           return "ERROR";
        }
    }
}
