package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @autor: Evelin
 **/
@RunWith(Cucumber.class)
@CucumberOptions(
       features = {"src/test/resources/user.feature","src/test/resources/projects.feature"}
        //features = {"src/test/resources/projects.feature"}
)
public class Runner {
}
