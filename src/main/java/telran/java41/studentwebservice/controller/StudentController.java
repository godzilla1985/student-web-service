package telran.java41.studentwebservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telran.java41.studentwebservice.dto.ScoreDto;
import telran.java41.studentwebservice.dto.StudentCredentialsDto;
import telran.java41.studentwebservice.dto.StudentDto;
import telran.java41.studentwebservice.dto.UpdateStudentDto;
import telran.java41.studentwebservice.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("student")
    public boolean addStudent(@RequestBody StudentCredentialsDto studentCredentialsDto) {
        return studentService.addStudent(studentCredentialsDto);
    }

    @GetMapping("student/{id}")
    public StudentDto findStudent(@PathVariable Integer id) {
        return studentService.findStudent(id);
    }

    @DeleteMapping("student/{id}")
    public StudentDto deleteStudent(@PathVariable Integer id) {
        //TODO: check if the object equals null and return error response in this case
        return studentService.deleteStudent(id);
    }

    @PutMapping("student/{id}")
    public StudentCredentialsDto updateStudent(@PathVariable Integer id, @RequestBody UpdateStudentDto updateStudentDto) {
        return studentService.updateStudent(id, updateStudentDto);
    }

    @PutMapping("score/student/{id}")
    public boolean addScore(@PathVariable Integer id, @RequestBody ScoreDto scoreDto) {
        return studentService.addScore(id, scoreDto);
    }

    @GetMapping("students/name/{name}")
    public List<StudentDto> findStudentByName(@PathVariable String name) {
        return studentService.findStudentByName(name);
    }

    @GetMapping("quantity/students")
    public List<Integer> studentsQuantity(@RequestBody List<String> names) {
        return studentService.studentQuantity(names);
    }

    @GetMapping("students/exam/History/minscore/{score}")
    public List<StudentDto> findStudentsByMinScore(@PathVariable Integer score) {
        return studentService.findStudentsByMinScore(score);
    }

}
