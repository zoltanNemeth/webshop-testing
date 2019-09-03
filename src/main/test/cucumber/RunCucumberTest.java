package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//src/main/resources/cucumber", glue = {"cucumber"}, plugin = "pretty")
public class RunCucumberTest {
}

