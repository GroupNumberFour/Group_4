
public class Manager {
private static int nextId = 1;



    public void createForm() {
        Form newForm = new Form(
            nextId++, "", "", "", "", "", "", new String[0]  
        );

        FileHandler.save(newForm);
        System.out.println("Form Created and Saved Successfully");
    }


}
