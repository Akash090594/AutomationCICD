package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:/Users/akash/eclipse-workspace/SeleniumProjectDesign/src/test/java/cucumber",glue="akashswamiacademy/stepDefinitions",monochrome=true,plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
