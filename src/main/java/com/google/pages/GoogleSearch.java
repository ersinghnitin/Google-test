package com.google.pages;
import org.openqa.selenium.*;
public class GoogleSearch {
	private WebDriver wd;
	public GoogleSearch(WebDriver wd){
		this.wd=wd;
	}
	public Boolean clickGmailLink(){
		wd.manage().window().maximize();
		wd.findElement(By.linkText("Gmail")).click();
		return true;
	}
}
