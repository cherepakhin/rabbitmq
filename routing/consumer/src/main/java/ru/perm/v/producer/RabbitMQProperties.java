package ru.perm.v.producer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitMQProperties {

	private String queueName1;
	private String queueName2;

	public String getQueueName1() {
		return queueName1;
	}

	public void setQueueName1(String queueName1) {
		this.queueName1 = queueName1;
	}

	public String getQueueName2() {
		return queueName2;
	}

	public void setQueueName2(String queueName2) {
		this.queueName2 = queueName2;
	}
}
