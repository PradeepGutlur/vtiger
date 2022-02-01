
package com.vtiger.comcast.gereriUtility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListImp implements ITestListener{
public void onTestFailure(ITestResult result1) {
		String failedTestName = result1.getMethod().getMethodName();

		EventFiringWebDriver edriver = new EventFiringWebDriver(basic_annotations.sdriver);
	
		File src = edriver.getScreenshotAs(OutputType.FILE);
		String systemDate = new Date().toString().replace(":", "_").replace(" ", "_");
		File dest = new File("./screenShot/"+failedTestName+"_"+systemDate+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			
		}

	}

}
