package org.example.ran;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.ran.dao")
public class FenKuFenBiaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FenKuFenBiaoApplication.class, args);
    }

}
