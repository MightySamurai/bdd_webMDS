package bdd.webMD.runner;

import java.io.File;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources/Features/WebMDSignIn" }, glue = { "bdd.webMD.stepDef",
		"bdd.webMD.utilities" }, tags = { "@SignIn" }, plugin = { "pretty", "html:target/cucumber-htmlreport",
				"json:target/cucumber-jsonreport/cucumber-report.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, monochrome = true)

public class WebMDTestRunner extends AbstractTestNGCucumberTests {

	@AfterClass
	public void generateExtendReport() {
		Reporter.loadXMLConfig(new File("config/config.xml"));
	}
}
