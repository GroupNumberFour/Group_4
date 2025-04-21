package project251;

import java.util.ArrayList;
import java.util.Scanner;

public class NewMain {

    public static void main(String[] args) {
        Manager manager = new Manager();
        FileHandler file = new FileHandler();
        Scanner input = new Scanner(System.in);


        System.out.println("=================================");
        System.out.println("  Welcome to Report Assistant");
        System.out.println("=================================");

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your employee ID: ");
        String employeeId = input.nextLine();


        String role = "";
        while (true) {
            
            

            System.out.print("Enter your role (manager(m)/employee(e)): ");
            role = input.nextLine().trim().toLowerCase();

            if (role.equals("manager") || role.equals("m")) {
                System.out.println("\nHello Manager " + name + " (ID: " + employeeId + ")");
                boolean status = true;
                
                
                while (status) {
                    
                    ManagerMenueDisplay();// method to display the manager menue 
                    int ManagerMenueSelection = input.nextInt();// store the manager selection 
                    
                    if (ManagerMenueSelection == 1) {// create form 
                        manager.createForm();
                        
                    } else if (ManagerMenueSelection == 2) {// delete form 
                        System.out.println("please enter form id you want to delete :");
                        int formID = input.nextInt();
                        file.delete(formID);
                    }
                     else if (ManagerMenueSelection == 3) {// generate excel 
                    } else if (ManagerMenueSelection == 4) {// exit 
                        status = false;
                    }
                }//end while 2 
                
                
                
                

               } else if (role.equals("employee") || role.equals("e")) {
                System.out.println("\nHello Employee " + name + " (ID: " + employeeId + ")");
             //1. fill 
             while(true){
              EmployeeMenueDisplay(); // method to display the employee menue
              int EmployeeMenueChoice = input.nextInt(); //store the employee choice
              if (EmployeeMenueChoice == 1)
                  file.fillForm();
              
              
              // 2. update form
               else if (EmployeeMenueChoice == 2){
                  updateForm(file, name, employeeId); 
               }
               
              else if (EmployeeMenueChoice == 3){
                  System.out.println("Exiting program...");
                  break;
                
              } else 
                System.out.println("Invalid choice. Try again.");
    
             }
            
           

            } else {
                System.out.println(" Invalid role. Please enter 'manager' or 'employee'.\n");
            }

             input.close();
        }//end while 1
        
       


      
    
}//end main 
   
      public static void ManagerMenueDisplay(){
        System.out.println("please choose a number from the menue: ");
        System.out.println("1. create a new form ");
        System.out.println("2. delete a specific form ");
        System.out.println("3. generate Excel report ");
        System.out.println("4. Logout");
        System.out.println("your selection: ");
    
    }
      
      
      
      public static void EmployeeMenueDisplay(){
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. Fill a new form");
            System.out.println("2. update a specific form ");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
      }

      

// Method to update the form
     private static void updateForm(FileHandler file, String name, String employeeId) {
         
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the form ID you want to update: ");
    int formId = input.nextInt();
    input.nextLine(); // Consume newline character left by nextInt()

    
     Form form = file.selectForm(formId);
        if (form == null) {
        // If the form doesn't exist, print the message and return
        System.out.println("Form does not exist.");
        return;  // Exit the method if the form doesn't exist
    }
        
        
    // Request user input for each field. User can leave fields empty to skip them.
    System.out.print("Enter new municipality (Press Enter to keep no change): ");
    String municipality = input.nextLine().trim();

    System.out.print("Enter new contract (Press Enter to keep no change): ");
    String contract = input.nextLine().trim();

    System.out.print("Enter new district (Press Enter to keep no change): ");
    String district = input.nextLine().trim();

    System.out.print("Enter new coordinates (Press Enter to keep no change): ");
    String coordinates = input.nextLine().trim();

    System.out.print("Enter new report date (Press Enter to keep no change): ");
    String reportDate = input.nextLine().trim();

    System.out.print("Enter new subject (Press Enter to keep no change): ");
    String subject = input.nextLine().trim();

    System.out.print("Enter new notes (Press Enter to keep no change): ");
    String notes = input.nextLine().trim();

    // Update the form using the employee's method
    Employee employee = new Employee(employeeId, name); // Use dynamic employee details
    employee.updateForm(file, formId, 
                        municipality.isEmpty() ? null : municipality,
                        contract.isEmpty() ? null : contract,
                        district.isEmpty() ? null : district,
                        coordinates.isEmpty() ? null : coordinates,
                        reportDate.isEmpty() ? null : reportDate,
                        subject.isEmpty() ? null : subject,
                        notes.isEmpty() ? null : notes);

       }
     
}