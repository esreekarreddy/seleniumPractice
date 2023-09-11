package myExamples;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentChildWindow {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector("a[href*='request']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		String parent = window.next();
		String child = window.next();
		driver.switchTo().window(child);
		String uname = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("@")[1].split(".com")[0];

		driver.switchTo().window(parent);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("username"))).click().sendKeys(uname).build().perform();
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//label[@class='customradio']/span[@class='checkmark'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		action.moveToElement(driver.findElement(By.id("okayBtn"))).click().build().perform();
		Select option = new Select(driver.findElement(By.cssSelector("select[class='form-control']")));
		option.selectByValue("consult");
		driver.findElement(By.id("signInBtn")).click();
		
		Thread.sleep(1000);
		driver.quit();
	}

}
