package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinitions"},
        monochrome = true,
        plugin = {
                "pretty",
                "json:target/cucumber-reports/CucumberReport.json", // Bu zaten var, bırakıyoruz
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Allure plugin ekleniyor
        }
)
public class TestRunner {
}
