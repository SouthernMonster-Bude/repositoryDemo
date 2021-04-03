## MYSQL安装file conflicts with file from package mariadb-libs-1:5.5.65-1.el7.x86_64报错

mysql安装包与mariadb包冲突，那么那么只要删除mariadb包即可

```
rpm -qa|grep -i mariadb
yum remove mariadb-libs-****
```

## User: myhadoop is not allowed to impersonate root (state=08S01,code=0)

将etc/hadoop/core-site.xml文件中相关配置改成以下配置

```
<property>
    <name>hadoop.proxyuser.myhadoop.hosts</name>
    <value>*</value>
</property>
<property>
    <name>hadoop.proxyuser.myhadoop.groups</name>
    <value>*</value>
</property>
```



## 1.2 GB of 1 GB physical memory used; 2.2 GB of 2.1 GB virtual memory used. Killing contain





修改所有nodemanager的yarn-site.xml配置文件，添加如下：

yarn.nodemanager.vmem-check-enabled
false
yarn.nodemanager.vmem-pmem-ratio
4



## 登录用户被拒绝

```sh
Connecting to jdbc:hive2://hadoop121:10000
21/03/17 04:33:52 [main]: WARN jdbc.HiveConnection: Failed to connect to hadoop121:10000
Error: Could not open client transport with JDBC Uri: jdbc:hive2://hadoop121:10000: Failed to open new session: java.lang.RuntimeException: org.apache.hadoop.ipc.RemoteException(org.apache.hadoop.security.authorize.AuthorizationException): User: myhadoop is not allowed to impersonate myhadoop (state=08S01,code=0)
Beeline version 3.1.2 by Apache Hive

```

解决 修改hadoop的core-site.xml配置文件

```xml
<property>
    <name>hadoop.proxyuser.myhadoop.hosts</name>
    <value>*</value>
</property>
<property>
    <name>hadoop.proxyuser.myhadoop.groups</name>
    <value>*</value>
</property>

```

