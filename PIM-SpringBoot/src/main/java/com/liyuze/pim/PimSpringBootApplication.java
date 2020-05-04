package com.liyuze.pim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liyuze.pim.dao")
public class PimSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PimSpringBootApplication.class, args);
	}

}
