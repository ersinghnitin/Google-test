package com.google.pages;

import org.openqa.selenium.*;
public class GmailLogin {
	private WebDriver wd;
	public GmailLogin(WebDriver wd){
		this.wd=wd;
	}
	public SignUp clickCreateAccount(){
		wd.findElement(By.xpath("//*[@id='link-signup']")).click();
		return new SignUp(wd);
	}
	
	
}
