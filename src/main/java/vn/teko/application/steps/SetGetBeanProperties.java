package vn.teko.application.steps;

import java.beans.Expression;
import java.beans.Statement;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import vn.teko.utilities.Constant;

public class SetGetBeanProperties {
	@Step
	public Object setBeanProperty(Object object, String fieldName, Object value, int ... length) {
		String setter = "set" + StringUtils.capitalize(fieldName.replace("'", "").replace("\"", ""));		
		Statement stmt = null;
		
		switch(value.toString()) {
			case Constant.NULL_VALUE:
				stmt = new Statement(object, setter, new Object[]{null});
				break;
				
			case Constant.EMPTY_VALUE:
				stmt = new Statement(object, setter, new Object[]{""});	
				break;
				
			case Constant.SPACES_ONLY_VALUE:
				stmt = new Statement(object, setter, new Object[]{"                   "});
				break;
				
			case Constant.LEADING_ENDING_SPACES_VALUE:				
				stmt = new Statement(object, setter, new Object[]{"           " + RandomStringUtils.random(length[0], RandomStringUtils.random(100, true, false)) + "                    "});				
				break;
				
			case Constant.CONTAIN_SPACE_VALUE:
				stmt = new Statement(object, setter, new Object[]{RandomStringUtils.random(length[0], RandomStringUtils.random(50, true, false) + Constant.SPACE_CHARACTERS)});		
				break;
				
			case Constant.CONTAIN_SPECIAL_CHARACTERS_VALUE:
				stmt = new Statement(object, setter, new Object[]{RandomStringUtils.random(length[0], RandomStringUtils.random(100, true, false) + Constant.SPECIAL_CHARACTERS)});					
				break;
				
			case Constant.RANDOM_STRING_VALUE:
				stmt = new Statement(object, setter, new Object[]{RandomStringUtils.random(length[0], RandomStringUtils.random(length[0], true, false))});				
				break;
			case Constant.RANDOM_DIACRITIC_MARK:
				stmt = new Statement(object, setter, new Object[]{RandomStringUtils.random(length[0], RandomStringUtils.random(100, true, false) + Constant.UNICODE_CHARACTERS)});					
				break;			
			default:
				stmt = new Statement(object, setter, new Object[]{value});						
		}
		try {
			stmt.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		return object;
	}
	
	@Step
	public void changeObjectValue(String objectName, String fieldName, Object value, int ... length) {	
		Object obj = Serenity.getCurrentSession().get(objectName);
		
		obj = setBeanProperty(obj, fieldName, value, length);

		//Put object back to session
		Serenity.getCurrentSession().put(objectName, obj);
	}	
	
//	@Step
	public Object setBeanPropertyWithVariable(Object object, String fieldName, String variable) {
		String setter = "set" + StringUtils.capitalize(fieldName.replace("'", "").replace("\"", ""));
		
		Object value = Serenity.getCurrentSession().get(variable);
		
		Statement stmt = null;
		
		stmt = new Statement(object, setter, new Object[]{value});						
		
		try {
			stmt.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object;
	}	
	
	@Step
	public void changeObjectWithVariable(String objectName, String fieldName, String variable) {	
		Object obj = Serenity.getCurrentSession().get(objectName);
		
		obj = setBeanPropertyWithVariable(obj, fieldName, variable);

		//Put object back to session
		Serenity.getCurrentSession().put(objectName, obj);
	}		
	
	public Object getBeanProperty(Object object, String fieldName) {
		String getter = "get" + StringUtils.capitalize(fieldName.replace("'", "").replace("\"", ""));		
		Expression expression = new Expression(object, getter, new Object[0]);	
		Object returnedObject = null;
		try {
			expression.execute();
			returnedObject = (Object)expression.getValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnedObject;		
	}
	
	
	 
}
