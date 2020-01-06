package vn.teko.test.application.stepdefinitions.brand;

import org.apache.commons.lang3.RandomStringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import vn.teko.application.steps.CommonSteps;
import vn.teko.test.application.common.ApplicationEndPoints;
import vn.teko.test.application.model.BrandModel;
import vn.teko.test.catelog.api.object.Brand;
import vn.teko.utilities.Constant;
import vn.teko.utilities.Helper;

public class BrandStepDefinitions {	
	private Brand brand;

	private String DASH_MIDDLE = "middel";
	private String DASH_LEADING = "leading";
	private String DASH_AFTER = "after";
	
	@Steps
	CommonSteps commonSteps;

	@And("^User initializes an object and stores as variable ['\"]([^'\"]*)['\"]$")
	public void init_store_object(String variable) {
		brand = new Brand();
		commonSteps.storeObject(variable, brand);	
	}
	
	@And("^User sets request url as variable ['\"]([^'\"]*)['\"]$")
	public void set_url(String variable) {
		String url = ApplicationEndPoints.BRAND_CREATION.getUrl();
		commonSteps.storeObject(variable, url);	
	}
	
	
	@And("^User sets database entity$")
	public void set_model() {
		Class<BrandModel> model = BrandModel.class;		
		commonSteps.storeObject(Constant.DATABASE_MODEL_CLASS_VARIABLE, model);		
	}
	
	@Given("^User set dash ['\"]([^'\"]*)['\"] in code at the position ['\"]([^'\"]*)['\"]$")
	public void create_brand_with_status(String dash, String dashPosition) {		
		brand = new Brand();
		// Add a random string so that the code will not be duplicated
		String randomString = RandomStringUtils.random(5, true, true).toLowerCase();
		String brandCode = "";
		if (dashPosition.equalsIgnoreCase(DASH_LEADING) || dashPosition.equalsIgnoreCase(DASH_MIDDLE)) {
			brandCode = dash + randomString;		
		} else if (dashPosition.equalsIgnoreCase(DASH_AFTER)) {
			brandCode = randomString + dash;
		}
		
		brand.setCode(brandCode.trim().toLowerCase());
	}

	@Given("^User selects image type as ['\"]([^'\"]*)['\"] and in size width (\\d+) and height (\\d+)$")
	public void select_image(String fileType, int width, int height) {
		brand.setLogo(Helper.generateImage(fileType, width, height));
	}
	

	
//	@And("User repeats action ['\"](create|update)['\"] for (\\d+) times as user ['\"]([^'\"]*)['\"]")
//	public void repeat_action(String action, int repeat, String user) {
//		for (int i = 0; i < repeat; i++) {
//			send_request(action, user);
//		}
//	}
//
//	@And("^The list of brands have no duplicated internal code$")
//	public void check_duplicated_internal_code() {
//		catalogAPISteps.checkBrandInternalCode(dataKeeper.getIdList());		
//	}

}
