package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeHRM_PIM_AddEmployee_Page extends BasePage
{
	public OrangeHRM_PIM_AddEmployee_Page(WebDriver driver)
	{
		super(driver); 
	}
	By addEmployeeTab = By.xpath("//a[text()='Add Employee']");
	By addEmployeePageTitle = By.xpath("//h6[text()='Add Employee']");
	By firstNameTextbox = By.name("firstName");
	By lastNameTextbox = By.name("lastName");
	By empId = By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
	By saveButton = By.xpath("//button[@type='submit']");
	By empNameHeading = By.xpath("//h6[text()='Peter Test']");
	By middleNameTextbox = By.name("middleName");
	By empNickNameTextbox = By.xpath("//label[text()='Nickname']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
	By employeedIdTextbox = By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
	By empLicenseNumberTextbox = By.xpath("//label[text()=\"Driver's License Number\"]/ancestor::div[contains(@class, 'oxd-input-group')]//input");
	By empNationalityField = By.xpath("//label[text()='Nationality']/ancestor::div[contains(@class, 'oxd-input-group')]//div[@class='oxd-select-wrapper']");
	By empMaritalStatusField = By.xpath("//label[text()='Marital Status']/ancestor::div[contains(@class, 'oxd-input-group')]//div[@class='oxd-select-wrapper']");
	By empDobField = By.xpath("//label[text()='Date of Birth']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
	By genderRadioButton = By.xpath("(//label[text()='Gender']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-radio-input')])[1]");
	By savePersonalDetails = By.xpath("(//button[@type='submit'])[1]");
	By bloodTypeField = By.xpath("//label[text()='Blood Type']/ancestor::div[contains(@class, 'oxd-input-group')]//div[@class='oxd-select-wrapper']");
	By Test_field = By.xpath("//label[text()='Test_Field']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
	By saveCustomFields = By.xpath("(//button[@type='submit'])[2]");
	By saveSuccessMsg = By.xpath("//p[text()='Successfully Saved']");
	By updateSuccessMsg = By.xpath("//p[text()='Successfully Updated']");
	
	By contactDetailsLink = By.xpath("//a[text()='Contact Details']");
	By empStreet = By.xpath("//label[text()='Street 1']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
	By empCity = By.xpath("//label[text()='City']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
	By empState = By.xpath("//label[text()='State/Province']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
	By empMobileNo = By.xpath("//label[text()='Mobile']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
	By empWorkEmail = By.xpath("//label[text()='Work Email']/ancestor::div[contains(@class, 'oxd-input-group')]//input");
	By saveContactDetails = By.xpath("//button[@type='submit']");
	
	By emergencyContactsDetailsLink = By.xpath("//a[text()='Emergency Contacts']");
	By addEmergencyContactButton = By.xpath("(//button[contains(@class, 'oxd-button')])[1]");
	By emergencyContactName = By.xpath("//label[contains(@class,'oxd-input-field-required') and text()='Name']/following::input[1]");
	By emergencyContactRelationship = By.xpath("//label[contains(@class,'oxd-input-field-required') and text()='Relationship']/following::input[1]");
	By emergencyContactPhone = By.xpath("//label[contains(@class,'oxd-label') and text()='Home Telephone']/following::input[1]");
	
	By dependentsLink = By.xpath("//a[text()='Dependents']");
	By relationshipDropdown = By.xpath("//label[text()='Relationship']/ancestor::div[contains(@class, 'oxd-input-group')]//div[@class='oxd-select-wrapper']");
	By specifyDependentField = By.xpath("//label[contains(@class,'oxd-input-field-required') and text()='Please Specify']/following::input[1]");
	
	By immigationLink = By.xpath("//a[text()='Immigration']");
	By passportNumberField = By.xpath("//label[contains(@class,'oxd-input-field-required') and text()='Number']/following::input[1]");
	
	By salaryLink = By.xpath("//a[text()='Salary']");
	By salaryComponent = By.xpath("//label[contains(@class,'oxd-input-field-required') and text()='Salary Component']/following::input[1]");
	By salaryCurrencyDropdown = By.xpath("//label[text()='Currency']/ancestor::div[contains(@class, 'oxd-input-group')]//div[@class='oxd-select-wrapper']");
	By salaryAmount = By.xpath("//label[contains(@class,'oxd-input-field-required') and text()='Amount']/following::input[1]");
	
	By qualificationsLink = By.xpath("//a[text()='Qualifications']");
	By companyNameField = By.xpath("//label[contains(@class,'oxd-input-field-required') and text()='Company']/following::input[1]");
	By jobTitleField = By.xpath("//label[contains(@class,'oxd-input-field-required') and text()='Job Title']/following::input[1]");
	
	By membershipsLink = By.xpath("//a[text()='Memberships']");
	By membershipDropdown = By.xpath("//label[text()='Membership']/ancestor::div[contains(@class, 'oxd-input-group')]//div[@class='oxd-select-wrapper']");
	
	public boolean addUpdateEmployeeDetails() throws InterruptedException
	{
		click(addEmployeeTab);
		Thread.sleep(3000);
		isDisplayed(addEmployeePageTitle);
		sendKeys(firstNameTextbox, "Peter");
		sendKeys(lastNameTextbox, "Test");
		clear(empId);
		click(saveButton);
		Thread.sleep(3000);
		if(verifyToastMessage("Successfully Saved"))
		{
			System.out.println("New employee is added successfully");
		}
		Thread.sleep(10000);
		isDisplayed(empNameHeading);
		sendKeys(middleNameTextbox, "S");
		sendKeys(empLicenseNumberTextbox, "7388");
		Thread.sleep(3000);
		click(empNationalityField);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		click(empMaritalStatusField);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		sendKeys(empDobField, "1994-07-08");
		Thread.sleep(3000);
		click(genderRadioButton);
		click(savePersonalDetails);
		if(verifyToastMessage("Successfully Updated"))
		{
			System.out.println("Personal details updated successfully");
		}
		Thread.sleep(5000);
		click(bloodTypeField);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		sendKeys(Test_field, "Test");
		click(saveCustomFields);
		return verifyToastMessage("Successfully Saved");
	}
	public boolean addContactDetails() throws InterruptedException
	{
		click(contactDetailsLink);
		Thread.sleep(3000);
		sendKeys(empStreet, "1st cross");
		sendKeys(empCity, "Banaglore");
		sendKeys(empState, "Karnataka");
		sendKeys(empMobileNo, "9999999999");
		sendKeys(empWorkEmail, "testuser@example.com");
		click(saveContactDetails);
		Thread.sleep(3000);
		return verifyToastMessage("Successfully Updated");
	}
	
	public boolean addEmergencyContacts() throws InterruptedException
	{
		click(emergencyContactsDetailsLink);
		Thread.sleep(3000);
		click(addEmergencyContactButton);
		sendKeys(emergencyContactName, "John S");
		sendKeys(emergencyContactRelationship, "Brother");
		sendKeys(emergencyContactPhone, "+919999999999");
		click(saveContactDetails);
		Thread.sleep(3000);
		return verifyToastMessage("Successfully Saved");
	}
	
	public boolean addDependents() throws InterruptedException
	{
		click(dependentsLink);
		Thread.sleep(3000);
		click(addEmergencyContactButton);
		sendKeys(emergencyContactName, "John S");
		click(relationshipDropdown);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		sendKeys(specifyDependentField, "Brother");
		click(saveContactDetails);
		Thread.sleep(3000);
		return verifyToastMessage("Successfully Saved");
	}
	public boolean addImmigration() throws InterruptedException
	{
		click(immigationLink);
		Thread.sleep(3000);
		click(addEmergencyContactButton);
		sendKeys(passportNumberField, "12345678");
		click(saveContactDetails);
		Thread.sleep(3000);
		return verifyToastMessage("Successfully Saved");
	}

	public boolean addSalaryDetails() throws InterruptedException
	{
		click(salaryLink);
		Thread.sleep(3000);
		click(addEmergencyContactButton);
		sendKeys(salaryComponent, "Fixed");
		click(salaryCurrencyDropdown);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		sendKeys(salaryAmount, "10000");
		click(saveContactDetails);
		Thread.sleep(3000);
		return verifyToastMessage("Successfully Saved");
	}
	
	public boolean addQualificationDetails() throws InterruptedException
	{
		click(qualificationsLink);
		Thread.sleep(3000);
		click(addEmergencyContactButton);
		sendKeys(companyNameField, "Test Company");
		sendKeys(jobTitleField, "Tester");
		click(saveContactDetails);
		Thread.sleep(3000);
		return verifyToastMessage("Successfully Saved");
	}
	
	public boolean addMembershipDetails() throws InterruptedException
	{
		click(membershipsLink);
		Thread.sleep(3000);
		click(addEmergencyContactButton);
		click(membershipDropdown);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		click(saveContactDetails);
		Thread.sleep(3000);
		return verifyToastMessage("Successfully Saved");
	}
}
