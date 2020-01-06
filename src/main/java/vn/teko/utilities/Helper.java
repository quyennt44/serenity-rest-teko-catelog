package vn.teko.utilities;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import vn.teko.application.steps.DatabaseSteps;

public class Helper {
	@Steps
	DatabaseSteps database;
	
	public static boolean checkDuplicatedStringFromList(List<String> list) {
		boolean duplicated = false;
		Collections.sort(list);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1).equals(list.get(i))) {				
				duplicated = true;
				break;
			}
		}
		return duplicated;
	}
	
	public static JsonNode searchForEntity(JsonNode node, String entityName) {
	    // A naive depth-first search implementation using recursion. Useful
	    // **only** for small object graphs. This will be inefficient 
	    // (stack overflow) for finding deeply-nested needles or needles 
	    // toward the end of a forest with deeply-nested branches.
	    if (node == null) {
	        return null;
	    }
	    if (node.has(entityName)) {
	        return node.get(entityName);
	    }
	    if (!node.isContainerNode()) {
	        return null;
	    }
	    for (JsonNode child : node) {
	        if (child.isContainerNode()) {
	            JsonNode childResult = searchForEntity(child, entityName);
	            if (childResult != null && !childResult.isMissingNode()) {
	                return childResult;
	            }
	        }
	    }
	    // not found fall through
	    return null;
	}	
	
	public static JsonNode searchForEntityFromResponse(String nodeName) {
		ObjectMapper mapper = new ObjectMapper();

		String response = SerenityRest.then().extract().body().asString();
		JsonNode rootNode;
		try {
			rootNode = mapper.readTree(response);
			JsonNode nodeToFind = Helper.searchForEntity(rootNode, nodeName);
			
			return nodeToFind;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}	
	
	public static int getIdFromResponse() {
		JsonNode id = searchForEntityFromResponse(Constant.RESPONSE_ID_FIELD);
		return id.asInt();
	}
	
	public static String generateImage(String imageType, int width, int height) {
		ImageUtils imageUtils = new ImageUtils();
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

}
