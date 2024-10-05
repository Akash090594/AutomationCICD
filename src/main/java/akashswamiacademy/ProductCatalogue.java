package akashswamiacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import akashswamiacademy.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
WebDriver driver;

public ProductCatalogue (WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(css=".mb-3")
List<WebElement> products;

By productsBy = By.cssSelector(".mb-3");
By addToCart = By.cssSelector(".card-body button:last-of-type");
By toastmsg = By.cssSelector("#toast-container");
By spinner = By.cssSelector(".ng-animating");

public List<WebElement> getProductList()
{
	waitForElementToAppear(productsBy);
	return products;
}

public WebElement getProductName(String productname)
{
	WebElement prod = getProductList().stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
	return prod;
}

public void addProductToCart(String productname)
{
	getProductName(productname).findElement(addToCart).click();	
	waitForElementToAppear(toastmsg);
	waitForElementToDisAppear(spinner);
}








}
