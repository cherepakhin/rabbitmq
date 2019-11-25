package ru.perm.v.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.perm.v.MessageJSON0;
import ru.perm.v.MessageJSON1;

/**
 * Обработчик принятых сообщений.
 * Должен быть @Bean для MessageAdapter
 */
@Component
public class Receiver {

	Logger logger = LoggerFactory.getLogger(Receiver.class);

	/**
	 * Прием сообщения MessageJSON0
	 * @param message
	 */
	public void receiveMessage(MessageJSON0 message) {
		logger.info("Received <" + message + ">");
	}

	/**
	 * Прием сообщения MessageJSON1
	 * @param message
	 */
	public void receiveMessage(MessageJSON1 message) {
		logger.info("Received <" + message + ">");
	}
}
