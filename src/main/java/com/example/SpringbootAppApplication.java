package com.example;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringbootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAppApplication.class, args);
	}

	// 비밀번호를 암호화하는 비밀번호 Enconder객체를 스프링 컨테이너에 등록한다.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); /// 동일한 비밀번호라도 매번 다르게 저장된다.
	}
}
