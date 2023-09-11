package sreekarreddy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import sreekarreddy.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client/");
		
		//logging in
		driver.findElement(By.id("userEmail")).sendKeys("2000sreekar@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("7Sreekar@");
		driver.findElement(By.id("login")).click();
		
		
		/*
		 * get all products
		 * get the desired product
		 * click the cart
		 */
		String productName = "zara coat 3";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
		List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
		
		WebElement product = products.stream()
			.filter(s->s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
			.findFirst().orElse(null);

		product.findElement(By.cssSelector(".card-body button:last-child")).click();
		
		
		//click on the cart button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink*='/dashboard/cart']")).click();
		
		
		/*
		 * check whether product is added correctly to the cart or not 
		 * click on checkout order
		 */
		List<WebElement> cartProducts = driver.findElements(By.xpath("//div/div/h3"));
		boolean match = cartProducts.stream()
			.anyMatch(s->s.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		
		/*
		 * send ind to Counrty input in last page
		 * click on purchase order
		 * validate confirmation message
		 */
		driver.findElement(By.cssSelector("input[placeholder*='Country']")).sendKeys("ind");
		List<WebElement> countryPicks = driver.findElements(By.cssSelector("section[class*='results']"));
		WebElement country = countryPicks.stream()
			.filter(s->s.getText().contains("India"))
			.findFirst().orElse(null);
		country.click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmation = driver.findElement(By.cssSelector(".hero-primary")).getText();
		boolean validation = confirmation.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		Assert.assertTrue(validation);
		
		//Thread.sleep(10000);
		driver.close();

	}

}
