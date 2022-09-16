package com.example.studentspringboot;

import com.example.studentspringboot.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class StudentSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSpringBootApplication.class, args);
	}

}
