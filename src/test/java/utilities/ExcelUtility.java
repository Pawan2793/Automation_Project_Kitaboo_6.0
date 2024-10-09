package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {

    private String filePath;
    private Workbook workbook;
    private Sheet sheet;

    // Constructor to initialize the Excel file and sheet
    public ExcelUtility(String filePath, String sheetName) throws IOException {
        this.filePath = filePath;
        
        
        FileInputStream inputStream = new FileInputStream(filePath);
        this.workbook = new XSSFWorkbook(inputStream);
        this.sheet = workbook.getSheet(sheetName);
        if (this.sheet == null) {
            this.sheet = workbook.createSheet(sheetName); // Create sheet if it doesn't exist
        }
    }

    // Get data from Excel based on row and column number
    public String getCellData(int rowNumber, int colNumber) {
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(colNumber);
        return cell.toString();
    }

    // Set data to Excel at a specific row and column
    public void setCellData(String data, int rowNumber, int colNumber) throws IOException {
        Row row = sheet.getRow(rowNumber);
        if (row == null) {
            row = sheet.createRow(rowNumber);
        }

        Cell cell = row.getCell(colNumber);
        if (cell == null) {
            cell = row.createCell(colNumber);
        }
        cell.setCellValue(data);

        // Write changes to the Excel file
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();
    }

    // Get the total number of rows in the sheet
    public int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }

    // Close the workbook after use
    public void close() throws IOException {
        workbook.close();
    }
}