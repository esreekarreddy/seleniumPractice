package functionalTest;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ECommerce {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");

		String[] requiredItems = { "Strawberry", "Raspberry", "Water Melon", "Walnuts", "Almonds" };

		addItemsToCart(driver, requiredItems);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		if(driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).getAttribute("class").contains("disabled")){
			System.out.println("No items added in the cart");
		}
		else {
			driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		Assert.assertEquals(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText(), "Code applied ..!"); 
		
		Thread.sleep(2000);
		driver.close();

	}

	public static void addItemsToCart(WebDriver driver, String[] requiredItems) {

		List<String> listItems = Arrays.asList(requiredItems);
		List<WebElement> elements = driver.findElements(By.cssSelector(".product-name"));
		int j = 0;
		for (int i = 0; i < elements.size(); i++) {
			String product = elements.get(i).getText().split("-")[0].trim();
			if (listItems.contains(product)) {
				j++;
				System.out.println("Product added was: " + product);
				driver.findElements(By.cssSelector(".product .product-action")).get(i).click();
				if (j == listItems.size())
					break;
			}
		}
	}

}
