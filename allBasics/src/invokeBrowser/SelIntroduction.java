package invokeBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		
		//setting the key-value pair for chromedriver extention file
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		/*
		 * gecko driver for Firefox browser
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		*/
		
		//creating an object for browser driver
		//using interface to limit only implemented object methods
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/");
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		//closes current window and not all associated windows
		driver.close();
		//driver.quit();
	}

}
