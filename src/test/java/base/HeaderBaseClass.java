package base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Random.RandomDetails;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HeaderPOM;
import pages.HolisticCareerServicesPOM;
import pages.JourneyTowardsPOM;
import pages.KeySpecializationsPOM;
import pages.OpenFormBBA;
import pages.OverviewPOM;
import pages.PoscastPOM;
import pages.ProgramOverviewandStructurePOM;
import pages.ProgramhighlightsPOM;
import pages.ShareButton;
import pages.WhyChooseAmityPOM;
import pages.WhySayYesToAmityOnlinePOM;
import pages.AccreditationsandRecognitionsPOM;
import pages.AdmissionProcessPOM;
import pages.AnnouncementSection;
import pages.ApplyNowPOM;
import pages.BlueRFIPOM;
import pages.DownloadBrochure;
import pages.EligibilityCriteriaPOM;
import pages.FeeStructurePOM;
import reporting.HeaderExtent;
import org.openqa.selenium.TimeoutException;
import pages.ProgramRelatedSpecializationsPOM;
import pages.Sticky_Buttons_Call_whats_POM;
import pages.FrequentlyAskedQuestionPOM;
import pages.AreYouReadytoTakeTheNextStepPOM;
import pages.MeetOurTopRankedFacultyPOM;
import pages.EmployeesFromLeadingOrgPOM;


public class HeaderBaseClass {

	protected WebDriver driver;
	protected HeaderPOM hPom;
	protected ExtentReports reports;
	protected ExtentTest test;
	protected HeaderExtent headerExtent;
	protected ApplyNowPOM Apom;
	protected RandomDetails random;
	protected WebDriverWait wait;
	protected OpenFormBBA openformbba;
	protected DownloadBrochure dbrochure;
	protected ShareButton sbutton;
	protected AnnouncementSection announcement;
	protected OverviewPOM overview;
	protected PoscastPOM podcast;
	protected ProgramhighlightsPOM programhigh;
	protected FeeStructurePOM feestructure;
	protected WhyChooseAmityPOM whychoose;
	protected AccreditationsandRecognitionsPOM accreditations;
	protected ProgramOverviewandStructurePOM programoverview;
	protected KeySpecializationsPOM kspec;
	protected SoftAssert softAssert;
	protected JavascriptExecutor js;
	protected EligibilityCriteriaPOM criteria;
	protected AdmissionProcessPOM admissionprocess;
	protected JourneyTowardsPOM journeytowards;
	protected HolisticCareerServicesPOM holisticcaareer;
	protected WhySayYesToAmityOnlinePOM waysayyes;
	protected BlueRFIPOM BlueRFI;
	protected ProgramRelatedSpecializationsPOM programRelatedSpecializations;
	protected Sticky_Buttons_Call_whats_POM Sticky_Buttons_Call_whats;
	protected FrequentlyAskedQuestionPOM FrequentlyAskedQuestion;
	protected AreYouReadytoTakeTheNextStepPOM AreYouReadytoTakeTheNextStep;
	protected MeetOurTopRankedFacultyPOM MeetOurTopRankedFaculty;
	protected EmployeesFromLeadingOrgPOM EmployeesFromLeadingOrg;
	
	
	@BeforeMethod
	public void LaunchBrowser() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		// options.addArguments("headless");
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://amityonline.com/bachelor-of-business-administration-online");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		hPom=new HeaderPOM(driver);
		Apom=new ApplyNowPOM(driver);
		random=new RandomDetails(driver);
		openformbba=new OpenFormBBA(driver);
		dbrochure=new pages.DownloadBrochure(driver);
		sbutton=new ShareButton(driver);
		announcement=new AnnouncementSection(driver);
		overview=new OverviewPOM(driver);
		podcast=new PoscastPOM(driver);
		programhigh=new ProgramhighlightsPOM(driver);
		feestructure=new FeeStructurePOM(driver);
		whychoose=new WhyChooseAmityPOM(driver);
		accreditations=new AccreditationsandRecognitionsPOM(driver);
		programoverview=new ProgramOverviewandStructurePOM(driver);
		kspec=new KeySpecializationsPOM(driver); 
		softAssert = new SoftAssert(); // ✅ SoftAssert instance
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		js=((JavascriptExecutor)driver);
		criteria=new EligibilityCriteriaPOM(driver);
		admissionprocess=new AdmissionProcessPOM(driver);
		journeytowards=new JourneyTowardsPOM(driver);
		holisticcaareer=new HolisticCareerServicesPOM(driver);
		waysayyes=new WhySayYesToAmityOnlinePOM(driver);
		BlueRFI=new BlueRFIPOM(driver);
		programRelatedSpecializations = new ProgramRelatedSpecializationsPOM(driver);
		Sticky_Buttons_Call_whats = new Sticky_Buttons_Call_whats_POM(driver);
		FrequentlyAskedQuestion = new FrequentlyAskedQuestionPOM(driver);
		AreYouReadytoTakeTheNextStep = new AreYouReadytoTakeTheNextStepPOM(driver);
		MeetOurTopRankedFaculty = new MeetOurTopRankedFacultyPOM(driver);
		EmployeesFromLeadingOrg = new EmployeesFromLeadingOrgPOM(driver);

	}	


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
