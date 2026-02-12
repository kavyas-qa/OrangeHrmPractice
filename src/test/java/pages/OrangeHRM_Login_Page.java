package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_Login_Page extends BasePage
{
	public OrangeHRM_Login_Page(WebDriver driver)
	{
		super(driver); 
	}
	By usernm = By.name("username");
	By pass = By.name("password");
	By loginBtn = By.xpath("//button[@type='submit']");
	By dashboardHeading = By.xpath("//h6[text()='Dashboard']");
	
	public void url(String url)
	{
		driver.get(url);
	}
	public void enterUserName(String un)
	{
		sendKeys(usernm, un);
	}
	public void enterPassword(String pw)
	{
		sendKeys(pass, pw);
	}
	public boolean clickOnLoginBtn() throws InterruptedException
	{
		click(loginBtn);
		Thread.sleep(5000);
		return isDisplayed(dashboardHeading);
	}
}
