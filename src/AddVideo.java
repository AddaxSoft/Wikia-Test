import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddVideo {
	
	private WebDriver driver;
	private String toVerify;
	
	public AddVideo()
	{
		driver = new FirefoxDriver();
	}
	
	public void loadPage()
	{
		driver.get("http://testhomework.wikia.com/");
		
		
		
		//login - inject session
		Cookie cookie = new Cookie("wikicities_session", "d5b625b9aacaee99e98f69dfa93a8b74");
		driver.manage().addCookie(cookie);
		driver.navigate().refresh();
		
		//wait for page to correctly load
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public void click_contribute()
	{
		driver.findElement(By.className("drop")).click();
		
	}
	
	public void click_addVideo()
	{
		driver.findElement(By.linkText("Add a Video")).click();
		
		//wait for the new page to load and elements to appear
		WebDriverWait waiter = new WebDriverWait(driver, 15);
		waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("wpWikiaVideoAddUrl")));
	}
	
	public void typeURL()
	{
		String URL = "http://www.youtube.com/watch?v=h9tRIZyTXTI";
		driver.findElement(By.id("wpWikiaVideoAddUrl")).sendKeys(URL);		
	}
	
	public void submitURL()
	{		
		driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/form/div/input")).click();
		
		WebDriverWait waiter = new WebDriverWait(driver, 20);
		WebElement FileLink = waiter.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.cssSelector(
								"body > div.WikiaSiteWrapper > div.global-notification.confirm > div > a")));
		
		toVerify = FileLink.getText().substring(5);
		//System.out.print(toVerify);
		FileLink.click();
	}
	
	public boolean verifiedNames()
	{
		String FileName = driver.findElement(By.cssSelector("#WikiaPageHeader > h1")).getText();
		//System.out.print(FileName);
		return (toVerify.equals(FileName) || toVerify.replace(' ', '_').equals(FileName));
	}
	
	
	public void startFireFoxTest()
	{
		loadPage();
		click_contribute();
		click_addVideo();
		typeURL();
		submitURL();
		if(verifiedNames())
		{
			System.out.println("Names are identical");
		}
		else
		{
			System.out.println("Names are NOT identical");
		}
	}
	
	public void startChromeTest()
	{
		driver = new ChromeDriver();
		loadPage();
		click_contribute();
		click_addVideo();
		typeURL();
		submitURL();
		if(verifiedNames())
		{
			System.out.println("Names are identical");
		}
		else
		{
			System.out.println("Names are NOT identical");
		}
	}

	public static void main(String[] args) {
		
		AddVideo av = new AddVideo();
		av.startFireFoxTest();
		//av.startChromeTest();

	}

}
