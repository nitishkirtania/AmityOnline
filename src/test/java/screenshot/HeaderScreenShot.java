package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HeaderScreenShot {

	public static String takeScreenshot(WebDriver driver, String testname) throws IOException {
		TakesScreenshot src=((TakesScreenshot)driver);
		File srcshot = src.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + "/Reports/Screenshot/" + testname + ".png";
		File destFile=new File(destinationPath);
		destFile.getParentFile().mkdirs();
		FileUtils.copyFile(srcshot, destFile);
		return destinationPath;

	}

}
