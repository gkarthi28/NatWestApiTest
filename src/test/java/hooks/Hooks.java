package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;


public class Hooks {
 @Before
  public void setUp(Scenario scenario) {
    System.out.println ("======= Begin of Scenario " + scenario.getName () + "=================");
 }
 @After
  public void tearDown(Scenario scenario){
  System.out.println ("======= End of Scenario " + scenario.getName () + "=================");
 }
}
