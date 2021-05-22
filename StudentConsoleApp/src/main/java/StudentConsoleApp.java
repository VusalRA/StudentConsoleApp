import console.CrudConsole;
import crud.Crud;
import helper.json.ReadJson;
import helper.json.UpdateJson;

public class StudentConsoleApp {

    public static void main(String[] args) throws Exception {

        Crud crud = new Crud();
        ReadJson readJson = new ReadJson(crud);
        readJson.addJsonDataToArrayList();

        UpdateJson updateJson = new UpdateJson(crud);
        CrudConsole console = new CrudConsole(updateJson, crud);
        console.consoleMenu();


    }

}
