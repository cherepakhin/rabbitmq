package ru.perm.v.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
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
		return QueueBuilder.durable(rabbitMQProperties.getQueueTopic1()).build();
	}

	@Bean
	public Queue queue2() {
		return QueueBuilder.durable(rabbitMQProperties.getQueueTopic2()).build();
	}

	@Bean
	public TopicExchange topicExchange() {
		return ExchangeBuilder.topicExchange(rabbitMQProperties.getExchangeName()).build();
	}

	@Bean
	public Binding bindingOrange(Queue queue1, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue1).to(topicExchange)
				.with(rabbitMQProperties.getRoutingKeyOrange());
	}

	@Bean
	public Binding bindingRabbit(Queue queue2, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue2).to(topicExchange)
				.with(rabbitMQProperties.getRoutingKeyRabbit());
	}

	@Bean
	public Binding bindingLazy(Queue queue2, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue2).to(topicExchange)
				.with(rabbitMQProperties.getRoutingKeyLazy());
	}

	@Bean
	public RabbitTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setExchange(rabbitMQProperties.getExchangeName());
		return rabbitTemplate;
	}

}
