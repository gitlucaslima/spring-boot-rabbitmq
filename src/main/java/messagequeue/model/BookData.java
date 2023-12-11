package messagequeue.model;

import lombok.Data;
import messagequeue.model.enums.Genre;

import javax.validation.constraints.Size;

@Data
public class BookData {

    @Size(min = 1, max = 200, message = "invalid author.")
    private String author;

    private String title;

    private String publisher;
    
    private Genre genre;

}
