package com.b2c.asianpaints.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="//div[@id='headerNav']/div[1]/ul/li[6]/a[2]/span[1]")
	@CacheLookup
	WebElement Shop;

	@FindBy(how = How.XPATH, using="//div[@id='SHOP']/div[2]/div/div/div[2]/div/div/a")
	@CacheLookup
	WebElement WallStickers;

	@FindBy(how = How.XPATH, using="//h2[@class='h2 section-header']")
	@CacheLookup
	WebElement WallStickersTitlePLPPage;

	@FindBy(how = How.XPATH, using="//div[@class='tab-pane active']/div[1]/div/div/ul/li[1]/div[2]/a/span[1]")
	@CacheLookup
	WebElement AddToCartPLPPage;
	
	@FindBy(how = How.XPATH, using="//input[@name='CART_PINCODE']")
	@CacheLookup
	WebElement PincodePLPPage;
	
	@FindBy(how = How.XPATH, using = "//form[@name='cart_pin_code_form']/div[2]/button")
	@CacheLookup
	WebElement PlpPageSubmitButton;

	@FindBy(how = How.XPATH, using = "//button[@id='cartPinCodeEditBtn']")
	@CacheLookup
	WebElement Edit_Pincode_Button_PLPPage;

	@FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']/div[1]/div/div/ul/li[1]/div[2]/span")
	@CacheLookup
	WebElement MsgAddToCartPLPPage;
	
	@FindBy(how = How.XPATH, using = "//div[@class='tab-content']/div[1]/div[1]/div/div/ul/li[1]/a/p")
	@CacheLookup
	WebElement PLPPageFirstProductLink;
	
	@FindBy(how = How.ID, using = "productPincode")
	@CacheLookup
	WebElement PincodeTextFieldPDPPage;
	
	@FindBy(how = How.XPATH, using = "//div[@class='google-map-icon pincode-service-check']/a")
	@CacheLookup
	WebElement PincodeCheckButtonPDPPage;
	
	@FindBy(how = How.XPATH, using = "//div[@id='responseMessage']")
	@CacheLookup
	WebElement responseMsgPincodeCheckPDPPage;
	
	@FindBy(how = How.XPATH, using = "//a[@class='global-button-white checkout-cart']")
	@CacheLookup
	WebElement AddToCartButtonPLPPage;
	
	@FindBy(how = How.ID, using="addToCartMessage")
	@CacheLookup
	WebElement AddToCartMsgPDPPage;
	
	@FindBy(how = How.XPATH, using = "//div[@class='header__main-container--utility']/div[2]/button")
	@CacheLookup
	WebElement MiniCart;
	
	@FindBy(how = How.XPATH, using = "//a[@class='ctaText w-100 active']")
	@CacheLookup
	WebElement Checkout;
	
	@FindBy(how = How.ID, using = "loginMobile")
	@CacheLookup
	WebElement MobileNumber;
	
	@FindBy(how = How.XPATH, using = "//button[@class='ctaText modal__variant-login--submit']")
	@CacheLookup
	WebElement SubmitMobile;
	
	@FindBy(how = How.ID, using = "loginOtp")
	@CacheLookup
	WebElement OTP;
	
	@FindBy(how = How.XPATH, using = "//button[@class='ctaText validate-login  modal__variant-login--submit']")
	@CacheLookup
	WebElement SubmitOTP;
	
	@FindBy(how = How.XPATH, using = "//div[@id='checkOutTab-1']/div/div[1]/div/div[1]/img")
	@CacheLookup
	WebElement productImgCheckOutPage;
	
	public void shopClick() {
		Shop.click();	
	}
	
	//hover mouse 
	public WebElement mouseoverShop() {
		return Shop;
	}
	
	//hover mouse wallsticker click
	public void WallStickersLink(){
		WallStickers.click();
	}
	
	/*public void WallStickersLink() {
		WallStickers.click();
	}*/
	
	public String getWallStickersTitle() {
		String title = WallStickersTitlePLPPage.getText();
		return title;	
	}

	public void clickAddtoCartPlppage() {
		AddToCartPLPPage.click();
	}
	
	public void setPincodePlpPage(String pincode) {
		PincodePLPPage.sendKeys(pincode);
	}
	
	public void PlpPageSubmitPincode() {
		PlpPageSubmitButton.click();
	}
	
	public String AddToCartMsgPLPPage() {

		String	Msg_PLPPage = MsgAddToCartPLPPage.getText();
		return Msg_PLPPage;
		
	}
	
	public void clickEditPincodeButtonPlpPage() {
		Edit_Pincode_Button_PLPPage.click();
	}

	public void clearPincodeTextboxPLPPage() {
		PincodePLPPage.clear();
	}
	
	public void getFirstProductPLPPage() {
		PLPPageFirstProductLink.click();
	}
	
	public void clickCheckButtonPDPPage() {
		PincodeCheckButtonPDPPage.click();
	}
	
	public String getErrorMsgPincodePDPPage() {
		String errormsgpincode=responseMsgPincodeCheckPDPPage.getText();
		return errormsgpincode;
	}

	public void clearPincodeFieldPDPPahge() {
		PincodeTextFieldPDPPage.clear();
	}
	
	public void setValidPincodePDPPage(String pincode) {
		PincodeTextFieldPDPPage.sendKeys(pincode);
	}
	
	public void clickAddToCartPDPPage() {
		AddToCartButtonPLPPage.click();
	}
	
	public String  AddToCartMsgPDPPage() {
		String  addToCartMessage = AddToCartMsgPDPPage.getText();
		return addToCartMessage;
	}
	
	public void clickOnMiniCart() {
		MiniCart.click();
	}
	
	public void clickOnCheckout() {
		Checkout.click();
	}
	
	public void setMobileNo(String No) {
		MobileNumber.sendKeys(No);
	}
	
	public void submitMobileNo() {
		SubmitMobile.click();
	}
	
	public void setOTP(String Otp) {
		OTP.sendKeys(Otp);
	}
	
	public void submitOTP() {
		SubmitOTP.click();
	}
	
	public WebElement getProductImgCheckoutPage() {
		return productImgCheckOutPage;
	}
	
}

