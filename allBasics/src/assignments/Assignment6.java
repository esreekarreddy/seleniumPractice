package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//select any checkbox out of option(1,2,3) and grab that text(label of selected textbox)
		driver.findElement(By.id("checkBoxOption2")).click();
		String grabbedText = driver.findElement(By.cssSelector("label[for='benz']")).getText();
		
		//select option in dropdown with the retrieved label from step1
		Select option = new Select(driver.findElement(By.id("dropdown-class-example")));
		option.selectByVisibleText(grabbedText);
		
		//enter step1 grabbed label text in edit box
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#name"))).click().sendKeys(grabbedText).build().perform();
		
		//click on alert and then verify if grabbed text in step1 is present in the pop up or not
		action.moveToElement(driver.findElement(By.id("alertbtn"))).click().build().perform();
		
		if(driver.switchTo().alert().getText().contains(grabbedText)) {
			System.out.println(grabbedText + " present in alert");
			driver.switchTo().alert().accept();
		}

		Thread.sleep(1000);
		driver.quit();
	}

}
