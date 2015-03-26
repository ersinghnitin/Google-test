package com.google.pages;

import org.openqa.selenium.*;


public class SignUp{
	public WebDriver wd;
	public By fName=By.xpath("//*[@id='FirstName']");
	public By lName=By.xpath("//*[@id='LastName']");
	public By uName=By.xpath("//*[@id='GmailAddress']");
	public By pass=By.xpath("//*[@id='Passwd']");
	public By cPass=By.xpath("//*[@id='PasswdAgain']");
	public By monthBtn=By.xpath("//*[@id='BirthMonth']/div[1]/div[2]");
	public By month=By.xpath("//*[@id=':1']");
	public By day=By.xpath("//*[@id='BirthDay']");
	public By year=By.xpath("//*[@id='BirthYear']");
	public By genderBtn=By.xpath("//*[@id='Gender']/div[1]/div[2]");
	public By gender=By.xpath("//*[@id=':f']");
	public By phone=By.xpath("//*[@id='RecoveryPhoneNumber']");
	public By email=By.xpath("//*[@id='RecoveryEmailAddress']");
	public By check=By.xpath("//*[@id='SkipCaptcha']");
	public By agreement=By.xpath("//*[@id='TermsOfService']");
	public By submit=By.xpath("//*[@id='submitbutton']");
	public By errMessage=By.xpath("//*[@id='errormsg_0_GmailAddress']");
	public WebElement message;
	public SignUp(WebDriver wd){
		this.wd=wd;
	}

	//### Fill form elements.###
	public void setFName(String strFName){
		wd.findElement(fName).sendKeys(strFName);
	}
	public void setLName(String strLName){
		wd.findElement(lName).sendKeys(strLName);
	}
	public void setUName(String strUName){
		wd.findElement(uName).sendKeys(strUName);;
	}
	public void setPass(String strPass){
		wd.findElement(pass).sendKeys(strPass);
	}
	public void setCPass(String strCPass){
		wd.findElement(cPass).sendKeys(strCPass);
	}
	public void clickMonthBtn(){
		wd.findElement(monthBtn).click(); 
	}
	public void setMonth(String strMonth){
		wd.findElement(month).click();
	}
	public void setDay(String strDay){
		wd.findElement(day).sendKeys(strDay);
	}
	public void setYear(String strYear){
		wd.findElement(year).sendKeys(strYear);	
	}
	public void clickGenderBtn(){
		wd.findElement(genderBtn).click();
	}
	public void setGender(String strGender){
		wd.findElement(gender).click();
	}
	public void setPhone(String strPhone){
		wd.findElement(phone).sendKeys(strPhone);
	}
	public void setEmail(String strEmail){
		wd.findElement(email).sendKeys(strEmail);
	}
	public void clickCheck(){
		wd.findElement(check).click();
	}
	public void clickAgreement(){
		wd.findElement(agreement).click();
	}
	public void clickSubmit(){
		wd.findElement(submit).click();
	}
	// Get error message
	public void errMessage(){
		message=wd.findElement(errMessage);
	}
	//### public method exposed to test classs.
	public void fillDetails(String strFName,String strLName,String strUName,String strPass,String strCPass,String strMonth,String strDay,String strYear,String strGender,String strPhone,String strEmail){
		this.setFName(strFName);
		this.setLName(strLName);
		this.setUName(strUName);
		this.setPass(strPass);
		this.setCPass(strCPass);
		this.clickMonthBtn();
		this.setMonth(strMonth);
		this.setDay(strDay);
		this.setYear(strYear);
		this.clickGenderBtn();
		this.setGender(strGender);
		this.setPhone(strPhone);
		this.setEmail(strEmail);
		this.clickCheck();
		this.clickAgreement();
		this.clickSubmit();
	}
}