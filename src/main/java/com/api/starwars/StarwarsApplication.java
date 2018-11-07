package com.api.starwars;

import com.api.starwars.common.util.ExternalRequestHttp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StarwarsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StarwarsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
