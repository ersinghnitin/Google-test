package com.google.pages;

import org.openqa.selenium.*;


public class SignUp{
	private WebDriver wd;
	private By fName=By.xpath("//*[@id='FirstName']");
	private By lName=By.xpath("//*[@id='LastName']");
	private By uName=By.xpath("//*[@id='GmailAddress']");
	private By pass=By.xpath("//*[@id='Passwd']");
	private By cPass=By.xpath("//*[@id='PasswdAgain']");
	private By monthBtn=By.xpath("//*[@id='BirthMonth']/div[1]/div[2]");
	private By month=By.xpath("//*[@id=':1']");
	private By day=By.xpath("//*[@id='BirthDay']");
	private By year=By.xpath("//*[@id='BirthYear']");
	private By genderBtn=By.xpath("//*[@id='Gender']/div[1]/div[2]");
	private By gender=By.xpath("//*[@id=':f']");
	private By phone=By.xpath("//*[@id='RecoveryPhoneNumber']");
	private By email=By.xpath("//*[@id='RecoveryEmailAddress']");
	private By check=By.xpath("//*[@id='SkipCaptcha']");
	private By agreement=By.xpath("//*[@id='TermsOfService']");
	private By submit=By.xpath("//*[@id='submitbutton']");
	public SignUp(WebDriver wd){
		this.wd=wd;
	}

//### Fill form elements.###
	private void setFName(String strFName){
		wd.findElement(fName).sendKeys(strFName);
	}
	private void setLName(String strLName){
		wd.findElement(lName).sendKeys(strLName);
	}
	private void setUName(String strUName){
		wd.findElement(uName).sendKeys(strUName);;
	}
	private void setPass(String strPass){
		wd.findElement(pass).sendKeys(strPass);
	}
	private void setCPass(String strCPass){
		wd.findElement(cPass).sendKeys(strCPass);
	}
	private void clickMonthBtn(){
		wd.findElement(monthBtn).click(); 
	}
	private void setMonth(String strMonth){
		wd.findElement(month).click();
	}
	private void setDay(String strDay){
		wd.findElement(day).sendKeys(strDay);
	}
	private void setYear(String strYear){
		wd.findElement(year).sendKeys(strYear);	
	}
	private void clickGenderBtn(){
		wd.findElement(genderBtn).click();
	}
	private void setGender(String strGender){
		wd.findElement(gender).click();
	}
	private void setPhone(String strPhone){
		wd.findElement(phone).sendKeys(strPhone);
	}
	private void setEmail(String strEmail){
		wd.findElement(email).sendKeys(strEmail);
	}
	private void clickCheck(){
		wd.findElement(check).click();
	}
	private void clickAgreement(){
		wd.findElement(agreement).click();
	}
	private void clickSubmit(){
		wd.findElement(submit).click();
	}

//### public method exposed to test classs.
	public void fillDetails(String strFName,String strLName,String strUName,String strPass,String strCPass,String strMonth,String strDay,String strYear,String strGender,String strPhone,String strEmail){
		this.setFName(strFName);
		this.setLName(strLName);
		//this.setUName(strUName);
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