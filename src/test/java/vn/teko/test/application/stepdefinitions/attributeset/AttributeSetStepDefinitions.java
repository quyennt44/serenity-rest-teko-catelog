package vn.teko.test.application.stepdefinitions.attributeset;

import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import vn.teko.application.steps.CommonSteps;
import vn.teko.test.application.common.ApplicationEndPoints;
import vn.teko.test.application.model.AttributeSetModel;
import vn.teko.test.catelog.api.object.AttributeSet;
import vn.teko.utilities.Constant;

public class AttributeSetStepDefinitions {
	private AttributeSet attributeSet;

	@Steps
	CommonSteps commonSteps;

	@And("^User initializes an object and stores as variable ['\"]([^'\"]*)['\"]$")
	public void init_store_object(String variable) {
		attributeSet = new AttributeSet();
		commonSteps.storeObject(variable, attributeSet);	
	}
	
	@And("^User sets request url as variable ['\"]([^'\"]*)['\"]$")
	public void set_url(String variable) {
		String url = ApplicationEndPoints.ATTRIBUTE_SET_CREATION.getUrl();
		commonSteps.storeObject(variable, url);	
	}
	
	
	@And("^User sets database entity$")
	public void set_model() {
		Class<AttributeSetModel> model = AttributeSetModel.class;		
		commonSteps.storeObject(Constant.DATABASE_MODEL_CLASS_VARIABLE, model);		
	}
	
//	@And("^User generates attribute set with name ['\"]([^'\"]*)['\"]$")
//	public void generate_attribute_set_name(String objectName) {
//		// Name unicode
//		String name = RandomStringUtils.random(5, true, false) + Constant.UNICODE_CHARACTERS;
//		
//		//uppercase
//		name = name.toUpperCase();
//		
//		//Add space to name
//		name = RandomStringUtils.random(10, true, true) + Constant.SPACE_CHARACTERS + name;
//		attributeSet.setName(name);
//		commonSteps.storeObject(objectName, attributeSet);	
//	}	
//	
//	@And("The data of attribute set code should be converted correctly")
//	public void check_attribute_code() {
//		Class<AttributeSetModel> model = AttributeSetModel.class;		
//		commonSteps.storeObject(Constant.DATABASE_MODEL_CLASS_VARIABLE, model);		
//	}

}
