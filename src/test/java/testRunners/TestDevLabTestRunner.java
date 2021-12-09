package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"/steps"},
        features = {"src/test/resources/features/TestDevLab.feature"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        }

)
public class TestDevLabTestRunner extends AbstractTestNGCucumberTests {
}
