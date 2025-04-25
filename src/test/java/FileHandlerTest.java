/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {

    // Test for saving the form and verifying the data after saving
    @Test
    public void testSave() {
        Form form = new Form(1, "Jeddah", "Contract1", "District1", "Coords1", "2025-04-18", "Subject1", "Note1");
        FileHandler.save(form);

        // Verify that the first form is saved and the data is the same
        Form retrieved = new FileHandler().selectForm(1);
        assertNotNull(retrieved); // Ensure that the form is saved
        assertEquals("Subject1", retrieved.getSubject()); // Verify the subject is correct
    }

//     Test for deleting a form and ensuring it has been deleted
    @Test
    public void testDelete() {
        Form form = new Form(2, "Jeddah", "Contract2", "District2", "Coords2", "2025-04-19", "Subject2", "Note2");
        FileHandler.save(form);

        // Ensure the form is saved first
        Form retrievedBeforeDelete = new FileHandler().selectForm(2);
        assertNotNull(retrievedBeforeDelete); // Ensure the form is saved before deletion

        // Now, delete the form
        FileHandler.delete(2);

        // Try to retrieve the form again after deletion
        Form retrievedAfterDelete = new FileHandler().selectForm(2);
        assertNull(retrievedAfterDelete); // It should be null because it was deleted
    }

    // Test for updating the form's data and verifying the update
    @Test
    public void testReplaceInfo() {
        Form form = new Form(3, "Jeddah", "Contract3", "District3", "Coords3", "2025-04-20", "OldSubject", "OldNote");
        FileHandler.save(form);

        // Create a new form with the same ID but updated data
        Form updated = new Form(3, "Jeddah", "Contract3", "District3", "Coords3", "2025-04-20", "NewSubject", "NewNote");

        boolean result = new FileHandler().replaceInfo(updated);
        assertTrue(result); // Ensure that the update was successful

        // Verify the data after the update
        Form retrieved = new FileHandler().selectForm(3);
        assertEquals("NewSubject", retrieved.getSubject()); // Verify the new subject
        assertEquals("NewNote", retrieved.getNotes()); // Verify the new notes
    }

    // Test for the case where a form is not found
    @Test
    public void testSelectForm_NotFound() {
        Form result = new FileHandler().selectForm(999); // Non-existent ID
        assertNull(result); // It should be null because the form does not exist
    }

//    // Test for saving the forms to a file and ensuring no errors occur
    @Test
    public void testSaveFormsToFile() {
        // Ensure that no exception is thrown while saving
        assertDoesNotThrow(() -> FileHandler.saveFormsToFile("test_output.txt"));
    }
}
