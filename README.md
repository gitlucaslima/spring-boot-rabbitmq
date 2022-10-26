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

Primeiro rode o RabbitMQ.<br>
Caso não tenha o RabbitMQ instalado, execute o seguinte comando via Docker:

```
$ docker run -d -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:management
```

Para carregar o projeto, digite no terminal:

```
$ ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

Aguarde carregar todo o serviço web. <br>

## Docker (Opcional)

Para rodar o projeto via Docker-Compose, basta executar o comando:

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

# Teste da Messageria

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