package ru.perm.v.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
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
			MyMessageAdapter myMessageAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(rabbitMQProperties.getQueueName());
//		MyMessageAdapter myMessageAdapter = new MyMessageAdapter();
//		myMessageAdapter.setMessageConverter(consumerJackson2MessageConverter());
		container.setMessageListener(myMessageAdapter);

		return container;
	}

//	@Bean
//	public DefaultClassMapper classMapper() {
//		DefaultClassMapper classMapper = new DefaultClassMapper();
//		Map<String, Class<?>> idClassMapping = new HashMap<>();
//		idClassMapping.put("ru.perm.v.MessageJSON", MessageJSON.class);
//		classMapper.setIdClassMapping(idClassMapping);
//		return classMapper;
//	}

	//  	@Bean
//	public RabbitTemplate amqpTemplate(ConnectionFactory connectionFactory) {
//		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//		rabbitTemplate.setMessageConverter(consumerJackson2MessageConverter());
//		return rabbitTemplate;
//	}

//	@Bean
//	public Jackson2JsonMessageConverter consumerJackson2MessageConverter() {
//		Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
//		converter.setClassMapper(classMapper());
//		return converter;
//	}

}
