## 配置yarn-site.xml

增加以下内容

```xml
<property>
    <name>yarn.log-aggregation-enable</name>
    <value>true</value>
i</property>
<property>  
    <name>yarn.log.server.url</name>  
    <value>http://${yarn.timeline-service.webapp.address}/applicationhistory/logs</value>
</property>
<property>
    <name>yarn.log-aggregation.retain-seconds</name>
    <value>604800</value>
</property>
<!--
<property>
    <name>yarn.timeline-service.enabled</name>
    <value>true</value>
</property>
<property>
    <name>yarn.timeline-service.hostname</name>
    <value>${yarn.resourcemanager.hostname}</value>
</property>
<property>
    <name>yarn.timeline-service.http-cross-origin.enabled</name>
    <value>true</value>
</property>
<property>
    <name>yarn.resourcemanager.system-metrics-publisher.enabled</name>
    <value>true</value>
</property>
-->
```

```sh
# 分发
xsync $HADOOP_HOME/etc/hadoop/yarn-site.xml
# 关闭NodeManager 、ResourceManager和HistoryServer
在102上执行： stop-yarn.sh
在101上执行： mapred --daemon stop historyserver
# 启动NodeManager 、ResourceManage、Timelineserver和HistoryServer
在102上执行：start-yarn.sh
在102上执行：yarn --daemon start timelineserver
在101上执行：mapred --daemon start historyserver
# 删除HDFS上已经存在的输出文件
hdfs dfs -rm -R /user/atguigu/output
# 执行WordCount程序
hadoop jar $HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-examples-3.1.3.jar wordcount /user/atguigu/input /user/atguigu/output
# 查看日志
http://hadoop101:19888/jobhistory
```

