package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {
		
		// Web Tables

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scroll(0,600)");
		
		//print no of rows
		System.out.println("Rows count: " +driver.findElements(By.cssSelector(".left-align #product tr")).size());
		
		//print no of columns
		System.out.println("Column count: " +driver.findElements(By.cssSelector(".left-align #product tr th")).size());	
		
		//print second row data
		List<WebElement> rowData = driver.findElements(By.cssSelector(".left-align #product tr:nth-child(3) td"));
		for(int i=0; i<rowData.size(); i++) {
			System.out.println(driver.findElements(By.cssSelector(".left-align #product tr:nth-child(3) td")).get(i).getText());
		}
		
		Thread.sleep(1000);
		driver.close();
		
	}

}
