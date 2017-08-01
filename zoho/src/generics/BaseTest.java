package generics;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(FWListener.class)
public abstract class BaseTest implements IAutoConst{
	public WebDriver driver;
	@BeforeSuite(alwaysRun=true)
	public void setDriverPath()
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	@Parameters({"node","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(String node,String browser)
			throws MalformedURLException{
		URL whichSystem=new URL(node);
		DesiredCapabilities whichBrowser=new DesiredCapabilities();
		whichBrowser.setBrowserName(browser);
		driver=new RemoteWebDriver(whichSystem,whichBrowser);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String url=UtilityLib.getPropertyValue(CONFIG_PATH,"URL");
		driver.get(url);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApp(){
		driver.quit();
	}
}





