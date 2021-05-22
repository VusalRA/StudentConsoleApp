package console;

import crud.Crud;
import helper.RandomNumberGenerator;
import helper.SearchStudent;
import helper.json.UpdateJson;
import helper.Validation;
import model.Student;

import java.io.IOException;
import java.util.Scanner;

public class CrudConsole {
    private UpdateJson updateJson;

    private Crud crud;

    public CrudConsole(UpdateJson updateJson, Crud crud) {
        this.updateJson = updateJson;
        this.crud = crud;
    }

    Scanner scanner = new Scanner(System.in);


    public void consoleMenu() {
        System.out.println("Choose a menu option: ");
        System.out.println("1: CRUD Menu");
        System.out.println("2: Search Menu");


        int menu = scanner.nextInt();

        switch (menu) {
            case 1:
                crudMainConsole();
                break;
            case 2:
                searchMenu();
                break;
        }

    }

    public void crudMainConsole() {

        System.out.println("1: Add Students");
        System.out.println("2: Delete Students");
        System.out.println("3: Update Students");
        System.out.println("4: List Students");
        int menu = scanner.nextInt();

        switch (menu) {
            case 1:
                aCrud();
                consoleMenu();
                break;
            case 2:
                dCrud();
                consoleMenu();
                break;
            case 3:
                uCrud();
                consoleMenu();
                break;
            case 4:
                rCrud();
                consoleMenu();
                break;
        }

    }

    public void aCrud() {
        Student student = new Student();
        student.setId(RandomNumberGenerator.getRandomNumber(100000, 999999));
        System.out.println("Enter Name: ");

        String name = scanner.next();
        while (!Validation.nameValidation(name)) {
            System.out.println("Incorrect name: ");
            System.out.println("Example: Vusal");
            name = scanner.next();
        }
        student.setName(name);

        System.out.println("Enter Surname: ");
        String surname = scanner.next();
        while (!Validation.nameValidation(surname)) {
            System.out.println("Incorrect name: ");
            System.out.println("Example: Vusal");
            surname = scanner.next();
        }
        student.setSurname(surname);

        System.out.println("Enter FatherName: ");
        String fatherName = scanner.next();
        while (!Validation.nameValidation(fatherName)) {
            System.out.println("Incorrect name: ");
            System.out.println("Example: Vusal");
            fatherName = scanner.next();
        }
        student.setFathername(fatherName);

        System.out.println("Enter Email: ");
        String mail = scanner.next();
        while (!Validation.mailValidation(mail)) {
            System.out.println("Incorrect mail: ");
            System.out.println("Example: vusalra@gmail.com");
            mail = scanner.next();
        }
        student.setEmail(mail);

        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.next();
        while (!Validation.numberValidation(phoneNumber)) {
            System.out.println("Incorrect phone: ");
            System.out.println("Example: 994776090606");
            phoneNumber = scanner.next();
        }
        student.setPhoneNumber(phoneNumber);

        crud.addStudents(student);

        try {
            updateJson.updateJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Student added to JSON");
    }

    public void dCrud() {
        crud.getStudents();
        int id = scanner.nextInt();

        for (int i = 0; i < crud.students.size(); i++) {
            if (crud.students.get(i).getId() == id) {
                crud.deleteStudent(crud.students.get(i));
                System.out.println("Student Deleted.");
                try {
                    updateJson.updateJson();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }

    public void uCrud() {
        crud.getStudents();
        System.out.println("Enter ID for Update: ");
        int id = scanner.nextInt();
        for (Student student : crud.students) {
            if (student.getId() == id) {
                System.out.println("Do you want to change name? 1 yes| 2 no");
                if (isChange()) {
                    System.out.println("Enter Student Name: ");
                    student.setName(scanner.next());
                }
                System.out.println("Do you want to change surname? 1 yes| 2 no");
                if (isChange()) {
                    System.out.println("Enter Student Surname: ");
                    student.setSurname(scanner.next());
                }
                System.out.println("Do you want to change FatherName? 1 yes| 2 no");
                if (isChange()) {
                    System.out.println("Enter Student FatherName: ");
                    student.setFathername(scanner.next());
                }
                System.out.println("Do you want to change Email? 1 yes| 2 no");
                if (isChange()) {
                    System.out.println("Enter Student Email: ");
                    student.setEmail(scanner.next());
                }
                System.out.println("Do you want to change PhoneNumber? 1 yes| 2 no");
                if (isChange()) {
                    System.out.println("Enter Student PhoneNumber");
                    student.setPhoneNumber(scanner.next());
                }
            }

        }

        try {
            updateJson.updateJson();
            System.out.println("Student updated on JSON");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void rCrud() {
        crud.getStudents();
    }

    public boolean isChange() {
        int entered = scanner.nextInt();
        if (entered == 1) {
            return true;
        } else if (entered == 2) {
            System.out.println("No");
            return false;
        } else {
            System.out.println("Enter correct option");
            isChange();
        }
        return false;
    }

    public void searchMenu() {
        SearchStudent student = new SearchStudent(crud.students, scanner);
        System.out.println("1: Search with Name: | 2: Search with Surname | 3: Search with FatherName");
        int menu = scanner.nextInt();

        switch (menu) {
            case 1:
                student.findWithName();
                break;
            case 2:
                student.findWithSurname();
                break;
            case 3:
                student.findWithFatherName();
                break;
            default:
                System.out.println("Enter Correct");
                break;
        }

    }


}
