package fall2023project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/com/example/fall2023project", // path to the features
    glue = "com.example.fall2023project", // path to the step definitions
    plugin = {"pretty", "html:target/cucumber-reports"}, // plugins for reporting
    strict = true
)

public class TestRunner {
}
