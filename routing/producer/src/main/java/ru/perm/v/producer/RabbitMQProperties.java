package ru.perm.v.producer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitMQProperties {
	private String queueName1;
	private String queueName2;
	private String exchangeName;
	private String routingKeyError;
	private String routingKeyInfo;
	private String routingKeyWarning;

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

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public String getRoutingKeyError() {
		return routingKeyError;
	}

	public void setRoutingKeyError(String routingKeyError) {
		this.routingKeyError = routingKeyError;
	}

	public String getRoutingKeyInfo() {
		return routingKeyInfo;
	}

	public void setRoutingKeyInfo(String routingKeyInfo) {
		this.routingKeyInfo = routingKeyInfo;
	}

	public String getRoutingKeyWarning() {
		return routingKeyWarning;
	}

	public void setRoutingKeyWarning(String routingKeyWarning) {
		this.routingKeyWarning = routingKeyWarning;
	}
}
