package quiz_App_Service.collections;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "quizzes")
public class Quiz {

    @Id
    private  String id;

    @Field("quiz_title")
    private  String title;
    private  String description;
    private  Integer maxMarks;
    private  Integer timeLimit;
    private  String createdBy;
    private  Integer noOfQuestions;
    private  String imageUrl;
    private  Boolean live;
    private  Integer passingMarks;
    private  String categoryId;




}