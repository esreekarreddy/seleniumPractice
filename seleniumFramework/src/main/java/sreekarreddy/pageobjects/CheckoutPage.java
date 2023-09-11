package sreekarreddy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	WebDriver driver;
	
	@FindBy(css="input[placeholder*='Country']")
	WebElement enterCountry;
	
	@FindBy(css="section[class*='results']")
	List<WebElement> countries;
	
	@FindBy(css=".action__submit")
	WebElement submitPurchase;
	

	
	public CheckoutPage(WebDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public void selectCountry(String input) {
		enterCountry.sendKeys(input);
		countries.stream()
				.filter(s->s.getText().contains("India"))
				.findFirst().orElse(null)
				.click();
		
	}
	
	public ConfirmationPage submitOrder() {
		submitPurchase.click();
		return new ConfirmationPage(driver);
	}
	

}
