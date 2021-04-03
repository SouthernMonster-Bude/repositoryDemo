



指令执行顺序

```sh
# nn1上
start-dfs.sh
hdfs namenode -format
stop-dfs.sh
start-dfs.sh
# nn2,nn3上
hdfs namenode -bootstrapStandby
# nn1上
stop-dfs.sh
start-dfs.sh
hdfs zkfc -formatZK

```

