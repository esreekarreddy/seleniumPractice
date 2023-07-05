package myExamples;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Groceries {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String[] itemsRequired = {"Mushroom", "Musk Melon", "Pista"};
		List<String> itemsList = Arrays.asList(itemsRequired);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		
		List<WebElement> elements = driver.findElements(By.cssSelector("h4[class=\"product-name\"]"));
		int j = 0;
		for(int i=0; i<elements.size(); i++) {
			String item = elements.get(i).getText().split("-")[0].trim();
			if(itemsList.contains(item)) {
				j++;
				System.out.println("Item added to cart: "+item);
				driver.findElements(By.cssSelector("div[class='product-action'] button")).get(i).click();
			}
			if(j == itemsList.size())
				break;
		}

		driver.findElement(By.cssSelector("img[alt=\"Cart\"]")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		Select option = new Select(driver.findElement(By.tagName("select")));
		option.selectByVisibleText("India");
		driver.findElement(By.className("chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		Thread.sleep(3000);
		driver.close();
	}

}
