package crud;

import model.Student;

import java.util.ArrayList;
import java.util.*;

public class Crud {

    public List<Student> students = new ArrayList<>();

    public boolean addStudents(Student student) {
        return students.add(student);
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {

        System.out.print("ID | NAME | SURNAME | FATHERNAME | EMAIL | PHONENUMBER");
        System.out.println();
        for (Student i : students) {
            System.out.print(i.getId()+" | ");
            System.out.print(i.getName()+" | ");
            System.out.print(i.getSurname()+" | ");
            System.out.print(i.getFathername()+" | ");
            System.out.print(i.getEmail()+" | ");
            System.out.print(i.getPhoneNumber());
            System.out.println();
        }
        return students;
    }

    public ArrayList<Student> getWithName(String name) {
        ArrayList<Student> findName = new ArrayList<>();
//        System.out.println("Enter name:");
//        System.out.println();
        for (Student student : students) {
            if (student.getName().startsWith(name)) {
                findName.add(student);
            }
            System.out.println();
        }
        return findName;
    }

}
