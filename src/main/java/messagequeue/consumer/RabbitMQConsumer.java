package messagequeue.consumer;

import messagequeue.model.Book;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Log4j2
@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue}"})
    public void receive(@Payload Book book) {
        log.info("Message received successfully at " + LocalDateTime.now());
        log.info("\n Author ---------> " + book.getAuthor()
                + "\n Title ----------> " + book.getTitle()
                + "\n Publisher ------> " + book.getPublisher()
                + "\n Genre ----------> " + book.getGenre());

    }

    @RabbitListener(queues = {"${rabbitmq.queueFantasy}"})
    public void receiveFantasy(@Payload Book book) {
        log.info("Book with genere "+  book.getGenre() +" received in: " + LocalDateTime.now());
        log.info("\n Author ---------> " + book.getAuthor()
                + "\n Title ----------> " + book.getTitle()
                + "\n Publisher ------> " + book.getPublisher()
                + "\n Genre ----------> " + book.getGenre());
    }

    @RabbitListener(queues = {"${rabbitmq.queueRomance}"})
    public void receiveRomance(@Payload Book book) {
        log.info("Book with genere "+  book.getGenre() +" received in: " + LocalDateTime.now());
        log.info("\n Author ---------> " + book.getAuthor()
                + "\n Title ----------> " + book.getTitle()
                + "\n Publisher ------> " + book.getPublisher()
                + "\n Genre ----------> " + book.getGenre());
    }

    @RabbitListener(queues = {"${rabbitmq.queueFiction}"})
    public void receiveFiction(@Payload Book book) {
        log.info("Book with genere "+  book.getGenre() +" received in: " + LocalDateTime.now());
        log.info("\n Author ---------> " + book.getAuthor()
                + "\n Title ----------> " + book.getTitle()
                + "\n Publisher ------> " + book.getPublisher()
                + "\n Genre ----------> " + book.getGenre());
    }

}