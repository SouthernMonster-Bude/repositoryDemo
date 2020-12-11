package com.hjm.boot.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties 将配置文件中的每一个属性的值，映射到这个组件中
 * 告诉springboot将本类中所有的属性和配置文件中相关的配置进行绑定
 * prefix 指定配置文件那个属性进行一一映射
 * 只有这个组件是spring中的组件才能使用这个功能
 */
//@PropertySource(value = {"classpath:people.properties"})
@PropertySource(value = {"classpath:people.yml"})
@ConfigurationProperties(prefix = "people")
@Component
public class People {
    private String firstName;
    private String lastName;
    private Integer age;
    private Date birth;
    private Boolean boss;
    private Map<String,Object> map;
    private List<Object> list;
    private Dog dog;

    @Override
    public String toString() {
        return "People{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", boss=" + boss +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}

/**
 * @author Houjiemu
 * @create 2020-11-03 13:42
 */
