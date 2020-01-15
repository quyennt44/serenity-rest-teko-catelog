package vn.teko.test.application.stepdefinitions.salechannel;

import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import vn.teko.application.steps.CommonSteps;
import vn.teko.test.application.common.ApplicationEndPoints;
import vn.teko.test.application.model.SaleChannelModel;
import vn.teko.test.catelog.api.object.SaleChannel;
import vn.teko.utilities.Constant;

public class SaleChannelStepDefinitions {
	private SaleChannel saleChannel;

	@Steps
	CommonSteps commonSteps;

	@And("^User initializes an object and stores as variable ['\"]([^'\"]*)['\"]$")
	public void init_store_object(String variable) {
		saleChannel = new SaleChannel();
		commonSteps.storeObject(variable, saleChannel);	
	}
	
	@And("^User sets request url as variable ['\"]([^'\"]*)['\"]$")
	public void set_url(String variable) {
		String url = ApplicationEndPoints.SALE_CHANNEL_CREATION.getUrl();
		commonSteps.storeObject(variable, url);	
	}
	
	
	@And("^User sets database entity$")
	public void set_model() {
		Class<SaleChannelModel> model = SaleChannelModel.class;		
		commonSteps.storeObject(Constant.DATABASE_MODEL_CLASS_VARIABLE, model);		
	}
	
	@And("^User sets temp database table$")
	public void set_temp_model() {		
		commonSteps.storeObject(Constant.DATABASE_MODEL_CLASS_REFERENCE_VARIABLE, Constant.ENTITY_SELLER);		
	}
}
