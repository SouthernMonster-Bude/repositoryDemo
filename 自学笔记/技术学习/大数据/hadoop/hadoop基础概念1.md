# 大数据

概念： 大数据（big data）:指无法在一定时间范围内用常用软件工具进行捕捉、管理和处理的数据集合，是需要新处理模式才能具有更强的决策力、洞察发现力和流程优化能力的海量、高增长率和多样化的信息资产。

主要解决：海量数据的存储和海量数据的分析计算。

特点：1.大量（volume）2.高速（velocity）3.多样（variety）4.低价值密度（value）

# hadoop

概念：hadoop是一个由apache基金会开发的分布式系统基础框架，主要用来解决海量数据的存储和海量数据的分析计算问题，广义上，hadoop通常是一个更广泛的概念-hadoop生态圈

## 发展历史
    lucene框架是由doug cutting开创的开源软件，实现了与google类似的全文搜索功能，提供了全文检索引擎架构，包括完整的查询引擎和索引引擎。之后2001年lucene成为apache的子项目。对于海量数据的场景，lucene面对与google同样的困难，存储数据困难，检索慢。学习和模仿google解决这些问题的办法，微型版nutch。google是hadoop思想之源。
    
    google在大数据方面的三篇论文
    ```
    GFS-->HDFS
      分布式存储
    Map-Reduce-->MR
      分布式计算
    BigTable-->HBase
      分布式数据库
    ```
    
    03~04年，google公开了部分gfs和mapreduce思想的细节，以此为基础doug cutting等人用两年的时间实现了dfs和mapreduce机制，是nutch性能飙升
    
    05年hadoop作为luence的子项目nutch的一部分正式引入apache基金会
    
    06年3月份 mapreduce和nutch distributed sysytem（ndfs） 分别被纳入到hadoop项目中，hadoop就此正事诞生，标志着大数据时代的到来
    
    hadoop 名字来源于doug cutting儿子的玩具


## 三大发行版
apache 最原始的版本

cloudera内部集成了很多大数据的框架，对应产品CDH

hortonworks文档较好，对应HDP

1.Apache Hadoop
官网地址：http://hadoop.apache.org/releases.html
下载地址：https://archive.apache.org/dist/hadoop/common/

2.Cloudera Hadoop 
官网地址：https://www.cloudera.com/downloads/cdh/5-10-0.html
下载地址：http://archive-primary.cloudera.com/cdh5/cdh/5/

3.Hortonworks Hadoop
官网地址：https://hortonworks.com/products/data-center/hdp/
下载地址：https://hortonworks.com/downloads/#data-platform