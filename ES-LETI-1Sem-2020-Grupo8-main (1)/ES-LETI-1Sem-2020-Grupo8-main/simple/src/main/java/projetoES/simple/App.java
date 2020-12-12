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
				if(bool.equals("TRUE") && compare(value, CYCLO).equals("TRUE")) {
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
				if(bool.equals("TRUE") && compare(value, LOC).equals("TRUE")) {
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
				if(bool.equals("TRUE") && compare(value, LAA).equals("TRUE")) {
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
				if(bool.equals("TRUE") && compare(value, ATFD).equals("TRUE")) {
					Cell longCell = workbook.getSheetAt(0).getRow(row).getCell(searchCell("is_feature_envy"));
					longCell.setCellValue("TRUE");
				}
			}
			break;
		}
	}

	public int searchCell(String cellName) {
		for (int i=0 ; i < columnNum ; i++) {
			if(columnNames[i].equals(cellName)) {
				return i;
			}
		}
		return -1;
	}

	public String compare(String value, Metric m) {
		Double aux = Double.parseDouble(value);
		switch (m.getSymbol()){
		case "<":
			if(aux<m.getValue()) {
				return "TRUE";
			} else {
				return "FALSE";
			}
		case ">":
			if(aux>m.getValue()) {
				return "TRUE";
			} else {
				return "FALSE";
			}
		case "=":
			if(aux==m.getValue()) {
				return "TRUE";
			} else {
				return "FALSE";
			}
		}
		return "FALSE";
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

	public String get(int i, int j) {
		Sheet aux = workbook.getSheetAt(0);
		Row aux1 = aux.getRow(i);
		Cell cell = aux1.getCell(j);
		String cellValue = dataFormatter.formatCellValue(cell);
		return cellValue;
	}
}