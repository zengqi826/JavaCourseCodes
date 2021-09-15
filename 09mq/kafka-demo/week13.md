1. 官网下载kafka http://kafka.apache.org/downloads

```
# 下载文件夹里打开cmd进行解压
tar zxvf kafka_2.13-2.7.0.tgz
```
   
2. 启动zookeeper
```
D:\environment\kafka_2.13-2.7.0\bin\windows>zookeeper-server-start.bat D:\environment\kafka_2.13-2.7.0\config\zookeeper.properties
```
2. 复制conf/server.properties三份并修改kafka配置值

kafka9001.properties:
```
broker.id=1
broker.list=localhost:9001,localhost:9002,localhost:9003
listeners=PLAINTEXT://localhost:9001
log.dirs=/tmp/kafka-logs1
```
kafka9002.properties:
```
broker.id=2
broker.list=localhost:9001,localhost:9002,localhost:9003
listeners=PLAINTEXT://localhost:9002
log.dirs=/tmp/kafka-logs2
```
kafka9003.properties:
```
broker.id=3
broker.list=localhost:9001,localhost:9002,localhost:9003
listeners=PLAINTEXT://localhost:9003
log.dirs=/tmp/kafka-logs3
```

3. 开三个cmd,启动三个节点组成集群：
```
D:\environment\kafka_2.13-2.7.0> .\bin\windows\kafka-server-start.bat .\config\kafka9001.properties
D:\environment\kafka_2.13-2.7.0> .\bin\windows\kafka-server-start.bat .\config\kafka9002.properties
D:\environment\kafka_2.13-2.7.0> .\bin\windows\kafka-server-start.bat .\config\kafka9003.properties
```

4. 开一个cmd,创建topic，并启动生产者客户端
```
D:\environment\kafka_2.13-2.7.0> .\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --create --topic test32
 --partitions 3 --replication-factor 2
 
D:\environment\kafka_2.13-2.7.0> .\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9003 --topic test32
```

5. 开一个cmd,启动消费者客户端
```
D:\environment\kafka_2.13-2.7.0> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9001 --topic 
test32 --frombeginning
```

6. 开一个cmd,性能测试
```
D:\environment\kafka_2.13-2.7.0>bin\windows\kafka-producer-perf-test.bat --topic test32 --num-records 100000 --record-size 1000 --throughput 2000 --producer-props bootstrap.servers=localhost:9002
10002 records sent, 1995.2 records/sec (1.90 MB/sec), 20.8 ms avg latency, 438.0 ms max latency.
10014 records sent, 2000.8 records/sec (1.91 MB/sec), 12.4 ms avg latency, 234.0 ms max latency.
10040 records sent, 2005.6 records/sec (1.91 MB/sec), 1.6 ms avg latency, 15.0 ms max latency.
10014 records sent, 1997.6 records/sec (1.91 MB/sec), 12.4 ms avg latency, 296.0 ms max latency.
10009 records sent, 2001.8 records/sec (1.91 MB/sec), 4.0 ms avg latency, 59.0 ms max latency.
10003 records sent, 1999.4 records/sec (1.91 MB/sec), 2.2 ms avg latency, 42.0 ms max latency.
10009 records sent, 2001.4 records/sec (1.91 MB/sec), 10.7 ms avg latency, 123.0 ms max latency.
10032 records sent, 2003.2 records/sec (1.91 MB/sec), 1.2 ms avg latency, 14.0 ms max latency.
10011 records sent, 2000.6 records/sec (1.91 MB/sec), 3.0 ms avg latency, 77.0 ms max latency.
100000 records sent, 1999.160353 records/sec (1.91 MB/sec), 7.27 ms avg latency, 438.00 ms max latency, 1 ms 50th, 30 ms 95th, 138 ms 99th, 234 ms 99.9th.
```

7. 通过/kafka-demo/../KafkaApplication 实现spring对kafka的操作