package vn.teko.test.application.stepdefinitions;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import vn.teko.application.steps.APISendRequestSteps;

public class SetUserStepDefinitions {

	@Steps	
	APISendRequestSteps apiSteps;
	
	@Given("^User has access to application as ['\"]([^'\"]*)['\"]$")
	public void set_user(String user) {
		apiSteps.storeUser(user);
//		Serenity.getCurrentSession().put("user", user);
//		apiSteps.setUser(user);
	}
	
}
