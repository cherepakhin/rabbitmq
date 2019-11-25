package ru.perm.v.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

	private static int counter = 0;

	Logger logger = LoggerFactory.getLogger(SimpleController.class);

	@Autowired
	RabbitMQProperties rabbitMQProperties;

	@Autowired
	RabbitTemplate template;

	@RequestMapping("/emit")
	@ResponseBody
	String queue1() throws InterruptedException {
		String message = "Message " + counter++;
		logger.info("Seng:" + message);
		// имя exchange можно указать в RabbitTemplate
		template.setExchange(rabbitMQProperties.getExchangeName());
		template.convertAndSend(rabbitMQProperties.getExchangeName(), message);
		return message;
	}
}
