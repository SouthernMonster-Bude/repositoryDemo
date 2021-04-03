

```sequence
Title: 标题：复杂使用
对象A->对象B: 对象B你好吗?（请求）
Note right of 对象B: 对象B的描述
Note left of 对象A: 对象A的描述(提示)
对象B-->对象A: 我很好(响应)
对象B->小三: 你好吗
小三-->>对象A: 对象B找我了
对象A->对象B: 你真的好吗？
Note over 小三,对象B: 我们是朋友
participant C
Note right of C: 没人陪我玩
```

```mermaid
%% 时序图例子,-> 直线，-->虚线，->>实线箭头
  sequenceDiagram
    participant 张三
    participant 李四
    张三->王五: 王五你好吗？
    loop 健康检查
        王五->王五: 与疾病战斗
    end
    Note right of 王五: 合理 食物 <br/>看医生...
    李四-->>张三: 很好!
    王五->李四: 你怎么样?
    李四-->王五: 很好!
```

```mermaid
%% 时序图例子,-> 直线，-->虚线，->>实线箭头
sequenceDiagram
    %%participant WEB
    %%participant Service
    %%participant Mysql DB
WEB->>Service: 数据元类型选择
    Service->>Mysql DB: 内部标志符查询
    Mysql DB->>Service: 返回内部标志符
    Service->>WEB: 返回内部标志符
    WEB->>Service: 中文名输入
    WEB->>Service: 数据元类型选择
    WEB->>Service: 数据元类型选择
    WEB->>Service: 数据元类型选择
    WEB->>Service: 数据元类型选择
    Service->>Service: 被占用修改标志符
    %%loop 健康检查
   %%     王五->王五: 与疾病战斗
   %% end
   %% Note right of 王五: 合理 食物 <br/>看医生...
   %% 李四-->>张三: 很好!
   %% 王五->李四: 你怎么样?
    %%李四-->王五: 很好!
```

