 package com.hms.generic;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.hms.pom.DoctorDashBoardPage;
import com.hms.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver ;
	FileLib f=new FileLib();
	@BeforeTest
	public void openBrowser() throws IOException {
		Reporter.log("Opening Browser", true);
		ChromeOptions options = new ChromeOptions();

HashMap<String, Object> prefs = new HashMap<>();

prefs.put("credentials_enable_service", false);
prefs.put("profile.password_manager_enabled", false);
prefs.put("profile.password_manager_leak_detection", false);

options.setExperimentalOption("prefs", prefs);

	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String url =f.getPropertyData("url");
        driver.get(url);   
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Closeing Browser", true);
	}
	@BeforeMethod
	public void login() throws IOException {
		String un =f.getPropertyData("doctor_username");
		String pwd = f.getPropertyData("password");
		LoginPage l = new LoginPage(driver);
		l.setLogin(un,pwd);
		Reporter.log("Login To the Application", true);
	}
	@AfterMethod
	public void logout() {
		Reporter.log("Logged out of the Application", true);
		DoctorDashBoardPage d=new DoctorDashBoardPage(driver);
		d.setLogOutBtn();
	}
}
