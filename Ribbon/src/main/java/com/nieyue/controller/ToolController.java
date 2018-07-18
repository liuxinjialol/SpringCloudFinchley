package com.nieyue.controller;

import com.nieyue.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 聂跃 on 2018/7/18.
 */
@RestController
public class ToolController {
    @Autowired
    ToolService toolService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return toolService.hiService( name );
    }
    @GetMapping(value = "/getSession")
    public String getSession() {
        return toolService.getSessionService( );
    }
}
