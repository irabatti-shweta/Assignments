package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(  
		features={".//src//test//java//Features//Assignment2.feature"},
		//features={".//src//test//java//Features//Assignment1.feature"},
		glue="StepDefAssi2",
		//glue="StepsDef",
		dryRun=false
		)

public class TestRunner {

}
