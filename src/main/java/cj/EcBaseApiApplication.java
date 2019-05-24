package cj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "cj")
public class EcBaseApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcBaseApiApplication.class, args);
	}
}