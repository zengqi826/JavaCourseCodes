## 分库分表
CREATE TABLE IF NOT EXISTS ds0.t_order_0 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_1 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_2 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_3 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_4 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                          VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_5 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                          VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_6 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                          VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_7 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                          VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_8 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                          VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_9 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                          VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_10 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                          VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_11 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                          VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_12 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                          VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_13 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_14 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                          VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds0.t_order_15 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                          VARCHAR(50), PRIMARY KEY (order_id));

CREATE TABLE IF NOT EXISTS ds1.t_order_0 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_1 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_2 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_3 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_4 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_5 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_6 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_7 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_8 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_9 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                           VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_10 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                            VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_11 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                            VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_12 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                            VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_13 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                            VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_14 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                            VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS ds1.t_order_15 (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status
                                            VARCHAR(50), PRIMARY KEY (order_id));
