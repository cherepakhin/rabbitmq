package ru.perm.v.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.perm.v.MessageJSON0;
import ru.perm.v.MessageJSON1;

@Controller
public class SimpleController {

	private static int counter = 0;

	Logger logger = LoggerFactory.getLogger(SimpleController.class);

	@Autowired
	RabbitMQProperties rabbitMQProperties;

	@Autowired
	RabbitTemplate template;

	/**
	 * Конвертация и посылка объектов MessageJSON0 и MessageJSON1
	 * @return
	 */
	@RequestMapping("/emit")
	@ResponseBody
	String queue1() {
		MessageJSON0 message0 = new MessageJSON0(counter++, "name0");
		logger.info("Seng:" + message0);
		template.convertAndSend(rabbitMQProperties.getExchangeName(),
				rabbitMQProperties.getRoutingKey(), message0);

		MessageJSON1 message1 = new MessageJSON1(counter++, "name1");
		logger.info("Seng:" + message1);
		template.convertAndSend(rabbitMQProperties.getExchangeName(),
				rabbitMQProperties.getRoutingKey(), message1);

		return message0.toString();
	}
}
