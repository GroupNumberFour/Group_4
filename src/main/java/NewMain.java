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
            
            

            System.out.print("Enter your role (manager/employee): ");
            role = input.nextLine().trim().toLowerCase();

            if (role.equals("manager")) {
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
                    } else if (ManagerMenueSelection == 3) {// generate excel 
                    } else if (ManagerMenueSelection == 4) {// exit 
                        status = false;
                    }
                }//end while 2 
                
                
                
                
                

               } else if (role.equals("employee")) {
                System.out.println("\nHello Employee " + name + " (ID: " + employeeId + ")");
             //1. fill 
             while(true){
              EmployeeMenueDisplay(); // method to display the employee menue
              int EmployeeMenueChoice = input.nextInt(); //store the employee choice
              if (EmployeeMenueChoice == 1)
                  file.fillForm();
              else if (EmployeeMenueChoice == 2){
                  System.out.println("Exiting program...");
                break;
              } else 
                System.out.println("Invalid choice. Try again.");
    
             }
            
             //2. update 

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
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
      }
  
}