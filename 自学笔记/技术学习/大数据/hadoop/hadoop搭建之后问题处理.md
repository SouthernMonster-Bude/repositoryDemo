# 问题

## 问题1

```shell
[root@hadoop101 hadoop-3.1.3]# sbin/stop-dfs.sh
Starting namenodes on [hadoop101]
ERROR: Attempting to operate on hdfs namenode as root
ERROR: but there is no HDFS_NAMENODE_USER defined. Aborting operation.
Starting datanodes
ERROR: Attempting to operate on hdfs datanode as root
ERROR: but there is no HDFS_DATANODE_USER defined. Aborting operation.
Starting secondary namenodes [hadoop103]
ERROR: Attempting to operate on hdfs secondarynamenode as root
ERROR: but there is no HDFS_SECONDARYNAMENODE_USER defined. Aborting operation.
```

```sh
解决：
是因为缺少用户定义造成的，所以分别编辑开始和关闭脚本
$ vim sbin/start-dfs.sh
$ vim sbin/stop-dfs.sh
在顶部空白处添加内容：
HDFS_DATANODE_USER=root
HADOOP_SECURE_DN_USER=hdfs
HDFS_NAMENODE_USER=root
HDFS_SECONDARYNAMENODE_USER=root
```

## 问题2

```sh
Starting resourcemanager
ERROR: Attempting to launch yarn resourcemanager as root
ERROR: but there is no YARN_RESOURCEMANAGER_USER defined. Aborting launch.
Starting nodemanagers
ERROR: Attempting to launch yarn nodemanager as root
ERROR: but there is no YARN_NODEMANAGER_USER defined. Aborting launch.
```

```sh
解决：
$ vim sbin/start-yarn.sh
$ vim sbin/stop-yarn.sh

在顶部空白处添加内容
YARN_RESOURCEMANAGER_USER=root
HADOOP_SECURE_DN_USER=yarn
YARN_NODEMANAGER_USER=root
```

## 问题3

```sh
hadoop101: ERROR: JAVA_HOME is not set and could not be found.
hadoop102: ERROR: JAVA_HOME is not set and could not be found.
hadoop103: ERROR: JAVA_HOME is not set and could not be found.
```

```
解决
 输入java –version，查看jdk是否安装成功
 输入export，查看jdk环境变量是否设置成功
 在集群环境下，即使各结点都正确地配置了JAVA_HOME，也会报如下错误
 在hadoop-env.sh\my-env.sh(自定义的环境变量文件)中，再显式的重新声明一遍JAVA_HOME
```

### 问题4

```sh
[myhadoop@hadoop101 hadoop-3.1.3]$ hadoop fs -mkdir /cms
mkdir: Cannot create directory /cms. Name node is in safe mode.
```

```
离开安全模式方法
  bin/hadoop  dfsadmin -safemode leave
若不处理安全模式的话，web服务无法启动，dfsadmin report结果异常
```

## 问题5

2021-02-24 10:12:05,311 WARN org.apache.hadoop.hdfs.server.common.Storage: Failed to add storage directory [DISK]file:/opt/module/hadoop-3.1.3/data/dfs/data
java.io.IOException: Incompatible clusterIDs in /opt/module/hadoop-3.1.3/data/dfs/data: namenode clusterID = CID-a03fdbe3-f7b0-47ec-b361-0e0b0324672f; datanode clusterID = CID-efaee799-8fa9-4ba4-9227-6b022a2bd58a
        at ...
2021-02-24 10:12:05,314 ERROR org.apache.hadoop.hdfs.server.datanode.DataNode: Initialization failed for Block pool <registering> (Datanode Uuid ff4744a8-a02f-4fee-8bf1-3dbc89bb14da) service to hadoop101/127.0.0.1:8020. Exiting.....

解决:

```
cd /opt/module/hadoop-3.1.3/data/dfs/data
vim VERSION
# 将clusterID 修改成另一个
```

## 问题6

初始化hadoop集群的方法，删除目录下data和logs，还有/tmp目录下和hadoop相关的文件，格式化集群

`rm -rf /opt/module/hadoop-3.1.3/data/ /opt/module/hadoop-3.1.3/logs/ /tmp/hsperfdata_myhadoop/ /tmp/hadoop*`

`hdfs namenode -format`

## 问题7

启动集群之后，报host unreachable，can't resolve hostname,unknown host exception

重新正确配置/etc/hosts 和hostname

## 问题8

xsync 同步过data目录的话会导致dn节点只会出现一个的问题，修复方法同问题6



## 问题9

启动Hadoop 报错：Problem connecting to server: node100/192.168.197.128:9000

> 原因分析

> 启动Hadoop,在主节点启动`./start-all.sh`后，主节点会去启动datanode，datanode再访问主节点的9000端口作为回应，此时需要主节点有在监听外部IP，之所以报这个错误，是因为主节点压根就没去监听外部访问



> 先看/etc/hosts内容如下

```
127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4
::1         localhost localhost.localdomain localhost6 localhost6.localdomain6
192.168.197.128 node100
192.168.197.129 node200
192.168.197.130 node300
```

> 因为有`localhost`的原因，主节点就没有去监听其他主机的访问，仅仅在监听本机的访问，也可以通过下面的命令来查看

```
$ netstat -an | grep 9000
tcp        0      0 127.0.0.1:9000          0.0.0.0:*               LISTEN     
tcp        0      0 127.0.0.1:42923         127.0.0.1:9000          TIME_WAIT
```

>解决方案：
>
>直接将前面两行的内容注销掉，**重新启动hadoop**，再查看监听的端口

```
netstat -an | grep 9000
tcp        0      0 192.168.197.128:9000    0.0.0.0:*               LISTEN     
tcp        0      0 192.168.197.128:9000    192.168.197.129:43951   ESTABLISHED
tcp        0      0 192.168.197.128:39744   192.168.197.128:9000    TIME_WAIT  
tcp        0      0 192.168.197.128:9000    192.168.197.130:37237   ESTABLISHED
```

## 问题10

hadoop 8088端口无法访问 50070可以访问





修改yarn-site.xml文件，将其<configuration></configuration>中的配置修改为：

```xml

<configuration>
 
<!-- Site specific YARN configuration properties -->
        <property>
                <name>yarn.resourcemanager.hostname</name>
                <value>xxxx</value>   <!--填写自定义的主机名/ip-->
        </property>
        <property>
                <name>yarn.nodemanager.aux-services</name>
                <value>mapreduce_shuffle</value>
        </property>
        <property>
                <name>yarn.resourcemanager.address</name>
                <value>0.0.0.0:8032</value>
         </property>
         <property>
                <name>yarn.resourcemanager.scheduler.address</name>
                <value>0.0.0.0:8030</value>
         </property>
         <property>
                <name>yarn.resourcemanager.resource-tracker.address</name>
                <value>0.0.0.0:8031</value>
         </property>
         <property>
                <name>yarn.resourcemanager.admin.address</name>
                <value>0.0.0.0:8033</value>
         </property>
         <property>
                <name>yarn.resourcemanager.webapp.address</name>
                <value>0.0.0.0:8088</value>
         </property>
</configuration>
```

