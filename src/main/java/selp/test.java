package selp;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import org.openqa.selenium.*;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class test extends BaseTest {

	LoginPage lp;
	HomePage hp;
	CartPage cp;
	test tst;


	@BeforeTest 
	public void BrowserSetup() {
//		tst = new test();
//		tst.setup(null);

	}

	@BeforeMethod
	@Parameters({"browser"})
	public void BrowserLoginSetup(String browser ) {
		tst = new test();
		tst.setup(browser);
		lp = new LoginPage(tst.bdriver);
		lp.loginsetup();
	}

	 @Test(enabled = true)
	public void Valid_Login_Button() {
		//code
		lp.txtusername.sendKeys("standard_user");
		lp.txtpass.sendKeys("secret_sauce");
		lp.buttonlogin.click();
		assertEquals(lp.driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");	
	}

	 @Test(enabled = true)
	public void Valid_Login_Enter() {
		
		lp.txtusername.sendKeys("standard_user");
		lp.txtpass.sendKeys("secret_sauce");
		//code 
		lp.txtpass.sendKeys(Keys.ENTER);
		assertEquals("https://www.saucedemo.com/inventory.html",lp.driver.getCurrentUrl());	
	}

	 @Test(enabled = true)
	public void Invalid_Password() {
		lp.txtusername.sendKeys("standard_user");
		lp.txtpass.sendKeys("sadasdsad");
		lp.txtpass.sendKeys(Keys.ENTER);
		//code 
		assertEquals("Epic sadface: Username and password do not match any user in this service",lp.loginError().getText());


	}

	 @Test(enabled = true)
	public void Invalid_Username() {
		lp.txtusername.sendKeys("dsdfdsfsdfsdf");
		lp.txtpass.sendKeys("secret_sauce");
		lp.txtpass.sendKeys(Keys.ENTER);
		//code 
		assertEquals("Epic sadface: Username and password do not match any user in this service",lp.loginError().getText());
	}

	 @Test(enabled = true)
	public void Blank_Username() {
		lp.txtusername.sendKeys("");
		lp.txtpass.sendKeys("secret_sauce");
		lp.txtpass.sendKeys(Keys.ENTER);
		//code
		assertEquals("Epic sadface: Username is required",lp.loginError().getText());
	}

	 @Test(enabled = true)
	public void Blank_Password() {
		lp.txtusername.sendKeys("dsdfdsfsdfsdf");
		lp.txtpass.sendKeys("");
		lp.txtpass.sendKeys(Keys.ENTER);
		assertEquals("Epic sadface: Password is required",lp.loginError().getText());
		
	}

	 @Test(enabled = true)
	public void Add_to_Item_to_Cart() {

		lp.txtusername.sendKeys("standard_user");
		lp.txtpass.sendKeys("secret_sauce");
		lp.txtpass.sendKeys(Keys.ENTER);
		// Code
		hp = new HomePage(lp.driver);
		hp.Homesetup();
		hp.buttonAddtoCart.click();
		cp =  new CartPage(hp.driver);
		assertEquals("1",(cp.GetCartBadge().getText()));
	}

	 @Test(enabled = true)
	public void Remove_Item_from_Cart() {

		lp.txtusername.sendKeys("standard_user");
		lp.txtpass.sendKeys("secret_sauce");
		lp.txtpass.sendKeys(Keys.ENTER);
		hp = new HomePage(lp.driver);
		hp.Homesetup();
		hp.buttonAddtoCart.click();
		cp =  new CartPage(hp.driver);
		// Code 
		hp.cart.click();
		cp.Cartsetup2();
		cp.btnRemoveitem.click();
		
		assertThrows(NoSuchElementException.class,()->cp.GetCartBadge().getText());
		// or @Test(expectedExceptions = NoSuchElementException.class)
	}

	 @Test(enabled = true)
	public void Navigate_to_Homepage() {
		lp.txtusername.sendKeys("standard_user");
		lp.txtpass.sendKeys("secret_sauce");
		lp.txtpass.sendKeys(Keys.ENTER);
		hp = new HomePage(lp.driver);
		hp.Homesetup();
		hp.buttonAddtoCart.click();
		cp =  new CartPage(hp.driver);
		hp.cart.click();
		cp.Cartsetup2();
		cp.btnRemoveitem.click();
		// Code
		cp.btnContinue.click();
		assertEquals( cp.driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html" );	
	}

	 @Test(enabled = true)
	public void Logout() {
		lp.txtusername.sendKeys("standard_user");
		lp.txtpass.sendKeys("secret_sauce");
		lp.txtpass.sendKeys(Keys.ENTER);
		hp = new HomePage(lp.driver);
		hp.Homesetup();
		hp.buttonAddtoCart.click();
		cp =  new CartPage(hp.driver);
		hp.cart.click();
		cp.Cartsetup2();
		cp.btnRemoveitem.click();
		// Code
		cp.btnContinue.click();
		cp.Cartsetup3();
		cp.btnmenu.click();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//cp.btnLogout.click();
		cp.getLogoutbtn().click();
		assertEquals(cp.driver.getCurrentUrl(),"https://www.saucedemo.com/");	
	}


	@AfterMethod
	public void BrowserTearDown() {
		tst.tearDown();
	}










}
