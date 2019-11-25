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

	@RabbitListener(queues = "queue1")
	public void worker1(String message) throws InterruptedException {
		logger.info("worker1: " + message);
		Thread.sleep(2000);
	}

	@RabbitListener(queues = "queue1")
	public void worker2(String message) throws InterruptedException {
		logger.info("worker2: " + message);
		Thread.sleep(2000);
	}
}
