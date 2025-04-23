
public class Employee {

    private String empId;
    private String name;


    Employee(String empId, String name) {

        this.empId = empId;
        this.name = name;
    }
    
    
    
    
    public void updateForm(FileHandler fileHandler, int formId, String municipality, String contract, String district,
                       String coordinates, String reportDate, String subject, String notes) {

    // Try to select the form using the given formId
    Form form = fileHandler.selectForm(formId);
    
    // Check if the form exists in the saved forms list
    if (form != null) {
        // If the form exists, update its information
        form.updateInfo(municipality, contract, district, coordinates, reportDate, subject, notes);
        
        // Attempt to replace the old form with the updated form in the saved forms list
        boolean success = fileHandler.replaceInfo(form);
        if (success) {
            System.out.println("\n ...............Success Update..................");  // Success message
            FileHandler.saveFormsToFile("Form.txt");  
        } else {
            System.out.println("\n ........................Replace failed......................");  // Error message if replacement fails
        }
    } else {
        // If the form doesn't exist, print a message indicating it
        System.out.println("\n.........................Not Valid Update.........................");
    }
}

}
