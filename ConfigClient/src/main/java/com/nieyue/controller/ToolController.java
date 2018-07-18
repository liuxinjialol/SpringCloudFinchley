package com.nieyue.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 聂跃 on 2018/7/18.
 */
@RestController
public class ToolController {
    @Value("${mySpringCloudConfig.test1}")
    String test1;
    @RequestMapping(value = "/hi")
    public String hi(){
        return test1;
    }
}
