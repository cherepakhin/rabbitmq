package ru.perm.v.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

	@Autowired
	RabbitMQProperties rabbitMQProperties;

	public Queue queue1() {
		return QueueBuilder.durable(rabbitMQProperties.getQueueName1()).build();
	}

	public Queue queue2() {
		return QueueBuilder.durable(rabbitMQProperties.getQueueName2()).build();
	}

	// Для publish-subscribe тип exchange д.б. fanout. Routing-key не нужен
	public FanoutExchange exchangeSubscribe() {
		return ExchangeBuilder.fanoutExchange(rabbitMQProperties.getExchangeName()).build();
	}

	/**
	 * Привязка 1-ой очереди к exchange
	 *
	 * @return
	 */
	@Bean
	public Binding binding1() {
		return BindingBuilder.bind(queue1()).to(exchangeSubscribe());
	}

	/**
	 * Привязка 2-ой очереди к exchange
	 *
	 * @return
	 */
	@Bean
	public Binding binding2() {
		return BindingBuilder.bind(queue2()).to(exchangeSubscribe());
	}
}
