package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",features= {"src/test/resources/Features/createInstrument.feature"},
glue= {"stepDefifinition"},
plugin= {"pretty","html:target/htmlReport.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
