package fall2023Project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "use_cases", // path to the features
	    glue = "" , // path to the step definitions
	    plugin = {"pretty", "html:target/cucumber-reports/report.html", "json:target/cucumber-reports/cucumber.json"} // plugins for reporting
	)

public class TestRunner {
}
