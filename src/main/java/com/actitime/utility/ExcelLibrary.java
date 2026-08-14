package com.actitime.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary extends BaseTest {
	
	public static String readData(String sheet, int row, int cell) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata/ActitimeData.xlsx");
		Workbook wb = new XSSFWorkbook(fis);
		String cellValue = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return cellValue;
		
	}
}
