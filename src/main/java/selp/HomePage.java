package selp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	protected WebDriver driver;
	protected WebElement buttonAddtoCart;
	protected WebElement cart;
	protected WebElement cartBadge;
	protected WebElement btnmenu;
	protected WebElement btnLogout;
	protected WebElement btnRemoveitem;
	protected WebElement btnContinue;

	HomePage(WebDriver ldriver ) {
		driver = ldriver;

	}
	void Homesetup() { 

		buttonAddtoCart = driver.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory "));
		cart = driver.findElement(By.className("shopping_cart_link"));
		//cartBadge = driver.findElement(By.className("shopping_cart_badge"));
	
		//btnRemoveitem = driver.findElement(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
		//btnContinue = driver.findElement(By.id("continue-shopping"));
		
	}
//	void Homesetup2() { 
//
//		
//		
//		btnRemoveitem = driver.findElement(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
//		btnContinue = driver.findElement(By.id("continue-shopping"));
//		
//	}



}
