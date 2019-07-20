package cj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import cj.configuration.AppConfig;
import cj.configuration.SwaggerConfig;

@SpringBootApplication
@EnableAutoConfiguration
@Import({AppConfig.class, SwaggerConfig.class})
@ComponentScan(basePackages = "cj")
public class EcBaseApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcBaseApiApplication.class, args);
	}
}