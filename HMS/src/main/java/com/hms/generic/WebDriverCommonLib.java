package com.hms.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	public void selectOption(WebElement element,int option) {
		Select  s=new Select(element);
		s.selectByIndex(option);	
		}
		public void selectOption(WebElement element,String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
		}
		public void selectOptionByValue(WebElement element,String value) {
			Select s=new Select(element);
			s.selectByValue(value);
		}
		public void mouseHover(WebDriver driver,WebElement target) {
			Actions a=new Actions(driver);
			a.moveToElement(target).perform();
		}
		public void scrollToParticularElement(WebDriver driver,WebElement element) {
			Actions a=new Actions(driver);
			a.scrollToElement(element).perform();
		}
		public void waitForElementToLoad(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
}
