package ajaxWidnowFrames;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsParentChild {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.className("blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		String parentWindow = window.next();
		String childWindow = window.next();
		driver.switchTo().window(childWindow);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".im-para.red")));
		String uname = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].split("with")[0].trim();
		System.out.println(uname);
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("username")).sendKeys(uname);
		
		
		Thread.sleep(2000);
		driver.quit();
		

	}

}
