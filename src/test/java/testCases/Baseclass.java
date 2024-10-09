package testCases;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger;     //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Baseclass {

	
public static WebDriver driver;

public Logger logger; //log4j

// To Capture screenshot for the test pass and failed

public String captureScreen (String tname) throws IOException {
	
	String timeStamp = new  SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
	
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
	File targetFile= new File (targetFilePath);
	
	sourceFile.renameTo(targetFile);
	return targetFilePath;
	
}
	
	@BeforeClass
	
	public void setup()
	{
		logger=LogManager.getLogger(this.getClass()); //log4j manger
		
		
		
		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://qareader.kitaboo.com/6.0/pwa_6.0/#/login");
		driver.manage().window().maximize();
		
	}
	
@AfterClass 

public void tearDown()
{
	driver.quit();
}

}
