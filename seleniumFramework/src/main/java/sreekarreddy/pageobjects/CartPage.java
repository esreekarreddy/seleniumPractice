package sreekarreddy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sreekarreddy.abstarctComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div/div/h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement proceed;
	
	public boolean productsValidationAndCheckout(String productName) {
		goToCart();
		boolean match = cartProducts.stream()
				.anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
	public CheckoutPage checkout() {
		proceed.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

}
