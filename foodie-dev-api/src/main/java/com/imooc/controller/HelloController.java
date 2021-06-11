package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * description: HelloController
 * date: 2021/5/26 8:53 下午
 * author: fengyunlong
 * version: 1.0
 */
@RestController
@ApiIgnore
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
