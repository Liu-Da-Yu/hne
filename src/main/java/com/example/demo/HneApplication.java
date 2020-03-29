package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*
@SpringBootApplication
public class HneApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(HneApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HneApplication.class);
	}
}*/

@SpringBootApplication
public class HneApplication  {
	public static void main(String[] args) {
		SpringApplication.run(HneApplication.class, args);
	}

}
