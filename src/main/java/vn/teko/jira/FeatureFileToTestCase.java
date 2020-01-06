package vn.teko.jira;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @author: QuyenNT
 * Read a feature file then get the scenario name as test case name; 
 * And get the feature steps as description for test case 
 */

public class FeatureFileToTestCase {	
	
//	public static void main(String str[]) {
//		String basePath = Configuration.getBaseFeaturePath();
//		String file = basePath + "/brand/BrandCreation.feature";
//		FeatureFileToTestCase t = new FeatureFileToTestCase();
//		String content = t.readFeatureFile(file);	
//		List stepObject = t.buildGherkinSteps(content);
//		for (Object object : stepObject) {
//			GherkinSteps obj = (GherkinSteps)object;
//			System.out.println("Name=\n" + obj.getName());
//			System.out.println("Step=\n" + obj.getStep());
//		}
//	}

	public String readFeatureFile(String featureFile) {
	    Path fpath= Paths.get(Configuration.getBaseFeaturePath() + featureFile).toAbsolutePath();
	    String content = "";	    
	    try {

	    	content = Files.lines(fpath)
	              .map(s -> s.trim())
	              .filter(s -> Stream.of(Configuration.FEATURE_KEYWORDS).anyMatch(s::startsWith))	            		  
	              .collect(Collectors.joining("\n"));	    	
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (RuntimeException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return content;
	}
	
	/*
	 * Return a list of Scenario with name and steps
	 */
	public List<ScenarioContent> buildScenarioContent(String content){
		List<ScenarioContent> scenarioContentList = new ArrayList<ScenarioContent>();
    	String[] splitted = Stream.of(content.split("Scenario:")).filter(w -> !w.isEmpty()).toArray(String[]::new);
    	
    	for (String str : splitted) {
			String name = str.substring(0,str.indexOf("\n")).trim();
			String step = str.substring(str.indexOf("\n"), str.length()).trim();
			
			ScenarioContent stepObject = new ScenarioContent();
			stepObject.setScenarioName(name);
			stepObject.setStepDescription(step);	
			scenarioContentList.add(stepObject);
		}	                		
    	
    	return scenarioContentList;
	}

}
