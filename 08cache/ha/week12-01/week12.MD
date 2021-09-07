
# 1.（必做）配置 redis 的主从复制，sentinel 高可用，Cluster 集群。
## 主从复制
1. 本地docker拉去了redis镜像 ```docker pull redis```
2. 下载redis配置文件（ http://download.redis.io/redis-stable/redis.conf），
   并放置到本地的指定文件夹，用于映射
3. 启动两个redis容器进程
```
docker run -idt -v D:\environment\redis\redis1\config\:/usr/local/redis/ -v D:\environment\redis\redis1\data\:/data/ -p 6300:6300 --name redis1 redis /usr/local/redis/redis.conf
docker run -idt -v D:\environment\redis\redis2\config\:/usr/local/redis/ -v D:\environment\redis\redis2\data\:/data/ -p 6301:6301 --name redis2 redis /usr/local/redis/redis.conf
```
4. 在第二个容器中进入redis-cli，输入命令```slaveof 127.0.0.1 6300``` 开启主从
5. 在redis-cli中 输入info  查看主从状态
```
Replication
role:slave
master_host:127.0.0.1
master_port:6300
master_link_status:down
master_last_io_seconds_ago:-1
master_sync_in_progress:0
slave_repl_offset:0
master_link_down_since_seconds:-1
slave_priority:100
slave_read_only:1
replica_announced:1
connected_slaves:0
master_failover_state:no-failover
master_replid:8c4862a6cb6d027473ccadcd61a08f4cc3777e91
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:0
second_repl_offset:-1
repl_backlog_active:0
repl_backlog_size:1048576
repl_backlog_first_byte_offset:0
repl_backlog_histlen:0
```
## sentinel 高可用
1. 在主从的基础上，分别在data目录下增加sentinel01.config，sentinel02.config
2. 在容器的CLI中分别打开redis1 和redis2 监听6300 和6301两个主从节点
```
redis-server sentinel01.config --sentinel
redis-server sentinel02.config --sentinel
```

## Cluster 集群
1. 删除主从容器
2. 修改配置文件
   修改bind bind 127.0.0.1 ::1 → bind 0.0.0.0 不进行IP绑定
   修改dir ./ → /data/ 原先指定的路径不存在
   修改 cluster-enabled cluster-enabled no → cluster-enabled yes
3. 启动进程
```
docker run -idt -v D:\environment\redis\redis1\config\:/usr/local/redis/ -v D:\environment\redis\redis1\data\:/data/ -p 6300:6379 --name redis1 redis /usr/local/redis/redis.conf
docker run -idt -v D:\environment\redis\redis2\config\:/usr/local/redis/ -v D:\environment\redis\redis2\data\:/data/ -p 6301:6379 --name redis2 redis /usr/local/redis/redis.conf
docker run -idt -v D:\environment\redis\redis3\config\:/usr/local/redis/ -v D:\environment\redis\redis3\data\:/data/ -p 6302:6379 --name redis3 redis /usr/local/redis/redis.conf
```
4. 创建集群
```
redis-cli --cluster create  --cluster-replicas 1 172.17.0.2:6379 172.17.0.3:6379 172.17.0.4:6379 172.17.0.5:6379 172.17.0.6:6379 172.17.0.7:6379

>>> Performing hash slots allocation on 6 nodes...
Master[0] -> Slots 0 - 5460
Master[1] -> Slots 5461 - 10922
Master[2] -> Slots 10923 - 16383
Adding replica 172.17.0.6:6379 to 172.17.0.2:6379
Adding replica 172.17.0.7:6379 to 172.17.0.3:6379
Adding replica 172.17.0.5:6379 to 172.17.0.4:6379
M: f79f7780b1fd0805974b072b7fb99297ff75e483 172.17.0.2:6379
   slots:[0-5460] (5461 slots) master
M: e03fc3491b5cae9314aa24c606350373f53cae55 172.17.0.3:6379
   slots:[5461-10922] (5462 slots) master
M: ead40ff8f04be9b0f14978c1dce867cc3fe24248 172.17.0.4:6379
   slots:[10923-16383] (5461 slots) master
S: ead40ff8f04be9b0f14978c1dce867cc3fe24248 172.17.0.5:6379
   replicates ead40ff8f04be9b0f14978c1dce867cc3fe24248
S: ead40ff8f04be9b0f14978c1dce867cc3fe24248 172.17.0.6:6379
   replicates f79f7780b1fd0805974b072b7fb99297ff75e483
S: ead40ff8f04be9b0f14978c1dce867cc3fe24248 172.17.0.7:6379
   replicates e03fc3491b5cae9314aa24c606350373f53cae55
Can I set the above configuration? (type 'yes' to accept): yes
>>> Nodes configuration updated
>>> Assign a different config epoch to each node
>>> Sending CLUSTER MEET messages to join the cluster

```
验证： ```cluster  info```
```
127.0.0.1:6379> cluster info
cluster_state:ok
cluster_slots_assigned:16384
cluster_slots_ok:16384
cluster_slots_pfail:0
cluster_slots_fail:0
cluster_known_nodes:3
cluster_size:3
cluster_current_epoch:6
cluster_my_epoch:1
cluster_stats_messages_ping_sent:540
cluster_stats_messages_pong_sent:525
cluster_stats_messages_sent:1065
cluster_stats_messages_ping_received:520
cluster_stats_messages_pong_received:540
cluster_stats_messages_meet_received:5
cluster_stats_messages_received:1065
```

# 6.（必做）搭建 ActiveMQ 服务，基于 JMS，写代码分别实现对于 queue 和 topic 的消息生产和消费，代码提交到 github。
已有demo，增加一个queue复用即可
09mq/activemq-demo/src/main/java/io/kimmking/javacourse/mq/activemq/ActivemqApplication.java
