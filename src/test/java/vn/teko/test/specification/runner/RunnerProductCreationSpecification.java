package vn.teko.test.specification.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/jira/ProductCreationToJira.feature", glue = {"vn.teko.test.specification.stepdefinitions"},
				plugin = { "pretty", "html:target" },monochrome = true)
public class RunnerProductCreationSpecification {

}
