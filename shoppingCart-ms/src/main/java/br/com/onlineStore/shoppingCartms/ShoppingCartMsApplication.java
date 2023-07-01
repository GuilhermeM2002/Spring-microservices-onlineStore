package br.com.onlineStore.shoppingCartms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShoppingCartMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartMsApplication.class, args);
	}

}
