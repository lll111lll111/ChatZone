package com.dyhczh.chat_zone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dyhczh.chat_zone.dao")
public class ChatZoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatZoneApplication.class, args);
	}

}
