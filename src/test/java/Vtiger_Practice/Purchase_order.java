package Vtiger_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Purchase_order {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Throwable {
		
		FileInputStream f = new FileInputStream("./property/commondata.txt");
		Properties p = new Properties();
		p.load(f);
		
		String url = p.getProperty("url");
		
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		 String bowser = p.getProperty("bowser");
		FileInputStream fi = new FileInputStream("./property/testcase.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet("sheet1");
		String subject = sh.getRow(4).getCell(1).getStringCellValue();
	 	//String vendor = sh.getRow(5).getCell(1).getStringCellValue();
	 	String ba = sh.getRow(6).getCell(1).getStringCellValue();
	 	 String sa = sh.getRow(7).getCell(1).getStringCellValue();
	 	 
	 	
		
		WebDriver driver = null;
		if(bowser.contentEquals(bowser))
		{
			driver = new ChromeDriver();
		}
		else if(bowser.contentEquals(bowser))
		{
			driver = new FirefoxDriver();
			
		}
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		WebElement ele = driver.findElement(By.xpath("(//a[@href='javascript:;'])[1]"));
		
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.name("Purchase Order")).click();
		driver.findElement(By.xpath("//img[@alt='Create Purchase Order...']")).click();
		driver.findElement(By.name("subject")).sendKeys(subject);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		
		
		
		String Parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for( String all:child) {
			driver.switchTo().window(all);
			if (all==Parent) {
			}	
		}
		driver.findElement(By.id("2")).click();
		for(String all:child) {
			driver.switchTo().window(Parent);
		}
		WebElement select = driver.findElement(By.name("postatus"));
		Select sc = new Select(select);
	    sc.selectByIndex(1);
		driver.findElement(By.name("bill_street")).sendKeys(ba);
	    driver.findElement(By.name("ship_street")).sendKeys(sa);
		
		driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
		
		Set<String> ch = driver.getWindowHandles();
		Iterator<String> pa = ch.iterator();
		String parentwindow = pa.next();
		String childwindow = pa.next();
		driver.switchTo().window(childwindow);
		driver.findElement(By.xpath("//a[text()='abcd1234']")).click();
		driver.switchTo().window(parentwindow);
		driver.findElement(By.id("qty1")).sendKeys("1");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Actions b = new Actions(driver);
		
		b.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("(//a[@class='drop_down_usersettings'])[2]")).click();
		driver.close();
		
	
		
		
		
	
	}

}
