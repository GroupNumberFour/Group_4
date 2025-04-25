import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    private Employee employee;
    private FileHandler fileHandler;
    private Form testForm;

    @BeforeEach
    public void setUp() {
        // Create a test form and file handler before each test
        fileHandler = new FileHandler();
        testForm = new Form(1, "Old Municipality", "Old Contract", "Old District", 
                            "Old Coordinates", "2025-04-25", "Old Subject", "Old Notes");
        fileHandler.save(testForm);
        employee = new Employee("E123", "John Doe");
    }

    @Test
    public void testUpdateForm() {
        // Update the form with new details
        employee.updateForm(fileHandler, 1, "New Municipality", "New Contract", "New District", 
                            "New Coordinates", "2025-05-01", "New Subject", "New Notes");

        // Fetch the updated form
        Form updatedForm = fileHandler.selectForm(1);

        // Check if the form's fields have been updated correctly
        assertNotNull(updatedForm, "Form should not be null.");
        assertEquals("New Municipality", updatedForm.municipality);
        assertEquals("New Contract", updatedForm.contract);
        assertEquals("New District", updatedForm.district);
        assertEquals("New Coordinates", updatedForm.coordinates);
        assertEquals("2025-05-01", updatedForm.reportDate);
        assertEquals("New Subject", updatedForm.subject);
        assertEquals("New Notes", updatedForm.notes);
    }

    @Test
    public void testUpdateForm_InvalidFormId() {
        // Try to update a form with an invalid ID
        employee.updateForm(fileHandler, 99, "Invalid Municipality", "Invalid Contract", 
                            "Invalid District", "Invalid Coordinates", "2025-06-01", 
                            "Invalid Subject", "Invalid Notes");

        // Ensure that the form was not updated and still contains the original values
        Form updatedForm = fileHandler.selectForm(99);
        assertNull(updatedForm, "Form with ID 99 should not exist.");
    }
}
