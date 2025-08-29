package selp;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;

public class LoginPage {
	protected WebDriver driver;
	protected WebElement  txtusername;
	protected WebElement txtpass;
	protected WebElement buttonlogin;
	protected WebElement msgError;

	LoginPage(WebDriver ldriver ) {
		driver = ldriver;

	}
	void loginsetup() { 

		driver.get("https://www.saucedemo.com/");
		txtusername = driver.findElement(By.id("user-name"));
		txtpass = driver.findElement(By.id("password"));
		buttonlogin = driver.findElement(By.id("login-button"));

	}
	WebElement loginError() {
		return msgError = driver.findElement(By.xpath("//form/div[contains(@class,'error-message-container')]/h3"));
				
	}



}
