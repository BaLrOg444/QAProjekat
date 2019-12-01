package humanity_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import humanity_pages.DashboardPage;
import humanity_pages.EmployeePage;
import humanity_pages.HomePage;
import humanity_pages.LoginPage;
import humanity_pages.TitlePage;
import rs.itbootcamp.ExcelUtils;


public class LoginTest extends BasicTest {

	private String baseUrl = "https://www.humanity.com/";

	@Test(priority = 0)
	public void basicLogin() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(6000);
		
		HomePage hp = new HomePage(driver);
		hp.getLoginBtn().click();
		Thread.sleep(6000);
		
		LoginPage lg = new LoginPage(driver);
		lg.singIn("balrog444@gmail.com", "testtest");
		Thread.sleep(6000);
		
		TitlePage tp = new TitlePage(driver);
		
		Assert.assertTrue(tp.getPageTitle().contains("Dashboard"));
	}
	
	@Test(priority = 1)
	public void dashboardTest() throws InterruptedException {
		
		
		DashboardPage dp = new DashboardPage(driver);
		System.out.print("dashboardTest" + dp.getNavLinks().size());
		Assert.assertTrue(dp.getNavLinks().size() > 0);
	}
	

	@Test(priority = 20)
	public void addEmployeeTest() throws InterruptedException {
		driver.get("https://sdn1.humanity.com/app/dashboard/");
		Thread.sleep(2000);
		
		DashboardPage dp = new DashboardPage(driver);
		System.out.print("addEmployeeTest" + dp.getNavLinks().size());
		dp.getNavLinks().get(5).click(); // Staff link
		Thread.sleep(2000);

		EmployeePage ep = new EmployeePage(driver);
		ep.getAddEmployeeBtn().click();
		Thread.sleep(2000);
		
		ExcelUtils ex = new ExcelUtils();
		ex.setExcell("C:\\Users\\Milos\\Documents\\Eclipse\\Selenium1\\excel\\radnici.xlsx");
		ex.setWorkSheet(1);
		
		System.out.println(ex.getRowNumber());
		
		for (int i = 1; i < ex.getRowNumber(); i++) 
		{
			ep.addEmploy(ex.getDataAt(i, 0), ex.getDataAt(i, 1), ex.getDataAt(i, 2));
			
		}
		
		ex.closeExcell();
		
		ep.getSaveBtn().click();
		Thread.sleep(2000);
//		
//		dp.getNavLinks().get(5).click(); 
//		
//		Assert.assertTrue(ep.employAdded("233343232332@email.com"));
//		Assert.assertTrue(ep.employAdded("ewd34334@email.com"));
//		Assert.assertTrue(ep.employAdded("09238732k32m@email.com"));
		
	}
	
}
