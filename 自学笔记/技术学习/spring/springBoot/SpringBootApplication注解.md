###主程序类
```java
@SpringBootApplication// 此注解说明这是一个springboot应用
public class HelloWordApplication {
    public static void main(String[] args) {
        // 将spring应用启动起来
        SpringApplication.run(HelloWordApplication.class,args);
    }
}
```
@SpringBootApplication：spring boot应用标注再某个类上说明这个类是springboot的主配置类，springboot就应该运行这个类的main方法来启动springboot应用

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public @interface SpringBootApplication {
```
@SpringBootConfiguration:spring boot 配置类

   - 说明一个类是springboot配置类
   
   - @Configuration 配置类 就是一个@Component
 
@EnableAutoConfiguration:开启自动配置功能
```java
@AutoConfigurationPackage
@Import(AutoConfigurationImportSelector.class)
public @interface EnableAutoConfiguration {
```
-   @AutoConfigurationPackage 自动配置包

        @Import(AutoConfigurationPackages.Registrar.class)
        spring底层注解@import 给容器导入一个组件；导入的组件有AutoConfigurationPackages.Registrar.class
     将主配置类（@SpringBootApplication标注的类）的所在包以及下面所有的组件扫描到spring容器里面

- @Import(AutoConfigurationImportSelector.class)给容器导入组件
    
        AutoConfigurationImportSelector 导入了那些组件
        将所有需要导入的组件以全类名的形式返回；这些组件会被添加到容器中；
        会给容器中导入非常多的自动配置类（xxxAutoConfiguration）；就是给容器中导入这个场景需要的所有组件，并配置好这些组件；
        
    有了自动配置类，将手动编写配置注入功能组件的工作免去了；
    
    ```java
    SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),getBeanClassLoader());
    
    ```
    


   
    