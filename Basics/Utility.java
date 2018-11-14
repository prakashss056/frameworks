package testng.Basics;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static String captureScreenshot(WebDriver driver, String Screenshotname) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("./basicsprojectScreenshots/" + " "+Screenshotname + ".png");
//	String path= System.getProperty("user.dir")+"/screenshotsfolder/"+screenshotname + ".png"+System.currentTimeMillis();
//	File dest=new File(path);
//try {
			FileUtils.copyFile(source,dest);
			System.out.println("scrteenshot taken");
//}
		} catch (Exception e) {
			System.out.println("Exception while taking the screenshot" + e.getMessage());
		}
		return Screenshotname;
	}
}
