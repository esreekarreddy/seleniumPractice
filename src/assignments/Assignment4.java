package assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		
		//Multiple window handling
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//*[contains(text(), 'Multiple Windows')]")).click();
		driver.findElement(By.xpath("(//a)[2]")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		String parentWindow = window.next();
		String childWindow = window.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		Thread.sleep(2000);
		driver.quit();
	}

}
