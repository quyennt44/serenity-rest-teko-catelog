package vn.teko.test.application.stepdefinitions.mastercategory;

import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import vn.teko.application.steps.CommonSteps;
import vn.teko.test.application.common.ApplicationEndPoints;
import vn.teko.test.application.model.MasterCategoryModel;
import vn.teko.test.catelog.api.object.MasterCategory;
import vn.teko.utilities.Constant;

public class MasterCategoryStepDefinitions {
	private MasterCategory masterCategory;

	@Steps
	CommonSteps commonSteps;

	@And("^User initializes an object and stores as variable ['\"]([^'\"]*)['\"]$")
	public void init_store_object(String variable) {
		masterCategory = new MasterCategory();
		commonSteps.storeObject(variable, masterCategory);	
	}
	
	@And("^User sets request url as variable ['\"]([^'\"]*)['\"]$")
	public void set_url(String variable) {
		String url = ApplicationEndPoints.MASTER_CATEGORY_CREATION.getUrl();
		commonSteps.storeObject(variable, url);	
	}
	
	
	@And("^User sets database entity$")
	public void set_model() {
		Class<MasterCategoryModel> model = MasterCategoryModel.class;		
		commonSteps.storeObject(Constant.DATABASE_MODEL_CLASS_VARIABLE, model);		
	}
	
	@And("^User sets reference database table$")
	public void set_reference_model() {		
		commonSteps.storeObject(Constant.DATABASE_MODEL_CLASS_REFERENCE_VARIABLE, Constant.ENTITY_SALE_CATEGORY);		
	}
	
}

