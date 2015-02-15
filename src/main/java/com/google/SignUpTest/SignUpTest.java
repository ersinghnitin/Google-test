package com.google.SignUpTest;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		wd=new ChromeDriver();
		try{
			file=new FileInputStream("test.xlsx");
			workbook=new XSSFWorkbook(file);
		}catch(FileNotFoundException fnf){
			System.out.println("Excel file not found"+fnf);
		}catch(IOException ioe){
			System.out.println("File not read successfully"+ioe);
		}
		sheet=workbook.getSheet("Test");
		row=sheet.getRow(1);		
	}
	@Test
	public void signUp(){
		wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
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

		try{Thread.sleep(5000);}catch(InterruptedException ie){			
		}
		//calling method fill Details to fill required details on the page.
		signUp.fillDetails(row.getCell(0).toString(),row.getCell(1).toString(),
				row.getCell(2).toString(),row.getCell(3).toString(),row.getCell(4).toString(),
				row.getCell(5).toString(),row.getCell(6).toString(),row.getCell(7).toString(),
				row.getCell(8).toString(),row.getCell(9).toString(),row.getCell(10).toString());

		//waiting for alert message to appear
		try{Thread.sleep(5000);}catch(InterruptedException ie){			
		}

		WebElement alert=wd.findElement(By.cssSelector("html body div.wrapper div.signuponepage.main.content.clearfix div.clearfix div.sign-up div.signup-box form#createaccount.createaccount-form div#gmail-address-form-element.form-element.email-address div#username-errormsg-and-suggestions span#errormsg_0_GmailAddress.errormsg"));
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(),"You can't leave this empty.","Test Unsuccessful, String not found");

	}
	@AfterTest
	public void closeInstances(){
		try{
		file.close();
		}catch(IOException ioe){System.out.println("workbook not closed"+ioe);}
		//wd.close();
	}

}