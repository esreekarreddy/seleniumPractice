package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// Auto suggest dropdown
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//send unit as input
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("autocomplete"))).click().sendKeys("unit").build().perform();
		//driver.findElement(By.id("autocomplete")).sendKeys("unit");
		
		//select united states
		
		List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item .ui-menu-item-wrapper"));
		for(int i=0; i<options.size(); i++) {
			if(options.get(i).getText().contains("United States")) {
				options.get(i).click();
				break;
			}	
		}
		
		//verify if correct one is selected or not
		Assert.assertEquals(driver.findElement(By.id("autocomplete")).getAttribute("value"), "United States (USA)");

		Thread.sleep(2000);;
		driver.close();
	}

}
