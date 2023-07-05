package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.findElement(By.name("name")).sendKeys("Chitra");
		driver.findElement(By.name("email")).sendKeys("chitra@gmail.com");
		driver.findElement(By.xpath("//div/input[contains(@id,'InputPassword')]")).sendKeys("password");
		driver.findElement(By.cssSelector("#exampleCheck1")).click();

		Select option = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		option.selectByVisibleText("Female");

		if (driver.findElement(By.id("inlineRadio1")).isSelected() == false) {
			driver.findElement(By.id("inlineRadio1")).click();
			Assert.assertTrue(driver.findElement(By.id("inlineRadio1")).isSelected());
		}

		driver.findElement(By.cssSelector("div input[max*='3000']")).sendKeys("04/10/2000");
		driver.findElement(By.cssSelector("input[class*='success']")).click();
		Thread.sleep(500);
		String success = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		System.out.println(success);

		Thread.sleep(2000);
		driver.close();

	}

}
