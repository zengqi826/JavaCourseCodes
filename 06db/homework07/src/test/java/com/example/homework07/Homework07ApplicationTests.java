package com.example.homework07;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootTest
class Homework07ApplicationTests {

    private static final String BATCH_INSERT_SQL = "insert into java_course.order(order_id,product_code,user_name," +
            "count,unit_price,real_price,discount_price) values(?,?,?,?,?,?,?)";

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
    }

    /**
     * 连接池+异步
     * 未开启rewriteBatchedStatements=true耗时为：691954
     * 开启rewriteBatchedStatements=true耗时为：317378
     */
    @Test
    void batchInsert() {
        long start = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        List<Future<?>> futureTasks = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            Future<?> submit = threadPool.submit(() -> {
                try (Connection connection = dataSource.getConnection();
                     PreparedStatement preparedStatement = connection.prepareStatement(BATCH_INSERT_SQL);) {
                    for (int i = 1; i <= 100000; i++) {
                        preparedStatement.setString(1, UUID.randomUUID().toString());
                        preparedStatement.setString(2, String.valueOf(i));
                        preparedStatement.setString(3, String.valueOf(i));
                        preparedStatement.setInt(4, i);
                        preparedStatement.setDouble(5, i);
                        preparedStatement.setDouble(6, i);
                        preparedStatement.setDouble(7, i);
                        preparedStatement.addBatch();
                    }
                    preparedStatement.executeBatch();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });
            futureTasks.add(submit);
        }
        futureTasks.forEach(f -> {
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        long time1 = System.currentTimeMillis();
        System.out.println("使用线程池批量增加的耗时为：" + (time1 - start));
    }

    @Test
    void batchInsertByJDBC() throws SQLException {
        /**
         * 开启rewriteBatchedStatements=true耗时为：630357
         */
        String url = "jdbc:mysql://localhost:3306/java_course?characterEncoding=utf8&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
        long start = System.currentTimeMillis();
        try (Connection connection = DriverManager.getConnection(url, "root", "1234");
             PreparedStatement preparedStatement = connection.prepareStatement(BATCH_INSERT_SQL);) {
            for (int i = 1; i <= 1000000; i++) {
                preparedStatement.setString(1, UUID.randomUUID().toString());
                preparedStatement.setString(2, String.valueOf(i));
                preparedStatement.setString(3, String.valueOf(i));
                preparedStatement.setInt(4, i);
                preparedStatement.setDouble(5, i);
                preparedStatement.setDouble(6, i);
                preparedStatement.setDouble(7, i);
                preparedStatement.addBatch();
                if (i % 10000 == 0) {
                    preparedStatement.executeBatch();
                }
            }
            long time1 = System.currentTimeMillis();
            System.out.println("使用preparedStatement批量插入100w条记录共耗时：" + (time1 - start) + " ms");
        }

    }
}
