package com.vtiger.comcast.gereriUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtilfiy {
/*
 * its used to read the data from commondata.Properties file based on key which you pass as an argments 
 * @param key
 * @throws Throwable
 * 
 */
	
	public String getPropertykeyvalue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./property/commondata.txt");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
}
