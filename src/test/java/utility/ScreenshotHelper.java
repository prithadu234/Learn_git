package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {

	//WebDriver driver;
	

	public  void getScreenshot( WebDriver driver,String filename) throws Exception {

		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		
		
		File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

		File targetLocation = new File(".//IBM_screenshot//"+ filename + ".png");

		FileUtils.copyFile(screenshotFile, targetLocation);
	}

}

