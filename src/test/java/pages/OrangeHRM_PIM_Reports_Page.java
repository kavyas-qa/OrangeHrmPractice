package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeHRM_PIM_Reports_Page  extends BasePage
{
	public OrangeHRM_PIM_Reports_Page(WebDriver driver)
	{
		super(driver); 
	}
	
	By reportsTab = By.xpath("//ul/li//a[text()='Reports']");
	By employeeReportsSection = By.xpath("//h5[text()='Employee Reports']");
	By searchButton = By.xpath("//button[normalize-space()='Search']");
	By recordsList = By.xpath("//span[contains(normalize-space(),'Records Found')]");
	By addRecordButton = By.xpath("//button[contains(@class, 'oxd-button')]/i");
	By reportNameField = By.xpath("//label[contains(@class,'oxd-input-field-required') and text()='Report Name']/following::input[1]");
	By displayFieldGroupDropdown = By.xpath("//label[text()='Select Display Field Group']/ancestor::div[contains(@class, 'oxd-input-group')]//div[@class='oxd-select-wrapper']");
	By displayFieldDropdown = By.xpath("//label[text()='Select Display Field']/ancestor::div[contains(@class, 'oxd-input-group')]//div[@class='oxd-select-wrapper']");
	By plusIcon = By.xpath("//h6[text()='Display Fields']/following::button/i");
	By saveReportsButton = By.xpath("//button[@type='submit']");
	By saveSuccessMsg = By.xpath("//p[text()='Successfully Saved']");
	By reportName = By.xpath("//h6[text()='PIM test report']");
	
	public boolean verifyReportPage() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		click(reportsTab);
		Thread.sleep(3000);
		isDisplayed(employeeReportsSection);
		click(searchButton);
		isDisplayed(recordsList);
		click(addRecordButton);
		sendKeys(reportNameField, "PIM test report");
		click(displayFieldGroupDropdown);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		click(displayFieldDropdown);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		click(plusIcon);
		click(saveReportsButton);
		if(verifyToastMessage("Successfully Saved"))
		{
			System.out.println("Report is added successfully");
		}
		Thread.sleep(5000);
		return isDisplayed(reportName);
	}
}
