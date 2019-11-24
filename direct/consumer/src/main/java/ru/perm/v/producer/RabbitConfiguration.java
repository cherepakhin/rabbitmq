package ru.perm.v.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

	@Autowired
	RabbitMQProperties rabbitMQProperties;

	@Bean
	public Queue queue1() {
		return QueueBuilder.durable(rabbitMQProperties.getQueueName()).build();
	}

	@Bean
	public DirectExchange queue1Exchange() {
		return ExchangeBuilder.directExchange(rabbitMQProperties.getExchangeName()).build();
	}

	@Bean
	public Binding binding(Queue queue1, DirectExchange queue1Exchange) {
		return BindingBuilder.bind(queue1).to(queue1Exchange)
				.with(rabbitMQProperties.getRoutingKey());
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(rabbitMQProperties.getQueueName());
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
}
