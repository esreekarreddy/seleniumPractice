package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) throws InterruptedException {
		
		//Frames

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.partialLinkText("Nested")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@name,'frame-top')]")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@name,'frame-middle')]")));
		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		driver.close();
	}

}
