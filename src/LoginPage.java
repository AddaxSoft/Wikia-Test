import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
	private String user;
	private String pass;
	private WebDriver driver;
	
	public LoginPage(String user, String pass)
	{
		this.user = user;
		this.pass = pass;
		driver = new FirefoxDriver();
	}
	
	void loadPage()
	{
		driver.get("http://testhomework.wikia.com/");
		
		//wait for page to correctly load
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	void hoverOverMenu()
	{
		Actions mousehouver = new Actions(driver);
		mousehouver.moveToElement(driver.findElement(By.className("ajaxLogin")));
		mousehouver.perform();
		
		//wait for menu to appear
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("UserLoginDropdown")));
	}
	
	void userLogin()
	{
		driver.findElement(By.name("username")).sendKeys(this.user);
		driver.findElement(By.name("password")).sendKeys(this.pass);
		driver.findElement(By.className("login-button")).submit();
	}
	
	public void startFireFoxTest()
	{
		loadPage();
		hoverOverMenu();
		userLogin();
	}
	public void startChromeTesT()
	{
		driver = new ChromeDriver();
		loadPage();
		hoverOverMenu();
		userLogin();
	}

	
	
	
	
	public static void main(String[] args) {
		
		LoginPage lp = new LoginPage("akzidani", "ak_pass");
		lp.startFireFoxTest();
		//lp.startChromeTesT();
		
	}

}
