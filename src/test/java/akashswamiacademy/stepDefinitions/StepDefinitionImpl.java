package akashswamiacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import akashswamiacademy.CartPage;
import akashswamiacademy.CheckOutPage;
import akashswamiacademy.ConfirmationPage;
import akashswamiacademy.LandingPage;
import akashswamiacademy.ProductCatalogue;
import akashswamiacademy.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{
    
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landingPage = launchApplication();
	}
	
	@Given("^Logged in with the username(.+) and password(.+)$")
	public void Logged_in_with_the_username_and_password(String username,String password)
	{
		productCatalogue = landingPage.loginApplication(username,password);
	}
	
	@When("^I add product(.+) to cart$")
	public void I_add_product_to_cart(String productName)
	{
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
    @When("^Checkout(.+) and submit the order$")
    public void Checkout_and_submit_the_order(String productName) throws InterruptedException
    {
    	CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		checkOutPage.SelectCountry("india");
		confirmationPage = checkOutPage.submitOrder();
    }
    
    @Then("{string} message is displayed on confirmationpage")
    public void message_is_displayed_on_confirmationpage(String string)
    {
    	String confirmmsg = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmmsg.equalsIgnoreCase(string));
		driver.close();
    }
	
}
