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
                    
                    if (ManagerMenueSelection == 1) {// 1. create form 
                        manager.createForm();
                    //-------------------------------------------------------------------------------------------------------
                    } else if (ManagerMenueSelection == 2) {// 2.delete form 
                        System.out.print("please enter the form id you want to delete: ");
                        
                        int formID = input.nextInt();// store the form id to delete 
                        file.delete(formID);// call the delete method 
                        file.listForms();// call display form method after deletion 
                    //--------------------------------------------------------------------------------------------------------
                    } else if (ManagerMenueSelection == 3) {// 3. generate excel 
                    } else if (ManagerMenueSelection == 4) {// 4. generate ppt 
                    } else if (ManagerMenueSelection == 5) {// 5. exit 
                        status = false;
                    }
                }//end while 2 
                break;
                
                
                
                
               } else if (role.equals("employee")) {
                System.out.println("\nHello Employee " + name + " (ID: " + employeeId + ")");
             

            } else {
                System.out.println(" Invalid role. Please enter 'manager' or 'employee'.\n");
                //fill report
                //ubdate 
            }
            
         
        
        }//end while 1 

        
        input.close();
      
    }

   
      public static void ManagerMenueDisplay(){
        System.out.println("please choose a number from the menue: ");
        System.out.println("1. create a new form ");
        System.out.println("2. delete a specific form ");
        System.out.println("3. generate Excel report ");
        System.out.println("4. generate PowerPoint report ");
        System.out.println("5. Logout");
        System.out.println("your selection: ");
    
    }
  
}