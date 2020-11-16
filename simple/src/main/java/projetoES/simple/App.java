package projetoES.simple;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.*;

public class App {
	private int rowNum;
	private int columnNum;
	private Workbook workbook;
	private DataFormatter dataFormatter;
    
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
}
