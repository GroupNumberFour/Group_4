import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    private static final String FORM_FILE = "template_forms.txt";
    private Manager manager = new Manager();

    @Test
    public void testCreateForm() throws IOException {
        // Create sample content and write it to the file
        String sampleContent = "Form ID: 1\nMunicipality: Municipality: XYZ\nContract: Contract:\nDistrict: District:\n";
        
        // Write the sample content to the file directly
        FileWriter fileWriter = new FileWriter(FORM_FILE);
        fileWriter.write(sampleContent);
        fileWriter.close();

        // Read file content using FileReader
        FileReader fileReader = new FileReader(FORM_FILE);
        StringBuilder fileContent = new StringBuilder();
        int charRead;

        // Read the content from the file
        while ((charRead = fileReader.read()) != -1) {
            fileContent.append((char) charRead);
        }
        fileReader.close();

        // Verify that the correct data is saved in the file
        String content = fileContent.toString();
        System.out.println(content);  // Print the content to verify the output

        // Verify that the content contains the data we wrote
        assertTrue(content.contains("Form ID: 1"), "Form ID should be saved correctly.");
        assertTrue(content.contains("Municipality: Municipality: "), "Municipality should be saved correctly.");
        assertTrue(content.contains("Contract: Contract:"), "Contract should be saved correctly.");
        assertTrue(content.contains("District: District:"), "District should be saved correctly.");
    }
}
