package vn.teko.application.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import vn.teko.utilities.Constant;
import vn.teko.utilities.Helper;
import vn.teko.utilities.RandomString;

public class CommonSteps {
	@Steps
	SetGetBeanProperties setGetBeanProperties;
	
	@Steps
	DatabaseSteps database;

//	@Step
	public void storeStringData(String variable, String type, boolean letter, boolean number, int length) {
		String variableValue = RandomString.generateSpecialRandomString(type, letter, number, length);
		Serenity.getCurrentSession().put(variable, variableValue);
	}

//	@Step
	public void storeObject(String variable, Object object) {
		Serenity.getCurrentSession().put(variable, object);
	}
	
	public Object retrieveObject(String variable) {
		Object object = Serenity.getCurrentSession().get(variable);
		return object;
	}

	@Step
	public void changeValueOfStringVariable(String variable, String type) {
		Object oldValue = Serenity.getCurrentSession().get(variable);
		String newValue = null;

		switch (type) {
		case Constant.REMOVE_DIACRITIC_MARK:
			newValue = StringUtils.stripAccents(oldValue.toString());
			break;

		case Constant.UPPER_CASE:
			newValue = StringUtils.upperCase(oldValue.toString());
			break;

		case Constant.LOWER_CASE:
			newValue = StringUtils.lowerCase(oldValue.toString());
			break;
		}

		Serenity.getCurrentSession().put(variable, newValue);
	}

	@Step
	public Object removeFieldFromObject(Object object, String paramToRemove) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.valueToTree(object);
		((ObjectNode) node).remove(paramToRemove);
		try {
			object = mapper.treeToValue(node, Object.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	@Step
	public Object removeFieldFromObjectAndStoreToVariable(Object object, String paramToRemove) {
		// Get existing object instance
		Object oldObject = Serenity.getCurrentSession().get(object);
		// Remove node from current instance
		Object newObject = null;
		if(oldObject!= null)
			newObject = removeFieldFromObject(oldObject, paramToRemove);
		else
			newObject = removeFieldFromObject(object, paramToRemove);
		// Put object back to session
		Serenity.getCurrentSession().put(object, newObject);
		return newObject;
	}

//	@Step
	public void compareDataToDatabase(Object inputObject, Object outputObject, List<Map<String, String>> fields,
			String inputFieldLabel, String outputFieldLabel) {
		
		String reportContent = inputFieldLabel + "|" + outputFieldLabel + "\n";
		
		for (Map<String, String> field : fields) {
			String inputField = field.get(inputFieldLabel);
			String outputField = field.get(outputFieldLabel);

			Object inputValue = setGetBeanProperties.getBeanProperty(inputObject, inputField);
			Object outputValue = setGetBeanProperties.getBeanProperty(outputObject, outputField);

			reportContent += inputValue.toString() + "|" + outputValue.toString() + "\n";
			
			assertThat(inputValue.toString().trim(), equalTo(outputValue.toString()));					                        
		}
		
		
		Serenity.recordReportData().withTitle("Show data").andContents(reportContent);	
	}

	@Step
	public void responseShouldContainNode(String nodeName) {
		assertNotNull(Helper.searchForEntityFromResponse(nodeName));
	}
	
	@Step
	public void responseNodeValueShouldBe(String nodeName, String nodeValue) {
		JsonNode node = Helper.searchForEntityFromResponse(nodeName);		
		assertTrue(nodeValue.equalsIgnoreCase(node.toString().replace("\"", "")));
	}
	
	
}
