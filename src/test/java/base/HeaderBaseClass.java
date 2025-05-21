package base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Random.RandomDetails;
import pages.HeaderPOM;
import pages.OpenFormMBA;
import pages.OverviewPOM;
import pages.PoscastPOM;
import pages.ProgramOverviewandStructurePOM;
import pages.ProgramhighlightsPOM;
import pages.ShareButton;
import pages.WhyChooseAmityPOM;
import pages.AccreditationsandRecognitionsPOM;
import pages.AnnouncementSection;
import pages.ApplyNowPOM;
import pages.DownloadBrochure;
import pages.FeeStructurePOM;
import reporting.HeaderExtent;

public class HeaderBaseClass {

	protected	WebDriver driver;
	protected	HeaderPOM hPom;
	protected	ExtentReports reports;
	protected ExtentTest test;
	protected HeaderExtent headerExtent;
	protected	ApplyNowPOM Apom;
	protected RandomDetails random;
	protected WebDriverWait wait;
	protected	OpenFormMBA openformmba;
	protected DownloadBrochure dbrochure;
	protected ShareButton sbutton;
	protected AnnouncementSection announcement;
	protected	OverviewPOM overview;
	protected PoscastPOM podcast;
	protected	ProgramhighlightsPOM programhigh;
	protected FeeStructurePOM feestructure;
	protected WhyChooseAmityPOM whychoose;
	protected AccreditationsandRecognitionsPOM accreditations;
	protected ProgramOverviewandStructurePOM programoverview;
	protected SoftAssert softAssert;
	

	@BeforeTest
	public void setupReport() {
		cleanScreenshotFolders();
		headerExtent=new HeaderExtent();
		reports = headerExtent.generateReport();

	}

	@AfterTest
	public void flushReport() {
		reports.flush();
	}

	public void cleanScreenshotFolders() {
		String screenshotDir = System.getProperty("user.dir") + "/Reports/Screenshot";
		deleteFilesInFolder(screenshotDir);
	}

	public void deleteFilesInFolder(String folderpath) {
		File folder=new File(folderpath);
		if (folder.exists() && folder.isDirectory()) {
			for (File file : folder.listFiles()) {
				if (file.isDirectory()) {
					deleteFilesInFolder(file.getAbsolutePath()); // recursive delete


				}else {
					boolean deleted = file.delete();
					if (!deleted) {
						System.out.println("Failed to delete: " + file.getAbsolutePath());
					}
				}
			}
		}

	}

	// Closing popup if appears
    public void closePopupIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(33));
            WebElement popupCloseButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bg-white padding-0-imp Modal_callUsModalClass__gzcBP Modal_dialog__e3Pgf']//*[name()='svg']")));
            popupCloseButton.click();
            System.out.println("Popup closed.");
        } catch (Exception e) {
            System.out.println("No popup found.");
        }
    }

}
