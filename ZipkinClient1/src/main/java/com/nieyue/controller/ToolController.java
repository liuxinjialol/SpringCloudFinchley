package com.nieyue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 聂跃 on 2018/7/19.
 */
@RestController
public class ToolController {
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/zipkinclient1")
    public String callHome(){
        return restTemplate.getForObject("http://localhost:8989/info", String.class);
    }
    @RequestMapping("/info")
    public String info(){
        return "i'm zipkinclient1";

    }
}
