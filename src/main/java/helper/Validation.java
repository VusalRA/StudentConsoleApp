package helper;

public class Validation {

    public static boolean nameValidation(String name) {

        boolean valid = name.matches("(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){3,24}$");

        return valid;
    }


    public static boolean mailValidation(String mail) {
        boolean valid = mail.matches("^(.+)@(.+)$");
        return valid;
    }

    public static boolean numberValidation(String number) {
        boolean valid = number.matches("\\d{10,12}");
        return valid;
    }

}
