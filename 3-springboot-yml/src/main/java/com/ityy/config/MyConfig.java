package com.ityy.config;

import com.ityy.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    /**
     * @Bean :将方法的返回值添加到容器中，这个组件在容器中默认的ID就是方法名
     * @return
     */
    @Bean
    public HelloService helloService02(){
        return new HelloService();
    }
}
