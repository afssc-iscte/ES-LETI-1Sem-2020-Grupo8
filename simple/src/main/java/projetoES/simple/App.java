package projetoES.simple;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.*;

public class App {
	private int rowNum;
	private int columnNum;
	private Workbook workbook;
	private DataFormatter dataFormatter;
	private String[][] rowData;
	private String[] columnNames;
	private Metric LOC;
	private Metric CYCLO;
	private Metric ATFD;
	private Metric LAA;

	/**
	 * Read an excel file and keep his data
	 * @param ExcelPath ExcelFile to read
	 */
	public void readFile (String ExcelPath) throws InvalidFormatException, IOException {
		workbook = WorkbookFactory.create(new File(ExcelPath));
		Sheet sheet = workbook.getSheetAt(0);
		dataFormatter = new DataFormatter();
		Row row = sheet.getRow(0);

		rowNum = sheet.getLastRowNum();
		columnNum = row.getLastCellNum();

		rowData = new String[rowNum()][columnNum()];
		columnNames = new String[columnNum()];

		LOC = new Metric("LOC",">",80);
		CYCLO = new Metric("CYCLO",">",10);
		ATFD = new Metric("ATFD",">",4);
		LAA = new Metric("LAA","<",  0.428571);
	}
	
	
	/**
	 * Save new updated data
	 */
	public void newData() {
		for (int row1=0 ; row1<rowNum+1 ; row1++) {
			for (int column=0 ; column<columnNum; column++) {
				String cell = get(row1, column);
				if (row1 == 0)
					columnNames[column] = cell;
				else
					rowData[row1 - 1][column] = cell;
			}
		}
	}


	
	/**Receives a metric and a row. Saves the metric and invokes the function search().
	 * 
	 * @param m Metric to search
	 * @param row Row to search
	 */
	public void escreveVF (Metric m, int row) {
		//Load Column Names
		for (int column=0 ; column < columnNum(); column++) {
			String cell = get(0, column);
			columnNames[column] = cell;
		}

		switch(m.getName()) {
		case "LOC":
			LOC.set(m.getSymbol(), m.getValue());
			search(LOC,row);
			break;

		case "CYCLO":
			CYCLO.set(m.getSymbol(), m.getValue());
			search(CYCLO,row);
			break;

		case "ATFD":
			ATFD.set(m.getSymbol(), m.getValue());
			search(ATFD,row);
			break;

		case "LAA":
			LAA.set(m.getSymbol(), m.getValue());
			search(LAA,row);
			break;
		}
	}


	/**Receives a metric and a row. Invokes the function change() and writes "TRUE" or 
	 * "FALSE" according to the metric given.
	 * @param m Metric to update
	 * @param row Given row to search
	 */
	public void search(Metric m ,int row) {
		int i = searchCell(m.getName());
		double a = Double.parseDouble(this.get(row, i));
		if(m.getSymbol().equals(">")) {
			if (a>m.getValue()) {
				change(m, row, "TRUE");
			} else {
				change(m, row, "FALSE");
			}
		}
		if(m.getSymbol().equals("<")) {
			if (a<m.getValue()) {
				change(m, row, "TRUE");
			} else {
				change(m, row, "FALSE");
			}
		}
		if(m.getSymbol().equals("=")) {
			if (a==m.getValue()) {
				change(m, row, "TRUE");
			} else {
				change(m, row, "FALSE");
			}
		}
	}

	/**
	 * Changes the value of "is_long_method" or "is_feature_envy" according to name of the metric and
	 * boolean value given. Only changes a specific row. 
	 * @param m Metric to change
	 * @param row Row to update
	 * @param bool New boolean value for the cell
	 */
	public void change(Metric m, int row, String bool) {
		String value;
		String longMethod;
		switch (m.getName()) {
		case "LOC":
			value = get(row, searchCell("CYCLO"));
			longMethod = get (row, searchCell("is_long_method"));
			if(longMethod.equals("TRUE")) {
				if(bool.equals("FALSE")) {
					Cell longCell = workbook.getSheetAt(0).getRow(row).getCell(searchCell("is_long_method"));
					longCell.setCellValue("FALSE");
				}
			} 
			if(longMethod.equals("FALSE")) {
				if(bool.equals("TRUE") && CYCLO.compare(value).equals("TRUE")) {
					Cell longCell = workbook.getSheetAt(0).getRow(row).getCell(searchCell("is_long_method"));
					longCell.setCellValue("TRUE");
				}
			}
			break;
		case "CYCLO":
			value = get(row, searchCell("LOC"));
			longMethod = get (row, searchCell("is_long_method"));
			if(longMethod.equals("TRUE")) {
				if(bool.equals("FALSE")) {
					Cell longCell = workbook.getSheetAt(0).getRow(row).getCell(searchCell("is_long_method"));
					longCell.setCellValue("FALSE");
				}
			} 
			if(longMethod.equals("FALSE")) {
				if(bool.equals("TRUE") && LOC.compare(value).equals("TRUE")) {
					Cell longCell = workbook.getSheetAt(0).getRow(row).getCell(searchCell("is_long_method"));
					longCell.setCellValue("TRUE");
				}
			}
			break;
		case "ATFD":
			value = get(row, searchCell("LAA"));
			longMethod = get (row, searchCell("is_feature_envy"));
			if(longMethod.equals("TRUE")) {
				if(bool.equals("FALSE")) {
					Cell longCell = workbook.getSheetAt(0).getRow(row).getCell(searchCell("is_feature_envy"));
					longCell.setCellValue("FALSE");
				}
			} 
			if(longMethod.equals("FALSE")) {
				if(bool.equals("TRUE") && LAA.compare(value).equals("TRUE")) {
					Cell longCell = workbook.getSheetAt(0).getRow(row).getCell(searchCell("is_feature_envy"));
					longCell.setCellValue("TRUE");
				}
			}
			break;
		case "LAA":
			value = get(row, searchCell("ATFD"));
			longMethod = get (row, searchCell("is_feature_envy"));
			if(longMethod.equals("TRUE")) {
				if(bool.equals("FALSE")) {
					Cell longCell = workbook.getSheetAt(0).getRow(row).getCell(searchCell("is_feature_envy"));
					longCell.setCellValue("FALSE");
				}
			} 
			if(longMethod.equals("FALSE")) {
				if(bool.equals("TRUE") && ATFD.compare(value).equals("TRUE")) {
					Cell longCell = workbook.getSheetAt(0).getRow(row).getCell(searchCell("is_feature_envy"));
					longCell.setCellValue("TRUE");
				}
			}
			break;
		}
	}

	/**
	 * Searches the index of a given cell name
	 * @param cellName Name of the column to search
	 * @return Index of the column
	 */
	public int searchCell(String cellName) {
		for (int i=0 ; i < columnNum ; i++) {
			if(columnNames[i].equals(cellName)) {
				return i;
			}
		}
		return -1;
	}

	public String[] getColumnNames() {
		return this.columnNames;
	}

	public String [][] getRowData() {
		return this.rowData;
	}

	public int rowNum() {
		return this.rowNum;
	}

	public int columnNum() {
		return this.columnNum;
	}

	public String getName(int i) {
		return columnNames[i];
	}

	public Workbook getWB() {
		return this.workbook;
	}

	/**
	 * Return a String with the value of a specific cell
	 * @param i Row of the cell
	 * @param j Column of the cell
	 * @return String with the cell value
	 */
	public String get(int i, int j) {
		Sheet aux = workbook.getSheetAt(0);
		Row aux1 = aux.getRow(i);
		Cell cell = aux1.getCell(j);
		String cellValue = dataFormatter.formatCellValue(cell);
		return cellValue;
	}
}