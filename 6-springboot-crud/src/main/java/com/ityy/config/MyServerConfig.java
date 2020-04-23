package com.ityy.config;

import com.ityy.servlet.MyFilter;
import com.ityy.servlet.MyListenner;
import com.ityy.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletContextListener;
import java.util.Arrays;
import java.util.EventListener;

@Configuration
public class MyServerConfig {
    //注册三大组件
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean<Servlet> servletServletRegistrationBean =
                new ServletRegistrationBean<>(new MyServlet(),"/myServlet");
        return  servletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new MyFilter());
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/myServlet","/hello"));
        return filterFilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean<ServletContextListener> eventListenerServletListenerRegistrationBean
                = new ServletListenerRegistrationBean<ServletContextListener>();
        eventListenerServletListenerRegistrationBean.setListener(new MyListenner());
        return eventListenerServletListenerRegistrationBean;
    }

    @Bean
    //以类的方式，定制嵌入式的servlet容器的相关规则/配置
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> embeddedServletContainerCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                //设置Tomcat的端口号
                factory.setPort(8081);
            }
        };
    }
}
