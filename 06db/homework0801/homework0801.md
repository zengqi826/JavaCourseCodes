week08
必做题2 设计对前面的订单表数据进行水平分库分表，拆分 2 个库，每个库 16 张表。并在新结构在演示常见的增删改查操作。代码、sql 和配置文件，上传到 Github

sql建表语句：init.sql
proxy 配置文件：
config-sharding.yaml
server.yaml
问题：已单独反馈，使用jdbc方式，配置后无法分库分表

必做题6  基于 hmily TCC 或 ShardingSphere 的 Atomikos XA 实现一个简单的分布式事务应用 demo（二选一），提交到 Github

首先在作业2的基础上已经配置了，申明使用Atomikos的XA事务  xa-transaction-manager-type: Atomikos
然后在service层增加事务的使用：
@Transactional
@ShardingTransactionType(TransactionType.XA)
最后单元测试使用此声明过使用事务的方法即可

Homework0801ApplicationTests
单元测试中进行增删改查记录的部分日志：
```
[INFO ] 2021-08-11 17:26:32.755 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: INSERT INTO t_order  ( order_id,
user_id,
status )  VALUES  ( 1425388152927371266,
992,
'NORAMAL' )
[INFO ] 2021-08-11 17:26:32.755 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLInsertStatement(setAssignment=Optional.empty, onDuplicateKeyColumns=Optional.empty)
[INFO ] 2021-08-11 17:26:32.756 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: INSERT INTO t_order_2  ( order_id,
user_id,
status )  VALUES  (1425388152927371266, 992, 'NORAMAL')
[INFO ] 2021-08-11 17:26:32.757 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.757 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional.empty, lock=Optional.empty, window=Optional.empty)
[INFO ] 2021-08-11 17:26:32.757 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.758 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: INSERT INTO t_order  ( order_id,
user_id,
status )  VALUES  ( 1425388152927371267,
993,
'NORAMAL' )
[INFO ] 2021-08-11 17:26:32.758 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLInsertStatement(setAssignment=Optional.empty, onDuplicateKeyColumns=Optional.empty)
[INFO ] 2021-08-11 17:26:32.758 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: INSERT INTO t_order_3  ( order_id,
user_id,
status )  VALUES  (1425388152927371267, 993, 'NORAMAL')
[INFO ] 2021-08-11 17:26:32.760 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.760 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional.empty, lock=Optional.empty, window=Optional.empty)
[INFO ] 2021-08-11 17:26:32.760 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.761 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: INSERT INTO t_order  ( order_id,
user_id,
status )  VALUES  ( 1425388152927371268,
994,
'NORAMAL' )
[INFO ] 2021-08-11 17:26:32.768 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLInsertStatement(setAssignment=Optional.empty, onDuplicateKeyColumns=Optional.empty)
[INFO ] 2021-08-11 17:26:32.768 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: INSERT INTO t_order_4  ( order_id,
user_id,
status )  VALUES  (1425388152927371268, 994, 'NORAMAL')
[INFO ] 2021-08-11 17:26:32.770 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.770 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional.empty, lock=Optional.empty, window=Optional.empty)
[INFO ] 2021-08-11 17:26:32.770 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.770 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: INSERT INTO t_order  ( order_id,
user_id,
status )  VALUES  ( 1425388152990285825,
995,
'NORAMAL' )
[INFO ] 2021-08-11 17:26:32.771 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLInsertStatement(setAssignment=Optional.empty, onDuplicateKeyColumns=Optional.empty)
[INFO ] 2021-08-11 17:26:32.771 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: INSERT INTO t_order_1  ( order_id,
user_id,
status )  VALUES  (1425388152990285825, 995, 'NORAMAL')
[INFO ] 2021-08-11 17:26:32.773 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.773 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional.empty, lock=Optional.empty, window=Optional.empty)
[INFO ] 2021-08-11 17:26:32.773 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.773 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: INSERT INTO t_order  ( order_id,
user_id,
status )  VALUES  ( 1425388152990285826,
996,
'NORAMAL' )
[INFO ] 2021-08-11 17:26:32.773 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLInsertStatement(setAssignment=Optional.empty, onDuplicateKeyColumns=Optional.empty)
[INFO ] 2021-08-11 17:26:32.773 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: INSERT INTO t_order_2  ( order_id,
user_id,
status )  VALUES  (1425388152990285826, 996, 'NORAMAL')
[INFO ] 2021-08-11 17:26:32.775 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.775 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional.empty, lock=Optional.empty, window=Optional.empty)
[INFO ] 2021-08-11 17:26:32.775 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.776 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: INSERT INTO t_order  ( order_id,
user_id,
status )  VALUES  ( 1425388152990285827,
997,
'NORAMAL' )
[INFO ] 2021-08-11 17:26:32.776 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLInsertStatement(setAssignment=Optional.empty, onDuplicateKeyColumns=Optional.empty)
[INFO ] 2021-08-11 17:26:32.776 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: INSERT INTO t_order_3  ( order_id,
user_id,
status )  VALUES  (1425388152990285827, 997, 'NORAMAL')
[INFO ] 2021-08-11 17:26:32.778 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.784 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional.empty, lock=Optional.empty, window=Optional.empty)
[INFO ] 2021-08-11 17:26:32.785 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.786 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: INSERT INTO t_order  ( order_id,
user_id,
status )  VALUES  ( 1425388153057394690,
998,
'NORAMAL' )
[INFO ] 2021-08-11 17:26:32.786 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLInsertStatement(setAssignment=Optional.empty, onDuplicateKeyColumns=Optional.empty)
[INFO ] 2021-08-11 17:26:32.787 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: INSERT INTO t_order_2  ( order_id,
user_id,
status )  VALUES  (1425388153057394690, 998, 'NORAMAL')
[INFO ] 2021-08-11 17:26:32.789 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.789 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional.empty, lock=Optional.empty, window=Optional.empty)
[INFO ] 2021-08-11 17:26:32.789 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.789 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: INSERT INTO t_order  ( order_id,
user_id,
status )  VALUES  ( 1425388153057394691,
999,
'NORAMAL' )
[INFO ] 2021-08-11 17:26:32.789 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLInsertStatement(setAssignment=Optional.empty, onDuplicateKeyColumns=Optional.empty)
[INFO ] 2021-08-11 17:26:32.790 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: INSERT INTO t_order_3  ( order_id,
user_id,
status )  VALUES  (1425388153057394691, 999, 'NORAMAL')
[INFO ] 2021-08-11 17:26:32.791 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.791 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional.empty, lock=Optional.empty, window=Optional.empty)
[INFO ] 2021-08-11 17:26:32.791 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.792 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: INSERT INTO t_order  ( order_id,
user_id,
status )  VALUES  ( 1425388153057394692,
1000,
'NORAMAL' )
[INFO ] 2021-08-11 17:26:32.792 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLInsertStatement(setAssignment=Optional.empty, onDuplicateKeyColumns=Optional.empty)
[INFO ] 2021-08-11 17:26:32.792 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: INSERT INTO t_order_4  ( order_id,
user_id,
status )  VALUES  (1425388153057394692, 1000, 'NORAMAL')
[INFO ] 2021-08-11 17:26:32.819 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: SELECT  order_id,user_id,status  FROM t_order
[INFO ] 2021-08-11 17:26:32.820 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional.empty, lock=Optional.empty, window=Optional.empty)
[INFO ] 2021-08-11 17:26:32.821 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_0 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.821 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_1 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.821 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_2 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.821 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_3 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.821 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_4 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.821 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_5 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.821 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_6 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.821 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_7 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_8 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_9 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_10 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_11 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_12 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_13 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_14 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT  order_id,user_id,status  FROM t_order_15 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_0 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_1 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_2 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_3 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_4 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_5 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_6 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.822 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_7 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.823 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_8 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.823 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_9 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.823 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_10 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.823 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_11 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.823 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_12 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.823 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_13 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.823 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_14 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.823 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT  order_id,user_id,status  FROM t_order_15 ORDER BY order_id ASC
[INFO ] 2021-08-11 17:26:32.891 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.891 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional.empty, lock=Optional.empty, window=Optional.empty)
[INFO ] 2021-08-11 17:26:32.893 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.894 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: UPDATE t_order  SET status='updated'  WHERE order_id=1425388126469701633
[INFO ] 2021-08-11 17:26:32.894 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLUpdateStatement(orderBy=Optional.empty, limit=Optional.empty)
[INFO ] 2021-08-11 17:26:32.894 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: UPDATE t_order_1  SET status='updated'  WHERE order_id=1425388126469701633
[INFO ] 2021-08-11 17:26:32.894 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: UPDATE t_order_1  SET status='updated'  WHERE order_id=1425388126469701633
[INFO ] 2021-08-11 17:26:32.902 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.902 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional.empty, lock=Optional.empty, window=Optional.empty)
[INFO ] 2021-08-11 17:26:32.902 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: SELECT @@session.transaction_read_only
[INFO ] 2021-08-11 17:26:32.903 [ShardingSphere-Command-18] ShardingSphere-SQL - Logic SQL: DELETE FROM t_order
[INFO ] 2021-08-11 17:26:32.906 [ShardingSphere-Command-18] ShardingSphere-SQL - SQLStatement: MySQLDeleteStatement(orderBy=Optional.empty, limit=Optional.empty)
[INFO ] 2021-08-11 17:26:32.906 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_0
[INFO ] 2021-08-11 17:26:32.906 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_1
[INFO ] 2021-08-11 17:26:32.906 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_2
[INFO ] 2021-08-11 17:26:32.907 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_3
[INFO ] 2021-08-11 17:26:32.907 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_4
[INFO ] 2021-08-11 17:26:32.907 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_5
[INFO ] 2021-08-11 17:26:32.907 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_6
[INFO ] 2021-08-11 17:26:32.907 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_7
[INFO ] 2021-08-11 17:26:32.907 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_8
[INFO ] 2021-08-11 17:26:32.907 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_9
[INFO ] 2021-08-11 17:26:32.907 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_10
[INFO ] 2021-08-11 17:26:32.907 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_11
[INFO ] 2021-08-11 17:26:32.907 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_12
[INFO ] 2021-08-11 17:26:32.907 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_13
[INFO ] 2021-08-11 17:26:32.907 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_14
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds0 ::: DELETE FROM t_order_15
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_0
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_1
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_2
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_3
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_4
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_5
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_6
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_7
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_8
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_9
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_10
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_11
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_12
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_13
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_14
[INFO ] 2021-08-11 17:26:32.908 [ShardingSphere-Command-18] ShardingSphere-SQL - Actual SQL: ds1 ::: DELETE FROM t_order_15

```

