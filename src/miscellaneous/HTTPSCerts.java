package miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HTTPSCerts {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions ch = new ChromeOptions();
		ch.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(1000);
		driver.close();

	}

}
