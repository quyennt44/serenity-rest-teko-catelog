package vn.teko.test.application.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/application/attribute_set/AttributeSetCreation.feature", glue = {"vn.teko.test.application.stepdefinitions.common","vn.teko.test.application.stepdefinitions.attributeset"},
				plugin = { "pretty", "html:target" },monochrome = true)
public class RunnerAttributeSetCreation {

}
