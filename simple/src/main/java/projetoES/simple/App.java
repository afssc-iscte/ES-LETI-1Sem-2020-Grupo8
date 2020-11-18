package projetoES.simple;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
<<<<<<< HEAD
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

=======
>>>>>>> f8e7e59e064ae0e2565e1c63b771c39b41968c95
import java.io.*;

public class App {
	private int rowNum;
	private int columnNum;
	private Workbook workbook;
	private DataFormatter dataFormatter;
<<<<<<< HEAD

	public void readFile (String ExcelPath) throws InvalidFormatException, IOException {
		workbook = WorkbookFactory.create(new File(ExcelPath));
		Sheet sheet = workbook.getSheetAt(0);
		dataFormatter = new DataFormatter();
		Row row = sheet.getRow(0);

		rowNum = sheet.getLastRowNum();
		columnNum = row.getLastCellNum();

		//        for (Row row: sheet) {
			//            for(Cell cell: row) {
		//                String cellValue = dataFormatter.formatCellValue(cell);
		//                System.out.print(cellValue + "\t");
		//            }
		//            System.out.println();
		//        }
	}


	public int rowNum() {
		return this.rowNum;
	}

	public int columnNum() {
		return this.columnNum;
	}

	public String get(int i, int j) {
		Sheet aux = workbook.getSheetAt(0);
		Row aux1 = aux.getRow(i);
		Cell cell = aux1.getCell(j);
		String cellValue = dataFormatter.formatCellValue(cell);
		return cellValue;
	}
	
	
=======
    
	public void readFile (String ExcelPath) throws InvalidFormatException, IOException {
    	workbook = WorkbookFactory.create(new File(ExcelPath));
        Sheet sheet = workbook.getSheetAt(0);
        dataFormatter = new DataFormatter();
        Row row = sheet.getRow(0);
        
        rowNum = sheet.getLastRowNum();
        columnNum = row.getLastCellNum();
     
//        for (Row row: sheet) {
//            for(Cell cell: row) {
//                String cellValue = dataFormatter.formatCellValue(cell);
//                System.out.print(cellValue + "\t");
//            }
//            System.out.println();
//        }
    }
    
    public int rowNum() {
    	return this.rowNum;
    }
    
    public int columnNum() {
    	return this.columnNum;
    }
    
    public String get(int i, int j) {
    	Sheet aux = workbook.getSheetAt(0);
    	Row aux1 = aux.getRow(i);
    	Cell cell = aux1.getCell(j);
    	String cellValue = dataFormatter.formatCellValue(cell);
    	return cellValue;
    }
>>>>>>> f8e7e59e064ae0e2565e1c63b771c39b41968c95
}
