

import java.util.Scanner;

 public class Form {
    int id;
    String municipality;     
    String contract;       
    String district;       
    String coordinates;      
    String reportDate;       
    String subject;         

    String notes;      
    
 
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
        public String getMunicipality() {
    return municipality;
}

public String getContract() {
    return contract;
}

public String getDistrict() {
    return district;
}

public String getCoordinates() {
    return coordinates;
}

public String getReportDate() {
    return reportDate;
}

public String getSubject() {
    return subject;
}

public String getNotes() {
    return notes;
}
    // update content
    public void updateInfo(String municipality, String contract, String district,
                       String coordinates, String reportDate, String subject, String notes) {
    if (municipality != null) 
        this.municipality = municipality;
    
    if (contract != null) 
        this.contract = contract;
    
    if (district != null) 
        this.district = district;
    
    if (coordinates != null) 
        this.coordinates = coordinates;
    
    if (reportDate != null)
        this.reportDate = reportDate;
    
    if (subject != null) 
        this.subject = subject;
    
    if (notes != null) 
        this.notes = notes;
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
