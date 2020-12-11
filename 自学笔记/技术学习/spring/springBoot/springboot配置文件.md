##配置文件

spring配置文件使用一个全局配置文件，配置文件名称固定；
- application.properties
- application.yml

配置文件的作用，修改springboot自动配置的默认值；springboot在底层给项目自动配置了一些参数；

YAML（YAML Ain't Markup Language）
一种标记语言，以数据为中心，比json和xml更适合做配置文件 

YAML:
```yaml
server:
    port: 8081
```
properties:
```properties
server.port=8081
```
XML:
```xml
<server>
    <port>8081</port>
</server>
```

##YAML语法
###1.基本语法
k:(空格)v 表示一堆键值对

以空格缩进控制层级关系
```yaml
server:
    port: 8080
    ip: 172.0.0.0
```
###2.值的写法
####2.1字面量 能用字符串表示的值
k: v

字符串默认不用加上单引号和双引号；

加上双引号的时候不会转义里面的特殊字符；
如name: "kk \n ll";输出kk (换行符) ll

加上单引号会转义,特殊字符会转义成为普通字符串
如name: 'kk \n ll';输出kk \n ll
####2.2对象、Map（属性和值）
k: v
注意缩进
```yaml
server:
    port: 8080
    ip: 172.0.0.0
#行内写法
server2: {port: 8080,ip: 172.0.0.0}
```
####数组和list
使用短线表示数组中的一个元素
```yaml
pets:
    - cat
    - dog
    - pig
#行内写法
pets2: [cat,dog,pig]
```
####2.3 @ConfigurationProperties注解
```yaml
people:
  firstName: 张
  lastName: 三
  age: 10
  birth: 2010/5/6
  boss: true
  map: {book: 三天光明,cito: gde}
  list: ["hhd",112]
  dog:
    name: 小狗
    age: 4
```
在yml中做映射的时候firstName和first-name是等价的
```java
/**
 * @ConfigurationProperties 将配置文件中的每一个属性的值，映射到这个组件中
 * 告诉springboot将本类中所有的属性和配置文件中相关的配置进行绑定
 * prefix 指定配置文件那个属性进行一一映射
 * 只有这个组件是spring中的组件才能使用这个功能
 */
@Component
@ConfigurationProperties(prefix = "people")
public class People {
    private String firstName;
    private String lastName;
    private Integer age;
    private Date birth;
    private Boolean boss;
    private Map<String,Object> map;
    private List<Object> list;
    private Dog dog;
    //...
}
```
引入依赖
```xml
<!--导入配置文件处理器-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```

注意：也可以使用@Value("字面量/${key}配置文件或者环境变量中获取值/#{SpEl}"),给某个属性赋值
```java
@Component
public class People {
    @Value("${people.firstName}")
    private String firstName;
    @Value("#{11*5}")
    private Integer age;
    @Value("true")
    private Boolean boss;
}
```
| 功能| @ConfigurationProperties|@Value |
|----|----|----|
| 松散绑定| 支持|不支持 |
| spEL| 不支持|支持 |
| jsr303数据校验| 支持|不支持 |

如果我们只需要从配置文件中获取某一个值的时候使用@Value

如果我们专门有个javaBean来映射配置属性，使用@ConfigurationProperties
##springboot单元测试
引入依赖
```xml
<!--		测试启动器-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
</dependency>
```
创建测试类Application
```java
/**
 * springboot 单元测试
 * 可以在测试期间很方便的类似编码一样
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestApplication {
    @Autowired
    People person;
    @Test
    public void contexrLoad(){
        System.out.println(person);
    }
}
```