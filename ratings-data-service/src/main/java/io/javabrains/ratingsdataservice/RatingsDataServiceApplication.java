package io.javabrains.ratingsdataservice;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import io.javabrains.ratingsdataservice.resources.RabbitMqListner;

@SpringBootApplication
@EnableEurekaClient
public class RatingsDataServiceApplication {
	
	
	@Value("${movieinfo.rabbitmq.queue}")
	String queueName;

	@Value("${spring.rabbitmq.username}")
	String username;

	@Value("${spring.rabbitmq.password}")
	private String password;

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}
	
	//create custom connection factory
		@Bean
		ConnectionFactory connectionFactory() {
			CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
			cachingConnectionFactory.setUsername(username);
			cachingConnectionFactory.setUsername(password);
			return cachingConnectionFactory;
		}
		
	    //create MessageListenerContainer using custom connection factory
		@Bean
		MessageListenerContainer messageListenerContainer() {
			SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
			simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
			simpleMessageListenerContainer.setQueues(queue());
			simpleMessageListenerContainer.setMessageListener(new RabbitMqListner());
			return simpleMessageListenerContainer;

		}
	
	public static void main(String[] args) {
		SpringApplication.run(RatingsDataServiceApplication.class, args);
	}

}
