
public class Manager {
    private static int nextId = 1;

    public void createForm(String title, String content) {
        Form newForm = new Form(nextId++, title, content);
        FileHandler.save(newForm);
        System.out.println("Form Created Successfully!");
    }
}
