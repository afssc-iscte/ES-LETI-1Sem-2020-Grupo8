package projetoES.simple;

import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.*;


@RunWith(JUnitPlatform.class)
@SelectClasses({AppTest.class, DefeitosTest.class, MetricTest.class, GUITest.class})
public class AllTests {

}
