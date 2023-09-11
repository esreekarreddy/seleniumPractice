package sreekarreddy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sreekarreddy.abstarctComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> orderPageProducts;
	
	
	public boolean productValidationOnOrderPage(String productName) {
		goToOrders();
		boolean match = orderPageProducts.stream()
				.anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
}
