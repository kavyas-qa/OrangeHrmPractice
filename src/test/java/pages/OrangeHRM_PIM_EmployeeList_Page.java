package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class  OrangeHRM_PIM_EmployeeList_Page extends BasePage
{
	public OrangeHRM_PIM_EmployeeList_Page(WebDriver driver)
	{
		super(driver); 
	}
	By employeeListTab = By.xpath("//ul/li//a[text()='Employee List']");
	By employeeInformationSection = By.xpath("//h5[text()='Employee Information']");
	By searchButton = By.xpath("//button[normalize-space()='Search']");
	By resetButton = By.xpath("//button[normalize-space()='Reset']");
	By addEmployeeButton = By.xpath("//button[contains(@class, 'oxd-button')]/i") ;
	
	By employerNameField = By.xpath("//label[text()='Employee Name']");
	By employerIdField = By.xpath("//label[text()='Employee Id']");
	By employmentStatusField = By.xpath("//label[text()='Employment Status']");
	By includeField = By.xpath("//label[text()='Include']");
	By supervisorNameField = By.xpath("//label[text()='Supervisor Name']");
	By jobTitleField = By.xpath("//label[text()='Job Title']");
	By subUnitField = By.xpath("//label[text()='Sub Unit']");
	
	By employeeNameInput = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");
	By recordsFoundText = By.xpath("//span[contains(normalize-space(),'Record Found') or contains(normalize-space(),'Records Found')]");
	By tableRows = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']");
	
	
	public boolean verifyEmployeeInformationSection() throws InterruptedException
	{
		click(employeeListTab);
		Thread.sleep(3000);
		isDisplayed(employeeInformationSection);
		isDisplayed(employerNameField);
		isDisplayed(employerIdField);
		isDisplayed(employmentStatusField);
		isDisplayed(includeField);
		isDisplayed(supervisorNameField);
		isDisplayed(jobTitleField);
		isDisplayed(subUnitField);
		isDisplayed(addEmployeeButton);
		isDisplayed(resetButton);
		return isDisplayed(searchButton);
	}
	public boolean isSearchResultDisplayed() throws InterruptedException
	{
		sendKeys(employeeNameInput, "Peter");
		Thread.sleep(5000);
		click(searchButton);
		Thread.sleep(5000);
		return isDisplayed(recordsFoundText);
	}
	public int getResultCount() throws InterruptedException
	{
		List<WebElement> rows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tableRows));
		return rows.size();
	}
	
}
