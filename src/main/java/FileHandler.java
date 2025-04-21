package project251;

import java.util.ArrayList;
import java.util.Scanner;


public class FileHandler {
    private static ArrayList<Form> savedForms = new ArrayList<>();

    
    public static void save(Form form) {
        savedForms.add(form);
        System.out.println("Form saved successfully.");
        
    }

  public static void delete(int formID) {
        
    formID--;
    if (savedForms.get(formID) == null) { 
        System.out.println("Form alreeady deleted.");
        
    }

    if (savedForms.isEmpty()) {
        System.out.println("You do not have forms to delete, create one first.");
        
    }

    if (formID <= 0) {
        System.out.println("Invalid form number. Form ID must be greater than 0.");
        
    }

    if (formID > savedForms.size()) {
        System.out.println("Invalid form number. No form exists with ID: " + formID);
        
    }

    else{
    savedForms.remove(formID);
    System.out.println("Form number: " + formID + " deleted successfully.");
}
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
                savedForms.set(i, updatedForm);
                return true;
            }
        }
        return false;
    }
    
    
}