package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeHRM_PIM_Configuration_Page extends BasePage
{
	public OrangeHRM_PIM_Configuration_Page(WebDriver driver)
	{
		super(driver); 
	}
	By pimLink = By.xpath("//ul[@class='oxd-main-menu']/child::li[2]/child::a");
	By pimTitle = By.xpath("//h6[text()='PIM']");
	By configurationDropdown = By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']");
	
	By optionalFieldsOption = By.xpath("//ul[@class='oxd-dropdown-menu']/child::li[1]/child::a");	
	By optionalFieldsPageTitle = By.xpath("//p[text()='Optional Fields']");
	By optionalFieldsSubTitle1 = By.xpath("//h6[text()='Show Deprecated Fields']");
	By optionalFieldsSubTitle2 = By.xpath("//h6[text()='Country Specific Information']");
	By optionalFieldsToggle1 = By.xpath("//p[text()='Show Nick Name, Smoker and Military Service in Personal Details']");
	By optionalFieldsToggle2 = By.xpath("//p[text()='Show SSN field in Personal Details']");
	By optionalFieldsToggle3 = By.xpath("//p[text()='Show SIN field in Personal Details']");
	By optionalFieldsToggle4 = By.xpath("//p[text()='Show US Tax Exemptions menu']");
	By saveButton = By.xpath("//button[@type='submit']");
	
	By customlFieldsOption = By.xpath("//ul[@class='oxd-dropdown-menu']/child::li[2]/child::a");
	By customFieldsPageTitle = By.xpath("//h6[text()='Custom Fields']");
	By addCustomFieldButton = By.xpath("//div[@class='orangehrm-header-container']/child::button");
	By customFieldName = By.xpath("//label[text()='Field Name']/following::input");
	By screenDropdown = By.xpath("//form[@class='oxd-form']/child::div[1]/descendant::div[@class='oxd-select-wrapper']");
	By selectScreen = By.xpath("//div[@role='listbox']/descendant::span[text()='Personal Details']");
	By typeDropdown = By.xpath("//form[@class='oxd-form']/child::div[2]/descendant::div[@class='oxd-select-wrapper']");
	By selectType = By.xpath("//div[@role='listbox']/descendant::span[text()='Text or Number']");
	By testRole = By.xpath("//div[contains(@class,'oxd-table-card')]//div[contains(text(),'TestRole')]");
	By confirmDeleteButton = By.xpath("//button[normalize-space()='Yes, Delete']");
	By deleteCustomFieldIcon = By.xpath("//div[@class='oxd-table-card']//div[contains(.,'TestRole')]//i[contains(@class,'bi-trash')]");
	
	By dataImportOption = By.xpath("//ul[@class='oxd-dropdown-menu']/child::li[3]/child::a");
	By dataImportPageTitle = By.xpath("//p[text()='Data Import']");
	
	By reportingMethodsOption = By.xpath("//ul[@class='oxd-dropdown-menu']/child::li[4]/child::a");
	By reportMethodsPageTitle = By.xpath("//p[text()='Reporting Methods']");
	By addReportingButton = By.xpath("//div[@class='orangehrm-header-container']/descendant::button/i");
	By enterReportName = By.xpath("//div[@class='oxd-form-row']/descendant::input");
	By testReport = By.xpath("//div[contains(@class,'oxd-table-card')]//div[contains(text(),'Test report A')]");
	By deleteReportIcon = By.xpath("//div[@class='oxd-table-card']//div[contains(.,'Test report A')]//i[contains(@class,'bi-trash')]");
	
	By terminationReasonsOption = By.xpath("//ul[@class='oxd-dropdown-menu']/child::li[5]/child::a");
	By terminationReasonsPageTitle  = By.xpath("//p[text()='Termination Reasons']");
	By addTerminationReasonsButton = By.xpath("//div[@class='orangehrm-header-container']/descendant::button");
	By enterTerminationReason = By.xpath("//div[@class='oxd-form-row']/descendant::input");
	By testTerminationReason = By.xpath("//div[contains(@class,'oxd-table-card')]//div[contains(text(),'Test Termination Reason')]");
	By deleteTerminationReasonIcon = By.xpath("//div[@class='oxd-table-card']//div[contains(.,'Test Termination Reason')]//i[contains(@class,'bi-trash')]");
			
	By saveSuccessMsg = By.xpath("//p[text()='Successfully Saved']");
	
	
	public void clickOnPIM()
	{
		click(pimLink);
	}
	public String verifyTitle()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(pimTitle)).getText();
	}
	public boolean verifyConfigurationDropdownOptions() throws InterruptedException
	{
		try
		{
			click(configurationDropdown);
			Thread.sleep(3000);
			if(isDisplayed(optionalFieldsOption))
			{
				click(optionalFieldsOption);
				Thread.sleep(5000);
				isDisplayed(optionalFieldsPageTitle);
				isDisplayed(optionalFieldsSubTitle1);
				isDisplayed(optionalFieldsToggle1);
				isDisplayed(optionalFieldsSubTitle2);
				isDisplayed(optionalFieldsToggle2);
				isDisplayed(optionalFieldsToggle3);
				isDisplayed(optionalFieldsToggle4);
				click(saveButton);
				if(verifyToastMessage("Successfully Saved"))
				{
					System.out.println("Optional fields are updated successfully");
				}
			}
			click(configurationDropdown);
			Thread.sleep(5000);
			if(isDisplayed(customlFieldsOption))
			{
				click(customlFieldsOption);
				Thread.sleep(5000);
				isDisplayed(customFieldsPageTitle);
				click(addCustomFieldButton);
				Thread.sleep(3000);
				sendKeys(customFieldName, "TestRole");
				click(screenDropdown);
				Thread.sleep(3000);
				click(selectScreen);
				click(typeDropdown);
				Thread.sleep(3000);
				click(selectType);
				click(saveButton);
				if(verifyToastMessage("Successfully Saved"))
				{
					System.out.println("Custom field is created successfully");
				}
				Thread.sleep(5000);
				click(deleteCustomFieldIcon);
		        click(confirmDeleteButton);
		        wait.until(ExpectedConditions.numberOfElementsToBe(testRole, 0));
		        System.out.println("Custom field is deleted successfully");
			}
			click(configurationDropdown);
			Thread.sleep(3000);
			if(isDisplayed(dataImportOption))
			{
				click(dataImportOption);
				Thread.sleep(5000);
				isDisplayed(dataImportPageTitle);			
			}
			click(configurationDropdown);
			Thread.sleep(3000);
			if(isDisplayed(reportingMethodsOption))
			{
				click(reportingMethodsOption);
				Thread.sleep(5000);
				isDisplayed(reportMethodsPageTitle);
				click(addReportingButton);
				sendKeys(enterReportName, "Test report A");
				click(saveButton);
				if(verifyToastMessage("Successfully Saved"))
				{
					System.out.println("Report is created successfully");
				}
				Thread.sleep(3000);
				click(deleteReportIcon);
		        click(confirmDeleteButton);
		        wait.until(ExpectedConditions.numberOfElementsToBe(testReport, 0));
				System.out.println("Report is deleted successfully");
			}
			
			click(configurationDropdown);
			if(isDisplayed(terminationReasonsOption))
			{
				click(terminationReasonsOption);
				Thread.sleep(5000);
				isDisplayed(terminationReasonsPageTitle);
				click(addTerminationReasonsButton);
				sendKeys(enterTerminationReason, "Test Termination Reason");
				click(saveButton);
				if(verifyToastMessage("Successfully Saved"))
				{
					System.out.println("Termination Reason is created successfully");
				}
				Thread.sleep(3000);
				click(deleteTerminationReasonIcon);
		        click(confirmDeleteButton);
		        wait.until(ExpectedConditions.numberOfElementsToBe(testTerminationReason, 0));
		        System.out.println("Termination Reason is deleted successfully");
			}	
			return true;
		}
		catch (Exception  e)
	    {
	        return false;
	    }
	}
}
