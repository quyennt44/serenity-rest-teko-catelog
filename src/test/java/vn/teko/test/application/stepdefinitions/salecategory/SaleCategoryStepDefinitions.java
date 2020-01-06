package vn.teko.test.application.stepdefinitions.salecategory;

import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import vn.teko.application.steps.CommonSteps;
import vn.teko.test.application.common.ApplicationEndPoints;
import vn.teko.test.application.model.SaleCategoryModel;
import vn.teko.test.catelog.api.object.SaleCategory;
import vn.teko.utilities.Constant;

public class SaleCategoryStepDefinitions {
	private SaleCategory saleCategory;

	@Steps
	CommonSteps commonSteps;

	@And("^User initializes an object and stores as variable ['\"]([^'\"]*)['\"]$")
	public void init_store_object(String variable) {
		saleCategory = new SaleCategory();
		commonSteps.storeObject(variable, saleCategory);	
	}
	
	@And("^User sets request url as variable ['\"]([^'\"]*)['\"]$")
	public void set_url(String variable) {
		String url = ApplicationEndPoints.SALE_CATEGORY_CREATION.getUrl();
		commonSteps.storeObject(variable, url);	
	}
	
	
	@And("^User sets database entity$")
	public void set_model() {
		Class<SaleCategoryModel> model = SaleCategoryModel.class;		
		commonSteps.storeObject(Constant.DATABASE_MODEL_CLASS_VARIABLE, model);		
	}
	
	@And("^User sets temp database table$")
	public void set_temp_model() {		
		commonSteps.storeObject(Constant.DATABASE_MODEL_CLASS_TEMP_VARIABLE, Constant.ENTITY_SALE_CATEGORY);		
	}
	
}

