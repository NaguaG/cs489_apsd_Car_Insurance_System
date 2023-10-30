package miu.edu.car_insurance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarInsuranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarInsuranceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(){
		return (args) -> {
			System.out.println("Hello .. Car Insurance application is starting...");
			System.out.println("Car Insurance WebAPI server. Started.\nRunning Apache Tomcat service and Listening for HTTP Request on Port number, 8082");


		};
	}

}
