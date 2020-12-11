##Springboot日志
底层使用sl4j+logback
同时使用了jul-to-sl4j、log4j-over-sl4j和jcl-over-sl4j去适配其他的日志系统

springboot引入其他框架的时候一定要移除掉该框架自带的日志框架依赖