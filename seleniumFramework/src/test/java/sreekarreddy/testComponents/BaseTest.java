package sreekarreddy.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import sreekarreddy.pageobjects.LandingPage;

public class BaseTest {

	public WebDriver driver; 
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/srekarreddy/resources/GlobalData.properties");
		properties.load(fileInputStream);
		String browser = properties.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage loginApplication() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void clodeDriver() {
		driver.close();
	}
	
	
	public String takeScreenshot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
	}
	
	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;
	}
}
