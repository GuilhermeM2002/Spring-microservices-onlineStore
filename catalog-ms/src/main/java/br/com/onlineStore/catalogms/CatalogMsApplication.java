package br.com.onlineStore.catalogms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CatalogMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogMsApplication.class, args);
	}

}
