import java.util.Scanner;
public class NewMain {

    public static void main(String[] args) {
         Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter form title: ");
        String title = scanner.nextLine();

        System.out.print("Enter form content: ");
        String content = scanner.nextLine();

        manager.createForm(title, content);

        System.out.println("\nAll Forms:");
        FileHandler.listForms();
        
    }
    
}
