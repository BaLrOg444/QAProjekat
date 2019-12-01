import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Test2 {
	
	private WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void googleCalculator() throws Exception{
		
		//Launch google
		driver.get("http://www.google.co.in");
		
		//Write 2+2 in google textbox
		WebElement googleTextBox = driver.findElement(By.className("gLFyf"));
		googleTextBox.sendKeys("2+2");
		Thread.sleep(1000);
		
		Actions builder = new Actions(driver);
//		builder.keyDown(Keys.ENTER).perform();
		builder.sendKeys(Keys.ENTER);
		
		//Get result from calculator
		WebElement calculatorTextBox = driver.findElement(By.id("cwos"));
		String result = calculatorTextBox.getText();
		
		//Verify that result of 2+2 is 4
		Assert.assertEquals(result, "4");
	}
	
	@AfterTest
	public void quit() {
//		driver.close();
	}
	
}