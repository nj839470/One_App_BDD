package Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {".//Features//Login.feature",},  //".//Features//Select_Vehicle.feature"
glue = "Step_Defination",
dryRun = false, 
monochrome = true,
plugin = {"pretty" })
public class runtest extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}


}
