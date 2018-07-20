package com.nieyue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Base64;

/**
 * Created by 聂跃 on 2018/7/17.
 */
@RestController
public class ToolController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name,
    HttpSession session) {
        System.err.println(session.getId());
        return "hi " + name + " ,i am from port:" + port;
    }
    @RequestMapping("/getSession")
    public String getSession( HttpSession session) {

        return new String(Base64.getEncoder().encode(session.getId().getBytes()));
    }
    @RequestMapping("/aa")
    public Object aa( HttpSession session) {
        BoundHashOperations<String, Object, Object> aa = stringRedisTemplate.boundHashOps("aa");
        aa.put("cds","sdfsdf");
        return aa.get("cds");
    }
}
