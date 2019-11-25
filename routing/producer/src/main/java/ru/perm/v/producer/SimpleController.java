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

	@RequestMapping("/emit/error")
	@ResponseBody
	String sendError() throws InterruptedException {
		String message = "Error message " + counter++;
		logger.info("Seng:" + message);
		template.convertAndSend(rabbitMQProperties.getExchangeName(),
				rabbitMQProperties.getRoutingKeyError(), message);
		return message;
	}

	@RequestMapping("/emit/info")
	@ResponseBody
	String sendInfo() throws InterruptedException {
		String message = "Info message " + counter++;
		logger.info("Seng:" + message);
		template.convertAndSend(rabbitMQProperties.getExchangeName(),
				rabbitMQProperties.getRoutingKeyInfo(), message);
		return message;
	}

	@RequestMapping("/emit/warning")
	@ResponseBody
	String sendWarning() throws InterruptedException {
		String message = "Warning message " + counter++;
		logger.info("Seng:" + message);
		template.convertAndSend(rabbitMQProperties.getExchangeName(),
				rabbitMQProperties.getRoutingKeyWarning(), message);
		return message;
	}
}
