package com.example.homework0502;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zengqi
 */
@SpringBootApplication
@Slf4j
public class Homework0502Application implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Homework0502Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        showConnection();
        showData();
    }

    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection connection = dataSource.getConnection();
            //关闭自动提交
            connection.setAutoCommit(false);
            // insert
            PreparedStatement pst = connection.prepareStatement("insert into student values (?,?)");
            for(int i=0;i<10;i++){
                pst.setInt(1,i);
                pst.setString(2,"userName"+i);
                pst.addBatch();
            }
            pst.executeBatch();
            pst.close();
            connection.commit();
            //delete
            PreparedStatement pst2 = connection.prepareStatement("delete from student where id > 5");
            pst2.executeUpdate();
            pst2.close();
            connection.commit();
            //update
            PreparedStatement pst3 = connection.prepareStatement("update student set name=? where id = ?");
            for(int i=0;i<10;i++){
                pst3.setString(1,i+"name");
                pst3.setInt(2,i);
                pst3.addBatch();
            }
            pst3.executeBatch();
            pst3.close();
            connection.commit();
            //select
            PreparedStatement pst4 = connection.prepareStatement("select * from student");
            ResultSet rs = pst4.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("id")+": "+ rs.getString("name"));
            }
        connection.close();

}

    private void showData() {
        jdbcTemplate.queryForList("SELECT * FROM Student")
                .forEach(row -> log.info(row.toString()));
    }
}
