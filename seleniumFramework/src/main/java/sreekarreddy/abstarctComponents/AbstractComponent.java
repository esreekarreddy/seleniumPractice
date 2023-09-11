package sreekarreddy.abstarctComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sreekarreddy.pageobjects.OrderPage;


public class AbstractComponent {
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AbstractComponent(WebDriver driver) {
		this.driver =driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	public void waitUntilElementIsVisible(By findBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitUntilElementIsVisible(WebElement findBy) {
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitUntilElementIsInvisible(WebElement element) throws InterruptedException {
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	@FindBy(css="button[routerlink*='/dashboard/cart']")
	WebElement cartClick;
	public void goToCart() {
		cartClick.click();
	}
	
	@FindBy(xpath="(//button[contains(@class,'btn-custom')])[2]")
	WebElement ordersClick;
	public OrderPage goToOrders() {
		ordersClick.click();
		return new OrderPage(driver);
	}

}
