import static org.junit.jupiter.api.Assertions.*;

import exceptions.NoSuchStudentException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentServiceTest {

    StudentService studentService = new StudentService();
    Student student1 = null;

    @BeforeEach
    void SetUp() {
        StudentService studentService = new StudentService();

        Student student1 = studentService.addNewStudent(new Student("0", "Aljoscha", "Java"));
        Student student2 = studentService.addNewStudent(new Student("0", "Gökhan", "Java"));
        Student student3 = studentService.addNewStudent(new Student("0", "Jonas", "Java"));
        Student student4 = studentService.addNewStudent(new Student("0", "Daniel", "Java"));
    }

    @AfterEach
    void tearDown() {
        studentService = null;
        student1 = null;
    }

    @Test
    void test_findById_WhenId1_ReturnStudentWithId1() {
        // GIVEN
        String studentId = student1.id();

        // WHEN
        Student actual = studentService.findById(studentId);

        // THEN
        Student expected = student1;
        assertEquals(expected, actual);
    }

    @Test
    void test_findById_WhenId5_ThrowNoSuchStudentException() {
        // GIVEN
        String studentId = "abc";

        assertThrows(NoSuchStudentException.class, () -> studentService.findById(studentId));
    }
}
