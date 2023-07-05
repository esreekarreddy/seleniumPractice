package webElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("au");
		Thread.sleep(2000);
		
		List<WebElement> elements = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement element : elements) {
			if(element.getText().equalsIgnoreCase("Palau")) {
				element.click();
				break;
			}
		}

		Thread.sleep(2000);
		driver.close();
	}

}
