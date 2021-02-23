#定义
Kafka 是一个分布式的基于发布/订阅模式的消息队列（Message Queue），主要应用于
大数据实时处理领域

    一般大数据公司使用了spark做实时处理之后，都会使用kafka进行对接

# 操作步骤
从官网下载tgz包
解压
tar -zxvf software/kafka_2.12-2.6.0.tgz -C /opt/module/

重命名
mv /opt/module/kafka_2.12-2.6.0 kafka

创建logs目录
mkdir /opt/module/kafka/logs

修改配置
vi /opt/module/kafka/config/server.properties
        #broker 的全局唯一编号，不能重复
        broker.id=0
        #删除 topic 功能使能
        delete.topic.enable=true
        #处理网络请求的线程数量
        num.network.threads=3
        #用来处理磁盘 IO 的现成数量
        num.io.threads=8
        #发送套接字的缓冲区大小
        socket.send.buffer.bytes=102400
        #接收套接字的缓冲区大小
        socket.receive.buffer.bytes=102400
        #请求套接字的缓冲区大小
        socket.request.max.bytes=104857600
        #kafka 运行日志存放的路径
        log.dirs=/opt/module/kafka/logs
        #topic 在当前 broker 上的分区个数
        num.partitions=1
        #用来恢复和清理 data 下数据的线程数量
        num.recovery.threads.per.data.dir=1
        #segment 文件保留的最长时间，超时将被删除
        log.retention.hours=168
        #配置连接 Zookeeper 集群地址
        zookeeper.connect=hadoop102:2181,hadoop103:2181,hadoop104:2181
配置环境变量
    sudo vi /etc/profile
        #KAFKA_HOME
        export KAFKA_HOME=/opt/module/kafka
        export PATH=$PATH:$KAFKA_HOME/bin
    source /etc/profile

启动
ssh node01 /opt/module/kafka/bin/kafka-server-start.sh  -daemon /opt/module/kafka/config/server.properties
ssh node02 /opt/module/kafka/bin/kafka-server-start.sh  -daemon /opt/module/kafka/config/server.properties
ssh node03 /opt/module/kafka/bin/kafka-server-start.sh  -daemon /opt/module/kafka/config/server.properties
停止
ssh node01 /opt/module/kafka/bin/kafka-server-stop.sh stop
ssh node02 /opt/module/kafka/bin/kafka-server-stop.sh stop
ssh node03 /opt/module/kafka/bin/kafka-server-stop.sh stop

启动脚本
    for i in node01 node02 node03
    do
    echo "========== $i =========="
    [sshpass -p password] (此处可以加上) ssh  $i << eoff
        source /etc/profile
        /opt/module/kafka/bin/kafka-server-start.sh  -daemon /opt/module/kafka/config/server.properties
        echo 'exit'
        exit
    eoff
    done




