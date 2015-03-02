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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
public class SignUpTest {
	public WebDriver wd;
	public FileInputStream file;
	Workbook workbook;
	Sheet sheet;
	Row row;
	Cell cell;

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

		//creating google search page object
		GoogleSearch gs=new GoogleSearch(wd);
		//calling google search method for clicking the link.
		Assert.assertTrue(gs.clickGmailLink(),"Page loaded successfully");

		//creating login page object
		GmailLogin gl=new GmailLogin(wd);
		//calling method clickCreateAccount of login page
		gl.clickCreateAccount();

		//creating signup page object
		SignUp signUp=new SignUp(wd);
		//calling method fill Details to fill required details on the page.
		signUp.fillDetails(row.getCell(0).toString(),row.getCell(1).toString(),
				row.getCell(2).toString(),row.getCell(3).toString(),row.getCell(4).toString(),
				row.getCell(5).toString(),row.getCell(6).toString(),row.getCell(7).toString(),
				row.getCell(8).toString(),row.getCell(9).toString(),row.getCell(10).toString());

		// check for error message- expected result
		Assert.assertEquals(signUp.errMessage(),"You can't leave this empty.","Test Unsuccessful, String not found");
		
	}

	@AfterTest
	public void close(){
		try{
			file.close();
		}catch(IOException ioe){System.out.println("workbook not closed"+ioe);}
		//wd.close();
	}

}