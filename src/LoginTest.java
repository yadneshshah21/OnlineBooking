
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LoginTest {

	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception 
	{		
		openUrl("Chrome");
		//signUp();
		doLogin();
		//driver.quit();
	}
	
	public static void openUrl(String browser)
	{
		if (browser.equalsIgnoreCase("Mozilla")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\resources\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}else {
			System.out.println("Please provide valid browser details!!!");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String url = "https://cheapticket.in/b2c/flights";
		
		driver.get(url);
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle="Cheap Airline Tickets, Domestic & International flight Booking at Lowest Airfare.";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public static void signUp() throws Exception
	{
		driver.findElement(By.id("signup")).click();
	
		
		driver.findElement(By.xpath("//div[@class='ui basic segment inside_form']/div[1]/input")).sendKeys("yadneshshah71@gmail.com");
		driver.findElement(By.xpath("//div[@class='ui basic segment inside_form']/div[2]/input")).sendKeys("8668673200");
		driver.findElement(By.xpath("//div[@class='ui basic segment inside_form']/div[3]/input")).sendKeys("Yadnesh");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ui basic segment inside_form']/div[4]/input")).sendKeys("test123");
		driver.findElement(By.xpath("//div[@class='ui basic segment inside_form']/div[5]/input")).sendKeys("test123");
		
		driver.findElement(By.xpath("//div[@class='ui basic segment inside_form']/button")).click();
		
		System.out.println("signup done");
	}
	
	public static void doLogin()
	{	
		driver.findElement(By.id("login")).click();
		driver.findElement(By.xpath("//div[@class='content']/form/div/div[1]/input")).sendKeys("yadneshshah91@gmail.com");
		driver.findElement(By.xpath("//div[@class='content']/form/div/div[2]/input")).sendKeys("test123");
		driver.findElement(By.xpath("//*[@class='ui small fluid blue button uppercase reset_button']")).click();
		
		
	}
	
	public static void doBooking() throws Exception
	{
		driver.findElement(By.xpath("//div[@class='header item b2bheaderlogo']")).click();
		Thread.sleep(3000);
	}
}
