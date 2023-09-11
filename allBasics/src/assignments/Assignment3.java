package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-body")));
		driver.findElement(By.cssSelector("#okayBtn")).click();
		Select option = new Select(driver.findElement(By.cssSelector(".form-control:nth-child(1)")));
		option.selectByIndex(2);
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.cssSelector("input[name='signin']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='my-4'][1]")));
		List<WebElement> elements = driver.findElements(By.cssSelector(".btn.btn-info"));
		for(WebElement element: elements) {
			element.click();
		}
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
		Thread.sleep(5000);
		driver.close();

	}

}
