package myExamples;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlightBooking {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		Wait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("in");
		List<WebElement> elements = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement element: elements) {
			if(element.getText().equalsIgnoreCase("India")) {
				element.click();
				break;
			}
		}
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='AMD']")).click();
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_destinationStation1_CTNR a[value='GOI']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]")).click();
		
		if(driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		
		driver.findElement(By.id("divpaxinfo")).click();
		for(int i=0; i<4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Select option = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		option.selectByValue("AED");
		driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
		
		Thread.sleep(2000);
		driver.close();
	}

}
