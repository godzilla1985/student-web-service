package telran.java41.studentwebservice.service;

import telran.java41.studentwebservice.dto.ScoreDto;
import telran.java41.studentwebservice.dto.StudentCredentialsDto;
import telran.java41.studentwebservice.dto.StudentDto;
import telran.java41.studentwebservice.dto.UpdateStudentDto;

import java.util.List;

public interface StudentService {

    boolean addStudent(StudentCredentialsDto studentCredentialsDto);

    StudentDto findStudent(Integer id);

    StudentDto deleteStudent(Integer id);

    StudentCredentialsDto updateStudent(Integer id, UpdateStudentDto updateStudentDto);

    boolean addScore(Integer id, ScoreDto scoreDto);

    List<StudentDto> findStudentByName(String name);

    List<Integer> studentQuantity(List<String> names);

    List<StudentDto> findStudentsByMinScore(Integer minscore);

}
