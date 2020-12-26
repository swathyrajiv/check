package com.w.simplilearn.thirdphase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.w.simplilearn.thirdphase")
public class ThirdPhaseApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ThirdPhaseApplication.class);
	}  

	public static void main(String[] args) {
		SpringApplication.run(ThirdPhaseApplication.class, args);
	}

}
