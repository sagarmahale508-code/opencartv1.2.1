package testBase;


import org.apache.logging.log4j.LogManager;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;




public class BaseClass {
	//Loading Config.Properties
	
	public Properties p;
	public WebDriver driver;
	public  Logger logger; //to generate logs

	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os , String browser) throws IOException {
		
		
//Loading Properties File
		FileReader fl=new FileReader("./src/test/resources/config.properties");
		
		p=new Properties();
		p.load(fl);
		
		logger=LogManager.getLogger(this.getClass());
//		driver=new ChromeDriver();
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//capabilities.setPlatform(Platform.WIN11);
			//capabilities.setBrowserName("chrome");
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.WIN11);
			} 
			else {
				System.out.println("No Matching Os");
				return;
			}
			
			//browser
			switch(browser.toLowerCase()) {
			
			case "chrome": capabilities.setBrowserName("chrome");
			break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");
			break;
			}
			
			driver=new RemoteWebDriver(new URL("http://10.195.33.123:4444/wd/hub"),capabilities );
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(browser.toLowerCase()) {
			case "chrome" : driver=new ChromeDriver();	
			break;
			case "edge" :   driver=new EdgeDriver();
			break;
			default :System.out.println("Invalid Browser name"); return;
		
		
			}
		
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public  void teardown() {
		driver.quit();
	}
	
}
