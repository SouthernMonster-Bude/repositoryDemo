xt333部署。口。径。，限限心限秒解读ptsstssggkf1￼



zookeeper从设计模式角度来讲，是一个基于观察者模式设计的分布式服务管理框架，它负责存储和管理数据，然后接受观察者的注册，一旦这些数据状态发生变化，它九江负责通知已经注册了的观察者，让观察者做出对应反应。

# 特点

1. 一个leader 多个follower
2. 集群中只要有半数以上节点存活，zookeeper就能正常服务
3. 全局数据一致，每个server保存一份相同的数据副本。c
4. 更新请求顺序进行，来自同一个client的更新请求按照顺序，依次执行。
5. 数据更新原子性，一次数据更新要么成功要么失败。
6. 实时性，在一定时间范围内，client能读取到最新的数据。

# 应用

统一命名服务，统一配置管理，统一集群管理，服务起节点动态上下线，软负载均衡

# 操作步骤


# 安装

1. 安装jdk yum install java-11-openjdk-devel.x86_64

2. 从官网下载tgz

3. tar -zxvf /opt/software/apache-zookeeper-3.6.1-bin.tar.gz -C /opt/module/

4. ```sh
   mv /opt/module/apache-zookeeper-3.6.1-bin /opt/module/zookeeper-3.6.1
   cd /opt/module/zookeeper-3.6.1/conf
   mv zoo_sample.cfg zoo_sample.cfg.bak
   cp zoo_sample.cfg.bak zoo.cfg
   vim zoo.cfg
   修改 dataDir=/opt/module/zookeeper-3.6.1/datas
   mkdir /opt/module/zookeeper-3.6.1/datas
   ```

   

5. 启动 bin/zkServer.sh start
   查看进程 jps
   查看状态 bin/zkServer.sh status
   启动客户端 bin/zkCli.sh 退出 quit
   停止Zookeeper bin/zkServer.sh stop

# zoo.cfg中参数含义解读

1. tickTime =2000：通信心跳数，Zookeeper 服务器与客户端心跳时间，单位毫秒
   2．initLimit =10：LF 初始通信时限
    集群中的Follower跟随者服务器与Leader领导者服务器之间初始连接时能容忍的最多心
   跳数（tickTime的数量），用它来限定集群中的Zookeeper服务器连接到Leader的时限
   3．syncLimit =5：LF 同步通信时限
   集群中Leader与Follower之间的最大响应时间单位，假如响应超过syncLimit * tickTime，
   Leader认为Follwer死掉，从服务器列表中删除Follwer。
   4．dataDir：数据文件目录+数据持久化路径
   主要用于保存 Zookeeper 中的数据。
   5．clientPort =2181：客户端连接端口
   监听客户端连接的端口。


# 分布式安装部署

hyper 创建三个虚拟机 linux01 linux02 linux03
分别设置    ip地址为 192.168.0.201 192.168.0.202 192.168.0.203
            hostname node01 node02 node03

具体操作参考/技术学习/Linux/20200904-zookeeper.txt

