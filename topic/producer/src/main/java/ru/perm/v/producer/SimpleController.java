package ru.perm.v.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

	Logger logger = LoggerFactory.getLogger(SimpleController.class);

	@Autowired
	RabbitMQProperties rabbitMQProperties;

	@Autowired
	RabbitTemplate template;

	@RequestMapping("/emit/{key}/{message}")
	@ResponseBody
	String sendMessage(@PathVariable("key") String key, @PathVariable("message") String message) {
		logger.info(String.format("Send %s to %s", message, key));
		template.convertAndSend(key, message);
		return message;
	}

}
