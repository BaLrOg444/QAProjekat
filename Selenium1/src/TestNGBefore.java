import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBefore {

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("beforeTest");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("\nbeforeMethod");
    }
    
    @AfterTest
    public void afterTest()
    {
        System.out.println("afterTest");
    }
    
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("afterMethod");
    }
    
    @Test
    public void firstTest()
    {
        System.out.println("firstTest");
    }

    @Test
    public void secondTest()
    {
        System.out.println("secondTest");
    }

    @Test
    public void thirdTest()
    {
        System.out.println("thirdTest");
    }
}