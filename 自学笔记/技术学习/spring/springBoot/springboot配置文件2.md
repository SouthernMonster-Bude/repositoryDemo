###读取指定配置文件
@PropertySource 导入properties配置文件
```java
@PropertySource(value = {"classpath:people.properties"})
@ConfigurationProperties(prefix = "people")
@Component
public class People {
```

@ImportResource 导入spring的配置文件，让配置文件里面的内容生效
spring boot里面没有spring配置文件，我们自己编写的配置文件也不能自动识别；

想让自己的spring配置文件生效使用@ImportResource标注在一个配置类上
```java
@ImportResource(location = {"xxx.xml"})
```

####springboot推荐的 给容器增加组件的方法；推荐使用全注解的方式
1.配置类====spring配置文件

2.@Configuration 和@Bean给容器添加组件


###配置文件占位符
person.name=名字${random.uuid}
person.age=${random.int}
person.age=${person.hello:hello} // 冒号后面是默认值
