package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources", //directorio de nuestros feature
    glue = "steps", //donde estan los step Definitions
    plugin = {"pretty", "html:target/cucumber-reports"}
    //tags = "@login"
)
public class TestRunner {
    //se ejecuta despues de todos los steps
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}
