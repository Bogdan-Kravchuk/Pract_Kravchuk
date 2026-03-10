import Pract8_Kravchuk.Student;
import Pract8_Kravchuk.StudentRegistry;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static Pract8_Kravchuk.StudentRegistry.*;

public class TestStudent {


    @BeforeAll
    public static void preparing(){
        clearStudents();

        Student student1 =new Student("A", "12345", "A@email.com");
        Student student2 =new Student("B", "1234567890", "B@email.com");
        Student student3 =new Student("C", "123", "C@email.com");

        addStudent(student1);
        addStudent(student2);
        addStudent(student3);

    }

    @ParameterizedTest
    @CsvSource({
            "123",
            "12345",
            "1234567890",
            "1",
            "2",
            "3"
    })
    public void removeStudent(String id) {
        StudentRegistry.removeById(id);

    }

    @ParameterizedTest
    @CsvSource({
            "123",
            "12345",
            "1234567890"
    })

    public void checkRemoveEmail(String id) {
        Student s;
           s = getFindByID().get(id);
           try {
              if (s==null){
                  throw new NullPointerException();
              }
           }catch (NullPointerException e){
               System.out.println("Email not found");
           }
    }

    @Test
    public void checkNewStudent() {
    Student student = new Student("A", "12345", "A@");
    addStudent(student);
    student =  getFindByID().get(student.id());
        System.out.println("New student ");
        System.out.println(containsEmail(student.email()));
}}
