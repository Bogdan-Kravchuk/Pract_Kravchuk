package Pacts.Pract8_Kravchuk;

import java.util.*;

public class StudentRegistry {
    private static List<Student> addStudentList = new ArrayList<>();
    private static Set<String> emailSet = new HashSet<>();
    private static Map<String, Student> findByID = new LinkedHashMap<>();

    public static Map<String, Student> getFindByID() {
        return Collections.unmodifiableMap(findByID);
    }

    public static Set<String> getEmailSet() {
        return Collections.unmodifiableSet(emailSet);
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

