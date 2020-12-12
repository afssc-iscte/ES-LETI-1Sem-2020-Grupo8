package projetoES.simple;

import static org.junit.Assert.*;

import org.junit.Test;

public class MetricTest {


	
	@Test
	public void testCompare() {
		Metric m = new Metric ("LOC" , "<" , 10);
		Metric m2 = new Metric ("LOC" , ">" , 2);
		Metric m3 = new Metric ("LOC" , "=", 4);
		String s = "3";
		String s2 = m2.compare(s);
		String s3 = m3.compare(s);
		String aux = m.compare(s);
		assertEquals(aux, "TRUE");
		assertEquals(s2 , "TRUE");
		assertEquals(s3, "FALSE");
	
	}

}
