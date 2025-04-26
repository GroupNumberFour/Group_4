
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;



public class Manager {
private static int nextId = 1;



    public void createForm() {
        
        Form newForm = new Form(nextId++, "Municipality:", "Contract:", "District:", "Coordinates:", "Report Date:", "Subject:", "Notes:");

        // Save to separate file instead of shared forms list
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("template_forms.txt", true))) {
            
            writer.println("Form ID: " + newForm.getId());
            writer.println("Municipality: " + newForm.municipality);
            writer.println("Contract: " + newForm.contract);
            writer.println("District: " + newForm.district);
            writer.println("Coordinates: " + newForm.coordinates);
            writer.println("Report Date: " + newForm.reportDate);
            writer.println("Subject: " + newForm.subject);
            writer.println("Notes: " + newForm.notes);
            writer.println("--------------------------------------------------");
        } catch (IOException e) {
            System.out.println("Error saving template: " + e.getMessage());
        }

        FileHandler.save(newForm);
        // Continue with normal display
        System.out.println("----------------------------------------------------");
        System.out.println("--------Form Created and Saved Successfully--------");
        System.out.println("----------------------------------------------------");
        newForm.displayForm();

        
        
    }
}