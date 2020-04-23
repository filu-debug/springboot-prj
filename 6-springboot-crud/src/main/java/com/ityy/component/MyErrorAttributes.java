package com.ityy.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 给容器中加入我们自己定义的错误属性
 * 【将自定义的json数据放到springboot指定的集合里面，springboot处理异常时自适应响应json数据的时候，
 * 就是从DefaultErrorAttributes类的errorAttributes集合里面取的】
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","atguigu");
        //我们的异常处理器携带的数据
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext",0);
        map.put("ext",ext);
        return map;
    }

    /**
     * 必须调用父类的构造方法，传入true，不然exception(异常类型)取不出来：
     *  exception:java.lang.ClassCastException
     */
    public MyErrorAttributes() {
        super(true);
    }
}

