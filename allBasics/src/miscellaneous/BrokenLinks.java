package miscellaneous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,2000)");
		
		SoftAssert softAssert = new SoftAssert();
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class*='gf'] a"));
		for(WebElement link : links) {
			String urlText = link.getAttribute("href");
			HttpURLConnection connect = (HttpURLConnection) new URL(urlText).openConnection();
			connect.setRequestMethod("HEAD");
			connect.connect();
			int statusCode = connect.getResponseCode();
			softAssert.assertTrue(statusCode<400, "Broken link is " + link.getText() + " with code " + statusCode);
		}
		
		softAssert.assertAll();
		
		Thread.sleep(1000);
		driver.close();

	}

}
