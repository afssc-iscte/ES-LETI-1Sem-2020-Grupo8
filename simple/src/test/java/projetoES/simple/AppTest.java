package projetoES.simple;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

public class AppTest {

	private App app = new App(); 

	@Test
	public void testRead() throws InvalidFormatException, IOException {
		app.readFile("C:\\Users\\costa\\Downloads\\Defeitos.xlsx");
		app.newData();
		int rowNum = app.rowNum();
		int columnNum = app.columnNum();
		assertEquals(rowNum,420);
		assertEquals(columnNum,12);
	}

	@Test   
	public void testEscreveVF() throws InvalidFormatException, IOException {
		testRead();
		Metric m = new Metric ("CYCLO",">",5);
		Metric LOC = new Metric("LOC",">",1);
		Metric ATFD = new Metric("ATFD",">",4);
		Metric LAA = new Metric("LAA","<",  0.428571);
		Metric m2 = new Metric("LOC" , "=" , 3);
		app.escreveVF(m, 4);
		app.escreveVF(m, 10);
		app.escreveVF(LOC, 7);
		app.escreveVF(ATFD, 8);
		app.escreveVF(LAA, 121);	
		app.escreveVF(m, 1);
		app.escreveVF(LOC, 2);
		app.escreveVF(ATFD, 3);
		app.escreveVF(LAA, 4);
		app.escreveVF(m2, 10);
	}
}