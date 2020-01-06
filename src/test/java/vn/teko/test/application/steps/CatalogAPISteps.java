package vn.teko.test.application.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import vn.teko.application.steps.DatabaseSteps;
import vn.teko.test.application.common.ResponseConstant;
import vn.teko.test.application.model.BrandModel;
import vn.teko.test.catelog.api.object.CommonPostResponseObject;
import vn.teko.utilities.Constant;
import vn.teko.utilities.Helper;
import vn.teko.utilities.ImageUtils;

public class CatalogAPISteps {
	private static String FIELD_ID = "id";

	private DatabaseSteps database = new DatabaseSteps();
//	private SetGetBeanProperties setGetBeanProperties = new SetGetBeanProperties();
	private ImageUtils imageUtils = new ImageUtils();
	private Helper helper = new Helper();

	public void responseCodeShouldBeEqual(String returnCodeValue) {
		CommonPostResponseObject obj = SerenityRest.then().extract().body().as(CommonPostResponseObject.class);
		assertThat(returnCodeValue.toLowerCase(), equalTo(obj.getCode().toLowerCase()));
	}

	
	@Step
	public List<Integer> getIdFromReposeList() {	
		int id = getIdFromResponse();
		List<Integer> result = new ArrayList<Integer>();
		result.add(id);
		return result;
	}		
	
	@Step
	public void checkDuplicatedInternalCodes() {
		List<Integer> idList = getIdFromReposeList();
		List<Object> brandList = database.findObjectListByIds(BrandModel.class, idList);
		List<String> internalCodes = new ArrayList<String>();
		for (Object object : brandList) {
			BrandModel brandModel = (BrandModel)object;
			internalCodes.add(brandModel.getInternal_code());
		}
		boolean duplicated = helper.checkDuplicatedStringFromList(internalCodes);
		assertThat(false, equalTo(duplicated));		
	}

	public Object getObjectFromDatabaseById(Class<?> classname) {
//		CommonPostResponseObject obj = SerenityRest.then().extract().body().as(CommonPostResponseObject.class);
		int id = getIdFromResponse();
		Object expectedObject = database.findObjectById(classname, id);
		return expectedObject;
	}
	
	public int getIdFromResponse() {
		int id = 0;
		CommonPostResponseObject obj = SerenityRest.then().extract().body().as(CommonPostResponseObject.class);
		if (obj != null & obj.getResult() != null) {
			id = obj.getResult().get(FIELD_ID);
		}
		return id;
	}

//	@Step
//	public void brandInDatabaseShouldBeCorrect(Brand inputBrand) {
//		BrandModel databaseBrand = (BrandModel) getObjectFromDatabaseById(BrandModel.class);
//		assertThat(inputBrand.getCode(), equalTo(databaseBrand.getCode().trim()));
//		assertThat(inputBrand.getName(), equalTo(databaseBrand.getName().trim()));
//	}
	@Step
	public void deleteObjectById(Class<?> classname) {
		int id = getIdFromResponse();
		database.deleteObjectById(classname, id);
	}
	
	@Step
	public void deleteObjectsByIds(Class<?> classname, List<Integer> ids) {
		database.deleteObjectsByIds(classname, ids);
	}	

//	public void compareDataToDatabase(Object inputObject, Object outputObject, List<Map<String, String>> fields,
//			String inputFieldLabel, String outputFieldLabel) {
//		for (Map<String, String> field : fields) {
//			String inputField = field.get(inputFieldLabel);
//			String outputField = field.get(outputFieldLabel);
//
//			Object inputValue = setGetBeanProperties.getBeanProperty(inputObject, inputField);
//			Object outputValue = setGetBeanProperties.getBeanProperty(outputObject, outputField);
//
//			assertThat(inputValue.toString().trim(), equalTo(outputValue.toString()));
//		}
//	}

	public void responseCodeShouldContainErrorMessage() {
		CommonPostResponseObject obj = SerenityRest.then().extract().body().as(CommonPostResponseObject.class);
		assertNotNull(obj.getErrors());
	}

	@Step
	public void checkResponseContent(String expectedContent) {		
		if (expectedContent.equalsIgnoreCase(ResponseConstant.SUCCESS_APPLICATION_CODE)) {
			responseCodeShouldBeEqual(expectedContent);
		} else if (expectedContent.equalsIgnoreCase(ResponseConstant.ERROR_APPLICATION_CODE)) {
			responseCodeShouldContainErrorMessage();
		}
	}

	@Step
	public String generateImage(String imageType, int width, int height) {
		String dataUri;
		String returnContent = null;
		if (imageType.equalsIgnoreCase("string")) {
			dataUri = Constant.TEXT_URI_SCHEMA;
			returnContent = dataUri + RandomStringUtils.random(100);
		} else {
			dataUri = Constant.IMAGE_URI_SCHEMA.replace("{imageType}", imageType);
			String fileName = imageType + width + "x" + height + "." + imageType;
			String imageContent = imageUtils.generateBase64ImageContent(fileName, imageType, width, height);
			returnContent = dataUri + imageContent;
		}
		
		return returnContent;
	}
	
	@Step
	public void checkBrandInternalCode(List<Integer> idList) {
		List<Object> brandList = database.findObjectListByIds(BrandModel.class, idList);
		List<String> internalCodeList = new ArrayList<String>();
		for (Object object : brandList) {
			BrandModel brandModel = (BrandModel)object;
			internalCodeList.add(brandModel.getInternal_code());
		}
		
		assertThat(false, equalTo(Helper.checkDuplicatedStringFromList(internalCodeList)));
	}
}
















