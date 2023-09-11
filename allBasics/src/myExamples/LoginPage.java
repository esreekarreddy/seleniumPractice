package myExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println("Title of the page is - " + driver.getTitle());
		Assert.assertEquals(driver.getCurrentUrl(), "https://rahulshettyacademy.com/locatorspractice/");

		String uname = "Sreekar";
		String password =getPassword(driver, uname);
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(uname);
		driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys(password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visitUsTwo")));
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logout-btn")));
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Thread.sleep(500);
		driver.close();
	}
	
	public static String getPassword(WebDriver driver, String uname) {
		
		driver.findElement(By.cssSelector(".forgot-pwd-container")).click();
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys(uname);
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("sr@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("8297338513");
		driver.findElement(By.className("reset-pwd-btn")).click();
		String password = driver.findElement(By.className("infoMsg")).getText().split("'")[1];
		driver.findElement(By.className("go-to-login-btn")).click();
		return password;
	}

}
