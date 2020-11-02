###pom文件
####1.父项目
```xml
<parent>
    <artifactId>spring-boot-starter-parent</artifactId>
    <groupId>org.springframework.boot</groupId>
    <version>2.2.5.RELEASE</version>
</parent>
他的父项目
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.2.5.RELEASE</version>
    <relativePath>../../spring-boot-dependencies</relativePath>
  </parent>
他是来真正管理spring boot 应用里面的所有依赖版本号
```
spring版本仲裁中心，便于以后导入依赖不用再写版本号
####2.导入依赖
```xml
<!--		springboot依賴-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
spring-boot-starter-web：
   - spring-boot-starter:springboot场景启动器，帮我们导入web模块正常运行依赖的组件；
   
 spring boot将所有功能场景都抽取出来做成了一个个的starter 启动器，需要使用时，只需要将其场景启动器引入进来
 