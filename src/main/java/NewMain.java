import java.util.ArrayList;
import java.util.Scanner;
public class NewMain {

    public static void main(String[] args) {
        Manager manager = new Manager();
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
                manager.createForm();
                break;
               } else if (role.equals("employee")) {
                System.out.println("\nHello Employee " + name + " (ID: " + employeeId + ")");
             

            } else {
                System.out.println(" Invalid role. Please enter 'manager' or 'employee'.\n");
            }
        }

        input.close();
    }
}