package streamExercises;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSort {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	
		//check the order whether it is sorted or not
		driver.findElement(By.xpath("(//th[@role='columnheader'])[1]")).click();
		List<WebElement> elements = driver.findElements(By.xpath("(//th[@role='columnheader'])[1]/parent::tr/parent::thead/parent::table/tbody/tr/td[1]"));
		List<String> originalList = elements.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));
		
		//get the price of beans
		elements.stream()
			.filter(s->s.getText().contains("Beans"))
			.map(s->s.findElement(By.xpath("following-sibling::td[1]")).getText()) //remeber to give path only to child
			.forEach(s->System.out.println(s));
		
		Thread.sleep(1000);
		driver.close();
		
	}

}
