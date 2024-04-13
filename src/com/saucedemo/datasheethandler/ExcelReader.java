package com.saucedemo.datasheethandler;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class ExcelReader {
    
    private Workbook workbook;
    private Sheet sheet;
    
    public ExcelReader(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        workbook = WorkbookFactory.create(fileInputStream);
        sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
    }
    
    public String getDataByTestCaseNameAndHeader(String testCaseName, String headerName) {
        Row headerRow = sheet.getRow(0);
        int headerIndex = -1;
        int testCaseIndex = -1;
        
        // Find the index of the specified header
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equals(headerName)) {
                headerIndex = cell.getColumnIndex();
                break;
            }
        }
        
        if (headerIndex == -1) {
            System.out.println("Header name not found.");
            return null;
        }
        
        // Find the index of the specified TestCaseName
        for (Row row : sheet) {
            Cell testCaseCell = row.getCell(0); // Assuming TestCaseName is in the first column
            if (testCaseCell != null && testCaseCell.getStringCellValue().equals(testCaseName)) {
                testCaseIndex = row.getRowNum();
                break;
            }
        }
        
        if (testCaseIndex == -1) {
            System.out.println("TestCaseName not found.");
            return null;
        }
        
        // Retrieve the data for the specified header and TestCaseName
        Row dataRow = sheet.getRow(testCaseIndex);
        Cell cell = dataRow.getCell(headerIndex);
        if (cell != null) {
            return cell.getStringCellValue();
        }
        
        return null;
    }
    
    public void close() throws IOException {
        workbook.close();
    }
    
}
