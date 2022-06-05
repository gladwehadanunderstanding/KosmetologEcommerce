package com.kosmetolog.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.kosmetolog.entity", "com.kosmetolog.admin.user"})
public class KostmetologBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(KostmetologBackEndApplication.class, args);
	}

}
