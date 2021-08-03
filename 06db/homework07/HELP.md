9.（必做）读写分离 - 动态切换数据源版本 1.0：
基本原理为使用ThreadLoacal对多个数据源进行持有，再通过注解切面或者别的方式在DAO层进行切换选择。
这道题生成或自己已经实现过多次，就没有再重新写代码，这里使用之前的一个demo：没有使用注解去切换使用，因为该demo会结合springbatch做批处理。每个任务会启动多个线程，每个线程会使用不同的数据源，达到动态切换的目的。
https://github.com/zengqi826/multi_tenant_springbatch_demo/tree/25376327208028edc93b62119aa23d470753370b
