package com.b2c.asianpaints.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.b2c.asianpaints.Utilites.XLUtils;
import com.b2c.asianpaints.pageObjects.HomePage;

public class Wall_Stickers extends BaseClass {

	@Test(priority = 1)
	public void NavigationWallStickers() throws InterruptedException, IOException {
		
		HomePage homepage = new HomePage(driver);
		Actions action = new Actions(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		logger.info("Site Navigation");
		
		action.moveToElement(homepage.mouseoverShop()).build().perform();
		logger.info("Hover Mouse on Shop Element");
		Thread.sleep(3000);
		
		homepage.WallStickersLink();
		logger.info("Click on WallStickers Link");
		
		
		js.executeScript("window.scrollBy(550,620)", "");
		Thread.sleep(3000);
		
		if (homepage.getWallStickersTitle().equalsIgnoreCase("Wall Stickers")) {
			Assert.assertTrue(true);
			logger.info("NavigationWallStickers Passed");

		} else {
			captureScreen(driver, "TC_Navigation_Wall_Stickers_PLP_001");
			Assert.assertTrue(false);
			logger.warn("NavigationWallStickers Failed");
			captureScreen(driver, "NavigationWallStickers");
		}
	}

	@Test(priority = 2,dataProvider = "Valid_Pincode_PLP")
	public void AddToCart_PLP_ValidInputs(String pincode, String value) throws InterruptedException, IOException {
		
		HomePage homepage = new HomePage(driver);
		homepage.clickAddtoCartPlppage();
		logger.info("Click on AddToCart in PLP Page");
		homepage.setPincodePlpPage(value);
		Thread.sleep(2000);
		logger.info("Pincode Entered");
		Thread.sleep(2000);
		homepage.PlpPageSubmitPincode();
		logger.info("Pincode Submitted PLP Page");
		Thread.sleep(3000);

		boolean msg = homepage.AddToCartMsgPLPPage().equalsIgnoreCase("Product successfully added to cart."); 
		if (msg==true) 
		{
			Assert.assertTrue(true);
			logger.info("AddToCart_Wall_Stickers_PLP Passed");
		} else {
			Assert.assertTrue(false);
			logger.warn("AddToCart_Wall_Stickers_PLP Failed");
			captureScreen(driver, "AddToCart_Wall_Stickers_PLP");
		}
	}
	
	@DataProvider(name="Valid_Pincode_PLP")
	String [][] getDataValid_Pincode_PLP() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/b2c/asianpaints/testData/Wall_Stickers.xlsx";
		int rownum = XLUtils.getRowCount(path, "Valid_Pincode");
		int colcount = XLUtils.getCellCount(path, "Valid_Pincode", 1);
		
		String pincode[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) 
		{
			for(int j=0;j<colcount;j++) 
			{
				pincode[i-1][j] = XLUtils.getCellData(path, "Valid_Pincode", i, j);
			}
		}
		return pincode;
	}
	

	@Test(priority = 3,dataProvider = "InValid_Pincode_PLP")
	public void AddToCart_PLP_InValidInputs(String pincode, String value) throws IOException, InterruptedException {
		HomePage homepage = new HomePage(driver);
		
		driver.navigate().refresh();
		Thread.sleep(6000);
		homepage.clickEditPincodeButtonPlpPage();
		logger.info("Click on Edit button for Pincode in PLP Page");
		Thread.sleep(2000);
		homepage.clearPincodeTextboxPLPPage();
		Thread.sleep(2000);
		homepage.setPincodePlpPage(value);
		logger.warn("Invalid Pincode Entered");
		Thread.sleep(2000);
		homepage.PlpPageSubmitPincode();
		logger.info("Pincode Submitted PLP Page");
		homepage.clickAddtoCartPlppage();
		Thread.sleep(3000);
		
		boolean errormsg= homepage.AddToCartMsgPLPPage().equalsIgnoreCase("The pincode entered is not serviceable for this product");
		if(errormsg==true) 
		{
			logger.warn("AddToCart_Wall_Stickers_PLP Failed");
			captureScreen(driver, "AddToCart_PLP_InValidInputs");
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("AddToCart_Wall_Stickers_PLP Passed");
		}
	}
	
	@DataProvider(name="InValid_Pincode_PLP")
	String [][] getDataInValid_Pincode_PLP() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/b2c/asianpaints/testData/Wall_Stickers.xlsx";
		int rownum = XLUtils.getRowCount(path, "InValid_Pincode");

		int colcount = XLUtils.getCellCount(path, "InValid_Pincode", 1);

		String pincode[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) 
		{
			for(int j=0;j<colcount;j++) 
			{
				pincode[i-1][j] = XLUtils.getCellData(path, "InValid_Pincode", i, j);
			}
		}
		return pincode;
	}	
	
	
	@Test(priority = 4)
	public void InvalidPincodeCheckAvailbilityPDPPage() throws IOException, InterruptedException {
		
		HomePage homepage = new HomePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		homepage.getFirstProductPLPPage();
		logger.info("Click on First Product PLP Page.");
		Thread.sleep(3000);
		
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 
		 js.executeScript("window.scrollBy(100,250)", "");
		 Thread.sleep(3000);
		
		homepage.clickCheckButtonPDPPage();
		logger.info("Click on Check Button PDP Page");
		Thread.sleep(3000);
		
		boolean errormsg = homepage.getErrorMsgPincodePDPPage().equalsIgnoreCase("This Pin Code is not Serviceable.");
		if(errormsg==true)
		{
			logger.warn("Pincode Entered Wrong");
			captureScreen(driver.switchTo().window(tabs.get(1)), "InvalidPincodeCheckAvailbilityPDPPage");
			Assert.assertTrue(false);
			logger.info(homepage.getErrorMsgPincodePDPPage());
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Pincode Enter Right");
		}
	}

	@Test(priority = 5,dataProvider = "Valid_Pincode_PLP")
	public void ValidPincodePDPPage(String pincode, String value) throws InterruptedException, IOException {
		HomePage homepage = new HomePage(driver);
	
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		
		homepage.clearPincodeFieldPDPPahge();
		Thread.sleep(3000);
		homepage.setValidPincodePDPPage(value);
		logger.info("Valid Pincode Enter");
		Thread.sleep(1000);
		homepage.clickCheckButtonPDPPage();
		logger.info("Click on Check Button PDP Page");
		Thread.sleep(3000);
		
		if(homepage.getErrorMsgPincodePDPPage().equalsIgnoreCase("This pin Code is Serviceable"))
		{
			logger.info("Pincode availbility check successfully");
			Assert.assertTrue(true);
			tabs.clear();
		}
		else
		{
			Assert.assertTrue(false);
			logger.warn("Pincode is not correct");
			captureScreen(driver.switchTo().window(tabs.get(1)), "ValidPincodePDPPage");
		}
	}

	@Test(priority = 6)
	public void AddToCartPDPPage() throws IOException, InterruptedException {
		
		HomePage homepage = new HomePage(driver);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		
		homepage.clickAddToCartPDPPage();
		logger.info("Click on Add to cart on PDP Page");
		Thread.sleep(3000);
		
		if(homepage.AddToCartMsgPDPPage().equalsIgnoreCase("Added To Cart Successfully. continue shopping")) {
			Assert.assertTrue(true);
			logger.info("Product added to cart");
			tabs.clear();
		}
		else {
			Assert.assertTrue(false);
			captureScreen(driver.switchTo().window(tabs.get(1)), "AddToCart");
		}
	}
	
	@DataProvider(name="LoginData1")
	String [][] getLoginData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/b2c/asianpaints/testData/Wall_Stickers.xlsx";
		int rownum = XLUtils.getRowCount(path, "LoginData2");
		System.out.println(rownum);
		int colcount = XLUtils.getCellCount(path, "LoginData2", 1);
		System.out.println(colcount);
		
		String loginDataCheckout[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) 
		{
			for(int j=0;j<colcount;j++) 
			{
				loginDataCheckout[i-1][j] = XLUtils.getCellData(path, "LoginData2", i, j);
			}
		}
		return loginDataCheckout;
	}
	
	/*
	 * @Test(priority = 7,dataProvider = "LoginData1")
	public void checkoutPage(String Mob, String Otp) throws IOException, InterruptedException {
		HomePage homepage = new HomePage(driver);
		ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		
		homepage.clickOnMiniCart();
		logger.info("Click on MiniCart");
		Thread.sleep(3000);
		
		homepage.clickOnCheckout();
		logger.info("Click on Checkout Button");
		Thread.sleep(3000);
		
		homepage.setMobileNo(Mob);
		logger.info("Mobile Number entered");
		Thread.sleep(3000);
		
		homepage.submitMobileNo();
		logger.info("Mobile number submitted");
		Thread.sleep(3000);
		
		homepage.setOTP(Otp);
		logger.info("OTP Entered");
		Thread.sleep(3000);
		
		homepage.submitOTP();
		logger.info("OTP Submitted");
		Thread.sleep(5000);
		
		if (isProductImagePresent()==true) {
			Assert.assertTrue(true);
			logger.info("Login Successfully. on Checkout Page");
			
		} else {
			Assert.assertTrue(false);
			logger.warn("Navigation to checkout page failed.");
			captureScreen(driver.switchTo().window(tabs.get(1)), "checkoutPage");
		}
		tabs.clear();
	}
	
	public boolean isProductImagePresent() {
		HomePage homepage = new HomePage(driver);
		ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		boolean display = homepage.getProductImgCheckoutPage().isDisplayed();
		tabs.clear();
		System.out.println(display);
		return display;
	}
	
	*/
	
}

