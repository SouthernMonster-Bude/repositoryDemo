#操作命令
创建topic
/opt/module/kafka/bin/kafka-topics.sh  --zookeeper node01:2181 --create --replication-factor 3 --partitions 1 --topic test01
查询topic
/opt/module/kafka/bin/kafka-topics.sh  --zookeeper node01:2181 --list
删除topic
/opt/module/kafka/bin/kafka-topics.sh  --zookeeper node01:2181 --delete --topic first
发送消息
/opt/module/kafka/bin/kafka-console-producer.sh --broker-list node01:9092 --topic first
接受消息
    zookeeper的方式
    /opt/module/kafka/bin/kafka-console-consumer.sh --zookeeper node01:2181 --topic first
    bootstrap-server的方式 端口9092 默认消费最新的消息
    /opt/module/kafka/bin/kafka-console-consumer.sh --bootstrap-server node01:9092 --topic first
    查看全部消息
    /opt/module/kafka/bin/kafka-console-consumer.sh --bootstrap-server node01:9092 --from-beginning --topic first

查看某个 Topic 的详情
/opt/module/kafka/bin/kafka-topics.sh  --zookeeper node01:2181 --describe --topic first

修改分区数
/opt/module/kafka/bin/kafka-topics.sh  --zookeeper node01:2181 --alter --topic first --partitions 6


读取 offset
修改配置文件 consumer.properties
exclude.internal.topics=false
0.11.0.0 之前版本:
/opt/module/kafka/bin/kafka-console-consumer.sh  --topic  test-consumer-group  --zookeeper  node01:2181  --formatter "kafka.coordinator.GroupMetadataManager\$OffsetsMessageFormatter" --consumer.config /opt/module/kafka/config/consumer.properties --from-beginning

0.11.0.0 之后版本(含)
/opt/module/kafka/bin/kafka-console-consumer.sh  --topic  test-consumer-group  --zookeeper  node01:2181  --formatter "kafka.coordinator.group.GroupMetadataManager\$OffsetsMessageFormatter"  --consumer.config  /opt/module/kafka/config/consumer.properties  --from-beginning

/opt/module/kafka/bin/kafka-console-consumer.sh  --bootstrap-server node01:9092 --topic first --consumer.config /opt/module/kafka/config/consumer.properties