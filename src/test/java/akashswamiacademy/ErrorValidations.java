package akashswamiacademy;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import akashswamiacademy.ProductCatalogue;
import akashswamiacademy.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest{
	

@Test(groups= {"ErrorHandling"})
public void LoginErrorValidation()
{
	String productname = "ZARA COAT 3";
	ProductCatalogue productCatalogue = landingPage.loginApplication("akashspna@gmail.com", "Test@1234");
	Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
}

@Test
public void ProductErrorValidation() throws IOException, InterruptedException
{
	
	String productname = "ZARA COAT 3";
	ProductCatalogue productCatalogue = landingPage.loginApplication("akashspna@gmail.com", "Test@12345");
	List<WebElement> products = productCatalogue.getProductList();
	productCatalogue.addProductToCart(productname);
	CartPage cartPage = productCatalogue.goToCartPage();
	Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 1");
	Assert.assertFalse(match);

}
}
