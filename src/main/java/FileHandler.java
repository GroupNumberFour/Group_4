
import java.util.ArrayList;


public class FileHandler {
    private static ArrayList<Form> savedForms = new ArrayList<>();

    public static void save(Form form) {
        savedForms.add(form);
        System.out.println("Form saved successfully.");
    }

    public static void listForms() {
        for (Form form : savedForms) {
            form.displayForm();
            System.out.println("-------------------------");
        }
    }
}
