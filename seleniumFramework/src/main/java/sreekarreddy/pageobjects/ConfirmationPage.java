package sreekarreddy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	WebDriver driver;
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	public ConfirmationPage(WebDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String validatePurchase() {
		return confirmationMessage.getText();
	}
}
