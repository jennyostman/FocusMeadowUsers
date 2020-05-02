package exarb.fmusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FmusersApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmusersApplication.class, args);
	}

}
