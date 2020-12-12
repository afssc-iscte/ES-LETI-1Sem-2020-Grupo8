package projetoES.simple;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

public class GUITest {
	
	private GUI gui;

	@Test
	public void test() throws InvalidFormatException, IOException {
		gui = new GUI();
	}

}
