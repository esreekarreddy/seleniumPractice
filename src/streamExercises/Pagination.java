package streamExercises;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Pagination {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> price;
		do {
		List<WebElement> nextItems = driver.findElements(By.xpath("//tr/td[1]"));
		price = nextItems.stream()
			.filter(s->s.getText().contains("Rice"))
			.map(s->s.findElement(By.xpath("following-sibling::td[1]")))
			.collect(Collectors.toList());
		
		price.forEach(s->System.out.println(s.getText()));
		
		if(price.size()<1)
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}while(price.size()<1);
		
		Thread.sleep(1000);
		driver.close();

	}

}
