# window 上跑hadoop问题之java.lang.UnsatisfiedLinkError: org.apache.hadoop.io.nativeio.NativeIO$Windows.





1、系统环境变量配置HADOOP_HOME ，并且添加进path 变量里；

2、HADOOP_HOME\bin 里是否有hadoop.dll  和 winutils.exe 这两个文件

3、C: windows\System32  里是否有hadoop.dll 文件 ，重启电脑



# win本地运行

```java
FileInputFormat.setInputPaths(job, new Path("E:\\样例数据\\input\\"));
```

会出现以下错误

Exception in thread "main" java.lang.UnsatisfiedLinkError: org.apache.hadoop.io.nativeio.NativeIO$POSIX.stat(Ljava/lang/String;)Lorg/apache/hadoop/io/nativeio/NativeIO$POSIX$Stat;
	at org.apache.hadoop.io.nativeio.NativeIO$POSIX.stat(Native Method)
	at org.apache.hadoop.io.nativeio.NativeIO$POSIX.getStat(NativeIO.java:455)
	at org.apache.hadoop.fs.RawLocalFileSystem$DeprecatedRawLocalFileStatus.loadPermissionInfoByNativeIO(RawLocalFileSystem.java:796)

解决：把路径具体到文件，程序就可以正常运行了

```java
FileInputFormat.setInputPaths(job, new Path("E:\\样例数据\\input\\*"));
```

解决方式2

```
查看本地windows使用的动态链接库版本，将项目对应hadoopjar包更换成对应版本即可
```

