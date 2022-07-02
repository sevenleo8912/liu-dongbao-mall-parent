package com.liu.dongbao.ums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liu.dongbao.ums.mapper")
public class LiuDongbaoUmsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiuDongbaoUmsApiApplication.class, args);
	}

}
