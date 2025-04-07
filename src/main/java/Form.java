
  public class Form {
    private int id;
    private String municipality;     
    private String contract;       
    private String district;       
    private String coordinates;      
    private String reportDate;       
    private String subject;         
    private String[] notes;         

    public Form(int id, String municipality, String contract, String district,
                String coordinates, String reportDate, String subject, String[] notes) {
        this.id = id;
        this.municipality = municipality;
        this.contract = contract;
        this.district = district;
        this.coordinates = coordinates;
        this.reportDate = reportDate;
        this.subject = subject;
        this.notes = notes;
    }

    public void displayForm() {
        System.out.println("Form ID: " + id);
        System.out.println("Municipality: " + municipality);
        System.out.println("Contract: " + contract);
        System.out.println("District: " + district);
        System.out.println("Coordinates: " + coordinates);
        System.out.println("Report Date: " + reportDate);
        System.out.println("Subject: " + subject);
        System.out.println("Notes:");
        for (String note : notes) {
            System.out.println("- " + note);
        }
        System.out.println("-------------------------");
    }

   
}

