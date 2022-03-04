package telran.java41.studentwebservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ModelEntityTesting {

    private static List<Student> students;

    @BeforeAll
    private static void setup() {
        Score score = new Score(123, "Math", 90);
        Score score2 = new Score(124, "Lit", 65);
        Score score3 = new Score(125, "History", 75);
        Set<Score> scores = new HashSet<>(Arrays.asList(score, score2));
        Student student = new Student(1, "John", "12345", scores);
        Student student2 = new Student(2, "Albert", "34856", scores);
        Student student3 = Student.builder()
                .studentId(3)
                .name("Albert")
                .password("0456hdjfg")
                .score(score3)
                .score(score).build();
        students = Arrays.asList(student, student2, student3);
    }


    @Test
    public void findStudentByIdTest() {
        Integer idForSearching = 2;
        Student expectedStudentRes = students.get(1);
        Student actualStudentRes = students.stream()
                .filter(studentItem -> studentItem.getStudentId().equals(idForSearching))
                .findAny().orElse(null);
        Assertions.assertEquals(expectedStudentRes, actualStudentRes);
    }


    @Test
    public void findStudentsByName() {
        String byName = "Albert";
        List<Student> studentsList = students.stream()
                .filter(studentItem -> studentItem.getName().equals(byName))
                .collect(Collectors.toList());
        Assertions.assertEquals(2, studentsList.size());
    }

    @Test
    public void findStudentsByMinScore() {
        Integer minscore = 70;
        List<Student> studentsResList = new ArrayList<>();
        for (Student student : students) {
            Set<Score> currentStudentScores = student.getScores().stream()
                    .filter(score -> score.getScore() < minscore)
                    .collect(Collectors.toSet());
            if (currentStudentScores.isEmpty()) {
                studentsResList.add(student);
            }
        }
        System.out.println(studentsResList);
        Assertions.assertEquals(1,studentsResList.size());
    }

}
