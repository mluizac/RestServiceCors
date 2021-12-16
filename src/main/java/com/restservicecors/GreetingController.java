package com.restservicecors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.atomic.AtomicLong;

//pra acessar a porta 8080: application.properties: server.port=8080, .\mvnw.cmd spring-boot:run
//pra acessar a porta 9000: application.properties: server.port=9000, .\mvnw spring-boot:run -Dserver".port=9000"


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";//mascara de acesso a variavel

    private final AtomicLong counter = new AtomicLong(); //é um contador pra ir incrementando

    //Você pode combinar a configuração CORS em nível global e de controlador.
    //configuração do metodo cors no controlador é local:
    @CrossOrigin(origins = "http://localhost:8080") //essa aplicação so vai aceitar recurso da mesma origem
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== get greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name)); //retorna o contador
    }

    //configuração cors global:
    @GetMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaconfig(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));

    }

}
