package net.phptravel;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/main/resources/"
		,glue={"net/phptravels/steps/"}
		//,format = {"pretty", "html:target/Destination/TestVinculacionBeneficiarios","json:target/TestVinculacionBeneficiarios.json"}
		//,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"}
		,junit = {"--filename-compatible-names"}
)
public class Test {
}