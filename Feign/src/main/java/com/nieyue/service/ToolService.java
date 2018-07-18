package com.nieyue.service;

import com.nieyue.hystrix.ToolServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 聂跃 on 2018/7/18.
 */
@FeignClient(value="eureka-client" ,fallback=ToolServiceHystrix.class)
public interface ToolService {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String hi(@RequestParam(value = "name") String name);
}
