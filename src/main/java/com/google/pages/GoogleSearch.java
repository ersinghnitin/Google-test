package com.google.pages;
import org.openqa.selenium.*;
public class GoogleSearch {
	private WebDriver wd;
	public GoogleSearch(WebDriver wd){
		this.wd=wd;
	}
	public GmailLogin clickGmailLink(){
		wd.findElement(By.linkText("Gmail")).click();
		return new GmailLogin(wd);
	}
}
