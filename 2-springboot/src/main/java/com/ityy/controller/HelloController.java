package com.ityy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody //将这个注解直接加在类上，表示：这个类的所有方法的return，都直接return给浏览器（如果是对象就转换为json数据）
//@Controller
@RestController//这个注解，相当于上面两个注解，更省事
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world quick";
    }
}
