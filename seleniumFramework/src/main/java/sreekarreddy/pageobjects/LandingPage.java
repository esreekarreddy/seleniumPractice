package sreekarreddy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sreekarreddy.abstarctComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email, String passcode) {
		userEmail.sendKeys(email);
		password.sendKeys(passcode);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage() {
		waitUntilElementIsVisible(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
		
	}
	
}
