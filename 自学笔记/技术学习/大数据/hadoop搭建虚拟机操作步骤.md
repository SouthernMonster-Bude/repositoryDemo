# 搭建Hadoop集群虚拟机

## 搭建一台Hadoop虚拟机

### 虚拟机基本配置

1. 使用vmshare最小安装虚拟机

2. 进入虚拟机修改配置静态ip地址

```properties
TYPE=Ethernet
BOOTPROTO=static
DEFROUTE=yes
PEERDNS=yes
PEERROUTES=yes
IPV4_FAILURE_FATAL=no
IPV6INIT=yes
IPV6_AUTOCONF=yes
IPV6_DEFROUTE=yes
IPV6_PEERDNS=yes
IPV6_PEERROUTES=yes
IPV6_FAILURE_FATAL=no
NAME=eth0
UUID=114601bb-f766-4194-a7bd-831f6b7bdf94
DEVICE=eth0
ONBOOT=yes
IPADDR=192.168.0.201
GATWAY=192.168.0.1
DNS1=192.168.0.1
DNS2=114.114.114.114
DNS3=8.8.8.8
NETMASK=255.255.255.0
```

3. 物理机的网卡的ip也需要调整成静态的ip，设置正确的网关和dns地址

4. 了解ipv4 通信原理

5. 物理机将虚拟机修改成桥接模式同一个WiFi下，其他物理机可以访问

6. 安装基本的依赖和工具

```shell
sudo yum install -y epel-release
sudo yum install -y psmisc nc net-tools rsync vim lrzsz ntp libzstd openssl-static tree iotop git
```

7. 修改虚拟机主机名`sudo hostnamectl --static set-hostname hadoop101`

8. 配置主机名称映射，打开/etc/hosts

```sh
sudo vim /etc/hosts
192.168.10.100 hadoop100
192.168.10.101 hadoop101
192.168.10.102 hadoop102
192.168.10.103 hadoop103
192.168.10.104 hadoop104
192.168.10.105 hadoop105
192.168.10.106 hadoop106
192.168.10.107 hadoop107
```

9. 物理机`C:\Windows\System32\drivers\etc\hosts`也添加IP映射

10. 关闭虚拟机防火墙，创建用户myhadoop，然后reboot

```sh
    sudo systemctl stop firewalld
    sudo systemctl disable firewalld
    sudo useradd myhadoop
    sudo passwd myhadoop
    # 设置密码123456
```

11. 配置myhadoop用户具有root权限

```sh
# 查看 sudo
vi sudo
# 修改/etc/sudoers文件，找到下面一行（91行），在root下面添加一行
vim /etc/sudoers
## Allow root to run any commands anywhere
root    ALL=(ALL)     ALL
myhadoop   ALL=(ALL)     ALL

# 在/opt目录下创建module、software文件夹
# 修改module、software文件夹的所有者 cd
sudo mkdir /opt/module /opt/software
sudo chown myhadoop:myhadoop /opt/module /opt/software
```

### 安装JDK

1. 卸载现有JDK`rpm -qa | grep -i java | xargs -n1 sudo rpm -e --nodeps`

2. 将jdk文件导入opt目录

3. 安装完jdk步骤参考【[技术学习/Linux/20200904-zookeeper.txt](../Linux/20200904-zookeeper.txt)】

4. 

### 执行Hadoop安装操作

1. 在[hadoop3.1.3(点击下载)](https://archive.apache.org/dist/hadoop/common/hadoop-3.1.3/)下载hadoop的安装包
2. 将包拷贝到/opt/software
3. 虚拟机执行相关命令

```sh

# cd 到software目录
cd /opt/software/
# 解压该文件
tar -zxvf hadoop-3.1.3.tar.gz -C /opt/module/
ls /opt/module/
# 将Hadoop添加到环境变量
vim /etc/profile.d/my_env.sh
# 将以下内容添加
## HADOOP_HOME
export HADOOP_HOME=/opt/module/hadoop-3.1.3
export PATH=$PATH:$HADOOP_HOME/bin
export PATH=$PATH:$HADOOP_HOME/sbin
# 使新的变量生效
source /etc/profile
# 测试安装结果
hadoop version
# Hadoop命令不能用，重启
reboot
```

ps:**Linux的环境变量配置在/etc/profile或/etc/profile.d/*.sh文件中的区别**

```
bash的运行模式可分为login shell和non-login shell
通过终端，输入用户名、密码，登录系统之后，得到就是一个login shell
执行以下命令ssh hadoop103 command，在hadoop103执行command的就是一个non-login shell
两种shell的主要区别在于，它们启动时会加载不同的配置文件:
login shell启动时会加载/etc/profile;
non-login shell启动时会加载~/.bashrc;
无论在加载~/.bashrc（实际上是加载了~/.bashrc中的/etc/bashrc）或/etc/profile时，都会执行如下代码片段
for i in /etc/profile.d/*.sh /etc/profile.d/sh.local;
do 
if [ -r "$i" ];then
if [ "${-#*i}" != "$-" ];then
. "$i"
else
. “$i” > /dev/null
fi
fi
done
所以，无论在login shell或non-login shell环境中，都会加载/etc/profile.d/*.sh文件，这样我们就可以在自定义my_env.sh文件存放java或者其他的环境变量
```

## 复制虚拟机



## hadoop原理讲解



### hadoop目录结构

> bin：存放对hadoop相关服务（HDFS,YARN）进行操作的脚本
>
> etc：Hadoop配置文件目录
>
> lib：存放hadoop本地库
>
> sbin：存放启停hadoop相关服务的脚本
>
> share：存放hadoop依赖的jar包、文档、官方案例

### 

