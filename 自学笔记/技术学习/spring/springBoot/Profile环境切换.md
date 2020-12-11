##profile功能
profile是springboot对不同环境提供不同配置功能的支持，可以通过激活指定参数快速切换环境

1.多profile文件形式

- 格式 application-{profile}.properties

2.多profile文档块模式

yaml中三个短线可以隔出来一个文档块
```yaml
server:
  port: 8082
spring:
    profiles:
      active: dev
---
server:
  port: 8083
spring:
  profiles: dev
---
server:
  port: 8283
spring:
  profiles: prod
```

3.激活方式
- 命令行 --spring.profiles.active=dev
- 配置文件 spring.profiles.active=dev
- jvm参数 -Dspring.profiles.active=dev