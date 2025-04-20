package project251;


import java.util.Scanner;

 public class Form {
    private int id;
    private String municipality;     
    private String contract;       
    private String district;       
    private String coordinates;      
    private String reportDate;       
    private String subject;         

    private String notes;      
    
 
    public Form(int id, String municipality, String contract, String district,
                String coordinates, String reportDate, String subject, String notes) {
        this.id = id;
        this.municipality = municipality;
        this.contract = contract;
        this.district = district;
        this.coordinates = coordinates;
        this.reportDate = reportDate;
        this.subject = subject;
        this.notes = notes;
    }
    
    

        public int getId() { 
         return id;
     }

    
    public void displayForm() {

        System.out.println("-------------------------");
        System.out.println("------------- Jeddah Municipality Form -------------");
        System.out.println("Form ID: " + id);
        System.out.println(municipality);
        System.out.println(contract);
        System.out.println(district);
        System.out.println(coordinates);
        System.out.println(reportDate);
        System.out.println(subject);
        System.out.println(notes);
        System.out.println("----------------------------------------------------");

    }
    
    public void displaySimple(){
    System.out.println("Form ID: " + id);
    System.out.println("----------------------------------------------------");
    }
    

   
}
