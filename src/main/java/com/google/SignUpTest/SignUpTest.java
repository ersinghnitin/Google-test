package com.google.SignUpTest;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.pages.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
public class SignUpTest {
	public WebDriver wd;
	public FileInputStream file;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	WebElement message;

	@BeforeTest
	@Parameters("browser")
	public void init(String browser){
		if(browser.equalsIgnoreCase("firefox")){
			wd=new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			wd=new ChromeDriver();

		}else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			wd=new InternetExplorerDriver();
		} else {
			System.out.println("Browser not found. Kindly provide correct browser name");
		}
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		try{
			file=new FileInputStream("test.xlsx");
			workbook=new XSSFWorkbook(file);
		}catch(FileNotFoundException fnf){
			System.out.println("Excel file not found"+fnf);
		}catch(IOException ioe){
			System.out.println("File not read successfully"+ioe);
		}catch(TimeoutException toe){
			System.out.println("page load timed out");
		}
		sheet=workbook.getSheet("Test");
		row=sheet.getRow(1);		
	}

	@Test
	public void signUp(){

		//navigate to google uk page
		wd.navigate().to("https://www.google.co.uk/");
		wd.manage().window().maximize();
		//creating google search page object
		GoogleSearch gs=new GoogleSearch(wd);
		//calling google search method for clicking the link.
		GmailLogin gl=gs.clickGmailLink();
        if (!wd.getTitle().equals("Gmail")) {
            throw new IllegalStateException("Incorrect login page");
        }
		//calling method clickCreateAccount of login page and creating signup page object
		SignUp signUp=gl.clickCreateAccount();

		//calling method fill Details to fill required details on the page.
		signUp.fillDetails(row.getCell(0).toString(),row.getCell(1).toString(),
				row.getCell(2).toString(),row.getCell(3).toString(),row.getCell(4).toString(),
				row.getCell(5).toString(),row.getCell(6).toString(),row.getCell(7).toString(),
				row.getCell(8).toString(),row.getCell(9).toString(),row.getCell(10).toString());

		// check for error message- expected result
		if(isElementPresent(signUp.errMessage)){
			signUp.errMessage();
			Assert.assertEquals(signUp.message.getText(),"You can't leave this empty.","Test Unsuccessful, String not found");
		}
	}

	@AfterTest
	public void close(){
		try{
			file.close();
		}catch(IOException ioe){System.out.println("workbook not closed"+ioe);}
		//wd.close();
	}
	
	//finding element
	private boolean isElementPresent(By by) {
		try {
			wd.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}