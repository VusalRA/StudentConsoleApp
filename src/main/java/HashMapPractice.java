import crud.Crud;
import model.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapPractice {
    private Crud crud;

    public HashMapPractice(Crud crud) {
        this.crud = crud;
    }

    public void mapPractice() {

        List<Student> students = crud.students;

        int id = 297599;


//        for (Student student : students.stream().filter(v -> v.getId() == id).collect(Collectors.toList())) {
//            System.out.println(student.getName());
//        }

        Map<Integer, Student> mapOfVinToListing = students.stream().collect(Collectors.toMap(Student::getId, student -> student)); // Assuming vin is unique per listing
        // O(1)
        System.out.println(mapOfVinToListing.get(297603));
//        System.out.println(mapOfVinToListing.get(297599));

//        HashMap<String, Student> hashMap = new HashMap<>();
//        hashMap.put(students.get(1).getName(), students.get(1));
//        hashMap.put(students.get(2).getName(), students.get(2));
//        hashMap.put(students.get(3).getName(), students.get(3));
//
////        System.out.println(hashMap.get("Vusal".startsWith("V")));
//        hashMap.forEach((k, v) -> {
//            if (k.startsWith("V")) {
//                System.out.format(v.getFathername());
//            }
//        });
//        System.out.println(students.size());

    }

}
