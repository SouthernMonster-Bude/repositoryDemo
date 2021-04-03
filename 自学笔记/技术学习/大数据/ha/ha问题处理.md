



## Unable to check if JNs are ready for formatting 

hdfs namenode -format 过程不成功



##  Directory */dfs/name is in an inconsistent state

```xml
<!-- core-site.xml文件中增加-->
<property>
        <name>hadoop.tmp.dir</name>
        <value>/opt/module/hadoop-3.1.3/data</value>
</property>
```

## Call From master/192.168.10.200 to slave1:8485 failed on connection exception

```xml
<!--修改core-site.xml中的ipc参数,防止出现连接journalnode服务ConnectException-->
<property>
    <name>ipc.client.connect.max.retries</name>
    <value>100</value>
    <description>Indicates the number of retries a client will make to establish a server connection.</description>
</property>
<property>
    <name>ipc.client.connect.retry.interval</name>
    <value>10000</value>
    <description>Indicates the number of milliseconds a client will wait for before retrying to establish a server connection.</description>
</property>
```









