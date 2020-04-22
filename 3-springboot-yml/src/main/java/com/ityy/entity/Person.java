package com.ityy.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将yml配置文件中配置的每一个属性的值，映射到这个组件中,需要用到@ConfigurationProperties注解
 *      @ConfigurationProperties ：告诉springboot，将本类中的所有属性，和配置文件中相关的数据进行绑定
 *      prefix = "Person" :指明将配置文件中，哪个前缀下面的属性，进行一一映射。
 */
@Component
//@Validated
@PropertySource(value = "classpath:person.properties")
@ConfigurationProperties(prefix ="person")
public class Person {
    @Email  //表示：pername必须是邮箱格式
    private String pername;
    private String gender;
    private Date birth;
    private List<Object> list;
    private Map<String,Object> map;
    private Dog dog;

    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pername='" + pername + '\'' +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                ", list=" + list +
                ", map=" + map +
                ", dog=" + dog +
                '}';
    }
}
