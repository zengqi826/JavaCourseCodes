1.（选做）使用 GCLogAnalysis.java 自己演练一遍串行 / 并行 /CMS/G1 的案例。
```
```
2.（选做）使用压测工具（wrk 或 sb），演练 gateway-server-0.0.1-SNAPSHOT.jar 示例。

分别使用4和15并发做测试，4并发性能更好，超过15会无法执行
java -jar -Xmx512m -Xms512m gateway-server-0.0.1-SNAPSHOT.jar

sb -u http://localhost:8088/api/hello  -c 4 -N 30
```
Starting at 2021/6/29 15:53:16
[Press C to stop the test]
79228   (RPS: 2190.5)
---------------Finished!----------------
Finished at 2021/6/29 15:53:53 (took 00:00:36.2180309)
Status 200:    79228

RPS: 2553 (requests/second)
Max: 2448ms
Min: 0ms
Avg: 0.2ms

  50%   below 0ms
  60%   below 0ms
  70%   below 0ms
  80%   below 0ms
  90%   below 0ms
  95%   below 1ms
  98%   below 1ms
  99%   below 2ms
99.9%   below 7ms
```
sb -u http://localhost:8088/api/hello  -c 15 -N 30
```
Starting at 2021/6/29 15:54:36
[Press C to stop the test]
61320   (RPS: 1693.2)
---------------Finished!----------------
Finished at 2021/6/29 15:55:13 (took 00:00:36.4190725)
Status 200:    61343

RPS: 1967.3 (requests/second)
Max: 126ms
Min: 0ms
Avg: 0.9ms

  50%   below 0ms
  60%   below 0ms
  70%   below 0ms
  80%   below 1ms
  90%   below 1ms
  95%   below 4ms
  98%   below 11ms
  99%   below 17ms
99.9%   below 36ms
```
3.（选做）如果自己本地有可以运行的项目，可以按照 2 的方式进行演练。
```
```
4.（必做）根据上述自己对于 1 和 2 的演示，写一段对于不同 GC 和堆内存的总结，提交到 GitHub。
```
```
5.（选做）运行课上的例子，以及 Netty 的例子，分析相关现象。

一：压测HttpServer01,02,03三个程序：
1. 测试了多次，-c参数不能过大，最大到16就无法运行（猜测和CPU核数有关，本机是4核4C），
多次压测发现配置并发数为4，RPS最大 
2. 使用线程池比创建线程的RPS高（线程复用减少了线程创建和销毁的消耗）
3. 但是，单线程串行消费RPS最高，这个和课件有较大出入？未弄清楚原因，还望老师解答

测试命令和日志：
 sb -u http://localhost:8801 -c 4 -N 30
```
Starting at 2021/6/29 15:08:30
[Press C to stop the test]
77127   (RPS: 3084.2)
---------------Finished!----------------
Finished at 2021/6/29 15:08:55 (took 00:00:25.1405961)
Status 200:    77050
Status 303:    77

RPS: 3650.6 (requests/second)
Max: 46ms
Min: 0ms
Avg: 0.1ms

  50%   below 0ms
  60%   below 0ms
  70%   below 0ms
  80%   below 0ms
  90%   below 0ms
  95%   below 1ms
  98%   below 1ms
  99%   below 2ms
99.9%   below 10ms
```

sb -u http://localhost:8801 -c 15 -N 30
```
Starting at 2021/6/29 15:13:54
[Press C to stop the test]
62490   (RPS: 1780.9)
---------------Finished!----------------
Finished at 2021/6/29 15:14:30 (took 00:00:35.2512733)
Status 303:    11208
Status 200:    51336

RPS: 2008.1 (requests/second)
Max: 120ms
Min: 0ms
Avg: 1.9ms

  50%   below 0ms
  60%   below 1ms
  70%   below 1ms
  80%   below 2ms
  90%   below 6ms
  95%   below 10ms
  98%   below 15ms
  99%   below 20ms
99.9%   below 39ms
```
sb -u http://localhost:8802 -c 4 -N 30
```
Starting at 2021/6/29 15:37:50
[Press C to stop the test]
51154   (RPS: 1422.7)
---------------Finished!----------------
Finished at 2021/6/29 15:38:26 (took 00:00:36.1621225)
Status 200:    50999
Status 303:    156

RPS: 1640.3 (requests/second)
Max: 110ms
Min: 0ms
Avg: 1.5ms

  50%   below 1ms
  60%   below 1ms
  70%   below 1ms
  80%   below 1ms
  90%   below 2ms
  95%   below 7ms
  98%   below 10ms
  99%   below 11ms
99.9%   below 16ms
```
sb -u http://localhost:8803 -c 8 -N 30
```
Starting at 2021/6/29 15:36:58
[Press C to stop the test]
53684   (RPS: 1492.2)
---------------Finished!----------------
Finished at 2021/6/29 15:37:34 (took 00:00:36.1072457)
Status 200:    52850
Status 303:    854

RPS: 1726.6 (requests/second)
Max: 116ms
Min: 0ms
Avg: 1.4ms

  50%   below 0ms
  60%   below 1ms
  70%   below 1ms
  80%   below 1ms
  90%   below 3ms
  95%   below 8ms
  98%   below 12ms
  99%   below 14ms
99.9%   below 24ms
```

6.（必做）写一段代码，使用 HttpClient 或 OkHttp 访问  http://localhost:8801 ，代码提交到 GitHub
```
```