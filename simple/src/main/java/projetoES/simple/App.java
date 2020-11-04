package projetoES.simple;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static final String ExcelPath = new String("C:\\Users\\costa\\Downloads\\Defeitos.xlsx");
	
    public static void main( String[] args ) throws InvalidFormatException, IOException {
    	
    	Workbook workbook = WorkbookFactory.create(new File(ExcelPath));
        System.out.println( "Hello World!" );
    
        System.out.println("Retrieving Sheets using for-each loop");
        for(Sheet sheet: workbook) {
            System.out.println("=> " + sheet.getSheetName());
        }
        
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Row row: sheet) {
            for(Cell cell: row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }
    }
}
