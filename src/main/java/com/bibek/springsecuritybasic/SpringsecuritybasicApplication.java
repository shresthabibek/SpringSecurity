package com.bibek.springsecuritybasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@SpringBootApplication
@ComponentScans({@ComponentScan("com.bibek.controller"), @ComponentScan("com.bibek.config") })
public class SpringsecuritybasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritybasicApplication.class, args);
	}

}
