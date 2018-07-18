package com.nieyue.hystrix;

import com.nieyue.service.ToolService;
import org.springframework.stereotype.Component;

@Component
public class ToolServiceHystrix implements ToolService {
    @Override
    public String hi(String name) {
        return "sorry "+name;
    }
}