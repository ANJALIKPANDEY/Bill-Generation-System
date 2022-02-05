package com.anjalipandey.hackerbills;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main SpringBootApplication class
 */
@SpringBootApplication
public class HackerbillsApplication {

	public static void main(String[] args) {

		SpringApplication.run(HackerbillsApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
