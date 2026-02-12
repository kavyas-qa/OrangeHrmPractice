package testRunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pages.OrangeHRM_Login_Page;
import pages.OrangeHRM_PIM_AddEmployee_Page;
import pages.OrangeHRM_PIM_Configuration_Page;
import pages.OrangeHRM_PIM_EmployeeList_Page;
import pages.OrangeHRM_PIM_Reports_Page;

public class PIM extends TestBase
{
	@Test
	public void verifyPIMPage() throws InterruptedException
	{
		extentTest = extent.createTest("Verify PIM page");
		//Login as Admin
		OrangeHRM_Login_Page lin = new OrangeHRM_Login_Page(driver);
		lin.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		lin.enterUserName("Admin");
		lin.enterPassword("admin123");
		Assert.assertTrue(lin.clickOnLoginBtn(), "Login failed");
		extentTest.log(Status.INFO, "Login success");
		
		//Verify the PIM page title
		OrangeHRM_PIM_Configuration_Page config = new OrangeHRM_PIM_Configuration_Page(driver);
		config.clickOnPIM();
		String actualPimTitle = "PIM";
		String expectedPimTitle = config.verifyTitle();
		Assert.assertEquals(expectedPimTitle, actualPimTitle);
		extentTest.log(Status.INFO, "Verified PIM page title successfully");
		
		//Verify the Configuration dropdown in PIM page
		Assert.assertTrue(config.verifyConfigurationDropdownOptions(), "Verify Configuration dropdown options failed");
		extentTest.log(Status.INFO, "Verified Configuration dropdown options successfully");
		
		//Verify the Add Employee feature in PIM page
		OrangeHRM_PIM_AddEmployee_Page addEmp = new OrangeHRM_PIM_AddEmployee_Page(driver);
		Assert.assertTrue(addEmp.addUpdateEmployeeDetails(), "Add/Update employee details failed");
		extentTest.log(Status.INFO, "Verified add/Update employee details successfully");
		Assert.assertTrue(addEmp.addEmergencyContacts(), "Add emergency contacts failed");
		extentTest.log(Status.INFO, "Verified add emergency contacts successfully");
		Assert.assertTrue(addEmp.addDependents(), "Add dependent details failed");
		extentTest.log(Status.INFO, "Verified add dependent details successfully");
		Assert.assertTrue(addEmp.addImmigration(), "Add immigration details failed");
		extentTest.log(Status.INFO, "Verified add immigration details successfully");
		Assert.assertTrue(addEmp.addSalaryDetails(), "Add Salary details failed");
		extentTest.log(Status.INFO, "Verified add Salary details successfully");
		Assert.assertTrue(addEmp.addQualificationDetails(), "Add qualification details failed");
		extentTest.log(Status.INFO, "Verified add qualification details successfully");
		Assert.assertTrue(addEmp.addMembershipDetails(), "Add membership details failed");
		extentTest.log(Status.INFO, "Verified add membership details successfully");
		
		//Verify the Employee list feature in PIM page
		OrangeHRM_PIM_EmployeeList_Page empList = new OrangeHRM_PIM_EmployeeList_Page(driver);
		Assert.assertTrue(empList.verifyEmployeeInformationSection(), "Employee information section verification failed");
		extentTest.log(Status.INFO, "Verified employee information section successfully");
		Assert.assertTrue(empList.isSearchResultDisplayed(), "Search result text is not displayed");
		extentTest.log(Status.INFO, "Verified search result successfully");
		Assert.assertTrue(empList.getResultCount() > 0, "No employee records found");
		extentTest.log(Status.INFO, "Verified employee records successfully");
		
		//Verify the Reports feature in PIM page
		OrangeHRM_PIM_Reports_Page reportPage = new OrangeHRM_PIM_Reports_Page(driver);
		Assert.assertTrue(reportPage.verifyReportPage(), "Report page verification failed");
		extentTest.log(Status.INFO, "Verified Report page successfully");
		extentTest.log(Status.INFO, "Verified PIM page successfully");
		
	}
}
