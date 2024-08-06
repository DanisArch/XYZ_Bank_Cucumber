package CucumberXYZBank;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "CucumberXYZBank.stepdefinitions")
@ExcludeTags("ignored")
public class RunCucumberTest {
}