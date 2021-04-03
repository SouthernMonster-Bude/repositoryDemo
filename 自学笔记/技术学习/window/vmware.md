# vmware遇到的问题

## VMware Workstation Pro 启动虚拟机报错，您的主机不满足在启用 Hyper-V 或 Device/Credential Guard 的情况下运行 VMware Workstation 的最低要求

**解决**

1.在控制面板关闭Hyper-V

　　按Windows键，搜索控制面板，点启用或关闭Windows功能，找到Hyper-V，把勾选去掉，选择不重启

2.通过命令行关闭Hyper-V（彻底关闭Hyper-V）

- 以管理员身份运行Windows Powershell (管理员)（Windows键+X）

- 运行下面命令并重启电脑：

  ```sh
  bcdedit /set hypervisorlaunchtype off
  ```