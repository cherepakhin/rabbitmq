### Примеры работы с RabbitMQ 
[RabbitMQ Spring tutorial](https://habr.com/ru/post/262069/)

[Пример работы с RabbitMQ](http://spring-projects.ru/guides/messaging-rabbitmq/#scratch)

**1. direct** - простой обмен

![Схема](doc/hello1.png "Схема")
```shell script
Тест: 
http :8080/emit
```
**2. direct-json** - простой обмен разными JSON объектами

![Схема](doc/hello1.png "Схема")
```shell script
Тест: 
http :8080/emit
```
**3. work-queues** - В данном примере одну очередь слушают уже два листенера. Так можно распараллелить очередь на несколько компьютеров или нод в облаке.

![Схема](doc/work-queues.png "Схема")
```shell script
Тест: 
http :8080/emit
```

**4. Publish-Subscribe** - Одно и то же сообщение приходит сразу двум консьюмерам.

![Схема](doc/work-queues.png "Схема")
```shell script
Тест: 
http :8080/emit
```

**5. Routing** - используется routing key, в зависимости от которого сообщение может попасть в одну из очередей или сразу в обе.

![Схема](doc/routing.png "Схема")
```shell script
Тест: 
http :8080/error
http :8080/info
http :8080/warming
```

**6. Topic** - вместо DirectExchange используем TopicExchange.

![Схема](doc/topic.png "Схема")
```shell script
Тест: 
http :8080/a.orange.b/message1
http :8080/a.b.rabbit/message2
http :8080/lazy/message3
```