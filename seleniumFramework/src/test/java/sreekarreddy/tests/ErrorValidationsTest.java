package sreekarreddy.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import sreekarreddy.pageobjects.CartPage;
import sreekarreddy.pageobjects.ProductCatalogue;
import sreekarreddy.testComponents.BaseTest;
import sreekarreddy.testComponents.Retry;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups = {"ErrorValidations"} ,retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws InterruptedException, IOException {
	
		landingPage.loginApplication("2000sreekar@gmail.com", "7Sreekr@");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	
	@Test
	public void productErrorValidation() throws InterruptedException, IOException {
		
		String productName = "zara coat 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("esreekarreddy@gmail.com", "7Sreekar@");
		List<WebElement> products = productCatalogue.productsList();
		productCatalogue.getProductByName(productName);
		CartPage cartPage = productCatalogue.addToCart(productName);
		boolean match = cartPage.productsValidationAndCheckout("zara coat 333");
		Assert.assertFalse(match);
		

	}

}
