package akashswamiacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import akashswamiacademy.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{
	
WebDriver driver;

public CartPage (WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(css=".cartSection h3")
List<WebElement> productTitles;

@FindBy(css="li button[type='button']")
WebElement checkOutbtn;


public Boolean VerifyProductDisplay(String productname)
{
	Boolean match = productTitles.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productname));
	return match;
}

public CheckOutPage goToCheckOut()
{
	checkOutbtn.click();
	return new CheckOutPage(driver);
	
}

//hi


}
