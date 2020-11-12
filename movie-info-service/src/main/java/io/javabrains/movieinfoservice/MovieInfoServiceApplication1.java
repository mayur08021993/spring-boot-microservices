package io.javabrains.movieinfoservice;
/*package io.javabrains.movieinfoservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableEurekaClient
public class MovieInfoServiceApplication extends SpringBootServletInitializer{
	
	@Value("${movieinfo.rabbitmq.queue}")
	String queueName;

	@Value("${movieinfo.rabbitmq.exchange}")
	String exchange;

	@Value("${movieinfo.rabbitmq.routingkey}")
	private String routingkey;
	
	@Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	  return application.sources(MovieInfoServiceApplication.class);
	 }
	
	public static void main(String[] args) {
		SpringApplication.run(MovieInfoServiceApplication.class, args);
	}
	
	

}
*/