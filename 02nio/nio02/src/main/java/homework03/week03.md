# 第3周作业


## 作业内容


1.（必做）整合你上次作业的 httpclient/okhttp；
2.（选做）使用 netty 实现后端 http 访问（代替上一步骤）
3.（必做）实现过滤器。
4.（选做）实现路由。

完成了1,3,4
1.代码路径
02nio/nio02/src/main/java/homework02/HttpClientDemo.java
02nio/nio02/src/main/java/homework02/HttpClientUtils.java
3.
新增ProxyBizFilter,新增ProxyHttpInboundHandler 实现新增过滤器和过滤器的处理器
然后修改HttpInboundHandler，让NIO网关使用新增的过滤器作为入站的过滤器
4.
路由器通过HttpOutboundHandler调用，使用RandomHttpEndpointRouter随机调用多个后端。
使用前需将后端的几个服务启动起来