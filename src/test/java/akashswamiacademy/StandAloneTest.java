package akashswamiacademy;

import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String productname = "ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("akashspna@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@12345");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
	WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
	driver.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	//ng-animating
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	
List<WebElement> cardproducts =	driver.findElements(By.cssSelector(".cartSection h3"));

Boolean match = cardproducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productname));
Assert.assertTrue(match);

driver.findElement(By.cssSelector("li button[type='button']")).click();

Actions a = new Actions(driver);
a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

driver.findElement(By.xpath("(//button[contains(@class,'ta-item')]) [2]")).click();
//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("action__submit")));
driver.findElement(By.cssSelector("a.action__submit")).click();

String confirmmsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
AssertJUnit.assertTrue(confirmmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

driver.close();




	
	
		
		
		
		
		
		

	}

}
