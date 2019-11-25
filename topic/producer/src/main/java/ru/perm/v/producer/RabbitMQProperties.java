package ru.perm.v.producer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitMQProperties {
	String queueTopic1;
	String queueTopic2;
	String exchangeName;
	String routingKeyOrange;
	String routingKeyRabbit;
	String routingKeyLazy;

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

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public String getRoutingKeyOrange() {
		return routingKeyOrange;
	}

	public void setRoutingKeyOrange(String routingKeyOrange) {
		this.routingKeyOrange = routingKeyOrange;
	}

	public String getRoutingKeyRabbit() {
		return routingKeyRabbit;
	}

	public void setRoutingKeyRabbit(String routingKeyRabbit) {
		this.routingKeyRabbit = routingKeyRabbit;
	}

	public String getRoutingKeyLazy() {
		return routingKeyLazy;
	}

	public void setRoutingKeyLazy(String routingKeyLazy) {
		this.routingKeyLazy = routingKeyLazy;
	}
}
