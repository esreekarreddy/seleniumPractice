package sreekarreddy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import sreekarreddy.pageobjects.CartPage;
import sreekarreddy.pageobjects.CheckoutPage;
import sreekarreddy.pageobjects.ConfirmationPage;
import sreekarreddy.pageobjects.OrderPage;
import sreekarreddy.pageobjects.ProductCatalogue;
import sreekarreddy.testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest{

	String productName = "zara coat 3";
	
	@Test(dataProvider = "getData", groups = "Purchase")
	public void submitOrder(HashMap<String, String> map) throws InterruptedException, IOException {
	
	
		//logging in
		ProductCatalogue productCatalogue = landingPage.loginApplication(map.get("email"), map.get("password"));
		
		
		/*
		 * get all products
		 * get the desired product
		 * click the cart
		 */
		List<WebElement> products = productCatalogue.productsList();
		productCatalogue.getProductByName(map.get("productName"));
		CartPage cartPage = productCatalogue.addToCart(map.get("productName"));
		
		/*
		 * click on the cart button
		 * check whether product is added correctly to the cart or not 
		 * click on checkout order
		 */
		boolean match = cartPage.productsValidationAndCheckout(map.get("productName"));
		AssertJUnit.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.checkout();
		
		
		/*
		 * send ind to Counrty input in last page
		 * click on purchase order
		 * validate confirmation message
		 */
		checkoutPage.selectCountry("ind");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		Assert.assertTrue(confirmationPage.validatePurchase().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}

	
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderPageValidation() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("esreekarreddy@gmail.com", "7Sreekar@");
		OrderPage orderPage = productCatalogue.goToOrders();
		Assert.assertTrue(orderPage.productValidationOnOrderPage(productName));;
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/sreekarreddy/data/PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
	
	
	/*
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {{"2000sreekar@gmail.com", "7Sreekar@", "adidas original"}, {"esreekarreddy@gmail.com", "7Sreekar@", "zara coat 3"}};
		
		

	 * HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "2000sreekar@gmail.com");
		map.put("password", "7Sreekar@");
		map.put("productName", "adidas original");
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "esreekarreddy@gmail.com");
		map1.put("password", "7Sreekar@");
		map1.put("productName", "zara coat 3");
	 * 
	
	}
	*/

}
