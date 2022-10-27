package messagequeue.producer;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import messagequeue.model.Book;
import messagequeue.model.BookData;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class RabbitMQProducer {

    private static final Faker faker = new Faker();
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    public String sendBookMessage(BookData bookData) {
        Book initializedBook = null;
        initializedBook = bookData == null ? initializedBook.builder()
                .author(faker.book().author())
                .title(faker.book().title())
                .publisher(faker.book().publisher())
                .genre(faker.book().genre()).build() : initializedBook.builder()
                .author(bookData.getAuthor())
                .title(bookData.getTitle())
                .publisher(bookData.getPublisher())
                .genre(bookData.getGenre()).build();
        rabbitTemplate.convertAndSend(exchange, routingKey, initializedBook);
        log.info("Book message produced successfully.");
        return "Book message sent successfully.";
    }

}
