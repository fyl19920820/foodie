package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return "hello world!";
    }
}
