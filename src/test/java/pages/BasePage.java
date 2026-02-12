package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	protected WebDriver driver;
    protected WebDriverWait wait;
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	private void waitForLoaderToDisappear()
	{
        try
        {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-loading-spinner")));
        } 
        catch (Exception e)
        {
            // Ignore if loader not present
        }
    }
	public void click(By locator) 
	{
		waitForLoaderToDisappear();
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        element.click();
	}
	public void clear(By locator) 
	{
		waitForLoaderToDisappear();
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        element.clear();
	}
	public void sendKeys(By locator, String text) 
	{
		waitForLoaderToDisappear();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
	}
	public boolean isDisplayed(By locator)
	{
	    try 
	    {
	    	waitForLoaderToDisappear();
	    	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    	return element.isDisplayed();
	    } 
	    catch (TimeoutException  e)
	    {
	        return false;
	    }
	}
	public boolean verifyToastMessage(String expectedText) 
	{
	    try 
	    {
	        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        By toast = By.cssSelector(".oxd-toast");
	        WebElement toastElement = shortWait.until(ExpectedConditions.visibilityOfElementLocated(toast));
	        String actualText = toastElement.getText();
	        return actualText.contains(expectedText);
	    } 
	    catch (TimeoutException e)
	    {
	        return false;
	    }
	}
}
