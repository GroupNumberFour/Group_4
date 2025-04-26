
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class FileHandler {
    private static ArrayList<Form> savedForms = new ArrayList<>();

    
    public ArrayList<Form> getSavedForms() {
    return savedForms;
}

    public static void save(Form form) {
        savedForms.add(form);
        System.out.println("Form saved successfully.");
        
    }

public static void delete(int formID) {
    if (savedForms.isEmpty()) {
        System.out.println("You do not have forms to delete, create one first.");
        return;
    }

    Form toDelete = null;
    for (Form form : savedForms) {
        if (form.getId() == formID) {
            toDelete = form;
            break;
        }
    }

    if (toDelete == null) {
        System.out.println("Invalid form number. No form exists with ID: " + formID);
        return;
    }

    savedForms.remove(toDelete);
    System.out.println("Form number: " + formID + " deleted successfully.");
    saveFormsToFile("Form.txt");
}



    
    public static void listForms() {
        
        System.out.println("--------------------Forms after deletion-------------------");
        System.out.println("-----------------------------------------------------------");
       for (Form form : savedForms)  {// display list after deletion 
            form.displaySimple();
        
        }

              
    }
     public static void fillForm() {
       Scanner scanner = new Scanner(System.in);

    System.out.println("===== Fill New Form =====");
    
    
   // enter the ID 
    System.out.print("Enter form ID (number): ");
    int id = Integer.parseInt(scanner.nextLine());
    
   // enter the municipality
    System.out.print("Enter municipality: ");
    String municipality = scanner.next();
   
    //enter the contract
    System.out.print("Enter contract: ");
    String contract = scanner.next();
    
    // enter the district
    System.out.print("Enter district: ");
    String district = scanner.next();
    
    
    // enter the coordinates
    System.out.print("Enter coordinates: ");
    String coordinates = scanner.next();
    
    
    // enter the reportDate

    System.out.print("Enter report date (e.g., 2025-04-18): ");
    String reportDate = scanner.next();

    
    // enter the subject
    System.out.print("Enter subject: ");
    String subject = scanner.next();
    
    

    // enter the notes
    System.out.print("Enter notes: ");
    String notes = scanner.next();
    

    // create a new form object and save it
    Form form = new Form(id, municipality, contract, district, coordinates, reportDate, subject, notes);
    save(form);
          saveFormsToFile("Form.txt");  
    }

    
     
     // for update 
    public Form selectForm(int formId) { // select form
        for (Form f : savedForms) {
            if (f.getId() == formId) {
                return f;
            }
        }
        return null;
    }


 public boolean replaceInfo(Form updatedForm) {
    for (int i = 0; i < savedForms.size(); i++) {
        if (savedForms.get(i).getId() == updatedForm.getId()) {
            savedForms.set(i, updatedForm); // استبدل النموذج القديم بالمعدل
            return true;
        }
    }
    return false; // إذا ما لقيناه
}
  
    public static void saveFormsToFile(String filename) {
    try (PrintWriter writer = new PrintWriter(filename)) {
        for (Form f : savedForms) {
            writer.println("Form ID: " + f.getId());
            writer.println("Municipality: " + f.municipality);
            writer.println("Contract: " + f.contract);
            writer.println("District: " + f.district);
            writer.println("Coordinates: " + f.coordinates);
            writer.println("Report Date: " + f.reportDate);
            writer.println("Subject: " + f.subject);
            writer.println("Notes: " + f.notes);
            writer.println("--------------------------------------------------");
        }
        System.out.println(" Forms saved to " + filename);
    } catch (IOException e) {
        System.out.println(" Error saving forms: " + e.getMessage());
    }
}
    
    

public static void loadFormsFromFile(String filename) {
    savedForms.clear(); // Clear old data first
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        int id = 0;
        String municipality = "", contract = "", district = "", coordinates = "", reportDate = "", subject = "", notes = "";
        
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Form ID:")) {
                id = Integer.parseInt(line.substring(8).trim());
            } else if (line.startsWith("Municipality:")) {
                municipality = line.substring(13).trim();
            } else if (line.startsWith("Contract:")) {
                contract = line.substring(9).trim();
            } else if (line.startsWith("District:")) {
                district = line.substring(9).trim();
            } else if (line.startsWith("Coordinates:")) {
                coordinates = line.substring(12).trim();
            } else if (line.startsWith("Report Date:")) {
                reportDate = line.substring(12).trim();
            } else if (line.startsWith("Subject:")) {
                subject = line.substring(8).trim();
            } else if (line.startsWith("Notes:")) {
                notes = line.substring(6).trim();
            } else if (line.startsWith("--------------------------------------------------")) {
                Form form = new Form(id, municipality, contract, district, coordinates, reportDate, subject, notes);
                savedForms.add(form);
            }
        }
        System.out.println("Forms loaded successfully from file.");
    } catch (Exception e) {
        System.out.println("Error loading forms: " + e.getMessage());
    }
}


}