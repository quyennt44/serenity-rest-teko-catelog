package vn.teko.test.application.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/application/product/ProductCreation.feature", glue = {"vn.teko.test.application.stepdefinitions.product","vn.teko.test.application.stepdefinitions.common"},
				plugin = { "pretty", "html:target" },monochrome = true)
public class RunnerProductCreation {

}
