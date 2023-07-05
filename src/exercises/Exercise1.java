package exercises;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//to get number of links present on page
		int linksNumber = driver.findElements(By.tagName("a")).size();
		System.out.println("Count of links in the page: " + linksNumber);

		//to get number of links present on footer of the page
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		int linksNumberFooter = footerDriver.findElements(By.tagName("a")).size();
		System.out.println("Count of links in the footer of the page: " + linksNumberFooter);
		
		//get links number in 1st cloumn in footer section
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int columnNumber = columnDriver.findElements(By.tagName("a")).size();
		System.out.println("Count of links in column of footer page: " + columnNumber);
		
		//click on each link in the 1st column & check if the pages are opening
		
		for(int i=1; i<columnNumber; i++) {
			
			String controlClick = Keys.chord(Keys.COMMAND, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(controlClick);
			Thread.sleep(1000);
		
		}
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		
		while(window.hasNext()) {
			String currentWindow = window.next();
			driver.switchTo().window(currentWindow);
			String title = driver.switchTo().window(currentWindow).getTitle();
			System.out.println(title);
		}
		
		
		Thread.sleep(4000);
		driver.quit();
	}

}
