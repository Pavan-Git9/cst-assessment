package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"steps", "base"},
    plugin = {
        "pretty",
        "summary",
        "html:target/cucumber-report.html",
        "json:target/cucumber.json"
    },
    tags = "@smoke",
    monochrome = true
)
public class RunCukesTest extends AbstractTestNGCucumberTests {
}