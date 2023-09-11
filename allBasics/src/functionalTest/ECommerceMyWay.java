package functionalTest;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ECommerceMyWay {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		String[] requiredProducts = {"Cauliflower", "Beetroot", "Carrot", "Pears", "Beans", "Walnuts", "Almonds"};
		List<String> addToCartProducts = Arrays.asList(requiredProducts);
		
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));
		int i = -1;
		int j = 0;
		for(WebElement product:products) {
			i++;
			System.out.println(product.getText());
			if(addToCartProducts.contains(product.getText().split("-")[0].trim())) {
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				i--;
				j++;
				if(j == requiredProducts.length)
					break;
			}
		}
		
		Thread.sleep(5000);
		driver.close();

	}

}
