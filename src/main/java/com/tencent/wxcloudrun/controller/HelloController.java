package com.tencent.wxcloudrun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 软件手
 * @date: 2023/5/23 0:49
 * @description:
 */

// @RestController 转为josn 返回文本   @Controller  返回网页+数据
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

}
