package autoIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComposeEmail 
{
	public static WebDriver driver = null;
	public static String driverKey = "webdriver.chrome.driver";
	public static String driverValue = ".\\Drivers\\chromedriver.exe";
	public WebDriverWait wait = null;
	
	@BeforeMethod
	public void preConditions ()
	{
		System.setProperty(driverKey, driverValue);
		driver = new ChromeDriver ();
		wait = new WebDriverWait(driver, 10);
		//driver.get("https://www.gmail.com/");
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().window().maximize();
	//	driver.manage().deleteAllCookies();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	
	public void runAutoIT ()
	{
		try 
		{
			String strFilePath = "D:\\Abhijit\\Edureka\\TestSampleFile.txt";
			String strPath = "D:\\Abhijit\\Edureka\\AutoIT\\AttachmentForGmail.exe";
			String strParameter = strPath + " " + strFilePath;
			Runtime.getRuntime().exec(strParameter);
		}
		
		catch (Exception e) 
		{
			System.out.println("Unable to attach the file");
		}
		
		
	}
	
	
	
	@Test
	public void loginToGmail ()
	{
		//  driver.findElement(By.xpath("//ul[@class='h-c-header__cta-list header__nav--ltr']//a[contains(@class,'h-c-header__nav-li-link')][contains(text(),'Sign in')]")).click();
		//	driver.findElement(By.xpath("//div[contains(text(),'Use another account')]")).click();
		
		WebElement username = driver.findElement(By.xpath("//input[@id='identifierId']"));
		username.sendKeys("abhijitedureka@gmail.com");
		
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("Edureka@123");
		
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		wait.until(ExpectedConditions.titleContains("Gmail"));
		
		WebElement composeEmail = driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']"));
		composeEmail.click();
		
		WebElement toSender = driver.findElement(By.xpath("//textarea[@id=':75']"));
		toSender.sendKeys("abhijitsellcraft@gmail.com");
		
		WebElement subjectLine = driver.findElement(By.xpath("//input[@id=':7n']"));
		subjectLine.sendKeys("Selenium Test Email with attachment Test Sample file");
		
		WebElement messageBody = driver.findElement(By.xpath("//div[@id=':6i']"));
		messageBody.sendKeys("THis is a test email. Plz ignore");
		
		WebElement attachFile = driver.findElement(By.xpath("//div[@id=':bl']"));
		attachFile.click();
		
		runAutoIT();
		
		WebElement sendEmail = driver.findElement(By.xpath("//div[@id=':7x']"));
		sendEmail.click();
				
	}
	
	
	//@AfterMethod
	
//	public void closeBrowser ()
//	{
//		driver.close();
//	}


}