package Pract8_Kravchuk;

import java.util.*;

public class StudentRegistry {
    private static List<Student> addStudentList = new ArrayList<>();
    private static Set<String> emailSet = new HashSet<>();
    private static Map<String, Student> findByID = new LinkedHashMap<>();

    public static Map<String, Student> getFindByID() {
        return Collections.unmodifiableMap(findByID);
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", "123", "A@");
        Student student2 = new Student("B", "12345","B@" );
        Student student3 = new Student("C", "1234567890","C@");


        addStudent(student1);
        addStudent(student2);
        addStudent(student3);


        findById("12345");
        containsEmail("A@");
    }

   public static void   clearStudents(){
        addStudentList.clear();
        emailSet.clear();
        findByID.clear();
   }

    public static void addStudent(Student student) {
        addStudentList.add(student);
        emailSet.add(student.email());
        findByID.put(student.id(), student);
    }

    public static boolean containsEmail(String email) {
        boolean contains = emailSet.contains(email);

        if (contains)
            System.out.println("contains email");
        else
            System.out.println("contains not email");


        return contains;
    }


    public static void findById(String id) {
        String name;
        Student studentFind = findByID.get(id);
        if (studentFind == null) {
            System.out.println("Студента з таким Student ID: " + id + " не знайдено! ");
            return;
        }

            name = "Студент: " + studentFind.name() + " | Student ID: " + studentFind.id();
            System.out.println(name);

    }

    public static void removeById(String id) {
        Student studentDelete = findByID.get(id);

        if (studentDelete == null) {
            System.out.println("Помилка: студента з ID " + id + " не знайдено!");
            return;
        }

        emailSet.remove(studentDelete.email());
        addStudentList.remove(studentDelete);
        findByID.remove(id);

        System.out.println("Студента " + studentDelete.name() + " видалено успішно!");
    }

    }

