package com.hms.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id="email")
    private WebElement EmailidTxtField;
    
    @FindBy(id="password")
    private WebElement passwordTxtField;
    
    @FindBy(xpath="//button[@type='submit']")
    private WebElement LoginBtn;
    
    public LoginPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }

    public void setLogin(String un,String pw) {
    	EmailidTxtField.sendKeys(un);
    	passwordTxtField.sendKeys(pw);
    	LoginBtn.click();
    }
    
    
	public WebElement getEmailidTxtField() {
		return EmailidTxtField;
	}

	public WebElement getPasswordTxtField() {
		return passwordTxtField;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}   
}
