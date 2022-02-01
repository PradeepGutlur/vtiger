package com.vtiger.comcast.gereriUtility;

import org.apache.commons.io.file.Counters.Counter;
import org.testng.ITestResult;

public class RetryImpClass {
	int counter=0;
	int retrylimit = 4;
	
	public boolean retry(ITestResult result)
	{
		if (counter<retrylimit)
		{
			counter++;
		return true;
	}
	
		return false;
		
	}

	
}
