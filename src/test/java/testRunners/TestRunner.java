package testRunners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/resources/Features", glue= "StepDefinitions")

//NOTE: Maven test autodiscovery will only look for classes that follow one of these patterns:
//Test* or *Test, and it is case sensitive. So `testRunner` wouldn't work, and you'll have no hint
//about why that is the case
public class TestRunner {

}