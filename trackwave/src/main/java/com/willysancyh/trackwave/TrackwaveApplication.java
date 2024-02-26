package com.willysancyh.trackwave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.willysancyh.trackwave.properties")
public class TrackwaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackwaveApplication.class, args);
	}

}
