package vn.teko.test.application.stepdefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	private String a;
	private String b;
	private ArrayList c;
	
	

	public String getA() {
		return a;
	}



	public void setA(String a) {
		this.a = a;
	}



	public String getB() {
		return b;
	}



	public void setB(String b) {
		this.b = b;
	}
	
	


	public ArrayList getC() {
		return c;
	}



	public void setC(ArrayList c) {
		this.c = c;
	}



	private JsonNode searchForEntity(JsonNode node, String entityName) {
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
	
	public static void main(String str[]) {
		Test test = new Test();
		test.a = "A value";
		test.b= "B value";
		
		ArrayList list = new ArrayList();
		HashMap map = new HashMap();
		map.put("c1", "c1 value");
		map.put("c2", "c2 value");
		list.add(map);
		
		test.c = list;
		
		 ObjectMapper Obj = new ObjectMapper(); 
		  
	        try { 
	  
	            // get Oraganisation object as a json string 
	            String jsonStr = Obj.writeValueAsString(test); 
	  
	            // Displaying JSON String 
	            System.out.println(jsonStr); 
	            
	            JsonNode actualObj = Obj.readTree(jsonStr);
	            System.out.println(test.searchForEntity(actualObj, "c1"));
	            System.out.println(test.searchForEntity(actualObj, "a"));
	            System.out.println(test.searchForEntity(actualObj, "d"));
	        } 
	  
	        catch (IOException e) { 
	            e.printStackTrace(); 
	        } 

	       
	}
}
