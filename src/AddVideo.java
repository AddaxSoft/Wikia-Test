import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AddVideo {
	
	private WebDriver driver;
	
	public void loadPage()
	{
		driver.get("http://testhomework.wikia.com/");
		
		//wait for page to correctly load
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public void click_contribute()
	{
		
	}
	
	public void click_addVideo()
	{
		
	}
	
	public void typeURL()
	{
		String URL = "http://www.youtube.com/watch?v=h9tRIZyTXTI";
	}
	
	public void submitURL()
	{
		
	}
	
	public boolean verifiedNames()
	{
		return false;
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
