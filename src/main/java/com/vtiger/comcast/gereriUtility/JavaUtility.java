package com.vtiger.comcast.gereriUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/*
 * this class contains java specific generic libraries
 * @author pradeep G V 
 */

public class JavaUtility {
	/*
	 * its used to generate the interger random number with in the boundary of 0 to 1000
	 * @return int Data
	 */
	
	public int getRandomNumber()
	{
		Random radom = new Random();
		int randomNum = radom.nextInt(1000);
		return randomNum;
		
	}
	/*
	 * itd use to get current system date and time
	 * @return
	 */
	public String getsystemDate()
	{
		Date date = new Date();
		String systemdateandtime = date.toString();
		return systemdateandtime;
	}
	
	/*
	 * its used to get the current system date with YYYY MM DD formate
	 * @return
	 */
	
	public String getsystemdate_YYYY_MM_DD()
	{
		Date date = new Date();
		String systemdateandtime = date.toString();
		System.out.println(systemdateandtime);
		String[] arr = systemdateandtime.split(" ");
		String DD = arr[2];
		String YYYY = arr[5];
		int MM = date.getMonth()+1;
		String finalformat = YYYY+" "+MM+" "+DD;
		return finalformat;
		}
	public void pressvirtualenterkey() throws AWTException
	{
	Robot ra = new Robot();
	ra.keyPress(KeyEvent.VK_ENTER);
	ra.keyRelease(KeyEvent.VK_ENTER);
	
	}

}

