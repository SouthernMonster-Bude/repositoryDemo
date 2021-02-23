#数据可靠性保证
acks 0 1 -1
-1 保证数据不会丢失，不能保证不重复
0 保证数据不会重复，不能保证数据不丢失

hw高水位控制数据存储的一致性和数据消费的一致性
leo每个副本最大的offset
hw是消费者最大能消费到的offset

#exactlyOnce
交易数据不能丢失也不能重复
at least once + 幂等性 = exactlyOnce


配置中 enable.idompotence 设置为true 即可启用幂等性
