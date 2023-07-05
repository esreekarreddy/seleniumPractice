package exercises;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercise2Calender {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.globalsqa.com/demo-site/datepicker/");
		
		String travelDate = "December 2023";
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame lazyloaded']")));
		//open the calender
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
		driver.findElement(By.cssSelector("#datepicker")).click();
		
		while(!driver.findElement(By.cssSelector(".ui-datepicker-month")).getText().contains(travelDate.split(" ")[0])) {
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
		}
		
		List<WebElement> days = driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
		int sizeOfDays = days.size();
		
		for(int i=0; i<sizeOfDays; i++) {
			if(driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).getText().contains("12")) {
				driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).click();
				break;
			}
				
		}
	
		Thread.sleep(2000);
		driver.close();
	}

}
