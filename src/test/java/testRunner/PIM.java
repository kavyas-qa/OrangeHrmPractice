package testRunner;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.OrangeHRM_Login_Page;
import pages.OrangeHRM_PIM_Page;

public class PIM
{
	@Test
	public void executionMethod() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		OrangeHRM_Login_Page lin = new OrangeHRM_Login_Page(driver);
		OrangeHRM_PIM_Page pim = new OrangeHRM_PIM_Page(driver);
		
		lin.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		lin.enterUserName("Admin");
		lin.enterPassword("admin123");
		lin.clickOnLoginBtn();
		
		pim.clickOnPIM();
		String actualPimTitle = "PIM";
		String expectedPimTitle = pim.verifyTitle();
		Assert.assertEquals(expectedPimTitle, actualPimTitle);
		pim.verifyConfigurationDropdownOptions();
	}
}
