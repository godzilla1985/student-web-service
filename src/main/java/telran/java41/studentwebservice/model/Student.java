package telran.java41.studentwebservice.model;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@ToString
public class Student {

    private Integer studentId;
    private String name;
    private String password;
    @Singular
    private Set<Score> scores;

}
