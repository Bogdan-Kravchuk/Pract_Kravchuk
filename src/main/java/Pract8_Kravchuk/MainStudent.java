package Pract8_Kravchuk;

import static Pract8_Kravchuk.StudentRegistry.*;

public class MainStudent {

    static void main(String[] args) {
        Student student1 = new Student("A", "123", "A@");
        Student student2 = new Student("B", "12345","B@" );
        Student student3 = new Student("C", "1234567890","C@");
        Student student4 = new Student("D", "1234567890","D@");
        Student student5 = new Student("E", "1234567890","E@");
        Student student6 = new Student("E", "1234567890","E@");
        Student student7 = new Student("E", "1234567890.","E@");

        addStudent(student1);
        addStudent(student2);
        addStudent(student3);
        addStudent(student4);
        addStudent(student5);
        addStudent(student6);
        addStudent(student7);

        //find by ID
        findById("12345");

        findById("1234567890#");

        //contains Email
        containsEmail("A@");

        containsEmail("B@.");

        System.out.println(student4.equals(student5));
        System.out.println(getEmailSet());
    }
}
