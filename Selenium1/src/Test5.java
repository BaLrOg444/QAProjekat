
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
@Test
public class Test5 {
    public String baseUrl = "https://www.juznevesti.com/";
    public WebDriver driver; 
    public String expected = null;
    public String actual = null;
    
    
      @BeforeTest
      public void launchBrowser() {
    	System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get(baseUrl);
      }
      
      @BeforeMethod
      public void verifyHomepageTitle() {
          String expectedTitle = "Ju�ne vesti - Leskovac, Ni�, Pirot, Prokuplje, Vranje - vesti iz ju�ne Srbije";
          String actualTitle = driver.getTitle();
          Assert.assertEquals(actualTitle, expectedTitle);
      }
          @Test(priority = 0)
      public void register() throws Exception{
          driver.findElement(By.linkText("Leskovac")).click() ;
          expected = "Leskovac : strana 1 : Ju�ne vesti";
          actual = driver.getTitle();
          Assert.assertEquals(actual, expected);
      }
          @Test(priority = 1)
      public void support() {
            driver.findElement(By.linkText("Prokuplje")).click() ;
            expected = "Under Construction: Mercury Tours";
            actual = driver.getTitle();
            Assert.assertEquals(actual, expected);
      }
      @AfterMethod
      public void goBackToHomepage ( ) throws InterruptedException {
  			Thread.sleep(1000);
  			driver.get(baseUrl);
      }
       
      @AfterTest
      public void terminateBrowser(){
          driver.close();
      }
}