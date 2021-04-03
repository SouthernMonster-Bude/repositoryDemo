## 核心配置文件core-site.xml

```sh
cd $HADOOP_HOME/etc/hadoop
vim core-site.xml
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
    <!-- nameNode地址 -->
    <property>
        <name>fs.defaultFS</name>
        <value>hdfs://hadoop101:8020</value>
    </property>
    <!-- hadoop数据存放路径 -->
    <property>
        <name>hadoop.tmp.dir</name>
        <value>/opt/module/hadoop-3.1.3/data</value>
    </property>
    <!-- 兼容hive的配置 -->
    <property>
        <name>hadoop.proxyuser.atguigu.hosts</name>
        <value>*</value>
    </property>
    <property>
        <name>hadoop.proxyuser.atguigu.groups</name>
        <value>*</value>
    </property>
    <property>
        <name>hadoop.http.staticuser.user</name>
        <value>atguigu</value>
    </property>
</configuration>
```

## HDFS配置文件hdfs-site.xml

```sh
vim hdfs-site.xml
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
    <property>
        <name>dfs.datanode.name.dir</name>
        <value>file://${hadoop.data.dir}/name</value>
     </property>
     <property>
        <name>dfs.datanode.data.dir</name>
        <value>file://${hadoop.data.dir}/data</value>
     </property>
    <property>
        <name>dfs.namenode.checkpoint.dir</name>
            <value>file://${hadoop.data.dir}/namesecondary</value>
     </property>
    <property>
        <name>dfs.client.datanode-restart.timeout</name>
        <value>30</value>
     </property>
    <property>
        <name>dfs.namenode.secondary.http-address</name>
        <value>hadoop103:9868</value>
     </property>
</configuration>
```

## YARN配置文件yarn-site.xml

```
vim yarn-site.xml
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>

<configuration>
    <property>
        <name>yarn.nodemanager.aux-services</name>
        <value>mapreduce_shuffle</value>
    </property>
    <property>
        <name>yarn.resourcemanager.hostname</name>
        <value>hadoop102</value>
    </property>
    <property>
        <name>yarn.nodemanager.env-whitelist</name>
        <value>JAVA_HOME,HADOOP_COMMON_HOME,HADOOP_HDFS_HOME,HADOOP_CONF_DIR,CLASSPATH_PREPEND_DISTCACHE,HADOOP_YARN_HOME,HADOOP_MAPRED_HOME</value>
    </property>
    <property>
        <name>yarn.scheduler.minimum-allocation-mb</name>
        <value>512</value>
    </property>
    <property>
        <name>yarn.scheduler.maximum-allocation-mb</name>
        <value>4096</value>
    </property>
    <property>
        <name>yarn.nodemanager.resource.memory-mb</name>
        <value>4096</value>
    </property>
    <property>
        <name>yarn.nodemanager.pmem-check-enabled</name>
        <value>false</value>
    </property>
    <property>
        <name>yarn.nodemanager.vmem-check-enabled</name>
        <value>false</value>
    </property>
</configuration>
```

## MapReduce配置文件mapred-site.xml

```
vim mapred-site.xml
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
    <property>
        <name>mapreduce.framework.name</name>
        <value>yarn</value>
    </property>
</configuration>
```

