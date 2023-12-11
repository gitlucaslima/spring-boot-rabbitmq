package messagequeue.producer;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import messagequeue.model.Book;
import messagequeue.model.BookData;
import messagequeue.model.enums.Genre;
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

    public String sendBookMessage(BookData bookData) {
        Book initializedBook = null;
        initializedBook = bookData == null ? Book.builder()
                .author(faker.book().author())
                .title(faker.book().title())
                .genre(Genre.valueOf(faker.book().genre()))
                .publisher(faker.book().publisher()).build() : Book.builder()
                .author(bookData.getAuthor())
                .title(bookData.getTitle())
                .publisher(bookData.getPublisher())
                .genre(bookData.getGenre()).build();
        rabbitTemplate.convertAndSend(exchange, bookData.getGenre().getGenre(), initializedBook);
        log.info("Book message produced successfully.");
        return "Book message sent successfully.";
    }

}
