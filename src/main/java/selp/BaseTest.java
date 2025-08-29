package selp;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public abstract class BaseTest {
	protected WebDriver bdriver ;



	public void setup(String Bn) {

		if (Bn.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:/Java+Selenium/workspace/Calculator/driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
	        // Disable the "credentials_enable_service" to prevent the "Save Password" prompt
	        prefs.put("credentials_enable_service", false);
	        // Disable the "profile.password_manager_enabled" to prevent the password manager from being enabled
	        prefs.put("profile.password_manager_enabled", false);
	        // Add the preferences to ChromeOptions
	        options.setExperimentalOption("prefs", prefs);
			options.addArguments("--start-maximized","--disable-gpu");
			bdriver = new ChromeDriver(options);
		}
		else 
		{
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			bdriver = new FirefoxDriver(options);


		}

	}
	public void tearDown() {

		bdriver.quit();


	}

}

