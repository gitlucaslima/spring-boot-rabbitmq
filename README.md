# Spring Boot RabbitMQ

Projeto de envio de messageria utilizando RabbitMQ e Java.

## Características

- Messageria
- Producer
- Consumer
- API RESTful

## Requisitos

- Java JDK 11
- Apache Maven >= 3.6.3 (Opcional)
- Docker (Opcional)

## Tecnologias

- Java
- Maven
- Spring
- Lombok
- Docker

## Instalação

```
$ git clone https://github.com/danilomeneghel/spring-boot-rabbitmq.git

$ cd spring-boot-rabbitmq
```

## Maven

Para carregar o projeto, digite no terminal:

```
$ ./mvnw spring-boot:run
```

Aguarde carregar todo o serviço web. <br>

## Docker

Para rodar o projeto via Docker, bastar executar o seguinte comando:

```
$ docker build -t projeto .
$ docker run -p 8282:8282 -d projeto
```

Ou via Docker-Compose:

```
$ docker-compose up
```

Aguarde baixar as dependências e carregar todo o projeto, esse processo é demorado. <br>
Caso conclua e não rode pela primeira vez, tente novamente executando o mesmo comando. <br>

Para encerrar tudo digite:

```
$ docker-compose down
```

## RabbitMQ

Para acessar o painel do RabbitMQ, abra o navegador e digite o endereço: <br>

http://localhost:15672

Em seguida, digite "guest" para usuário e senha.<br>
Depois crie a fila e a exchange com os mesmos nomes do arquivo application.properties.<br>

rabbitmq.queue=messagequeue<br>
rabbitmq.exchange=messagequeue-exchange<br>
rabbitmq.routingKey=messagequeue-routeKey<br>

Para testar a aplicação abra o Postman e insira os seguintes dados:<br>

POST<br>
http://localhost:8282/book/send-message

```
{
    "author": "aaaaaaaaaa",
    "title": "bbbbbbbbbb",
    "publisher": "cccccccc",
    "genre": "m"
}
```

## Licença

Projeto licenciado sob <a href="LICENSE">The MIT License (MIT)</a>.<br><br>


Desenvolvido por<br>
Danilo Meneghel<br>
danilo.meneghel@gmail.com<br>
http://danilomeneghel.github.io/<br>