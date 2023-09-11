package selenium4;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleWindows {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		String parent = window.next();
		String child = window.next();
		driver.switchTo().window(child);
		driver.get("https://rahulshettyacademy.com/");
		
		String course = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		System.out.println(course);
		driver.switchTo().window(parent);
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys(course);
		
		//take element screenshot
		File src = name.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("sc.jpg"));
		
		//get height & width
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		Thread.sleep(1000);
		driver.quit();

	}

}
