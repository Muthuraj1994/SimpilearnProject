package TestRunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src\\test\\java\\features",
        glue = {"stepDefinitions"},
        dryRun = false,
        monochrome = true,
        publish = true,
        plugin = {"html:target/CucumberReports/cucumberReports.html",
                "json:target/CucumberReports/Json-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner extends AbstractTestNGCucumberTests {


}
