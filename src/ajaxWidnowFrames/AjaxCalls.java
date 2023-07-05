package ajaxWidnowFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AjaxCalls {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		WebElement signIn = driver.findElement(By.cssSelector("div[id='nav-tools'] a[data-nav-role=\"signin\"]"));
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		Actions action = new Actions(driver);
		action.moveToElement(signIn).build().perform();
		action.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("facewash").doubleClick().build().perform();
		action.moveToElement(signIn).contextClick().build().perform();
		
		Thread.sleep(2000);
		driver.close();

	}

}
