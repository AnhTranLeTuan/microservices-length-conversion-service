package project.microservices.lengthconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LengthConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LengthConversionServiceApplication.class, args);
	}

}
