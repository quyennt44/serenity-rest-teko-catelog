package vn.teko.test.application.stepdefinitions.common;

import cucumber.api.java.After;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import vn.teko.application.steps.CommonSteps;
import vn.teko.application.steps.DatabaseSteps;
import vn.teko.utilities.Constant;
import vn.teko.utilities.DataKeeper;

public class TearDown {

	@Steps
	DatabaseSteps database;


	@Steps
	CommonSteps commonSteps;

//	@After
//	public void tidyUp() {
//		System.out.println("Deleting...");
//		
//		Class<?> className = (Class<?>) Serenity.getCurrentSession().get(Constant.DATABASE_MODEL_CLASS_VARIABLE);
//		
//		DataKeeper dataKeeper = (DataKeeper) commonSteps.retrieveObject("dataKeeper");
//		if (dataKeeper != null && dataKeeper.getIdList().size() > 0) {
//			database.deleteObjectsByIds(className, dataKeeper.getIdList());
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	}
}
