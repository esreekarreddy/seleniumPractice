package myExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxFlipkart {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://www.nykaa.com/");
		Actions action = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
		action.moveToElement(brands).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("brandSearchBox")));
		action.moveToElement(driver.findElement(By.id("brandSearchBox"))).click().keyDown(Keys.SHIFT).sendKeys("Nivea").doubleClick().build().perform();
		
		Thread.sleep(2000);
		driver.close();

	}

}
