package messagequeue.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Book.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private String author;

    private String title;

    private String publisher;

    private String genre;

}
