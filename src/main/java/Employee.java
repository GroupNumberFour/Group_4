
public class Employee {

    private String empId;
    private String name;


    Employee(String empId, String name) {

        this.empId = empId;
        this.name = name;
    }
    
    
    
    
    public void updateForm(FileHandler fileHandler, int formId, String municipality, String contract, String district,
                       String coordinates, String reportDate, String subject, String notes) {

    FileHandler.loadFormsFromFile("Form.txt"); 

    Form form = fileHandler.selectForm(formId);
    if (form != null) {
        form.updateInfo(municipality, contract, district, coordinates, reportDate, subject, notes);
        
        boolean success = fileHandler.replaceInfo(form);
        if (success) {
            System.out.println("\n ...............Success Update..................");
            FileHandler.saveFormsToFile("Form.txt");  
        } else {
            System.out.println("\n ........................Replace failed......................");
        }
    } else {
        System.out.println("\n.........................Not Valid Update.........................");
    }
}


}
