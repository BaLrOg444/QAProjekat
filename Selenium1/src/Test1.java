import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {

//	Napisati test koji testira funkcionalnost dodavanja proizvoda u korpu.
//	Test:
//	- URL: https://www.dynadot.com/
//	- u delu za pretragu potraziti ime domena po izboru (samo da je domen slobodan)
//	- dodati domen u korpu (nakon toga sacekati malo, da se na serveru dese promene)
//	- zatim otici na stranicu korpe (gornji desni ugao dugme za korpu > View Cart)
//	- proveriti da li se trazeni domen nalazi u korpi

	private WebDriver driver;
	private String baseUrl = "https://www.dynadot.com/";
	private String domain = "sdsdksdjksdj.com";

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void cartTest() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		WebElement search = driver.findElement(By.name("domain"));
		search.sendKeys(domain);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#id-target-result .s-btn-add")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#id-shopping-cart a")).click();
		driver.findElement(By.cssSelector(".view-card-item a")).click();
		Thread.sleep(2000);

		WebElement domainEl = driver.findElement(By.cssSelector(".domain-privacy-sitebuilder-container .item-name"));
		Assert.assertEquals(domainEl.getText(), domain);
	}

	@AfterTest
	public void quit() {
//		driver.close();
	}
}

