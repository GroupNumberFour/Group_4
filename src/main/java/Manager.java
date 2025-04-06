
public class Manager {
private static int nextId = 1;

    public void createForm(String municipality, String contract, String district,
                           String coordinates, String reportDate, String subject, String[] notes) {

        Form newForm = new Form(nextId++, municipality, contract, district,
                                coordinates, reportDate, subject, notes);

        FileHandler.save(newForm);
        System.out.println("Form Created Successfully!");
    }
}
