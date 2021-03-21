import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	plugin={"pretty:target/cucumber-htmlreport.text", "json:target/cucmber-report.json"},
	features = { "src/test/java/Features"}
)
public class RunCucumberTest {

}

