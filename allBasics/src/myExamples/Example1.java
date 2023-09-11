package myExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Example1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//going to rahul homepage
		driver.findElement(By.xpath("//*[text()='Home']")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		
		/*
		 * select radio2,
		 * add suggestion class
		 * select option2 in dropdown
		 * check option3 in checkbox
		 */
		
		driver.findElement(By.xpath("(//div[contains(@class,'left')])[1] //label[1]/following-sibling::label[1]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("India");
		Thread.sleep(1000);
		Select option = new Select(driver.findElement(By.cssSelector("div div[class*='cen'] select[id*='class']")));
		option.selectByIndex(2);
		driver.findElement(By.xpath("//div[contains(@class,'right')][2]/fieldset/label[1]/following-sibling::label[2]/input")).click();
		
		
		/*
		 * Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Open Window']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[id*='tab']")).click();
		Thread.sleep(1000);
		*/
		driver.findElement(By.name("enter-name")).sendKeys("Sreekar");
		Thread.sleep(1000);
		driver.findElement(By.id("alertbtn")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
