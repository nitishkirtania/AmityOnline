package Program.MBA;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Assert.softAssert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.applitools.eyes.selenium.rendering.WebElementRegion;
import com.aventstack.extentreports.Status;

import Random.RandomDetails;
import base.HeaderBaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.timeout.TimeoutException;
import pages.AccreditationsandRecognitionsPOM;
import pages.AnnouncementSection;
import pages.ApplyNowPOM;
import pages.FeeStructurePOM;
import pages.HeaderPOM;
import pages.OpenFormMBA;
import pages.OverviewPOM;
import pages.PoscastPOM;
import pages.ProgramOverviewandStructurePOM;
import pages.ProgramhighlightsPOM;
import pages.ShareButton;
import pages.WhyChooseAmityPOM;
import screenshot.HeaderScreenShot;

public class MBAProgram_new extends HeaderBaseClass{


	@BeforeMethod
	public void LaunchBrowser() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("headless");
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://amityonline.com/master-of-business-administration-online");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		hPom=new HeaderPOM(driver);
		Apom=new ApplyNowPOM(driver);
		random=new RandomDetails(driver);
		openformmba=new OpenFormMBA(driver);
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
        softAssert = new SoftAssert(); // ✅ SoftAssert instance
	}



public void Showmore() {	  
	        // Click 'SHOW MORE'
	        WebElement showMoreBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn);
	}
	
	@Test
	public void FooterSection() throws InterruptedException {
		test = reports.createTest("Footer Section");

		Showmore();
		// Thread.sleep(2000);
	    try {
            closePopupIfPresent();
	        // Click 'About us'
	        WebElement aboutUs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='About us']")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutUs);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", aboutUs);
	        wait.until(ExpectedConditions.urlContains("about-us"));
	        String aboutUrl = driver.getCurrentUrl();
	        System.out.println("Current URL after navigating to About us: " + aboutUrl);
	        softAssert.assertEquals(aboutUrl, "https://amityonline.com/about-us", "About Us URL mismatch");
	        test.log(Status.PASS, "Navigated to About Us page: " + aboutUrl);
	    } catch (Exception e) {
	        test.log(Status.FAIL, "Navigation to About Us page failed: " + e.getMessage());
	        softAssert.fail("Navigation to About Us page failed: " + e.getMessage());
	    }

	    driver.navigate().back();
	    // Thread.sleep(2000);

	    try {
	    	Showmore();
	        // Click 'Career services' (opens in new tab)
	        String originalWindow = driver.getWindowHandle();
	        WebElement careerServices = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Career services']")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", careerServices);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", careerServices);
	        // Wait for new tab
	        wait.until(driver -> driver.getWindowHandles().size() > 1);

	        // Switch to new tab
	        for (String handle : driver.getWindowHandles()) {
	            if (!handle.equals(originalWindow)) {
	                driver.switchTo().window(handle);
	                break;
	            }
	        }

	        wait.until(ExpectedConditions.urlContains("career-services"));
	        String careerUrl = driver.getCurrentUrl();
	        System.out.println("Current URL after navigating to Career services: " + careerUrl);
	        softAssert.assertEquals(careerUrl, "https://amityonline.com/career-services", "About Us URL mismatch");
	        test.log(Status.PASS, "Navigated to Career Services page: " + careerUrl);
	        // Optional: Close new tab and return to original
	        driver.close();
	        driver.switchTo().window(originalWindow);

	    } catch (Exception e) {
	        test.log(Status.FAIL, "Career Services navigation failed: " + e.getMessage());
	        softAssert.fail("Career Services navigation failed: " + e.getMessage());
	    }

        try {
	         // Click 'Student stories'
	        WebElement studentstories = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Student stories']")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", studentstories);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", studentstories);
	        wait.until(ExpectedConditions.urlContains("student-story"));
	        String studentstoriesUrl = driver.getCurrentUrl();
	        System.out.println("Current URL after navigating to Student Stories: " + studentstoriesUrl);
	        Assert.assertEquals(studentstoriesUrl, "https://amityonline.com/student-story", "URL does not contain 'student-story'");
	        test.log(Status.PASS, "Navigated to Student stories page: " + studentstoriesUrl);
	    } catch (Exception e) {
	        test.log(Status.FAIL, "Navigation to Student stories page failed: " + e.getMessage());
	        softAssert.fail("Navigation to Student stories page failed: " + e.getMessage());
	    }

	    driver.navigate().back();
        
        // Click 'SHOW MORE' and navigate to 'Leadership'
        try {
            Showmore();
            WebElement leadership = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Leadership']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", leadership);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", leadership);
            wait.until(ExpectedConditions.urlContains("leadership"));
            String leadershipUrl = driver.getCurrentUrl();
            System.out.println("Current URL after navigating to Leadership: " + leadershipUrl);
            Assert.assertEquals(leadershipUrl, "https://amityonline.com/leadership", "URL does not contain 'leadership'");
            test.log(Status.PASS, "Navigated to Leadership page: " + leadershipUrl);
        } catch (Exception e) {
            test.log(Status.FAIL, "Navigation to Leadership page failed: " + e.getMessage());
            softAssert.fail("Navigation to Leadership page failed: " + e.getMessage());
        }
        driver.navigate().back();

        // Click 'SHOW MORE' and navigate to 'Corporate'
        try {
            Showmore();
            WebElement corporate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Corporate']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", corporate);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", corporate);
            wait.until(ExpectedConditions.urlContains("corporates"));
            String corporateUrl = driver.getCurrentUrl();
            System.out.println("Current URL after navigating to Corporate: " + corporateUrl);
            Assert.assertEquals(corporateUrl, "https://amityonline.com/corporates", "URL does not contain 'corporate'");
            test.log(Status.PASS, "Navigated to Corporate page: " + corporateUrl);
        } catch (Exception e) {
            test.log(Status.FAIL, "Navigation to Corporate page failed: " + e.getMessage());
            softAssert.fail("Navigation to Corporate page failed: " + e.getMessage());
        }
        driver.navigate().back();

        // Click 'SHOW MORE' and navigate to 'Contact us'
        try {
            Showmore();
            WebElement contactUs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Contact us']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactUs);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", contactUs);
            wait.until(ExpectedConditions.urlContains("contact-us"));
            String contactUrl = driver.getCurrentUrl();
            System.out.println("Current URL after navigating to Contact Us: " + contactUrl);
            Assert.assertEquals(contactUrl,"https://amityonline.com/contact-us", "URL does not contain 'contact-us'");
            test.log(Status.PASS, "Navigated to Contact Us page: " + contactUrl);
        } catch (Exception e) {
            test.log(Status.FAIL, "Navigation to Contact Us page failed: " + e.getMessage());
            softAssert.fail("Navigation to Contact Us page failed: " + e.getMessage());
        }
        driver.navigate().back();

        // Click 'SHOW MORE' and navigate to 'Privacy Policy'
        try {
            Showmore();
            WebElement privacyPolicy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@target='_self'][normalize-space()='Privacy Policy']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", privacyPolicy);
            wait.until(ExpectedConditions.urlContains("privacy-policy"));
            String privacyPolicyUrl = driver.getCurrentUrl();
            System.out.println("Current URL after navigating to Privacy Policy: " + privacyPolicyUrl);
            Assert.assertEquals(privacyPolicyUrl, "https://amityonline.com/privacy-policy", "URL does not contain 'privacy-policy'");
            test.log(Status.PASS, "Navigated to Privacy Policy page: " + privacyPolicyUrl);
        } catch (Exception e) {
            test.log(Status.FAIL, "Navigation to Privacy Policy page failed: " + e.getMessage());
            softAssert.fail("Navigation to Privacy Policy page failed: " + e.getMessage());
        }
        driver.navigate().back();

        try {
            Showmore();
            // Click 'Student Support'
            WebElement studentSupport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Student support']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", studentSupport);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", studentSupport);
            wait.until(ExpectedConditions.urlContains("home"));
            String studentSupportUrl = driver.getCurrentUrl();
            System.out.println("Current URL after navigating to Student Support: " + studentSupportUrl);
            Assert.assertEquals(studentSupportUrl, "https://amitysupport.freshdesk.com/support/home", "URL does not contain 'home'");
            test.log(Status.PASS, "Navigated to Student Support page: " + studentSupportUrl);
        } catch (Exception e) {
            test.log(Status.FAIL, "Navigation to Student Support page failed: " + e.getMessage());
            softAssert.fail("Navigation to Student Support page failed: " + e.getMessage());
        }

        driver.navigate().back();

        try {
            Showmore();
            // Click 'Intellectual Properties'
            WebElement intellectualPro = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Intellectual Properties']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", intellectualPro);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", intellectualPro);
            wait.until(ExpectedConditions.urlContains("ip-listing"));
            String intellectualProUrl = driver.getCurrentUrl();
            System.out.println("Current URL after navigating to Intellectual Properties: " + intellectualProUrl);
            Assert.assertEquals(intellectualProUrl,"https://amityonline.com/ip-listing", "URL does not contain 'ip-listing'");
            test.log(Status.PASS, "Navigated to Intellectual Properties page: " + intellectualProUrl);
        } catch (Exception e) {
            test.log(Status.FAIL, "Navigation to Intellectual Properties page failed: " + e.getMessage());
            softAssert.fail("Navigation to Intellectual Properties page failed: " + e.getMessage());
        }

        driver.navigate().back();

        try {
            Showmore();
            // Click 'UGC Approvals'
            WebElement ugcApprovals = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='UGC Approvals']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ugcApprovals);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ugcApprovals);
            wait.until(ExpectedConditions.urlContains("ugc_regulations"));
            String ugcApprovalsUrl = driver.getCurrentUrl();
            System.out.println("Current URL after navigating to UGC Approvals: " + ugcApprovalsUrl);
            Assert.assertEquals(ugcApprovalsUrl, "https://amityonline.com/ugc_regulations/", "URL does not contain 'ugc_regulations'");
            test.log(Status.PASS, "Navigated to UGC Approvals page: " + ugcApprovalsUrl);
        } catch (Exception e) {
            test.log(Status.FAIL, "Navigation to UGC Approvals page failed: " + e.getMessage());
            softAssert.fail("Navigation to UGC Approvals page failed: " + e.getMessage());
        }

        driver.navigate().back();

	    // Call assertAll at the end to mark test failed if any soft assertion failed
	    softAssert.assertAll();
	}

@Test
public void resourcesSection() {
    test = reports.createTest("Click 'Resources' → Blog → Media");
    // Step 1: Click 'SHOW MORE' and navigate to Blog
    try {
        Showmore();
        WebElement blog = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Blog']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", blog);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", blog);
        wait.until(ExpectedConditions.urlContains("blog"));
        String blogUrl = driver.getCurrentUrl();
        System.out.println("Current URL after navigating to Blog: " + blogUrl);
        Assert.assertEquals(blogUrl, "https://amityonline.com/blog", "URL does not contain 'blog'");
        test.log(Status.PASS, "Navigated to Blog page: " + blogUrl);
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Blog page failed: " + e.getMessage());
        softAssert.fail("Navigation to Blog page failed: " + e.getMessage());
    }

    driver.navigate().back();
    // Step 2: Click 'SHOW MORE' and navigate to Media
    try {
        Showmore();
        WebElement media = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Media']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", media);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", media);
        wait.until(ExpectedConditions.urlContains("news"));
        String mediaUrl = driver.getCurrentUrl();
        System.out.println("Current URL after navigating to Media: " + mediaUrl);
        Assert.assertEquals(mediaUrl, "https://amityonline.com/news", "URL does not contain 'news'");
        test.log(Status.PASS, "Navigated to Media page: " + mediaUrl);
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Media page failed: " + e.getMessage());
        softAssert.fail("Navigation to Media page failed: " + e.getMessage());
    }
    driver.navigate().back();

    softAssert.assertAll();
}

@Test
public void ugProgramSection() {
    test = reports.createTest("Click 'UG Program'");

    // Step 1: Navigate to 'Bachelor of Computer Applications'
    try {
        Showmore();
        WebElement bcaLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Computer Applications']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bcaLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bcaLink);

        wait.until(ExpectedConditions.urlContains("bachelor-of-computer-applications-online"));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Navigated URL: " + currentUrl);
        Assert.assertEquals(currentUrl, "https://amityonline.com/bachelor-of-computer-applications-online", "URL mismatch after clicking BCA.");
        test.log(Status.PASS, "Navigated to BCA page: " + currentUrl);
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to BCA page failed: " + e.getMessage());
        softAssert.fail("Navigation to BCA page failed: " + e.getMessage());
    }

    driver.navigate().back();

    // Step 2: Navigate to 'BCA with specialization in Cloud & Security'
    try {
        Showmore();

        WebElement bcaWithCloudSecurity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='BCA with specialization in Cloud & Security']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bcaWithCloudSecurity);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bcaWithCloudSecurity);
        wait.until(ExpectedConditions.urlContains("bca-cloud-security-online"));
        String bcaWithCloudSecurityUrl = driver.getCurrentUrl();
        System.out.println("Current URL after navigating to BCA with specialization in Cloud & Security: " + bcaWithCloudSecurityUrl);
        Assert.assertEquals(bcaWithCloudSecurityUrl, "https://amityonline.com/bca-cloud-security-online", "URL does not contain 'bca-cloud-security-online'");
        test.log(Status.PASS, "Navigated to BCA with specialization in Cloud & Security page: " + bcaWithCloudSecurityUrl);
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to BCA with Cloud & Security failed: " + e.getMessage());
        softAssert.fail("Navigation to BCA with Cloud & Security failed: " + e.getMessage());
    }
    driver.navigate().back();

    try {
    Showmore();
    // Click 'BCA with specialization in Data Analytics'
    WebElement bcaWithDataAnalytics = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='BCA with specialization in Data Analytics']")));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bcaWithDataAnalytics);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bcaWithDataAnalytics);
    wait.until(ExpectedConditions.urlContains("bca-data-analytics-online"));
    String bcaWithDataAnalyticsUrl = driver.getCurrentUrl();
    System.out.println("Current URL after navigating to BCA with specialization in Data Analytics: " + bcaWithDataAnalyticsUrl);
    Assert.assertEquals(bcaWithDataAnalyticsUrl, "https://amityonline.com/bca-data-analytics-online", "URL does not contain 'bca-data-analytics-online'");
    test.log(Status.PASS, "Navigated to BCA with specialization in Data Analytics page: " + bcaWithDataAnalyticsUrl);

    driver.navigate().back();
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to BCA with Data Analytics failed: " + e.getMessage());
        softAssert.fail("Navigation to BCA with Data Analytics failed: " + e.getMessage());
    }

    try {
        Showmore();

        // Click 'Bachelor of Business Administration'
        WebElement bba = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Business Administration']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bba);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bba);
        wait.until(ExpectedConditions.urlContains("bachelor-of-business-administration-online"));
        String bbaUrl = driver.getCurrentUrl();
        System.out.println("Current URL after navigating to Bachelor of Business Administration: " + bbaUrl);
        Assert.assertEquals(bbaUrl, "https://amityonline.com/bachelor-of-business-administration-online", "URL does not contain 'bachelor-of-business-administration-online'");
        test.log(Status.PASS, "Navigated to Bachelor of Business Administration: " + bbaUrl);

        driver.navigate().back();

    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Bachelor of Business Administration failed: " + e.getMessage());
        softAssert.fail("Navigation to Bachelor of Business Administration failed: " + e.getMessage());
    }

    try {
        Showmore();

        // Click 'Bachelor of Arts (Journalism and Mass communication)'
        WebElement baJMC = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Bachelor of Arts (Journalism and Mass communicatio')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baJMC);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", baJMC);
        wait.until(ExpectedConditions.urlContains("bachelor-of-arts-journalism-and-mass-communication-online"));
        String baJMCUrl = driver.getCurrentUrl();
        System.out.println("Current URL after navigating to Bachelor of Arts: " + baJMCUrl);
        Assert.assertEquals(baJMCUrl, "https://amityonline.com/bachelor-of-arts-journalism-and-mass-communication-online", "URL does not contain 'bachelor-of-arts-journalism-and-mass-communication-online'");
        test.log(Status.PASS, "Navigated to Bachelor of Arts: " + baJMCUrl);

        driver.navigate().back();

    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Bachelor of Arts (JMC) failed: " + e.getMessage());
        softAssert.fail("Navigation to Bachelor of Arts (JMC) failed: " + e.getMessage());
    }

    try {
        Showmore();

        // Click 'Bachelor of Commerce'
        WebElement boc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Commerce']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", boc);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", boc);
        wait.until(ExpectedConditions.urlContains("bachelor-of-commerce-online"));
        String bocUrl = driver.getCurrentUrl();
        System.out.println("Current URL after navigating to Bachelor of Commerce: " + bocUrl);
        Assert.assertEquals(bocUrl, "https://amityonline.com/bachelor-of-commerce-online", "URL does not contain 'bachelor-of-commerce-online'");
        test.log(Status.PASS, "Navigated to Bachelor of Commerce: " + bocUrl);

        driver.navigate().back();

    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Bachelor of Commerce failed: " + e.getMessage());
        softAssert.fail("Navigation to Bachelor of Commerce failed: " + e.getMessage());
    }

    try {
        Showmore();

        // Click 'Bachelor of Arts'
        WebElement ba = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ba);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ba);
        wait.until(ExpectedConditions.urlContains("bachelor-of-arts-online"));
        String baUrl = driver.getCurrentUrl();
        System.out.println("Current URL after navigating to Bachelor of Arts: " + baUrl);
        Assert.assertEquals(baUrl, "https://amityonline.com/bachelor-of-arts-online", "URL does not contain 'bachelor-of-arts-online'");
        test.log(Status.PASS, "Navigated to Bachelor of Arts: " + baUrl);

        driver.navigate().back();

    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Bachelor of Arts failed: " + e.getMessage());
        softAssert.fail("Navigation to Bachelor of Arts failed: " + e.getMessage());
    }

    try {
        Showmore();
        // Click 'Bachelor of Art (Kannada Medium)'
	    WebElement baKM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Art (Kannada Medium)']")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baKM);
	 	((JavascriptExecutor) driver).executeScript("arguments[0].click();", baKM);
	    wait.until(ExpectedConditions.urlContains("bachelor-of-arts-kannada-online"));
	    String baKMUrl = driver.getCurrentUrl();
	    System.out.println("Current URL after navigating to Bachelor of Art (Kannada Medium): " + baKMUrl);
	    Assert.assertEquals(baKMUrl, "https://amityonline.com/bachelor-of-arts-kannada-online", "URL does not contain 'bachelor-of-arts-kannada-online'");
	    test.log(Status.PASS, "Navigated to Bachelor of Art (Kannada Medium): " + baKMUrl);

        driver.navigate().back();

    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Bachelor of Art (Kannada Medium): " + e.getMessage());
        softAssert.fail("Navigation to Bachelor of Art (Kannada Medium): " + e.getMessage());
    }

    try {
        Showmore();
	    // Click 'Bachelor of Arts (Malayalam Medium)'
	    WebElement baMM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts (Malayalam Medium)']")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baMM);
	 	((JavascriptExecutor) driver).executeScript("arguments[0].click();", baMM);
	    wait.until(ExpectedConditions.urlContains("bachelor-of-arts-malayalam-online"));
	    String baMMUrl = driver.getCurrentUrl();
	    System.out.println("Current URL after navigating to Bachelor of Arts (Malayalam Medium): " + baMMUrl);
	    Assert.assertEquals(baMMUrl, "https://amityonline.com/bachelor-of-arts-malayalam-online", "URL does not contain 'bachelor-of-arts-malayalam-online'");
	    test.log(Status.PASS, "Navigated to Bachelor of Arts (Malayalam Medium): " + baMMUrl);

        driver.navigate().back();

    } catch (Exception e) {
        test.log(Status.FAIL, "Navigated to Bachelor of Arts (Malayalam Medium): " + e.getMessage());
        softAssert.fail("Navigated to Bachelor of Arts (Malayalam Medium): " + e.getMessage());
    }

    try {
        Showmore();
        // Click 'Bachelor of Arts (Tamil Medium)'
	    WebElement baTM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts (Tamil Medium)']")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baTM);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", baTM);
	    wait.until(ExpectedConditions.urlContains("bachelor-of-arts-tamil-online"));
	    String baTMUrl = driver.getCurrentUrl();
	    System.out.println("Current URL after navigating to Bachelor of Arts (Tamil Medium): " + baTMUrl);
	    Assert.assertEquals(baTMUrl, "https://amityonline.com/bachelor-of-arts-tamil-online", "URL does not contain 'bachelor-of-arts-tamil-online'");
	    test.log(Status.PASS, "Navigated to Bachelor of Arts (Tamil Medium): " + baTMUrl);

        driver.navigate().back();

    } catch (Exception e) {
        test.log(Status.FAIL, "Navigated to Bachelor of Arts (Tamil Medium): " + e.getMessage());
        softAssert.fail("Navigated to Bachelor of Arts (Tamil Medium): " + e.getMessage());
    }

    try {
        Showmore();
        // Click 'Bachelor of Arts (Telugu Medium)'
	    WebElement baTeluguMedium = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts (Telugu Medium)']")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baTeluguMedium);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", baTeluguMedium);
	    wait.until(ExpectedConditions.urlContains("bachelor-of-arts-telugu-online"));
	    String baTeluguMediumUrl = driver.getCurrentUrl();
	    System.out.println("Current URL after navigating to Bachelor of Arts (Telugu Medium): " + baTeluguMediumUrl);
	    Assert.assertEquals(baTeluguMediumUrl, "https://amityonline.com/bachelor-of-arts-telugu-online", "URL does not contain 'bachelor-of-arts-telugu-online'");
	    test.log(Status.PASS, "Navigated to Bachelor of Arts (Telugu Medium): " + baTeluguMediumUrl);

        driver.navigate().back();

    } catch (Exception e) {
        test.log(Status.FAIL, "Navigated to Bachelor of Arts (Telugu Medium): " + e.getMessage());
        softAssert.fail("Navigated to Bachelor of Arts (Telugu Medium): " + e.getMessage());
    }

    try {
        Showmore();
	         
	    // Click 'Bachelor of Arts (Hindi Medium)'
	    WebElement baHindiMedium = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts (Hindi Medium)']")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baHindiMedium);
	 	((JavascriptExecutor) driver).executeScript("arguments[0].click();", baHindiMedium);
	    wait.until(ExpectedConditions.urlContains("bachelor-of-arts-hindi-medium-online"));
	    String baHindiMediumUrl = driver.getCurrentUrl();
	    System.out.println("Current URL after navigating to Bachelor of Arts (Hindi Medium): " + baHindiMediumUrl);
	    Assert.assertEquals(baHindiMediumUrl,"https://amityonline.com/bachelor-of-arts-hindi-medium-online", "URL does not contain 'bachelor-of-arts-hindi-medium-online'");
	    test.log(Status.PASS, "Navigated to Bachelor of Arts (Hindi Medium): " + baHindiMediumUrl);

        driver.navigate().back();

    } catch (Exception e) {
        test.log(Status.FAIL, "Navigated to Bachelor of Arts (Hindi Medium): " + e.getMessage());
        softAssert.fail("Navigated to Bachelor of Arts (Hindi Medium): " + e.getMessage());
    }

    try {
        Showmore();
	         
	    // Click 'B.Com with Specialization in International Finance & Accounting'
	    WebElement bComHindiMedium = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'B.Com with Specialization in International Finance')]")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bComHindiMedium);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bComHindiMedium);
	    wait.until(ExpectedConditions.urlContains("bcom-internationalfinance"));
	    String bComHindiMediumUrl = driver.getCurrentUrl();
	    System.out.println("Current URL after navigating to B.Com with Specialization in International Finance & Accounting: " + bComHindiMediumUrl);
	    Assert.assertEquals(bComHindiMediumUrl,"https://amityonline.com/bcom-internationalfinance", "URL does not contain 'bcom-internationalfinance'");
	    test.log(Status.PASS, "Navigated to B.Com with Specialization in International Finance & Accounting: " + bComHindiMediumUrl);

        driver.navigate().back();

    } catch (Exception e) {
        test.log(Status.FAIL, "Navigated to B.Com with Specialization in International Finance & Accounting: " + e.getMessage());
        softAssert.fail("Navigated to B.Com with Specialization in International Finance & Accounting: " + e.getMessage());
    }

    try {
        Showmore();
	         
	   	// Click 'Bachelor Of Commerce (Honours)'
	    WebElement bachelorOfCH = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor Of Commerce (Honours)']")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bachelorOfCH);
	 	((JavascriptExecutor) driver).executeScript("arguments[0].click();", bachelorOfCH);
	    wait.until(ExpectedConditions.urlContains("bachelor-of-commerce-honours"));
	    String bachelorOfCHUrl = driver.getCurrentUrl();
	    System.out.println("Current URL after navigating to Bachelor Of Commerce (Honours): " + bachelorOfCHUrl);
	    Assert.assertEquals(bachelorOfCHUrl,"https://amityonline.com/bachelor-of-commerce-honours", "URL does not contain 'bachelor-of-commerce-honours'");
	    test.log(Status.PASS, "Navigated to Bachelor Of Commerce (Honours): " + bachelorOfCHUrl);

        driver.navigate().back();

    } catch (Exception e) {
        test.log(Status.FAIL, "Navigated to Bachelor Of Commerce (Honours): " + e.getMessage());
        softAssert.fail("Navigated to Bachelor Of Commerce (Honours): " + e.getMessage());
    }

    try {
        Showmore();
	         
	   	// Click 'UG + PG Degree Program'
	    WebElement ugPgDegree = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='UG + PG Degree Program']")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ugPgDegree);
	 	((JavascriptExecutor) driver).executeScript("arguments[0].click();", ugPgDegree);
	    wait.until(ExpectedConditions.urlContains("ug-pg-degree-set"));
	    String ugPgDegreeUrl = driver.getCurrentUrl();
	    System.out.println("Current URL after navigating to UG + PG Degree Program: " + ugPgDegreeUrl);
	    Assert.assertEquals(ugPgDegreeUrl, "https://amityonline.com/ug-pg-degree-set", "URL does not contain 'ug-pg-degree-set'");
	    test.log(Status.PASS, "Navigated to UG + PG Degree Program: " + ugPgDegreeUrl);

        driver.navigate().back();

    } catch (Exception e) {
        test.log(Status.FAIL, "Navigated to UG + PG Degree Program: " + e.getMessage());
        softAssert.fail("Navigated to UG + PG Degree Program: " + e.getMessage());
    }

    try{    
        Showmore();

	 	// Wait until the UG Program heading is visible
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[2]")));

	 	// Collect all course links under UG Program
	 	List<WebElement> courseElements = driver.findElements(By.xpath("//footer[@class='container mb-8 footer_root__az0w0']//ul[2]//li"));

	 	for (int i = 0; i < courseElements.size(); i++) {
	 		String courseName = courseElements.get(i).getText();
	 		System.out.println("  ▶ Course " + (i + 1) + ": " + courseName);
	 	}

	 	// Verify the count matches expectation
	 	int expectedCount = 15;
	 	int actualCount = courseElements.size() - 1;

	 	Assert.assertEquals(actualCount, expectedCount, "❌ Mismatch in course count. Expected: " + expectedCount + ", Found: " + actualCount);
	 	// System.out.println("✅ Course count validation passed.");
	 	System.out.println("✅ UG Program course count verified successfully: " + actualCount);
	        
	    }catch (Exception e) {
	 		test.log(Status.FAIL, "Test failed with exception: " + e.getMessage());
	 		e.printStackTrace(); // Console output
	 		Assert.fail("Test failed due to exception.", e); // Preserve original error
	 	}
    softAssert.assertAll();
}

	@Test
	public void pgProgramSection() {
	    test = reports.createTest("Click 'PG Program'");

        try {
        Showmore();
        WebElement mca = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Master of Computer Applications']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mca);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mca);
        wait.until(ExpectedConditions.urlContains("master-of-computer-applications-online"));
        String url = driver.getCurrentUrl();
        System.out.println("Navigated to: " + url);
        Assert.assertEquals(url,"https://amityonline.com/master-of-computer-applications-online");
        test.log(Status.PASS, "Navigated to Master of Computer Applications: " + url);
        driver.navigate().back();
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Master of Computer Applications failed: " + e.getMessage());
        softAssert.fail("Navigation to Master of Computer Applications failed: " + e.getMessage());
    }

    try {
        Showmore();
        WebElement blockchain = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='MCA with specialization in Blockchain']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", blockchain);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", blockchain);
        wait.until(ExpectedConditions.urlContains("mca-blockchain-online"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/mca-blockchain-online");
        test.log(Status.PASS, "Navigated to Blockchain: " + url);
        driver.navigate().back();
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Blockchain failed: " + e.getMessage());
        softAssert.fail("Navigation to Blockchain failed: " + e.getMessage());
    }

    try {
        Showmore();
        WebElement mlai = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='MCA with specialization in ML & Al']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mlai);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mlai);
        wait.until(ExpectedConditions.urlContains("mca-machine-learning-and-artificial-intelligence-online"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/mca-machine-learning-and-artificial-intelligence-online");
        test.log(Status.PASS, "Navigated to ML & AI: " + url);
        driver.navigate().back();
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to ML & AI failed: " + e.getMessage());
        softAssert.fail("Navigation to ML & AI failed: " + e.getMessage());
    }

    try {
        Showmore();
        WebElement ml = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='MCA with specialization in Machine Learning']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ml);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ml);
        wait.until(ExpectedConditions.urlContains("mca-machine-learning-online"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/mca-machine-learning-online");
        test.log(Status.PASS, "Navigated to Machine Learning: " + url);
        driver.navigate().back();
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Machine Learning failed: " + e.getMessage());
        softAssert.fail("Navigation to Machine Learning failed: " + e.getMessage());
    }

    try {
        Showmore();
        WebElement vr = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='MCA with specialization in AR & VR']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", vr);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", vr);
        wait.until(ExpectedConditions.urlContains("mca-virtualreality-online"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/mca-virtualreality-online");
        test.log(Status.PASS, "Navigated to AR & VR: " + url);
        driver.navigate().back();
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to AR & VR failed: " + e.getMessage());
        softAssert.fail("Navigation to AR & VR failed: " + e.getMessage());
    }

    try {
        Showmore();
        WebElement mba = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Master of Business Administration']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mba);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mba);
        wait.until(ExpectedConditions.urlContains("master-of-business-administration-online"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/master-of-business-administration-online");
        test.log(Status.PASS, "Navigated to MBA: " + url);
        // driver.navigate().back();
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to MBA failed: " + e.getMessage());
        softAssert.fail("Navigation to MBA failed: " + e.getMessage());
    }

    try {
        Showmore();
        WebElement mba_digitalmarketing = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='MBA with specialization in Digital Marketing Management']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mba_digitalmarketing);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mba_digitalmarketing);
        wait.until(ExpectedConditions.urlContains("mba-digital-marketing-management-online"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/mba-digital-marketing-management-online");
        test.log(Status.PASS, "Navigated to Digital Marketing: " + url);
        driver.navigate().back();
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Digital Marketing failed: " + e.getMessage());
        softAssert.fail("Navigation to Digital Marketing failed: " + e.getMessage());
    }

    try {
        Showmore();
        WebElement hr_analytics = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='MBA with specialization in HR Analytics']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hr_analytics);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hr_analytics);
        wait.until(ExpectedConditions.urlContains("mba-human-resources-hr-analytics-online"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/mba-human-resources-hr-analytics-online");
        test.log(Status.PASS, "Navigated to HR Analytics: " + url);
        driver.navigate().back();
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to HR Analytics failed: " + e.getMessage());
        softAssert.fail("Navigation to HR Analytics failed: " + e.getMessage());
    }

    try {
        Showmore();
        WebElement ds = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='MBA with specialization in Data Science']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ds);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ds);
        wait.until(ExpectedConditions.urlContains("mba-data-science-online"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/mba-data-science-online");
        test.log(Status.PASS, "Navigated to Data Science: " + url);
        driver.navigate().back();
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Data Science failed: " + e.getMessage());
        softAssert.fail("Navigation to Data Science failed: " + e.getMessage());
    }

    try {
        Showmore();
        WebElement ba = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='MBA with specialization in Business Analytics']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ba);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ba);
        wait.until(ExpectedConditions.urlContains("mba-business-analytics-online"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/mba-business-analytics-online");
        test.log(Status.PASS, "Navigated to Business Analytics: " + url);
        driver.navigate().back();
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Business Analytics failed: " + e.getMessage());
        softAssert.fail("Navigation to Business Analytics failed: " + e.getMessage());
    }

    try {
        Showmore();
        WebElement de = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='MBA with specialization in Digital Entrepreneurship']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", de);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", de);
        wait.until(ExpectedConditions.urlContains("mba-digital-entrepreneurship-online"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/mba-digital-entrepreneurship-online");
        test.log(Status.PASS, "Navigated to Digital Entrepreneurship: " + url);
        driver.navigate().back();
    } catch (Exception e) {
        test.log(Status.FAIL, "Navigation to Digital Entrepreneurship failed: " + e.getMessage());
        softAssert.fail("Navigation to Digital Entrepreneurship failed: " + e.getMessage());
    }

    // ************** SHOW MORE BUTTON - 12 **************
    try {
        Showmore();

        WebElement MA_Jour_Mass_Comm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Master of Arts (Journalism and Mass communication)']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MA_Jour_Mass_Comm);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", MA_Jour_Mass_Comm);
        wait.until(ExpectedConditions.urlContains("master-of-arts-journalism-and-mass-communication-online"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/master-of-arts-journalism-and-mass-communication-online", "URL mismatch after clicking MA Journalism and Mass Communication.");
        test.log(Status.PASS, "Navigated to MA Journalism and Mass Communication page: " + url);
    } catch (Exception e) {
        test.log(Status.FAIL, "MA Journalism and Mass Communication section failed: " + e.getMessage());
        softAssert.fail("Interaction failed for MA Journalism and Mass Communication.");
    }
    driver.navigate().back();

    // ************** SHOW MORE BUTTON - 13 **************
    try {
        Showmore();

        WebElement M_Com_Fintech = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='M.Com with specialization in Fintech']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", M_Com_Fintech);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", M_Com_Fintech);
        wait.until(ExpectedConditions.urlContains("mcom-fintech-online"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/mcom-fintech-online", "URL mismatch after clicking M.Com Fintech.");
        test.log(Status.PASS, "Navigated to M.Com Fintech page: " + url);
    } catch (Exception e) {
        test.log(Status.FAIL, "M.Com Fintech section failed: " + e.getMessage());
        softAssert.fail("Interaction failed for M.Com Fintech.");
    }
    driver.navigate().back();

    // ************** SHOW MORE BUTTON - 14 **************
    try {
        Showmore();

        WebElement M_Com_FM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='M.Com with specialization in Financial Management']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", M_Com_FM);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", M_Com_FM);
        wait.until(ExpectedConditions.urlContains("master-of-commerce-financial-management-online"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/master-of-commerce-financial-management-online", "URL mismatch after clicking M.Com Financial Management.");
        test.log(Status.PASS, "Navigated to M.Com Financial Management page: " + url);
    } catch (Exception e) {
        test.log(Status.FAIL, "M.Com Financial Management section failed: " + e.getMessage());
        softAssert.fail("Interaction failed for M.Com Financial Management.");
    }
    driver.navigate().back();

    // ************** SHOW MORE BUTTON - 15 **************
    try {
        Showmore();

        WebElement MA_PPG = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Master of Arts in Public Policy & Governance']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MA_PPG);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", MA_PPG);
        wait.until(ExpectedConditions.urlContains("ma-public-policy"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/ma-public-policy", "URL mismatch after clicking MA Public Policy & Governance.");
        test.log(Status.PASS, "Navigated to MA Public Policy & Governance page: " + url);
        } catch (Exception e) {
            test.log(Status.FAIL, "MA Public Policy & Governance section failed: " + e.getMessage());
            softAssert.fail("Interaction failed for MA Public Policy & Governance.");
        }
        driver.navigate().back();

    // ************** SHOW MORE BUTTON - 16 **************
    try {
        Showmore();

        WebElement MA_Psych = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Master of Arts in Psychology']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MA_Psych);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", MA_Psych);
        wait.until(ExpectedConditions.urlContains("ma-in-psychology"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://amityonline.com/ma-in-psychology", "URL mismatch after clicking MA Psychology.");
        test.log(Status.PASS, "Navigated to MA Psychology page: " + url);
    } catch (Exception e) {
        test.log(Status.FAIL, "MA Psychology section failed: " + e.getMessage());
        softAssert.fail("Interaction failed for MA Psychology.");
    }
    driver.navigate().back();

    // ************** SHOW MORE BUTTON - 17 **************
    try {
        Showmore();

        WebElement MSc_DS = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Master of Science in Data Science']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MSc_DS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", MSc_DS);
        wait.until(ExpectedConditions.urlContains("msc-in-data-science"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/msc-in-data-science", "URL mismatch after clicking MSc Data Science.");
        test.log(Status.PASS, "Navigated to MSc Data Science page: " + url);
    } catch (Exception e) {
        test.log(Status.FAIL, "MSc Data Science section failed: " + e.getMessage());
        softAssert.fail("Interaction failed for MSc Data Science.");
    }
    driver.navigate().back();

    // ************** SHOW MORE BUTTON - 18 **************
    try {
        Showmore();

        WebElement MBA_Dual = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='MBA With Dual Specialization']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MBA_Dual);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", MBA_Dual);
        wait.until(ExpectedConditions.urlContains("mba-dual-specialization"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://amityonline.com/mba-dual-specialization", "URL mismatch after clicking MBA Dual Specialization.");
        test.log(Status.PASS, "Navigated to MBA Dual Specialization page: " + url);
    } catch (Exception e) {
        test.log(Status.FAIL, "MBA Dual Specialization section failed: " + e.getMessage());
        softAssert.fail("Interaction failed for MBA Dual Specialization.");
    }
    driver.navigate().back();

    // ************** SHOW MORE BUTTON - 19 **************
    try {
        Showmore();

        WebElement MBA_GM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Master of Business Administration in General Manag')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MBA_GM);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", MBA_GM);
        wait.until(ExpectedConditions.urlContains("mba-general-management"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://amityonline.com/mba-general-management", "URL mismatch after clicking MBA General Management.");
        test.log(Status.PASS, "Navigated to MBA General Management page: " + url);
    } catch (Exception e) {
        test.log(Status.FAIL, "MBA General Management section failed: " + e.getMessage());
        softAssert.fail("Interaction failed for MBA General Management.");
    }
    driver.navigate().back();

    try {
        Showmore();

        // Wait for PG Program section to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[3]")));
        test.log(Status.PASS, "PG Program section is visible.");

        // Collect all course list elements under PG Program
        List<WebElement> courseElements = driver.findElements(By.xpath("//footer[@class='container mb-8 footer_root__az0w0']//ul[3]//li"));
        int actualCount = courseElements.size() - 1; // Adjusting if last element is non-course (e.g. 'View All')
        int expectedCount = 19;

        // Logging course names
        for (int i = 0; i < courseElements.size(); i++) {
            String courseName = courseElements.get(i).getText();
            System.out.println("  ▶ Course " + (i + 1) + ": " + courseName);
        }

        // Validate course count
        Assert.assertEquals(actualCount, expectedCount, "❌ Course count mismatch. Expected: " + expectedCount + ", Found: " + actualCount);
        test.log(Status.PASS, "✅ PG Program course count matched expected value: " + actualCount);
    } catch (Exception e) {
        test.log(Status.FAIL, "PG Program section failed: " + e.getMessage());
        e.printStackTrace();
        softAssert.fail("Interaction failed for PG Program course list.");
    }

     softAssert.assertAll();

    }



@Test
public void Frequently_Asked_Questions() {
    test = reports.createTest("Frequently Asked Questions");
    // SoftAssert softAssert = new SoftAssert();

    // --- Frequently Asked Questions Section ---
    try {
        WebElement frequentlyAskedQues = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[normalize-space()='Frequently Asked Questions']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", frequentlyAskedQues);
        test.log(Status.PASS, "'Frequently Asked Questions' section visible.");
        Thread.sleep(2000);

        // Click initial FAQ arrows
        clickArrow("//div[@class='text-gray-800']//span[@class='FaqWithCategory_icon__KxkUd']//*[name()='svg']");
        clickArrow("//div[@class='md:px-0 px-4 space-y-4']//div[2]//div[1]//span[2]//*[name()='svg']");
        clickArrow("//section[@class='FaqSection_container__X78DX']//div[3]//div[1]//span[2]//*[name()='svg']");
        clickArrow("//section[@class='FaqSection_container__X78DX']//div[4]//div[1]//span[2]//*[name()='svg']");
        clickArrow("//section[@class='FaqSection_container__X78DX']//div[5]//div[1]//span[2]//*[name()='svg']");
        Thread.sleep(2000);
    } catch (Exception e) {
        test.log(Status.FAIL, "Frequently Asked Questions section failed: " + e.getMessage());
        softAssert.fail("Frequently Asked Questions section interaction failed.");
    }

    // --- ACADEMICS Section ---
    try {
        WebElement academicBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='ACADEMICS']")));
        academicBtn.click();
        test.log(Status.PASS, "Clicked 'ACADEMICS' button.");
        Thread.sleep(2000);

        clickArrow("//div[@class='text-gray-800']//span[@class='FaqWithCategory_icon__KxkUd']//*[name()='svg']");
        clickArrow("//div[@class='md:px-0 px-4 space-y-4']//div[2]//div[1]//span[2]//*[name()='svg']");
        clickArrow("//section[@class='FaqSection_container__X78DX']//div[3]//div[1]//span[2]//*[name()='svg']");
        clickArrow("//section[@class='FaqSection_container__X78DX']//div[4]//div[1]//span[2]//*[name()='svg']");
        Thread.sleep(2000);
    } catch (Exception e) {
        test.log(Status.FAIL, "ACADEMICS section failed: " + e.getMessage());
        softAssert.fail("ACADEMICS section interaction failed.");
    }

    // --- ADMISSION Section ---
    try {
        WebElement admissionBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='ADMISSION']")));
        admissionBtn.click();
        test.log(Status.PASS, "Clicked 'ADMISSION' button.");
        Thread.sleep(2000);

        clickArrow("//div[@class='text-gray-800']//span[@class='FaqWithCategory_icon__KxkUd']//*[name()='svg']");
        clickArrow("//div[@class='md:px-0 px-4 space-y-4']//div[2]//div[1]//span[2]//*[name()='svg']");
        clickArrow("//section[@class='FaqSection_container__X78DX']//div[3]//div[1]//span[2]//*[name()='svg']");
        clickArrow("//section[@class='FaqSection_container__X78DX']//div[4]//div[1]//span[2]//*[name()='svg']");
        Thread.sleep(2000);
    } catch (Exception e) {
        test.log(Status.FAIL, "ADMISSION section failed: " + e.getMessage());
        softAssert.fail("ADMISSION section interaction failed.");
    }
    softAssert.assertAll(); // Ensure all soft asserts are verified
}

// Helper method for clicking an arrow element
    private void clickArrow(String xpath) {
        try {
            WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            arrow.click();
            test.log(Status.PASS, "Arrow clicked: " + xpath);
        } catch (Exception e) {
            test.log(Status.WARNING, "Arrow not clickable or not found: " + xpath + " | " + e.getMessage());
        }
    }



@Test
public void meet_our_top_ranked_faculty_Section() {
    test = reports.createTest("Meet our top-ranked faculty");
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Scroll into view
    WebElement sectionHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='SectionCard_hr__WSBKM']")));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionHeading);

    try {
        Thread.sleep(2000);

        // First bullet (1st 3 cards)
        WebElement bullet1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='MeetFacultySection']//span[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bullet1);
        Thread.sleep(500);
        // test.log(Status.INFO, "🔍 Checking first 3 faculty");
        // Faculty 1
        try {
            WebElement one_container = driver.findElement(By.xpath("//h3[normalize-space()='Neha Tandon']more"));
            Assert.assertTrue(one_container.isDisplayed(), "Neha Tandon not displayed");
            test.log(Status.PASS, "✅ Neha Tandon displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "❌ Neha Tandon not found/displayed: " + e.getMessage());
            softAssert.fail("Neha Tandon not found" + e.getMessage());
        }
        // Faculty 2
        try {
            WebElement two_container = driver.findElement(By.xpath("//h3[normalize-space()='Dr Sunil Kumar']"));
            Assert.assertTrue(two_container.isDisplayed(), "Dr Sunil Kumar not displayed");
            test.log(Status.PASS, "✅ Dr Sunil Kumar displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "❌ Dr Sunil Kumar not found/displayed: " + e.getMessage());
            softAssert.fail("Dr Sunil Kumar not found" + e.getMessage());
        }
        // Faculty 3
        try {
            WebElement three_container = driver.findElement(By.xpath("//h3[normalize-space()='Sachit Paliwal']"));
            Assert.assertTrue(three_container.isDisplayed(), "Sachit Paliwal not displayed");
            test.log(Status.PASS, "✅ Sachit Paliwal displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "❌ Sachit Paliwal not found/displayed: " + e.getMessage());
            softAssert.fail("Sachit Paliwal not found" + e.getMessage());
        }
    } catch (Exception e) {
        test.log(Status.FAIL, "❌ Meet our top-ranked faculty first group: " + e.getMessage());
        softAssert.fail("Meet our top-ranked faculty first group: " + e.getMessage());
    }

    try {
        Thread.sleep(2000);
        // Second bullet (next 3 cards)
        WebElement bullet4 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='MeetFacultySection']//span[4]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bullet4);
        Thread.sleep(500);
        // test.log(Status.INFO, "🔍 Checking next 3 faculty");

        // Faculty 4
        try {
            WebElement four_container = driver.findElement(By.xpath("//h3[normalize-space()='Dr Ron Darnell']"));
            Assert.assertTrue(four_container.isDisplayed(), "Dr Ron Darnell not displayed");
            test.log(Status.PASS, "✅ Dr Ron Darnell displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "❌ Dr Ron Darnell not found/displayed: " + e.getMessage());
            softAssert.fail("Dr Ron Darnell not found" + e.getMessage());
        }
        // Faculty 5
        try {
            WebElement five_container = driver.findElement(By.xpath("//h3[normalize-space()='Dr. Hayley Stainton']more"));
            Assert.assertTrue(five_container.isDisplayed(), "Dr. Hayley Stainton not displayed");
            test.log(Status.PASS, "✅ Dr. Hayley Stainton displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "❌ Dr. Hayley Stainton not found/displayed: " + e.getMessage());
            softAssert.fail("Dr. Hayley Stainton not found" + e.getMessage());
        }
        // Faculty 6
        try {
            WebElement six_container = driver.findElement(By.xpath("//h3[normalize-space()='Luke Pearce']"));
            Assert.assertTrue(six_container.isDisplayed(), "Luke Pearce not displayed");
            test.log(Status.PASS, "✅ Luke Pearce displayed");
        } catch (Exception e) {
            test.log(Status.FAIL, "❌ Luke Pearce not found/displayed: " + e.getMessage());
            softAssert.fail("Luke Pearce not found" + e.getMessage());
        }
    } catch (Exception e) {
        test.log(Status.FAIL, "❌ Meet our top-ranked faculty second group: " + e.getMessage());
        softAssert.fail("Meet our top-ranked faculty second group: " + e.getMessage());
    }

    softAssert.assertAll();
}




    // Employees From Leading Organizations Trust Amity For Lifelong Learning
    @Test
    public void employeesFrom_Leading_Organization() {
    test = reports.createTest("Verify All Company Logos Are Present and Displayed in Carousel");
    // closePopupIfPresent();
    try {  
        WebElement sectionHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Employees From Leading Organizations Trust')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionHeading);
        Thread.sleep(2000);
        test.log(Status.PASS, "Pass Scrolled to the Employees From Leading Organizations Trust Amity For Lifelong Learning" + //
                        ".");
        } catch (Exception e) {
                test.log(Status.FAIL, "❌ Error in employees from leading organization scroll: " + e.getMessage());
                softAssert.fail("Error in employees from leading organization scroll" + e.getMessage());
        }
    try {
    // Get all logo elements
    List<WebElement> logos = driver.findElements(By.xpath("//div[@class='swiper swiper-initialized swiper-horizontal swiper-grid']//div[@class='swiper-wrapper']/div"));
    int actualCount = logos.size();
    // Verify count
    if (actualCount == 51) {
        test.log(Status.PASS, "✅ Correct number of logos found: 51");
    } else {
        test.log(Status.FAIL, "❌ Incorrect number of logos found. Expected: 51, Found: " + actualCount);
        softAssert.fail("Logo count mismatch: Found " + actualCount + " instead of 51");
    }

    // // Verify all logos are visible
    // int index = 1;
    // for (WebElement logo : logos) {
    //     if (logo.isDisplayed()) {
    //         test.log(Status.PASS, "✅ Logo " + index + " is visible");
    //     } else {
    //         test.log(Status.FAIL, "❌ Logo " + index + " is NOT visible");
    //         softAssert.fail("Logo at index " + index + " not visible");
    //     }
    //     index++;
    //     }
    } catch (Exception e) {
        test.log(Status.FAIL, "❌ Exception occurred while verifying logos: " + e.getMessage());
        softAssert.fail("Exception occurred", e);
    }
        softAssert.assertAll();
    }

    @Test
    public void testimonial_videosPlay(){
        test = reports.createTest("Video Play");
        closePopupIfPresent();
        
        try {
            WebElement video_scroll = driver.findElement(By.xpath("//img[@title='Ruchir']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", video_scroll);
            Thread.sleep(2000);
            test.log(Status.PASS, "Scrolled to the faculty section.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to scroll to the faculty section: " + e.getMessage());
            e.printStackTrace();
            softAssert.fail("Scroll to video section failed", e);
        }

        try {
            Thread.sleep(2000);
            WebElement play1_button = driver.findElement(By.xpath("//div[@class='swiper-slide swiper-slide-active']//div[@class='VideoCard_playBtnOverlay__AojHz']"));
            play1_button.click();
            Thread.sleep(5000);
            test.log(Status.PASS, "Clicked Video 1 successfully.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error in Video 1 play: " + e.getMessage());
            e.printStackTrace();
            softAssert.fail("Video 1 play failed", e);
        }

        try {
            WebElement play2_button = driver.findElement(By.xpath("//div[@class='swiper-slide swiper-slide-next']//div[@class='VideoCard_playBtnOverlay__AojHz']//*[name()='svg']//*[name()='path' and contains(@d,'M481.6 270')]"));
            play2_button.click();
            Thread.sleep(5000);
            test.log(Status.PASS, "Clicked Video 2 successfully.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error in Video 2 play: " + e.getMessage());
            e.printStackTrace();
            softAssert.fail("Video 2 play failed", e);
        }

        try {
            WebElement play3_button = driver.findElement(By.xpath("//div[@class='StudentTestimonial_testimonialContainer__fqCLy']//div[3]//div[1]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M481.6 270')]"));
            play3_button.click();
            Thread.sleep(5000);
            test.log(Status.PASS, "Clicked Video 3 successfully.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error in Video 3 play: " + e.getMessage());
            e.printStackTrace();
            softAssert.fail("Video 3 play failed", e);
        }

        try {
            WebElement play4_button = driver.findElement(By.xpath("//div[@class='StudentTestimonial_testimonialContainer__fqCLy']//div[4]//div[1]//div[1]//div[1]//div[1]"));
            play4_button.click();
            Thread.sleep(5000);
            test.log(Status.PASS, "Clicked Video 4 successfully.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error in Video 4 play: " + e.getMessage());
            e.printStackTrace();
            softAssert.fail("Video 4 play failed", e);
        }
        softAssert.assertAll();
    }

    @Test
    public void TestimonialStudent(){
        test = reports.createTest("Open_Honest_Reviews_by_our_Learners");
        // closePopupIfPresent();
        try {
            WebElement Open_Honest_Scroll = driver.findElement(By.xpath("//h2[normalize-space()='Open & Honest Reviews by our Learners']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Open_Honest_Scroll);
            Thread.sleep(2000);
            test.log(Status.PASS, "Scrolled to the faculty section.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to scroll to the faculty section: " + e.getMessage());
            e.printStackTrace();
            softAssert.fail("Scroll to video section failed", e);
        }
        try {
        Thread.sleep(2000);
        List<WebElement> testimonialSlides = driver.findElements(By.cssSelector(
            "div[class='swiper swiper-initialized swiper-horizontal swiper-backface-hidden'] div[class='swiper-wrapper'] div[class*='swiper-slide']"
        ));

        int actualCount = testimonialSlides.size();
        test.log(Status.INFO, "Total testimonial slides found: " + actualCount);

        if (actualCount == 8) {
            test.log(Status.PASS, "Correct number of testimonial slides found: 8");
        } else {
            test.log(Status.FAIL, "Expected 8 testimonial slides but found: " + actualCount);
            softAssert.fail("Mismatch in testimonial slide count. Expected: 8, Found: " + actualCount);
        }
        } catch (Exception e) {
            test.log(Status.FAIL, "Unable to fetch testimonial slides: " + e.getMessage());
            e.printStackTrace();
            softAssert.fail("Fetching testimonial slides failed", e);
        }
        softAssert.assertAll();
    }

    @Test
    public void Potential_Job_roles(){
        test = reports.createTest("Potential_Job_roles");
        try {
            WebElement potential_job_Scroll = driver.findElement(By.cssSelector("section[id='PotentialJobRoles'] div[class='pt-7 lg:pt-7']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", potential_job_Scroll);
            Thread.sleep(2000);
            test.log(Status.PASS, "Scrolled to the Potential_Job_roles section.");
            } catch (Exception e) {
                test.log(Status.FAIL, "Failed to scroll to the Potential_Job_roles section: " + e.getMessage());
                e.printStackTrace();
                softAssert.fail("Scroll to Potential_Job_roles failed", e);
            }

        try{
            List <WebElement> three_Container =  driver.findElements(By.xpath("//div[@class='JobRolesSection_JobRolesSection__cardContainer__hBWOQ']/child::div"));

            int container_count = three_Container.size();
            test.log(Status.INFO, "Total container found" + container_count);

            if(container_count == 3) {
                test.log(Status.PASS, "Correct numbers of container found 3");
             } else{
                    test.log(Status.FAIL, "Not get correct container size.." + container_count);
                    softAssert.fail("Miss match count in potential job roles " + container_count);
                }
            } catch (Exception e) {
                test.log(Status.FAIL, "Failed to Potential_Job_roles section: " + e.getMessage());
                e.printStackTrace();
                softAssert.fail("Scroll to Potential_Job_roles section failed" + e.getMessage());
            }
        softAssert.assertAll();
    }

    // Are you ready to take the next step in your career ?
    @Test
    public void next_step_in_your_career(){
        test = reports.createTest("Are you ready to take the next step in your career ?");
        WebElement Your_Career_Scroll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Are you ready to take the next step in your career')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Your_Career_Scroll);
        // Thread.sleep(2000);
        try{
            Thread.sleep(2000);
            WebElement apply_now = driver.findElement(By.xpath("//div[@class='BannerCard_content__gyu4c']//div//span[@class='ClientSideButton_btnText__5gMgu'][normalize-space()='APPLY NOW']"));
            apply_now.click();
            test.log(Status.PASS, "Pass apply now button.");

        } catch (Exception e){
            test.log(Status.FAIL, "Failed apply now button Are you ready to take the next step in your career ?" + e.getMessage());
            softAssert.fail("Failed apply now button Are you ready to take the next step in your career " + e.getMessage());
        }

        try{
            // Enter phone number
            Random random = new Random();
            int last4digit = 1000 + random.nextInt(9000);
            String phone = "948383" + last4digit;
            WebElement phone_number = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='basis-1/2']//input[@placeholder='Enter your no.']")));
            phone_number.sendKeys(phone);
            Thread.sleep(2000);
            // Enter full name
            String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis"};
            String lastName = lastNames[random.nextInt(lastNames.length)];
            String dynamicFullName = "Test" + " " + lastName;
            WebElement full_name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='basis-1/2']//input[@placeholder='Enter your full name']")));
            full_name.sendKeys(dynamicFullName);
            Thread.sleep(2000);
            // Enter email -id
            String dynamicEmail = "testuser" + last4digit + "@gmail.com";
            WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='basis-1/2']//input[@placeholder='abc@xyz.com']")));
            email.sendKeys(dynamicEmail);
            Thread.sleep(2000);
            // Click to Submit button
            WebElement submit_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='font-semibold font-raleway uppercase w-full border Input_btn___g__n bg-primary-blue border-blue-950 text-white']")));
            submit_button.click();
            Thread.sleep(2000);
        }catch(Exception e){
            test.log(Status.FAIL, "" + e.getMessage());
            softAssert.fail("jjndskfksndsfnskfn" + e.getMessage());
        }
        softAssert.assertAll();
    }



    @AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException {
		String testname=result.getName();
		String myscreenshot=HeaderScreenShot.takeScreenshot(driver, testname);
		if (result.getStatus()==ITestResult.FAILURE) {
			test.addScreenCaptureFromPath(myscreenshot);
			test.log(Status.FAIL, "Test failed: " + result.getThrowable());
		}else if (result.getStatus() == ITestResult.SUCCESS) {
			test.addScreenCaptureFromPath(myscreenshot);
			test.log(Status.PASS, "Test passed");

		}else if (result.getStatus() == ITestResult.SKIP) {
			test.addScreenCaptureFromPath(myscreenshot);
			test.log(Status.SKIP, "Test Skip");
		}
		driver.quit();

	}

}