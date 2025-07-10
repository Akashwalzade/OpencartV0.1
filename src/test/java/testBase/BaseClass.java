package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
//	java -jar selenium-server-4.34.0.jar standalone -- to run the server in the remote with selenium gridjava
	
	public static WebDriver driver;
	public Logger logger; // create the logger varibale inside the base class to generate the log file
	public Properties p;
	@BeforeClass(groups= {"Master","sanity","Regression"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
//		loading the config properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger =LogManager.getLogger(this.getClass()); // 
		
//		os
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);

			}
			else {
				System.out.println("No Matching os");
				return;
			}
			
//			browser
			
			switch(br.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default:System.out.println("No matching browser"); return;			
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))  {
			
			switch(br.toLowerCase()) {
			case "chrome": driver= new ChromeDriver(); break;
			case "edge": driver= new EdgeDriver(); break;
			case "firefox": driver= new FirefoxDriver(); break;
			default:System.out.println("Invalid browser name"); return; // if browser name is wrong the next step should not execute amd exit from all
			}
			
		}
		
//		browser
		
		
		
		
//		loading the values from the config file
		
		
		
		
		driver.get(p.getProperty("appurl"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass(groups= {"Master","sanity","Regression"})
	public void tearDown() {
		driver.quit();

	}
	
	public String randomString() {
		String generatedstring= RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomNumber() {
		String generatednumber= RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomalphanumneric() {
		String generatednumber= RandomStringUtils.randomNumeric(10);
		String generatedstring= RandomStringUtils.randomAlphabetic(5);

		return (generatednumber+"@"+generatedstring);
	}
	
	public String captureScreen(String tname) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        
        TakesScreenshot takesscreenshot =  (TakesScreenshot)driver;
        
        File sourcefile = takesscreenshot.getScreenshotAs(OutputType.FILE);
        String filepath = System.getProperty("user.dir")+"\\screenshots\\"+ tname + "-" + timeStamp ;
        
        File targetfile = new File(filepath);
        sourcefile.renameTo(targetfile);
        
        return filepath;
	}
	

}
