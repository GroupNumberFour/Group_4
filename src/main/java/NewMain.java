import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.SwingUtilities;

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

        // writing employee info in a file
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("employees.txt", true))) {
            writer.println("ID: " + employeeId + ", Name: " + name);
        } catch (IOException e) {
            System.out.println("Error saving employee info: " + e.getMessage());
        }

        boolean continueProgram = true;

        while (continueProgram) {
            System.out.print("Enter your role (manager(m)/employee(e)): ");
            String role = input.nextLine().trim().toLowerCase();

            if (role.equals("manager") || role.equals("m")) {
                System.out.println("\nHello Manager " + name + " (ID: " + employeeId + ")");
                boolean status = true;

                while (status) {
                    ManagerMenuDisplay();
                    int ManagerMenuSelection = input.nextInt();
                    input.nextLine(); // consume the leftover newline

                    if (ManagerMenuSelection == 1) { // create form
                        manager.createForm();
                    } else if (ManagerMenuSelection == 2) { // delete form
                        System.out.println("Please enter form ID you want to delete:");
                        int formID = input.nextInt();
                        input.nextLine();
                        file.delete(formID);
                        file.listForms();
                    } else if (ManagerMenuSelection == 3) { // open Excel form
                        System.out.println("Opening Excel form...");
                        SwingUtilities.invokeLater(() -> {
                            new ExcelTableApp();
                        });
                    } else if (ManagerMenuSelection == 4) { // logout
                        System.out.println("Logging out...");
                        status = false;
                    } else {
                        System.out.println("Invalid choice. Try again.");
                    }
                }
            } else if (role.equals("employee") || role.equals("e")) {
                System.out.println("\nHello Employee " + name + " (ID: " + employeeId + ")");
                boolean status = true;

                while (status) {
                    EmployeeMenuDisplay();
                    int EmployeeMenuChoice = input.nextInt();
                    input.nextLine(); // consume the leftover newline

                    if (EmployeeMenuChoice == 1) {
                        file.fillForm();
                    } else if (EmployeeMenuChoice == 2) {
                        updateForm(file, name, employeeId);
                    } else if (EmployeeMenuChoice == 3) { // logout
                        System.out.println("Logging out...");
                        status = false;
                    } else {
                        System.out.println("Invalid choice. Try again.");
                    }
                }
            } else {
                System.out.println("Invalid role. Please enter 'manager' or 'employee'.\n");
                continue;
            }

            // Ask if the user wants to continue
            System.out.print("Do you want to continue? (Y/N): ");
            String choice = input.nextLine().trim().toLowerCase();

            if (choice.equals("n")) {
                System.out.println("Thank you! Exiting...");
                continueProgram = false;
            } else if (!choice.equals("y")) {
                System.out.println("Invalid input. Exiting...");
                continueProgram = false;
            }
        }

        input.close();
    }

    public static void ManagerMenuDisplay() {
        System.out.println("\n===== Manager Menu =====");
        System.out.println("1. Create a new form");
        System.out.println("2. Delete a specific form");
        System.out.println("3. Generate Excel report");
        System.out.println("4. Logout");
        System.out.print("Your selection: ");
    }

    public static void EmployeeMenuDisplay() {
        System.out.println("\n===== Employee Menu =====");
        System.out.println("1. Fill a new form");
        System.out.println("2. Update a specific form");
        System.out.println("3. Logout");
        System.out.print("Enter your choice: ");
    }

    private static void updateForm(FileHandler file, String name, String employeeId) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the form ID you want to update: ");
        int formId = input.nextInt();
        input.nextLine(); // consume newline

        Form form = file.selectForm(formId);
        if (form == null) {
            System.out.println("Form does not exist.");
            return;
        }

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

        Employee employee = new Employee(employeeId, name);
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