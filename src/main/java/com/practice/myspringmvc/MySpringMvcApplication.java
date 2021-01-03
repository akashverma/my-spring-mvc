package com.practice.myspringmvc;

import com.practice.myspringmvc.config.YAMLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MySpringMvcApplication implements CommandLineRunner {

	@Autowired
	YAMLConfig yamlConfig;

	public static void main(String[] args) {
		SpringApplication.run(MySpringMvcApplication.class, args);
	}

	public void run(String... args){
		System.out.println("env name = " + yamlConfig.getEnvironment());
		System.out.println("name = " + yamlConfig.getName());
		System.out.println("servers = " + yamlConfig.getServers());
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
