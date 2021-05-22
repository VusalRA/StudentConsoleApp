package helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import crud.Crud;
import model.Student;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class ReadJson {
    private Crud crud;

    public ReadJson(Crud crud) {
        this.crud = crud;
    }

    public boolean addJsonDataToArrayList() {
        ReadJson readJson = null;
        try {
            readJson = new ReadJson(crud);
            readJson.readJson();
            return true;
        } catch (Exception e) {
            System.out.println("Can't read file: " + e.getMessage());
            return false;
        }
    }

    public void readJson() throws Exception {

        String file = null;
        file = "students.json";
        String json = readFileAsString(file);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Student> students = objectMapper.readValue(json, new TypeReference<List<Student>>() {
        });
        crud.students = students;
    }


    public static String readFileAsString(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

}
