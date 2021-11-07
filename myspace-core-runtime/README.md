# MySpace Runtime

## 职责

### 服务管理

> 负责本机的服务安装、卸载、启动、终止、配置等职责

服务既包括MySpace实现的app服务，又包括MySQL、kafka、Redis、zookeeper、nginx、防火墙等服务

### 集群管理

> 负责和其他集群主机同步、通信

### 资源管理

> app服务向runtime申请服务资源，Runtime给app服务分配资源

### 本机管理

> 监控本机状态信息
