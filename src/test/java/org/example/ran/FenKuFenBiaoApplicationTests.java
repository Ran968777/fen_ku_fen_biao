package org.example.ran;

import org.example.ran.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FenKuFenBiaoApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
        orderService.createOrder(1L, 101L);
        orderService.createOrder(2L, 100L);
    }


    @Test
    void query_test() {
        System.out.println(orderService.list());
    }
}
