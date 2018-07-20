package com.nieyue.controller;

import com.nieyue.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 聂跃 on 2018/7/18.
 */
@RestController
public class ToolController {
    @Autowired
    ToolService toolService;
    @RequestMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return toolService.hi( name );
    }

}
