package helper;

import model.Student;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchStudent {
    private List<Student> students;
    private Scanner scanner;

    public SearchStudent(List<Student> students, Scanner scanner) {
        this.students = students;
        this.scanner = scanner;
    }

    public void findWithName() {
        System.out.println("Enter Name: ");
        String name = scanner.next();
        Stream<Map.Entry<String, Student>> search = getStudentsWithName().entrySet().stream().filter(w -> w.getKey().toLowerCase().startsWith(name.toLowerCase()));
        getStudent(search);
    }

    public void findWithSurname() {
        System.out.println("Enter Surname: ");
        String surname = scanner.next();
        Stream<Map.Entry<String, Student>> search = getStudentsWithSurname().entrySet().stream().filter(w -> w.getKey().toLowerCase().startsWith(surname.toLowerCase()));
        getStudent(search);
    }

    public void findWithFatherName() {
        System.out.println("Enter FatherName: ");
        String fatherName = scanner.next();
        Stream<Map.Entry<String, Student>> search = getStudentsFatherName().entrySet().stream().filter(w -> w.getKey().toLowerCase().startsWith(fatherName.toLowerCase()));
        getStudent(search);
    }


    public Map<String, Student> getStudentsWithName() {
        Map<String, Student> studentsWithName = students.stream()
                .collect(Collectors.toMap
                        (student -> student.getName() + student.getId()
                                , student -> student));
        return studentsWithName;
    }

    public Map<String, Student> getStudentsWithSurname() {
        Map<String, Student> studentsWithName = students.stream()
                .collect(Collectors.toMap
                        (student -> student.getSurname() + student.getId()
                                , student -> student));
        return studentsWithName;

    }



    public Map<String, Student> getStudentsFatherName() {
        Map<String, Student> studentsWithName = students.stream()
                .collect(Collectors.toMap
                        (student -> student.getFathername() + student.getId()
                                , student -> student));
        return studentsWithName;
    }

    public void getStudent(Stream<Map.Entry<String, Student>> search) {
        System.out.println("ID | NAME | SURNAME | FATHERNAME | EMAIL | PHONENUMBER");

        for (Map.Entry<String, Student> ss : search.collect(Collectors.toList())) {
            System.out.print(ss.getValue().getId() + " | ");
            System.out.print(ss.getValue().getName() + " | ");
            System.out.print(ss.getValue().getSurname() + " | ");
            System.out.print(ss.getValue().getFathername() + " | ");
            System.out.print(ss.getValue().getEmail() + " | ");
            System.out.println(ss.getValue().getPhoneNumber());

            System.out.println("--------------------------------------------------------------");
        }
    }
}
