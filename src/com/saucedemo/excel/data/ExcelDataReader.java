package com.saucedemo.excel.data;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import com.saucedemo.consts.Constants;


public class ExcelDataReader {
	

	public static String[] getUserData(String testCaseName) {
        String[] userData = new String[2];
        try (FileInputStream inputStream = new FileInputStream(new File(Constants.EXCEL_PATH));
             Workbook workbook = WorkbookFactory.create(inputStream)) {
            Sheet sheet = workbook.getSheet(Constants.SHEET_NAME);
            if (sheet == null) {
                System.out.println("Sheet '" + Constants.SHEET_NAME + "' not found.");
                return null;
            }

            for (Row row : sheet) {
                Cell cell = row.getCell(0); // Assuming TestCaseName is in the first column
                if (cell != null && cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(testCaseName)) {
                    userData[0] = row.getCell(1).getStringCellValue(); // Username
                    userData[1] = row.getCell(2).getStringCellValue();// Password
                    userData[2] = row.getCell(3).getStringCellValue();// First name
                    userData[3] = row.getCell(4).getStringCellValue();// Last name
                    userData[4] = row.getCell(5).getStringCellValue();// Zip code
                     
                    break;
                }
            }
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
        return userData[0] != null && userData[1] != null ? userData : null;
    }

}
