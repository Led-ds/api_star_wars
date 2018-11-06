package com.api.starwars;

import com.api.starwars.common.util.ExternalRequestHttp;
import com.api.starwars.service.PlanetaServiceImpl;
import org.json.simple.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class StarwarsApplication implements CommandLineRunner {

	private ExternalRequestHttp externalRequestHttp;

	public static void main(String[] args) {
		SpringApplication.run(StarwarsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		externalRequestHttp = new ExternalRequestHttp();
		System.out.println(externalRequestHttp.getRequestSWApi());
	}
}
