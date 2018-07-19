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


    @RequestMapping("/info")
    public String callHome(){
        return "i'm zipkinclient2";
    }
    @RequestMapping("/zipkinclient2")
    public String info(){
        return restTemplate.getForObject("http://localhost:8988/info",String.class);
    }
}
