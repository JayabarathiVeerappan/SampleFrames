package org.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Framesexecution {
 public static void main(String[] args) throws IOException {
	//To locate the workbook
	 File file = new File("C:\\Users\\sindh\\OneDrive\\Documents\\JB.xlsx");
	 
    //To get data from file workbook to eclipse FileInputStream
	 FileInputStream stream = new FileInputStream(file); 
	 
	//To define workbook format
	 Workbook book = new XSSFWorkbook(stream); 
	 
	//To get Sheet from workbook
	 Sheet sheet = book.getSheet("Sheet1");
	 
	 //To get Rows occupied by data
	 for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		//To get Row from Sheet
		 Row row = sheet.getRow(i);	 
	
	//To get cells occupied by data
	for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
		//To get cells from Row
		Cell cell = row.getCell(j);

	
	//To find celltype String || Numeric value (Date Format or Pure Numeric) from cell
	CellType cellType = cell.getCellType();
	
	switch (cellType) {
	case STRING:
		String stringCellValue = cell.getStringCellValue();
		
		if (stringCellValue.equals("Saraswathi")) {
			cell.setCellValue("Sarasu");
			FileOutputStream outputStream = new FileOutputStream(file);
			book.write(outputStream);
		}
		String stringCellValue2 = cell.getStringCellValue();
		System.out.print(stringCellValue2+"          ");
		break;
		
	case NUMERIC:
		//Whether the Numeric cell is date format
		if(DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String format = SimpleDateFormat.format(dateCellValue);
			System.out.print(format+"         ");
		}else {
			double numericCellValue = cell.getNumericCellValue();
			BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
			String string = valueOf.toString();
			System.out.print(string+"         ");
		}
			break;
			
	default:
		System.out.println("Invalid_CellType");
		break;
	}
	}
 
     System.out.println();	
 }
}
}