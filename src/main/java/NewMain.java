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

                System.out.print("Do you want to create a form? (yes/no): ");
                String response = input.nextLine().trim().toLowerCase();

                if (response.equals("yes")) {
                    System.out.print("Municipality: ");
                    String municipality = input.nextLine();

                    System.out.print("Contract: ");
                    String contract = input.nextLine();

                    System.out.print("District: ");
                    String district = input.nextLine();

                    System.out.print("Coordinates: ");
                    String coordinates = input.nextLine();

                    System.out.print("Report Date (e.g., 07/10/2024): ");
                    String reportDate = input.nextLine();

                    System.out.print("Subject: ");
                    String subject = input.nextLine();

                    ArrayList<String> notesList = new ArrayList<>();
                    while (true) {
                        System.out.print("Do you want to enter a note? (yes/no): ");
                        String choice = input.nextLine().trim().toLowerCase();

                        if (choice.equals("yes")) {
                            System.out.print("Enter note: ");
                            String note = input.nextLine();
                            notesList.add(note);
                        } else if (choice.equals("no")) {
                            break;
                        } else {
                            System.out.println("Please enter 'yes' or 'no'.");
                        }
                    }

                    String[] notes = notesList.toArray(new String[0]);

                    manager.createForm(municipality, contract, district, coordinates, reportDate, subject, notes);

                    System.out.println("\nAll Forms:");
                    FileHandler.listForms();
                } else {
                    System.out.println("Returning to main menu");
                }
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