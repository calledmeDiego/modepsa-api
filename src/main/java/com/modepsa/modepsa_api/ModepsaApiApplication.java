package com.modepsa.modepsa_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class ModepsaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModepsaApiApplication.class, args);
	}

	@Bean 
	public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MODEPSA API")
                        .version("1.0.0")
                        .description("Documentación de la API REST de MODEPSA"));
    }
}
