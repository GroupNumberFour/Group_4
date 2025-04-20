package project251;

public class Manager {
private static int nextId = 1;



    public void createForm() {


        Form newForm = new Form(nextId++,"Municipality:","Contract:","District:","Coordinates:","Report Date:","Subject:","Notes:");
        FileHandler.save(newForm);
        
        System.out.println("----------------------------------------------------");
        System.out.println("--------Form Created and Saved Successfully--------");
        System.out.println("----------------------------------------------------");
        newForm.displayForm();

    }


}