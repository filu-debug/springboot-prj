package com.ityy;


import com.ityy.entity.Person;
import com.ityy.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ApplicationTests {
    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;


    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    void contextLoads2() {
        Boolean bean = ioc.containsBean("helloService02");
        System.out.println(bean);
    }

}
