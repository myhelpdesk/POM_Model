package config;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunctions.AdminLoginPage;
import commonFunctions.AdminLogout;

public class AppUtil {
	
	public static WebDriver driver;
	public static Properties conpro;
	@BeforeTest
	public static void setUp()throws Throwable
	{
		conpro = new Properties();
		Thread.sleep(10000);
		conpro.load(new FileInputStream("./PropertyFiles\\Environment.properties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(conpro.getProperty("Url"));
		//call login page class
		//create object for AdminLoginPage by using PageFactory class
		//PageFactory class provided in to one static method that is initElements
		//initElements initialize what are the elements and methods that are available in admin login page ill initiate to this initElements method 
		AdminLoginPage login =PageFactory.initElements(driver, AdminLoginPage.class);
		//call login method
		login.adminLogin("admin", "master");
	}
	@AfterTest
	public static void tearDown()
	{
		AdminLogout logout = PageFactory.initElements(driver, AdminLogout.class);
		logout.adminLogout();
		driver.quit();
		
	}

}
