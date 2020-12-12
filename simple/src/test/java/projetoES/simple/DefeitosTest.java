package projetoES.simple;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

public class DefeitosTest {
	
	private App app;
	private Defeitos def;

	@Test
	public void testDef() throws InvalidFormatException, IOException {
    	app = new App();
    	app.readFile("C:\\Users\\costa\\Downloads\\Defeitos.xlsx");
		app.newData();
		def = new Defeitos (app.getRowData());
		String [][] s = def.detecaoDefeitos();
		assertEquals(s[0][1], "140");
    }

}
