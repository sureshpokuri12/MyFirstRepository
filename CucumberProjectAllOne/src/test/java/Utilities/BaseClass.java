package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	
	static String browsername;
	public static WebDriver driver;
	FetchDataFromExcel fsexcelurl=new FetchDataFromExcel();
	
	public static WebDriver intialization_Driver()
	{
		
		try {
			browsername=FetchDataFromProperty.fetchdatafromPropertyMethod().getProperty("browser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			try {
				driver.get(FetchDataFromExcel.getURL(1, 0));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		if(browsername.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			try {
				driver.get(FetchDataFromExcel.getURL(1, 0));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		if(browsername.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			try {
				driver.get(FetchDataFromExcel.getURL(1, 0));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return driver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//************************************************************************************************************************************************************************//
	public static void getTitle()
	{
		String getTitle=driver.getTitle();
		System.out.println(getTitle);
	}
	
	

	
	//static String filePath="C:\\Users\\pokur\\Desktop\\GROW SKILL IT TRAINING\\screenshotMine\\pic1.png";
	//static String folderPath ="C:\\Users\\pokur\\Desktop\\screenshotMine";
	    public static void takeScreenshot(String filepath) {
	        // Convert WebDriver object to TakesScreenshot
	        TakesScreenshot screenshot = (TakesScreenshot) driver; 
	        // Capture the screenshot and store it in a file
	        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
	        // Define destination file
	       // File destFile = new File("C:\\Users\\pokur\\Desktop\\GROW SKILL IT TRAINING\\screenshotMine\\pic1.png");
	        File destFile = new File(filepath);
	        try {
	            // Copy screenshot to the destination
	            FileUtils.copyFile(srcFile, destFile);
	           System.out.println("Screenshot saved: " + filepath);
	        } catch (IOException e) {
	            System.out.println("Failed to save screenshot: " + e.getMessage());
	        }
	    }
	
	
	    public static void maximizewindow()
	    {
	    	driver.manage().window().maximize();
	    }
	    
	    
	    public static void AddimplicityWait()
	    {
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }
	    
	    
	public static void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	

}
