package com.restservicecors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestservicecorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestservicecorsApplication.class, args);
	}

	//adicionar mapeamento CORS na classe do aplicativo:
	//ta configurando pra toda aplicação, dai nao precisa fazer no controller
	//aqui é global
	@Bean //quer dizer que esse é um elemento que vai ser gerenciado pelo spring, @component-> pesquisar
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080");
			}
		};
	}
}
