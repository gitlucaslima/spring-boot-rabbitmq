package messagequeue.controller;

import jdk.jfr.ContentType;
import messagequeue.model.BookData;
import messagequeue.producer.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final RabbitMQProducer rabbitMQProducer;

    @PostMapping(value = "/send-message", produces = "application/json")
    @ResponseBody
    public String send(@Valid @RequestBody BookData bookData) {
        return rabbitMQProducer.sendBookMessage(bookData.getAuthor() == null ? null : bookData);
    }

}
