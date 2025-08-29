package selp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	protected WebDriver driver;
	protected WebElement buttonAddtoCart;
	protected WebElement cart;
	protected WebElement cartBadge;
	protected WebElement btnmenu;
	protected WebElement btnLogout;
	protected WebElement btnRemoveitem;
	protected WebElement btnContinue;

	CartPage(WebDriver ldriver ) {
		driver = ldriver;

	}

	WebElement GetCartBadge() { 


		return driver.findElement(By.className("shopping_cart_badge"));


	}
	void Cartsetup2() { 


		btnRemoveitem = driver.findElement(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
		btnContinue = driver.findElement(By.id("continue-shopping"));


	}
	void Cartsetup3() {

		btnmenu = driver.findElement(By.id("react-burger-menu-btn"));
	
	}
	WebElement getLogoutbtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return  wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
	
	}
}
