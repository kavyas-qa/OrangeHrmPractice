package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_PIM_Page 
{
	WebDriver driver;
	public OrangeHRM_PIM_Page(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//ul[@class='oxd-main-menu']/child::li[2]/child::a") WebElement pimLink;
	@FindBy(xpath="//h6[text()='PIM']") WebElement pimTitle;
	@FindBy(xpath="//span[@class='oxd-topbar-body-nav-tab-item']") WebElement configurationDropdown;
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/child::li[1]/child::a") WebElement optionalFieldsOption;
	
	
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/child::li[4]/child::a") WebElement reportingMethodsOption;
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/child::li[5]/child::a") WebElement terminationReasonsOption;
	@FindBy(xpath="//p[text()='Optional Fields']") WebElement optionalFieldsTitle;
	@FindBy(xpath="//h6[text()='Show Deprecated Fields']") WebElement optionalFieldsSubTitle1;
	@FindBy(xpath="//h6[text()='Country Specific Information']") WebElement optionalFieldsSubTitle2;
	@FindBy(xpath="//p[text()='Show Nick Name, Smoker and Military Service in Personal Details']") WebElement optionalFieldsToggle1;
	@FindBy(xpath="//p[text()='Show SSN field in Personal Details']") WebElement optionalFieldsToggle2;
	@FindBy(xpath="//p[text()='Show SIN field in Personal Details']") WebElement optionalFieldsToggle3;
	@FindBy(xpath="//p[text()='Show US Tax Exemptions menu']") WebElement optionalFieldsToggle4;
	@FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/child::li[2]/child::a") WebElement customlFieldsOption;
	@FindBy(xpath="//h6[text()='Custom Fields']") WebElement customFieldsTitle;
	@FindBy(xpath="//div[@class='orangehrm-header-container']/child::button") WebElement addButton;
	@FindBy(xpath="//form[@class='oxd-form']/child::div[1]/descendant::input") WebElement customFieldName;
	@FindBy(xpath="//form[@class='oxd-form']/child::div[1]/descendant::div[@class='oxd-select-wrapper']") WebElement screenDropdown;
	@FindBy(xpath="//div[@role='listbox']/descendant::span[text()='Personal Details']") WebElement selectScreen;
	@FindBy(xpath="//form[@class='oxd-form']/child::div[2]/descendant::div[@class='oxd-select-wrapper']") WebElement typeDropdown;
	@FindBy(xpath="//div[@role='listbox']/descendant::span[text()='Text or Number']") WebElement selectType;
	@FindBy(xpath="///div[text()='TestRole']") WebElement testRole;
	@FindBy(xpath="(//div[@class='oxd-checkbox-wrapper'])[3]//descendant::i") WebElement selectTheCheckbox;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/button") WebElement deleteSelected;
	@FindBy(xpath="//div[@class='orangehrm-modal-footer']/child::button[2]") WebElement deleteButton;
	
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/child::li[3]/child::a") WebElement dataImportOption;
	
	@FindBy(xpath="//form[@class='oxd-form']/descendant::input[2]") WebElement empIdTextBox;
	@FindBy(xpath="//button[@type='submit']") WebElement searchBtn;
	@FindBy(xpath="//div[@class='oxd-table-card']/child::div/child::div[3]/child::div") WebElement empName;
	
	
	public void clickOnPIM()
	{
		pimLink.click();
	}
	public String verifyTitle()
	{
		return pimTitle.getText();
	}
	public void verifyConfigurationDropdownOptions() throws InterruptedException
	{
		configurationDropdown.click();
		if(optionalFieldsOption.isDisplayed())
		{
			optionalFieldsOption.click();
			optionalFieldsTitle.isDisplayed();
			optionalFieldsSubTitle1.isDisplayed();
			optionalFieldsToggle1.isDisplayed();
			optionalFieldsSubTitle2.isDisplayed();
			optionalFieldsToggle2.isDisplayed();
			optionalFieldsToggle3.isDisplayed();
			optionalFieldsToggle3.isDisplayed();
			saveButton.click();
		}
		configurationDropdown.click();
		if(customlFieldsOption.isDisplayed())
		{
			customlFieldsOption.click();
			customFieldsTitle.isDisplayed();
			addButton.click();
			customFieldName.sendKeys("TestRole");
			screenDropdown.click();
			Thread.sleep(3000);
			selectScreen.click();
			typeDropdown.click();
			Thread.sleep(3000);
			selectType.click();
			saveButton.click();
			Thread.sleep(3000);
			testRole.isDisplayed();
			selectTheCheckbox.click();
			deleteSelected.click();
			deleteButton.click();
			Thread.sleep(3000);
			testRole.isDisplayed();
		}
		configurationDropdown.click();
		if(dataImportOption.isDisplayed())
		{
			dataImportOption.click();
			
			
		}
	}
}
