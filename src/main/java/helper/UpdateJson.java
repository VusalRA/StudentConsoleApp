package helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import crud.Crud;
import java.io.*;

public class UpdateJson {
    private Crud crud;

    public UpdateJson(Crud crud) {
        this.crud = crud;
    }

    public void updateJson() throws IOException {
                ObjectMapper mapper = new ObjectMapper();
                String jsonString = mapper.writeValueAsString(crud.students);
                try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("students.json"), "utf-8"))) {
                    writer.write(jsonString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
}

