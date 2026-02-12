package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils 
{
	static String currentWorkingDirectory;
	static String executionStartDate;
	public static String getScreenshot(WebDriver driver)
	{
		currentWorkingDirectory = System.getProperty("user.dir");
		executionStartDate = DateUtils.getCurrentDateAndTime();
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\Screenshots\\"+executionStartDate+".png";
		File destination=new File(path);
		
		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		
		return path;
	}
}
