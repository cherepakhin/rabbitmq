package ru.perm.v.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit //нужно для активации обработки аннотаций @RabbitListener
@Component
public class RabbitMQListener {

	Logger logger = LoggerFactory.getLogger(RabbitMQListener.class);

	/**
	 * Обработчик сообщений для очереди 1
	 * @param message
	 */
	@RabbitListener(queues = "${rabbitmq.queueName1}")
	public void worker1(String message) {
		logger.info("queueName1: " + message);
	}

	/**
	 * Обработчик сообщений для очереди 2
	 * @param message
	 */
	@RabbitListener(queues = "${rabbitmq.queueName2}")
	public void worker2(String message) {
		logger.info("queueName2: " + message);
	}
}
