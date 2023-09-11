package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsHandling {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("name")).sendKeys("Sreekar");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(500);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		Thread.sleep(300);
		driver.findElement(By.id("name")).sendKeys("Reddy");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(500);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		driver.close();
	}

}
