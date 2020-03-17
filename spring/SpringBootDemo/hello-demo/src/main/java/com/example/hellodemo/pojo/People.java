package com.example.hellodemo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Component
@ConfigurationProperties(prefix = "person")
//@PropertySource(value = "classpath:myapp.properties",encoding = "utf-8")
public class People {
    @Email(message = "邮箱格式错误！！")
    private String name;
    private Integer age;
    private Date birth;
    private Map<String,String> map;
    private List<String> list;
    private Dog dog;
//    JSR303校验
//    @Null	被注释的元素必须为 null
//    @NotNull	被注释的元素必须不为 null
//    @AssertTrue	被注释的元素必须为 true
//    @AssertFalse	被注释的元素必须为 false
//    @Min(value)	被注释的元素必须是一个数字，其值必须大于等于指定的最小值
//    @Max(value)	被注释的元素必须是一个数字，其值必须小于等于指定的最大值
//    @DecimalMin(value)	被注释的元素必须是一个数字，其值必须大于等于指定的最小值
//    @DecimalMax(value)	被注释的元素必须是一个数字，其值必须小于等于指定的最大值
//    @Size(max, min)	被注释的元素的大小必须在指定的范围内
//    @Digits (integer, fraction)	被注释的元素必须是一个数字，其值必须在可接受的范围内
//    @Past	被注释的元素必须是一个过去的日期
//    @Future	被注释的元素必须是一个将来的日期
//    @Pattern(value)	被注释的元素必须符合指定的正则表达式

//    @Email	被注释的元素必须是电子邮箱地址
//    @Length	被注释的字符串的大小必须在指定的范围内
//    @NotEmpty	被注释的字符串的必须非空
//    @Range	被注释的元素必须在合适的范围内

    public People() {
    }

    public People(String name, Integer age, Date birth, Map<String, String> map, List<String> list, Dog dog) {
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.map = map;
        this.list = list;
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }
}
