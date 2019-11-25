package ru.perm.v.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

	@Autowired
	RabbitMQProperties rabbitMQProperties;

	@Bean
	public Queue queue1() {
		return QueueBuilder.durable(rabbitMQProperties.getQueueName1()).build();
	}

	@Bean
	public Queue queue2() {
		return QueueBuilder.durable(rabbitMQProperties.getQueueName2()).build();
	}

	@Bean
	public DirectExchange queueExchange() {
		return ExchangeBuilder.directExchange(rabbitMQProperties.getExchangeName()).build();
	}

	@Bean
	public Binding binding1Error(Queue queue1, DirectExchange queueExchange) {
		return BindingBuilder.bind(queue1).to(queueExchange)
				.with(rabbitMQProperties.getRoutingKeyError());
	}

	@Bean
	public Binding binding2Error(Queue queue2, DirectExchange queueExchange) {
		return BindingBuilder.bind(queue2).to(queueExchange)
				.with(rabbitMQProperties.getRoutingKeyError());
	}

	@Bean
	public Binding bindingInfo(Queue queue2, DirectExchange queueExchange) {
		return BindingBuilder.bind(queue2).to(queueExchange)
				.with(rabbitMQProperties.getRoutingKeyInfo());
	}

	@Bean
	public Binding bindingWarning(Queue queue2, DirectExchange queueExchange) {
		return BindingBuilder.bind(queue2).to(queueExchange)
				.with(rabbitMQProperties.getRoutingKeyWarning());
	}

	@Bean
	public RabbitTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setExchange(rabbitMQProperties.getExchangeName());
		return rabbitTemplate;
	}

}
