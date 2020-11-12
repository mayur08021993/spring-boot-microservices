package io.javabrains.movieinfoservice.resources;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQPublisher {
	
	@Autowired
	private AmqpTemplate rabbitMqTemplate;
	
	@Value("${movieinfo.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${movieinfo.rabbitmq.routingkey}")
	private String routingKey;
	
	public void publish(Movie movie) {
		rabbitMqTemplate.convertAndSend(exchange, routingKey, movie);
	}
	
}
