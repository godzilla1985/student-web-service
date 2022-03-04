package telran.java41.studentwebservice.dto;

import lombok.Getter;

import java.util.Map;

@Getter
public class StudentDto {

    private Integer id;
    private String name;
    private Map<String, Integer> scores;

}
