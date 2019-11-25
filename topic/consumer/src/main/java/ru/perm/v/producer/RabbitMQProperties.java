package ru.perm.v.producer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitMQProperties {

	String queueTopic1;
	String queueTopic2;

	public String getQueueTopic1() {
		return queueTopic1;
	}

	public void setQueueTopic1(String queueTopic1) {
		this.queueTopic1 = queueTopic1;
	}

	public String getQueueTopic2() {
		return queueTopic2;
	}

	public void setQueueTopic2(String queueTopic2) {
		this.queueTopic2 = queueTopic2;
	}
}
