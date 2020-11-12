package io.javabrains.ratingsdataservice.resources;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitMqListner implements MessageListener {

	@Override
	public void onMessage(Message message) {
		
		System.out.println("Message received -"+ new String(message.getBody()));
	}

}
