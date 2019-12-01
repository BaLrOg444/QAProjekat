
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://accounts.eclipse.org/user/register?destination=user/login%3Ftakemeback%3Dhttps%253A//www.eclipse.org/");
		Thread.sleep(3000);

		WebElement selectElement = driver.findElement(By.id("edit-field-profile-legal-address-und-0-country"));
		Select select = new Select(selectElement);
		List<WebElement> allOptions = select.getOptions();
		
		for (int i = 0; i < allOptions.size(); i++) 
		{
			System.out.println(allOptions.get(i).getText());
		}
		
		select.selectByIndex(5);
		//select.selectByVisibleText("Zimbabwe");
	}
}





//Otici na sajt https://www.ebay.com zatim na
//Advanced Search, iz dropdown-a liste "In this category:"
//izvuci sve podatke i proveriti da li postoji kategorija Books
//Ukoliko postoji izabrati je ukoliko ne postoji izabrati kategoriju Art