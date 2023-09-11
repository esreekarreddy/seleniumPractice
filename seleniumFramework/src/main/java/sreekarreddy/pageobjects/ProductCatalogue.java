package sreekarreddy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sreekarreddy.abstarctComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".col-lg-4")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement loadingScreenWait;
	
	By productsBy = By.cssSelector(".col-lg-4");
	By addToCart = By.cssSelector(".card-body button:last-child");
	By toastMessageAppear = By.id("toast-container");
	
	public List<WebElement> productsList() {
		waitUntilElementIsVisible(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement product = productsList().stream()
				.filter(s->s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return product;
	}
	
	public CartPage addToCart(String productName) throws InterruptedException {
		WebElement product = getProductByName(productName);
		product.findElement(addToCart).click();
		waitUntilElementIsVisible(toastMessageAppear);
		waitUntilElementIsInvisible(loadingScreenWait);
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}
