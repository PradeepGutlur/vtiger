package com.vtiger.comcast.gereriUtility;
/*
 * this class contain Webdriver specific generic method
 * pradeep g v 
 */

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
/*
 *This method wait for 20 sec for page loading  
 * @param driver
 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/*
	 * This method wait for the element to be visiable 
	 * @param driver 
	 * @param element 
	 * 
	 */
	
	public void waitforElementVisibility(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/*
	 * This method wait for the element to be clickd , itd custom wait created to aviod elementinterAceptableException
	 * @param element 
	 * @Throws Throwable 
	 */
	
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count = 0;
		while(count<20) {
				try {
					element.click();
					break;
				}
				catch(Throwable e )
				{
					Thread.sleep(1000);
					count++;	
				}
	}
	}
	/*
	 * This method enables user to handle dropdown using visible text 
	 * @param element 
	 * @param option 
	 * 
	 */
	public void select(WebElement element,String option)
	{
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}
	/*
	 * this method enables user to handle dropdown using index
	 * @param element
	 * @param index
	 * 
	 */
	public void select(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/*
	 * This methos will perfrom mouse over action
	 * @param
	 * @param element
	 * 
	 * 
	 */
	public void mouseover(WebDriver driver,WebElement element )
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/*This method perform rigth click opertion
	 * @param driver
	 * @param element 
	 * 
	 * 
	 */
	public void rigthclick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/*This method helps to switch from one window to another 
	 * @param driver
	 * @param partialWinTitle
	 * 
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle )
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			
			if(title.contains(partialWinTitle))
			{
				break;
			}
			
		}
	}
	
		/*
		 * This method will switch to alert popup
		 * Accept alert
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		/*This method will switch to alter popup
		 * cancel alert
		 * @param driver
		 * 
		 * 
		 */
		public void cancelAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		/*
		 * this method used for scrolling action in a webpage
		 * @paran driver
		 * @param element
		 * 
		 */
		public void scrolltoWebElement(WebDriver driver, WebElement element)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			int y = element.getLocation().getY();
			jse.executeScript("window.scrollby(o,"+y+")",element);
			
		}
		public void switchframe(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
		}
		public void switchframe(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}
		public void switchframe(WebDriver driver, String idOrName)
		{
			driver.switchTo().frame(idOrName);
			
		}
		public void takeScreenshot(WebDriver driver, String screenshotName) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshot/"+screenshotName+".PNG");
			Files.copy(src, dest);
		}
		/*
		 * this
		 * @param driver
		 * 
		 */
		public void passEnterKey(WebDriver driver)
		{
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
		}
		
}

