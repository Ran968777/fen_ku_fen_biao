-- db0/init.sql 和 db1/init.sql 内容相同，只是数据库名不同
CREATE TABLE IF NOT EXISTS t_order_0 (
                                         order_id BIGINT PRIMARY KEY,
                                         user_id BIGINT NOT NULL,
                                         status VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS t_order_1 LIKE t_order_0;
