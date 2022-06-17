package kg.erkin.mongoDB.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("workPlace")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkPlace {
    @Id
    private String id;

    private String name;
    private String description;
    private long number;
}
