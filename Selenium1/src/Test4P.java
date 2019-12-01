import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Test4P{
	
	@Test
	public void a_test() {
		Assert.fail();
	}
	
	@Test
	public void b_test() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void c_test() {
		throw new SkipException("Preskocen");
	}
	
}
