package akashswamiacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import akashswamiacademy.AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

WebDriver driver;

public CheckOutPage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

@FindBy(css="[placeholder='Select Country']")
WebElement country;

@FindBy(xpath="(//button[contains(@class,'ta-item')]) [2]")
WebElement SelectCountry;

@FindBy(css="a.action__submit")
WebElement submit;

By results = By.cssSelector(".ta-results");

public void SelectCountry(String CountryName)
{
	Actions a = new Actions(driver);
	a.sendKeys(country, CountryName).build().perform();
	waitForElementToAppear(results);
	SelectCountry.click();	
}

public ConfirmationPage submitOrder()
{
	submit.click();
	return new ConfirmationPage(driver);
}

}
