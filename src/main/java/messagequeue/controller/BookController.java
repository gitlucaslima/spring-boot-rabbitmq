package messagequeue.controller;

import messagequeue.model.BookData;
import messagequeue.producer.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final RabbitMQProducer rabbitMQProducer;

    @PostMapping(value = "/send-message")
    public String send(@Valid @RequestBody BookData bookData) {
        return rabbitMQProducer.sendBookMessage(bookData.getAuthor()==null?null:bookData);
    }

}
