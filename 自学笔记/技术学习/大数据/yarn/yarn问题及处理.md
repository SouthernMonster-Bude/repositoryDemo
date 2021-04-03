# 问题和处理

## 问题1

```
Current usage: 106.2 MB of 1 GB physical memory used; 2.1 GB of 2.1 GB virtual memory used
```



虚拟内存溢出导致异常

> 解决：在yarn-site.xml中配置，yarn.nodemanager.vmem-check-enabled=false

## 问题2

