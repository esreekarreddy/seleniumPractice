package webElements;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEnd {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// from hyd
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(200);
		driver.findElement(By.cssSelector("a[value='HYD']")).click();
		// System.out.println("Departure from: "
		// +driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getText());

		// to bglr
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"))
				.click();
		// System.out.println("Destination: "+driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getText());

		// depart date today
		driver.findElement(By.cssSelector("a[class*='highlight']")).click();
		// System.out.println("Depart Date: "+driver.findElement(By.id("ctl00_mainContent_view_date1")).getText());

		// check round trip is disabled
		if (driver.findElement(By.cssSelector("#Div1")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		// passengers 2 adults & 1 child
		driver.findElement(By.id("divpaxinfo")).click();
		driver.findElement(By.id("hrefIncAdt")).click();
		driver.findElement(By.id("hrefIncChd")).click();
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("Passenger count: " + driver.findElement(By.id("divpaxinfo")).getText());

		// student checkbox
		driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();

		// usd currency
		Select option = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		option.selectByVisibleText("USD");

		// search
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

		Thread.sleep(400);
		driver.close();

	}

}
