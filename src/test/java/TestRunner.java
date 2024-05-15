import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\v8\\Desktop\\ptojetos-appium\\alura-appium\\src\\test\\resources", 
    glue = {"org.example"},
    tags = "@cadastro"
)

public class TestRunner {

}
