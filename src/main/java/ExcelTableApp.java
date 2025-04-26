import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelTableApp extends JFrame {
    protected JTable table;
    protected DefaultTableModel model;
    JTextField rowsField;

    public ExcelTableApp() {
        setTitle("إعداد جدول البيانات");
        setSize(1600, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // إدخال عدد الصفوف + الأزرار
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("عدد الصفوف:"));
        rowsField = new JTextField(5);
        inputPanel.add(rowsField);

        JButton createButton = new JButton("إنشاء جدول");
        JButton resetButton = new JButton("إعادة تعيين الجدول");
        inputPanel.add(createButton);
        inputPanel.add(resetButton);
        add(inputPanel, BorderLayout.NORTH);

        createButton.addActionListener(e -> createTable());
        resetButton.addActionListener(e -> resetTable());

        setVisible(true);
    }

    protected void createTable() {
        int rows = Integer.parseInt(rowsField.getText());

        String[] columnNames = {
            
            "الكنس الآلي (كم)", "الكنس اليدوي والتقاط المبعثرات (كم)", "نظافة الطرق السريعة (كم)",
            "نظافة الاراضي الفضاء (م2)", "جمع ونقل النفايات المنزلية (طن)", "غسيل وتطهير الحاويات (عدد)",
            "صيانة الحاويات (عدد)", "جمع ونقل النفايات ذات الحجم الكبير (م3)",
            "جمع ونقل حاويات الاوراق الدينية (طن)", "جمع ونقل حاويات الأطعمة (طن)",
            "غسيل الأرصفة (كم)", "ازالة مخلفات الأمطار (م3)",
            "الباعة الجائلين (عدد)", "المظلات المخالفة (عدد)", "اللوحات الإعلانية (عدد)",
            "الكتابات المشوهه (م2)", "الحواجز الخرسانيه (عدد)", "نظافة وغسيل مرافق الحدائق (عدد)",
            "الإطارات المستهلكة (عدد)", "غربلة الشواطئ الرملية (كم)", "رفع الطحالب (طن)",
            "جمع ونقل مخلفات البناء والهدم (م3)", "فرز النفايات القابلة لإعادة التدوير (طن)",
            "جمع ونقل النفايات التجارية (طن)", "الدعم في المشاركات المجتمعية والفعاليات والمناسبات (عدد)"
        };

        model = new DefaultTableModel(columnNames, rows);
        table = new JTable(model);

        // توليد التواريخ تلقائياً
        LocalDate today = LocalDate.now();
        for (int i = 0; i < rows; i++) {
            model.setValueAt(today.plusDays(i).toString(), i, 0);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton exportButton = new JButton("توليد ملف Excel");
        exportButton.addActionListener(e -> generateExcel());
        add(exportButton, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }

    void resetTable() {
        if (table != null) {
            remove(table.getParent().getParent());
            revalidate();
            repaint();
        }
    }

   // This method creates and exports an Excel file with grouped headers and wrapped units (like (كم), (عدد)) in a new line.
// It opens a Save dialog so the user can choose where to save the file.
// The table columns auto-adjust, and the final file looks clean and readable.
protected void generateExcel() {
    try (Workbook workbook = new XSSFWorkbook()) {

        Sheet sheet = workbook.createSheet("نموذج التقارير");

        // Group titles for Excel header (row 0)
        String[] groupTitles = {
            "التاريخ",
            "الخدمات التعاقدية",
            "خدمات التشوه البصري",
            "الأعمال الاستثمارية",
            "الدعم في المشاركات المجتمعية والفعاليات والمناسبات"
        };

        // How many columns each group spans
        int[] groupSpans = {1, 12, 9, 3, 1};

        // Column headers with units on new lines (row 1)
        String[] headers = {
            "التاريخ",
            "الكنس الآلي\n(كم)", "الكنس اليدوي والتقاط المبعثرات\n(كم)", "نظافة الطرق السريعة\n(كم)",
            "نظافة الاراضي الفضاء\n(م2)", "جمع ونقل النفايات المنزلية\n(طن)", "غسيل وتطهير الحاويات\n(عدد)",
            "صيانة الحاويات\n(عدد)", "جمع ونقل النفايات ذات الحجم الكبير\n(م3)",
            "جمع ونقل حاويات الاوراق الدينية\n(طن)", "جمع ونقل حاويات الأطعمة\n(طن)",
            "غسيل الأرصفة\n(كم)", "ازالة مخلفات الأمطار\n(م3)",
            "الباعة الجائلين\n(عدد)", "المظلات المخالفة\n(عدد)", "اللوحات الإعلانية\n(عدد)",
            "الكتابات المشوهه\n(م2)", "الحواجز الخرسانيه\n(عدد)", "نظافة وغسيل مرافق الحدائق\n(عدد)",
            "الإطارات المستهلكة\n(عدد)", "غربلة الشواطئ الرملية\n(كم)", "رفع الطحالب\n(طن)",
            "جمع ونقل مخلفات البناء والهدم\n(م3)", "فرز النفايات القابلة لإعادة التدوير\n(طن)",
            "جمع ونقل النفايات التجارية\n(طن)", "الدعم في المشاركات المجتمعية والفعاليات والمناسبات\n(عدد)"
        };

        // Row 0: group headers
        Row groupRow = sheet.createRow(0);
        int col = 0;
        CellStyle headerStyle = createHeaderStyle(workbook);

        for (int i = 0; i < groupTitles.length; i++) {
            if (groupSpans[i] > 1) {
                sheet.addMergedRegion(new CellRangeAddress(0, 0, col, col + groupSpans[i] - 1));
            }
            Cell cell = groupRow.createCell(col);
            cell.setCellValue(groupTitles[i]);
            cell.setCellStyle(headerStyle);
            col += groupSpans[i];
        }

        // Row 1: detailed headers with line wrap
        CellStyle wrappedHeaderStyle = workbook.createCellStyle();
        wrappedHeaderStyle.setWrapText(true);
        wrappedHeaderStyle.setAlignment(HorizontalAlignment.CENTER);
        wrappedHeaderStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        org.apache.poi.ss.usermodel.Font font = workbook.createFont();
        font.setBold(true);
        wrappedHeaderStyle.setFont(font);

        Row headerRow = sheet.createRow(1);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(wrappedHeaderStyle);
        }

        // Fill table data from JTable
        for (int i = 0; i < model.getRowCount(); i++) {
            Row row = sheet.createRow(i + 2);
            for (int j = 0; j < model.getColumnCount(); j++) {
                Object value = model.getValueAt(i, j);
                Cell cell = row.createCell(j);
                if (value != null) {
                    try {
                        cell.setCellValue(Double.parseDouble(value.toString()));
                    } catch (NumberFormatException e) {
                        cell.setCellValue(value.toString());
                    }
                }
            }
        }

        // Auto-size all columns for better display
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Save dialog (user picks where to save file)
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("حدد مكان حفظ الملف");
        fileChooser.setSelectedFile(new java.io.File("report_" + date + ".xlsx"));

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            FileOutputStream fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            fileOut.close();

            JOptionPane.showMessageDialog(this, "تم حفظ الملف بنجاح:\n" + filePath);
        } else {
            JOptionPane.showMessageDialog(this, "لم يتم حفظ الملف. تم إلغاء العملية.");
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, " فشل إنشاء الملف: " + e.getMessage());
    }
}
    private CellStyle centeredStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    private CellStyle createHeaderStyle(Workbook wb) {
         CellStyle style = wb.createCellStyle();
    org.apache.poi.ss.usermodel.Font font = wb.createFont(); 
    font.setBold(true);
    style.setFont(font);
    style.setAlignment(HorizontalAlignment.CENTER);
    style.setVerticalAlignment(VerticalAlignment.CENTER);
    style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    return style;
    }

}