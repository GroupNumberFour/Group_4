/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Amani
 */
public class ExcelTableAppTest {
    
   ExcelTableApp app;

    @BeforeEach
    public void setUp() {
        app = new ExcelTableApp(); // Initialize the ExcelTableApp
    }

    @Test
    public void testCreateTableWith3Rows() {
        app.rowsField.setText("3"); // Simulate user entering 3 rows
        app.createTable(); // Call method to create the table

        // Verify table is created
        assertNotNull(app.table, "Table should be created!");

        // Verify the table has 3 rows
        assertEquals(3, app.table.getRowCount(), "Table should have 3 rows!");

        // Verify the table has 26 columns (matching header count)
        assertEquals(26, app.table.getColumnCount(), "Table should have 26 columns!");
    }

    @Test
    public void testResetTable() {
        app.rowsField.setText("3");
        app.createTable(); // Create a table first

        // Verify table is created
        assertNotNull(app.table, "Table should be created!");

        // Now reset the table
        app.resetTable();

        // Verify table is reset (no parent means it has been removed)
        assertNull(app.table.getParent(), "Table should be removed from UI!");
    }

    @Test
    public void testGenerateExcel() {
        app.rowsField.setText("3");
        app.createTable(); // Create a table first

    // Test the Excel export functionality
    app.generateExcel();

    // Check if file was created successfully
    File file = new File("report_20250425.xlsx");
    assertTrue(file.exists(), "Excel file should be created!");
    }

    @Test
    public void testExcelFileContents() {
        app.rowsField.setText("3");
        app.createTable();
        app.generateExcel();

        // Verify that the content is correctly written to the file
        File file = new File("report_20250425.xlsx");
        assertTrue(file.exists(), "Excel file should be created!");

        // Open the file and check its contents
        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            
            // Verify the number of rows and columns
            assertEquals(3, sheet.getPhysicalNumberOfRows(), "Row count in Excel should match the table row count!");
            assertEquals(26, sheet.getRow(1).getPhysicalNumberOfCells(), "Column count in Excel should be correct!");

            // Add more assertions to verify specific values or formatting in the Excel file

            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error reading the generated Excel file.");
        }
    }
    
}
