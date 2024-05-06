import static org.junit.jupiter.api.Assertions.*;

import exceptions.NoSuchStudentException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentServiceTest {

    StudentService studentService = null;
    Student student1 = null;
    Student student2 = null;
    Student student3 = null;
    Student student4 = null;

    @BeforeEach
    void SetUp() {
        studentService = new StudentService();

        student1 = studentService.addNewStudent(new Student("0", "Aljoscha", "Java"));
        student2 = studentService.addNewStudent(new Student("0", "Gökhan", "Java"));
        student3 = studentService.addNewStudent(new Student("0", "Jonas", "Java"));
        student4 = studentService.addNewStudent(new Student("0", "Daniel", "Java"));
    }

    @AfterEach
    void tearDown() {
        studentService = null;
        student1 = null;
    }

    @Test
    void test_findById_WhenStudent1Id_ReturnStudent1() {
        // GIVEN
        String student1Id = student1.id();

        // WHEN
        Student actual = studentService.findById(student1Id);

        // THEN
        Student expected = student1;
        assertEquals(expected, actual);
    }

    @Test
    void test_findById_WhenId5_ThrowNoSuchStudentException() {
        // GIVEN
        String studentId = "abc";

        NoSuchStudentException exception = assertThrows(NoSuchStudentException.class, () -> studentService.findById(studentId));

        assertEquals("Student with id abc could not be found.", exception.getMessage());
    }
}
