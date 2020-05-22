package autoIT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginToFacebook 
{

	String driverKey = "webdriver.chrome.driver";
	String driverValue = ".\\Drivers\\chromedriver.exe";
	public static WebDriver driver = null;
	public WebDriverWait wait = null;
	
	@BeforeMethod
	public void preConditions ()
	{
		System.setProperty(driverKey, driverValue);
		driver = new ChromeDriver ();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void loginFacebook () throws FindFailed
	{
		Screen screen = new Screen ();
		Pattern FacebookUsername = new Pattern ("D:\\Abhijit\\Edureka\\Sikuli\\FacebookUsername.png");
		Pattern FacebookPassword = new Pattern ("D:\\Abhijit\\Edureka\\Sikuli\\FacebookPassword.png");
		Pattern FacebookLogin = new Pattern ("D:\\Abhijit\\Edureka\\Sikuli\\FacebookLogin.png");
		
		screen.wait(FacebookUsername, 10);
		screen.type(FacebookUsername, "Abhijit");
		screen.type(FacebookPassword, "Abhijit");
		screen.click(FacebookLogin);
	}
	
	
	
	@AfterMethod
	public void closeBrowser ()
	{
		driver.close();
	}
	
	
}
