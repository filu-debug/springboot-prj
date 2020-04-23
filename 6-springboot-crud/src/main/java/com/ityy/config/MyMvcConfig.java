package com.ityy.config;

import com.ityy.component.MyLocalResolver;
import com.ityy.interceptor.LoginInterceptor;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

//使用WebMvcConfigurer，可以扩展springMVC的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 所有的WebMvcConfigurer组件都会一起起作用，我们自己的和springboot默认的。
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //haha请求，映射到success.html页面(前缀后缀由模板引擎自动解析)
                registry.addViewController("/haha").setViewName("success");
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            /**
             * 向容器中注册写好的拦截器
             */
            /*@Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/login.html","/","/user/login","/asserts/**","/webjars/**");
            }*/
        };
        return webMvcConfigurer;
    }
    /**
     * 国际化
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }



}
