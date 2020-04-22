package com.ityy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping("/user")
@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        Map<String,Object> map,
                        HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123".equals(password)){
            session.setAttribute("user",username);
            return "redirect:/main.html";
        }
        map.put("msg","用户名或密码错误");
        return "login";
    }
}
