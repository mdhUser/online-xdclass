package net.maxwellclass.online.xdclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("net.maxwellclass.online.xdclass.mapper")
@EnableAsync
@EnableTransactionManagement
public class OnlineXdclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineXdclassApplication.class, args);
	}

}
