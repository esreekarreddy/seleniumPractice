package streamExercises;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterWebElement {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.cssSelector("#search-field")).sendKeys("ric");
		
		List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> searchResult = items.stream()
			.filter(s->s.getText().contains("Rice"))
			.collect(Collectors.toList());
		
		Assert.assertEquals(items.size(), searchResult.size());
		
		Thread.sleep(1000);
		driver.close();

	}

}
