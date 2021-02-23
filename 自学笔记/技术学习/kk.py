from pyspark.streaming.kafka import KafkaUtils,TopicAndPartition
from pyspark import SparkConf,SparkContext
from pyspark.sql import SparkSession
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pyspark.sql.window import Window
from pyspark.streaming import StreamingContext
import os,sys,importlib
from collections import defaultdict
from kafka import KafkaProducer,KafkaConsumer
from kafka.errors import KafkaError
import uuid
import datetime
import json
import time
import hashlib
import logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s: %(message)s')
logger = logging.getLogger(__name__)
importlib.reload(sys)

def save_offset():
    offset_df = spark.createDataFrame(offsetRanges, offset_schema)
    offset_df.repartition(1).write.mode('overwrite').json(offset_file)

def store_offset_ranges(rdd):
    global offsetRanges
    offsetRanges = rdd.offsetRanges()
    return rdd

def assemble_offset(x):
    topic = x['topic']
    partition = x['partition']
    start_point = x['untilOffset']
    return {TopicAndPartition(topic, partition): start_point}

def get_offset():
    offset_schema = StructType([
        StructField("topic", StringType(), True),
        StructField("partition", StringType(), True),
        StructField("untilOffset", StringType(), True)
    ]
    )
    offset_df = spark.read.json(offset_file, schema=offset_schema)
    if offset_df.rdd.isEmpty():
        return None
    else:
        offset_list = offset_df.rdd.map(lambda row: assemble_offset(row)).collect()
        offset_dict = {}
        for i in offset_list:
            for k, v in i.items():
                offset_dict[k] = v
        return offset_dict

def kfk_to_hive(rdd):
    pass

if __name__ == '__main__':
    conf = SparkConf().setAppName(${AppName}).setMaster('yarn')
    conf.set("spark.sql.warehouse.dir", "/user/hive/warehouse/")
    #纠正Hive和spark建表是的字段类型不同
    conf.set("spark.sql.parquet.writeLegacyFormat", True)
    spark = SparkSession.builder.config(conf=conf).enableHiveSupport().getOrCreate()
    #开启动态分区设置，以防万一
    spark.sql("set hive.exec.dynamic.partition.mode = nonstrict")
    spark.sql("set hive.exec.dynamic.partition=true")
    sc = spark.sparkContext
    #设置读取周期时长：120s
    ssc = StreamingContext(sc, ${Time})
    #kafka的broker连接地址
    brokers = "10.162.121.88:21005,10.162.121.86:21005,10.162.121.89:21005,10.162.121.87:21005,10.162.121.90:21005"
    #kafka消费者topic
    consumerTopic = [${ConsumerTopic}]
    #写入的hive表名（库+表）
    table_name = ${HiveTableName}
    kafkaParams = {
        'metadata.broker.list':brokers,
        'auto.offset.reset': "smallest"
    }
    offset_file = ${OffsetFile}
    offset_range = get_offset()
    if offset_range is None:
        kafkastream = KafkaUtils.createDirectStream(ssc, consumerTopic, kafkaParams=kafkaParams)
    else:
        kafkastream = KafkaUtils.createDirectStream(ssc, consumerTopic, kafkaParams=kafkaParams, fromOffsets=offset_range)
    kafkastream.transform(store_offset_ranges).map(lambda rdd: rdd[1]).map(lambda rdd: rdd.split(",")).foreachRDD(kfk_to_hive)
    ssc.start()
    logger.info('------------start time -------------')
    ssc.awaitTermination()