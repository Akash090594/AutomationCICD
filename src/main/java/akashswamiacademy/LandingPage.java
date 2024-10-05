package akashswamiacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import akashswamiacademy.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
WebDriver driver;

public LandingPage (WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(id="userEmail")
WebElement userEmail;

@FindBy(id="userPassword")
WebElement userpassword;

@FindBy(id="login")
WebElement submit;

@FindBy(css="[class*='flyInOut']")
WebElement errorMessage;

public ProductCatalogue loginApplication(String email,String password)
{
	userEmail.sendKeys(email);
	userpassword.sendKeys(password);
	submit.click();
	ProductCatalogue productCatalogue = new ProductCatalogue(driver);
	return productCatalogue;
}

public void goTo() {
	driver.get("https://rahulshettyacademy.com/client"); 
	
}

public String getErrorMessage()
{
	waitForWebElementToAppear(errorMessage);
	return errorMessage.getText();
}






}
