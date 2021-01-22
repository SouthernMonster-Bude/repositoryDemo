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