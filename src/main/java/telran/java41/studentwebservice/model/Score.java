package telran.java41.studentwebservice.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class Score {

    private Integer scoreId;
    private String examName;
    private Integer score;

}
