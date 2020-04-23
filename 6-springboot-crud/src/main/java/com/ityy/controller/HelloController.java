package com.ityy.controller;

import com.fasterxml.jackson.databind.util.ObjectBuffer;
import com.ityy.exception.UserNotExistsException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user")String user){
        System.out.println(111);
        if(user.equals("aaa")){
            throw new UserNotExistsException("用户不存在!!");
        }
        return "hello";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        map.put("zs","张三");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

}
