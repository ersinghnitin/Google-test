package com.google.pages;
import org.openqa.selenium.*;
public class GoogleSearch {
	private WebDriver wd;
	public GoogleSearch(WebDriver wd){
		this.wd=wd;
	}
	public void clickGmailLink(){
		wd.manage().window().maximize();
		wd.findElement(By.linkText("Gmail")).click();
	}
}
