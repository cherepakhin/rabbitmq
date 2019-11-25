package ru.perm.v.consumer;

import java.util.HashMap;
import java.util.Map;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Component;
import ru.perm.v.MessageJSON0;
import ru.perm.v.MessageJSON1;

/**
 * Адаптер для обработки принятых сообщений
 */
@Component
public class MyMessageAdapter extends MessageListenerAdapter {

	public MyMessageAdapter(Receiver receiver) {
		// Определяется bean и метод обработки принятых сообщений
		super(receiver, "receiveMessage");
		// Конвертор из JSON в объект
		this.setMessageConverter(consumerJackson2MessageConverter());
	}

	/**
	 * Маппер для конвертора сообщений. В header сообщения передается название класса в поле
	 * __TypeId__ В зависимоти от значения этого поля, определяется какой объект в теле сообщения
	 *
	 * @return
	 */
	public DefaultClassMapper classMapper() {
		DefaultClassMapper classMapper = new DefaultClassMapper();
		Map<String, Class<?>> idClassMapping = new HashMap<>();
		idClassMapping.put("ru.perm.v.MessageJSON0", MessageJSON0.class);
		idClassMapping.put("ru.perm.v.MessageJSON1", MessageJSON1.class);
		classMapper.setIdClassMapping(idClassMapping);
		return classMapper;
	}

	//  Если не определять Receiver в конструкторе, то сообщения можно обрабатывать этим методом
	//	@SuppressWarnings("unused")
	//	public void handleMessage(Object object) {
	//		System.out.println("Got a " + object);
	//	}

	public Jackson2JsonMessageConverter consumerJackson2MessageConverter() {
		Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
		converter.setClassMapper(classMapper());
		return converter;
	}

}
