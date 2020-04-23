package com.ityy.controller;

import com.ityy.exception.UserNotExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 定义自己的异常处理器,用以定制发生指定异常时，该响应哪些json数据
 */
@ControllerAdvice//必须要标上这个注解，才表示这是一个异常处理器
public class MyExceptionHandler {

//1、第一种方式，浏览器客户端返回的都是json数据
    /**
     * @ExceptionHandler 这个注解用来声明这个方法处理哪个类型的异常
     * @return
     */
    /*@ResponseBody
    @ExceptionHandler(UserNotExistsException.class)
    public Map UserException(Exception e){//接收异常信息
        Map<String,Object> map = new HashMap<>();
        map.put("code","user not exists");//自定义发生指定异常时，该响应哪些json数据
        map.put("time",new Date());
        map.put("message",e.getMessage());
        return map;
    }*/

//2、第二种方式，像springboot的处理一样，自适应：浏览器返回页面，其他客户端返回json数据

//  【注：】springboot捕获到/error请求后，会调用BasicErrorController进行这种自使用的处理，
//          所以，我们直接转发一个/error请求，让springboot帮我们做自适应处理即可
//         【不过仅仅是这样的话，我们拿不到自定义的数据，因为springboot取错误信息固定是从它的DefaultErrorAttributes类
//         中的errorAttributes集合里面取,请看MyErrorAttributes类，这是我们自定义的一个DefaultErrorAttributes类型的类，
//         为了使自定义的json数据，能被springboot灵活的、自适应的响应出来】
    @ExceptionHandler(UserNotExistsException.class)
    public String UserException(Exception e, HttpServletRequest request){//接收异常信息
        Map<String,Object> map = new HashMap<>();
        map.put("code","user not exists");//自定义发生指定异常时，该响应哪些json数据
        //写异常处理器，必须设置自己的状态码，不然默认就是200;springboot底层就是用这个长长的key，在请求域中获取状态码的
        request.setAttribute("javax.servlet.error.status_code","500");
        map.put("time",new Date());
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
