package Program.MBA;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Random.RandomDetails;
import base.HeaderBaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
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

public class MBAProgram extends HeaderBaseClass{


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

	/*

	@Test(priority = 1)
	public void AmityLogo() {
		test=reports.createTest("Amity Logo");
		try {	
			if (hPom.amitylogoElement.isDisplayed()) {
				Assert.assertTrue(true);	
				test.log(Status.PASS, "Amity Logo Visible");

			}else {
				Assert.assertTrue(false);
				test.log(Status.FAIL, "Amity Logo Not Visible");
			}

		}catch (Exception e) {
			test.log(Status.FAIL, "Amity Logo Not Visible");
			Assert.fail("Logo Not Displayed" + " " + e.getMessage());
			throw e;
		}


	}




	@Test(priority = 2)
	public void HeaderProgram() {
		test=reports.createTest("HeaderCareerServices");
		try {
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();", hPom.programsElement);

			if (hPom.allProgramElement.getText().equals("All Programs")) {
				Assert.assertTrue(true);
				test.log(Status.PASS, "Header HeaderCareerServices Working");

			}else {
				Assert.assertTrue(false);
				test.log(Status.FAIL, "Header HeaderCareerServices not Working");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Header HeaderCareerServices not Working");
			Assert.fail("Header Program Element is not working" + " " + e.getMessage());
			throw e;
		}
	}



	@Test(priority = 3)
	public void HeaderCareerServices() {
		test=reports.createTest("HeaderCareerServices");
		try {
			String parentWindow=driver.getWindowHandle();
			hPom.Career();
			Set<String> allwindows = driver.getWindowHandles();
			Iterator<String> itr = allwindows.iterator();
			while(itr.hasNext()) {
				String childWindow=itr.next();

				if (!parentWindow.equals(childWindow)){
					driver.switchTo().window(childWindow);
				}			
			}

			String expectecUrl="https://amityonline.com/career-services";
			if (expectecUrl.equals(driver.getCurrentUrl())) {
				Assert.assertTrue(true);
				test.log(Status.PASS, "Header HeaderCareerServices Working");

			}else {
				Assert.assertTrue(false);
				test.log(Status.FAIL, "Header HeaderCareerServices not Working");
			}

		}catch (Exception e) {
			test.log(Status.FAIL, "Header HeaderCareerServices not Working");
			Assert.fail("Career Services element is now working" + " " + e.getMessage());
			throw e;
		}


	}




	@Test(priority = 4)
	public void HeaderAdvantages() {
		test=reports.createTest("HeaderAdvantages");
		try {
			JavascriptExecutor js1=((JavascriptExecutor)driver);
			js1.executeScript("arguments[0].click();", hPom.advantagesElement);
			String exUrl = "https://amityonline.com/amity-online-advantage";
			if (exUrl.equals(driver.getCurrentUrl())) {
				Assert.assertTrue(true);
				test.log(Status.PASS, "Header HeaderAdvantages Working");

			}else {
				Assert.assertTrue(false);
				test.log(Status.FAIL, "Header HeaderAdvantages Working");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Header HeaderAdvantages Working");
			Assert.fail("Advantage element is not working" + " " + e.getMessage());
			throw e;
		}

	}



	@Test(priority = 5)
	public void HeaderSearch() throws InterruptedException {
		test=reports.createTest("HeaderSearch");
		try {
			JavascriptExecutor js2=((JavascriptExecutor)driver);
			js2.executeScript("arguments[0].click();", hPom.searchbuttotElement);
			hPom.searchbuttoncontentElement.sendKeys("master of business");
			Actions act=new Actions(driver);
			act.moveToElement(hPom.mbaElement).click().perform();
			String expmbaElement = "https://amityonline.com/master-of-business-administration-online";
			if (expmbaElement.equals(driver.getCurrentUrl())) {
				Assert.assertTrue(true);
				test.log(Status.PASS, "Header HeaderSearch Working");

			}else {
				Assert.assertTrue(false);
				test.log(Status.FAIL, "Header HeaderSearch not Working");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Header HeaderSearch not Working");
			Assert.fail("Search element is now working" + " " + e.getMessage());
			throw e;
		}


	}



	@Test(priority = 6)
	public void HeaderCallUs() {
		test=reports.createTest("HeaderCallUs");
		try {
			JavascriptExecutor js3=((JavascriptExecutor)driver);
			js3.executeScript("arguments[0].click();", hPom.callusElement);
			String handle1 = driver.getWindowHandle();
			driver.switchTo().window(handle1);
			if (hPom.calluspopcontentElement.getText().equals("Share Your Details And Get A Free Counseling Session")) {
				Assert.assertTrue(true);
				test.log(Status.PASS, "Header HeaderCallUs Working");

			}else {
				Assert.assertTrue(false);
				test.log(Status.FAIL, "Header HeaderCallUs not Working");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Header HeaderCallUs not Working");
			Assert.fail("Call us element is not working" + " " + e.getMessage());
			throw e;

		}


	}



	@Test(priority = 7)

	public void HeaderVideoCall() {
		test=reports.createTest("HeaderVideoCall");
		try {
			String Parentwindow1 = driver.getWindowHandle();
			hPom.VideoCall();
			Set<String> allWindow = driver.getWindowHandles();
			Iterator<String> itr1 = allWindow.iterator();
			while(itr1.hasNext()) {
				String childWindow1 = itr1.next();
				if (!Parentwindow1.equals(childWindow1)) {
					driver.switchTo().window(childWindow1);
				}

			}

			String expVideourl = "https://widget01.popin.to/share/12338";
			if (expVideourl.equals(driver.getCurrentUrl())) {
				Assert.assertTrue(true);
				test.log(Status.PASS, "Header VideoCall Working");

			}else {
				Assert.assertTrue(false);
				test.log(Status.FAIL, "Header VideoCall not Working");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Header VideoCall not Working");
			Assert.fail("Header video call element not working" + " " + e.getMessage());
			throw e;
		}

	}



	@Test(priority = 8)
	public void HeaderStudentLogin() {
		test=reports.createTest("HeaderStudentLogin");
		try {
			JavascriptExecutor js4=((JavascriptExecutor)driver);
			js4.executeScript("arguments[0].click();", hPom.existingstudentloginElement);
			String handle2 = driver.getWindowHandle();
			driver.switchTo().window(handle2);
			if(hPom.existingstudentloginContentElement.getText().equals("Student Login")) {
				Assert.assertTrue(true);
				test.log(Status.PASS, "Header Student Login Working");
			}else {
				Assert.assertTrue(false);
				test.log(Status.FAIL, "Header Student Login not Working");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Header Student Login not Working");
			Assert.fail("Header existing student login not working" + " " + e.getMessage());
			throw e;
		}
	}



	@Test(priority = 9)
	public void HeaderApplyNow() {
		test=reports.createTest("HeaderApplyNow");
		try {
			JavascriptExecutor js5=((JavascriptExecutor)driver);
			js5.executeScript("arguments[0].click();", hPom.applyNowHeaderElement);
			String handle3 = driver.getWindowHandle();
			driver.switchTo().window(handle3);

			if (hPom.applynowcontentElement.getText().equals("Connect With Our Counsellor")) {
				Assert.assertTrue(true);
				test.log(Status.PASS, "Header Apply Now Working");

			}else {
				Assert.assertTrue(false);
				test.log(Status.FAIL, "Header Apply Now not Working");
			}
		}catch (Exception e) {
			test.log(Status.FAIL, 
					"Header Apply Now not Working " + e.getMessage());
			Assert.fail("Header Apply Now not working" + " " + e.getMessage());
			throw e;
		}
	}


	@Test(priority = 10)
	public void yelloStrip() {
		test=reports.createTest("Yellow Strip");
		try {
		hPom.YStrip();

		String handle4 = driver.getWindowHandle();
		driver.switchTo().window(handle4);
		if (hPom.yellowstripcontentElement.getText().equals("Connect With Our Counsellor")) {

			Assert.assertTrue(true);
			test.log(Status.PASS, "Yellow Strip is Working");

		}else {
			Assert.assertTrue(false);
			test.log(Status.FAIL, "Yellow Strip is not Working");
		}
	}catch (Exception e) {
		test.log(Status.FAIL, "Yellow Strip is not Working");
		Assert.fail("Yellow Strip is not Working" + " " + e.getMessage());
		throw e;

	}




	}

/*
	@Test(priority = 11)
	public void ApplyNowIndian() throws InterruptedException, NoSuchElementException {

		test=reports.createTest("Apply Now Journey Indian");
		try {

			String originalWindow = driver.getWindowHandle();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ApplynowBTN = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/button[1]")));
			ApplynowBTN.click();
			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			// 👇 Re-initialize POM and Wait in new window context
			Apom = new ApplyNowPOM(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));



			Thread.sleep(3000);

			Apom.indianBTN.click();
			Select dropdown=new Select(Apom.countrycodeElement);
			dropdown.selectByIndex(0);

			// 👇 Generate and Log Random Data
			String randomMobileNumber = "23" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			System.out.println("Random Name: " + randomName);
			System.out.println("Random Email: " + randomEmail);
			System.out.println("Random Mobile Number: " + randomMobileNumber);

			Apom.nameElement.sendKeys(randomName);
			Apom.mobiElement.sendKeys(randomMobileNumber);
			Apom.emailElement.sendKeys(randomEmail);
			Apom.submitElement.click();

			Thread.sleep(3000);

			String handle = driver.getWindowHandle();
			driver.switchTo().window(handle);

			wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Apom.degreeElement)).sendKeys("PG");

			wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Apom.prograElement)).sendKeys("MASTER OF COMPUTER APPLICATIONS WITH SPECIALIZATION IN CYBER SECURITY");

			Apom.submit2elElement.click();

			Thread.sleep(6000);

			Apom.OTPCell1.sendKeys(random.GetOTP());
			Apom.OTPCell2.sendKeys(random.GetOTP());
			Apom.OTPCell3.sendKeys(random.GetOTP());
			Apom.OTPCell4.sendKeys(random.GetOTP());
			Apom.OTPCell5.sendKeys(random.GetOTP());
			Apom.OTPCell6.sendKeys(random.GetOTP());


			Apom.VerifyOTP.click();

			Thread.sleep(7000);



			if (Apom.startapplicationElement.isEnabled()) {

				test.log(Status.PASS, "Apply Now Journey is Successful" );
				System.out.println("Apply Now journey is Successful");

			}else {
				test.log(Status.FAIL, "Apply Now Journey is Failed");
				System.out.println("Apply now journey is Failed");
			}

		}catch (Exception e) {
			test.log(Status.FAIL, "Apply Now Journey is Failed" + e.getMessage());
			throw e; // Re-throw the exception to mark the test as failed in TestNG


		} 

	}


	@Test(priority = 12)
	public void ApplyNowInternational() throws Exception {

		test=reports.createTest("Apply Now Journey International");
		try {

			String originalWindow = driver.getWindowHandle();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ApplynowBTN = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/button[1]")));
			ApplynowBTN.click();
			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			// 👇 Re-initialize POM and Wait in new window context
			Apom = new ApplyNowPOM(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			Thread.sleep(3000);

			Apom.internationalElement.click();
			Select dropdown=new Select(Apom.countrycodeElement);
			dropdown.selectByIndex(2);

			String randomMobileNumber = "23" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			System.out.println("Random Name: " + randomName);
			System.out.println("Random Email: " + randomEmail);
			System.out.println("Random Mobile Number: " + randomMobileNumber);

			Apom.nameElement.sendKeys(randomName);
			Apom.mobiElement.sendKeys(randomMobileNumber);
			Apom.emailElement.sendKeys(randomEmail);
			Apom.submitElement.click();


			Thread.sleep(3000);

			String handle2 = driver.getWindowHandle();
			driver.switchTo().window(handle2);

			wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Apom.degreeElement)).sendKeys("PG");

			wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Apom.prograElement)).sendKeys("MASTER OF COMPUTER APPLICATIONS WITH SPECIALIZATION IN CYBER SECURITY");

			Apom.submit2elElement.click();

			Thread.sleep(6000);

			if (Apom.startapplicationElement.isEnabled()) {

				test.log(Status.PASS, "Apply Now Journey is Successful");
				System.out.println("Apply Now journey is Successful");

			}else {
				test.log(Status.FAIL, "Apply Now Journey is Failed");
				System.out.println("Apply now journey is Failed");
			}

		}catch (Exception e) {
			test.log(Status.FAIL, "Apply Now Journey is Failed" + e.getMessage());
			throw e; // Re-throw the exception to mark the test as failed in TestNG


		} 


	}


	 */

	//------------------------------------------------MBA Open form---------------------------------------	

	/*

	@Test(priority = 13)
	public void OpenformMBAIndia() throws InterruptedException {

		test = reports.createTest("Apply Now Open Form Indian");
		try {

			String mbaName = "TestQA" + " " + random.GetRandomName();
			String mbaMobileNumber = "23" + random.getRandomMobileNumber();
			String mbaEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + mbaName);
			test.info("Random Mobile Number: " + mbaMobileNumber);
			test.info("Random Email: " + mbaEmail);


			System.out.println("Random Name: " + mbaName);
			System.out.println("Random Email: " + mbaEmail);
			System.out.println("Random Mobile Number: " + mbaMobileNumber);


			openformmba.name.sendKeys(mbaName);
			openformmba.selectdropdown();
			openformmba.mobile.sendKeys(mbaMobileNumber);
			openformmba.email.sendKeys(mbaEmail);
			openformmba.clicksubmit();

			Thread.sleep(6000);

			openformmba.OTPCell1.sendKeys(random.GetOTP());
			openformmba.OTPCell2.sendKeys(random.GetOTP());
			openformmba.OTPCell3.sendKeys(random.GetOTP());
			openformmba.OTPCell4.sendKeys(random.GetOTP());
			openformmba.OTPCell5.sendKeys(random.GetOTP());
			openformmba.OTPCell6.sendKeys(random.GetOTP());

			openformmba.VerifyOTP.click();

			Thread.sleep(7000);



			if (openformmba.startapplicationElement.isEnabled()) {

				test.log(Status.PASS, "MBA Open form is submitted successfully" );
				System.out.println("MBA Open form is submitted successfully");

			}else {
				test.log(Status.FAIL, "MBA Open form is failed");
				System.out.println("MBA Open form is failed");
			}

		}catch (Exception e) {
			test.log(Status.FAIL, "MBA Open form is failed" + e.getMessage());
			throw e; // Re-throw the exception to mark the test as failed in TestNG


		} 


	}


	@Test(priority = 14)
	public void OpenformMBAInternational() throws InterruptedException {

		test = reports.createTest("Apply Now Open Form International");
		try {

			String mbaName = "TestQA" + " " + random.GetRandomName();
			String mbaMobileNumber = "23" + random.getRandomMobileNumber();
			String mbaEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + mbaName);
			test.info("Random Mobile Number: " + mbaMobileNumber);
			test.info("Random Email: " + mbaEmail);


			System.out.println("Random Name: " + mbaName);
			System.out.println("Random Email: " + mbaEmail);
			System.out.println("Random Mobile Number: " + mbaMobileNumber);


			openformmba.name.sendKeys(mbaName);
			openformmba.selectdropdown1();
			openformmba.mobile.sendKeys(mbaMobileNumber);
			openformmba.email.sendKeys(mbaEmail);
			openformmba.clicksubmit();


			Thread.sleep(7000);



			if (openformmba.startapplicationElement.isEnabled()) {

				test.log(Status.PASS, "MBA Open form is submitted successfully" );
				System.out.println("MBA Open form is submitted successfully");

			}else {
				test.log(Status.FAIL, "MBA Open form is failed");
				System.out.println("MBA Open form is failed");
			}

		}catch (Exception e) {
			test.log(Status.FAIL, "MBA Open form is failed" + e.getMessage());
			throw e; // Re-throw the exception to mark the test as failed in TestNG


		} 


	}

//---------------------------Download Brochure--------------------------------------------------------------

	@Test(priority = 15)
	public void DownloadBrochureIndia() throws Exception {

		test=reports.createTest("DownloadBrochure India");
		try {

		dbrochure.clickbrochure();
		String handle4 = driver.getWindowHandle();
		driver.switchTo().window(handle4);
		dbrochure.selectdropdown();

		String dname = "TestQA" + " " + random.GetRandomName();
		String dmobilenumber = "23" + random.getRandomMobileNumber();
		String demailid = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

		test.info("Random Name: " + dname);
		test.info("Random Mobile Number: " + dmobilenumber);
		test.info("Random Email: " + demailid);


		System.out.println("Random Name: " + dname);
		System.out.println("Random Email: " + demailid);
		System.out.println("Random Mobile Number: " + dmobilenumber);

        dbrochure.selectdropdown();
		dbrochure.contactnumberElement.sendKeys(dmobilenumber);
		dbrochure.usernamElement.sendKeys(dname);
		dbrochure.useremailElement.sendKeys(demailid);
		dbrochure.usersubmitbuttonElement.click();

		Thread.sleep(6000);

		dbrochure.OTPCell1.sendKeys(random.GetOTP());
		dbrochure.OTPCell2.sendKeys(random.GetOTP());
		dbrochure.OTPCell3.sendKeys(random.GetOTP());
		dbrochure.OTPCell4.sendKeys(random.GetOTP());
		dbrochure.OTPCell5.sendKeys(random.GetOTP());
		dbrochure.OTPCell6.sendKeys(random.GetOTP());

		dbrochure.VerifyOTP.click();

		Thread.sleep(7000);

		dbrochure.proceedbutton.click();

		Thread.sleep(1000);

		dbrochure.switchwindow();


		Thread.sleep(2000);



		if (dbrochure.startapplicationElement.isEnabled()) {

			test.log(Status.PASS, "Download Brochure is working" );
			System.out.println("Download Brochure is working");

		}else {
			test.log(Status.FAIL, "Download Brochure is not working");
			System.out.println("Download Brochure is not working");
		}

	}catch (Exception e) {
		test.log(Status.FAIL, "Download Brochure is not working" + e.getMessage());
		throw e; // Re-throw the exception to mark the test as failed in TestNG


	} 


}



	@Test(priority = 16)
	public void DownloadBrochureInternational() throws Exception {

		test=reports.createTest("DownloadBrochure International");
		try {

		dbrochure.clickbrochure();
		String handle4 = driver.getWindowHandle();
		driver.switchTo().window(handle4);
		dbrochure.selectdropdown();

		String dname = "TestQA" + " " + random.GetRandomName();
		String dmobilenumber = "23" + random.getRandomMobileNumber();
		String demailid = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

		test.info("Random Name: " + dname);
		test.info("Random Mobile Number: " + dmobilenumber);
		test.info("Random Email: " + demailid);


		System.out.println("Random Name: " + dname);
		System.out.println("Random Email: " + demailid);
		System.out.println("Random Mobile Number: " + dmobilenumber);

		dbrochure.selectdropdown1();
		dbrochure.contactnumberElement.sendKeys(dmobilenumber);
		dbrochure.usernamElement.sendKeys(dname);
		dbrochure.useremailElement.sendKeys(demailid);
		dbrochure.usersubmitbuttonElement.click();

		Thread.sleep(7000);

		dbrochure.proceedbutton.click();

		Thread.sleep(1000);

		dbrochure.switchwindow();


		Thread.sleep(2000);



		if (dbrochure.startapplicationElement.isEnabled()) {

			test.log(Status.PASS, "Download Brochure is working" );
			System.out.println("Download Brochure is working");

		}else {
			test.log(Status.FAIL, "Download Brochure is not working");
			System.out.println("Download Brochure is not working");
		}

	}catch (Exception e) {
		test.log(Status.FAIL, "Download Brochure is not working" + e.getMessage());
		throw e; // Re-throw the exception to mark the test as failed in TestNG


	} 


}


//-----------------------------------Share button-----------------------------------------------------------


	@Test(priority = 17)
	public void sharebutton() throws Exception {

	    test = reports.createTest("Share Button");

	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        sbutton.shareincon();
	        String handle7 = driver.getWindowHandle();
	        driver.switchTo().window(handle7);

	        // WhatsApp Icon
	        try {
	            wait.until(ExpectedConditions.visibilityOf(sbutton.whatsappElement));
	            wait.until(ExpectedConditions.elementToBeClickable(sbutton.whatsappElement));
	            Assert.assertTrue(sbutton.whatsappElement.isDisplayed());
	            Assert.assertTrue(sbutton.whatsappElement.isEnabled());
	            test.log(Status.PASS, "WhatsApp icon is displayed and clickable.");
	        } catch (Exception e) {
	            test.log(Status.FAIL, "WhatsApp icon check failed: " + e.getMessage());
	        }

	        // LinkedIn Icon
	        try {
	            wait.until(ExpectedConditions.visibilityOf(sbutton.linkediElement));
	            wait.until(ExpectedConditions.elementToBeClickable(sbutton.linkediElement));
	            Assert.assertTrue(sbutton.linkediElement.isDisplayed());
	            Assert.assertTrue(sbutton.linkediElement.isEnabled());
	            test.log(Status.PASS, "LinkedIn icon is displayed and clickable.");
	        } catch (Exception e) {
	            test.log(Status.FAIL, "LinkedIn icon check failed: " + e.getMessage());
	        }

	        // Facebook Icon
	        try {
	            wait.until(ExpectedConditions.visibilityOf(sbutton.facebookElement));
	            wait.until(ExpectedConditions.elementToBeClickable(sbutton.facebookElement));
	            Assert.assertTrue(sbutton.facebookElement.isDisplayed());
	            Assert.assertTrue(sbutton.facebookElement.isEnabled());
	            test.log(Status.PASS, "Facebook icon is displayed and clickable.");
	        } catch (Exception e) {
	            test.log(Status.FAIL, "Facebook icon check failed: " + e.getMessage());
	        }

	        // X Icon
	        try {
	            wait.until(ExpectedConditions.visibilityOf(sbutton.xelElement));
	            wait.until(ExpectedConditions.elementToBeClickable(sbutton.xelElement));
	            Assert.assertTrue(sbutton.xelElement.isDisplayed());
	            Assert.assertTrue(sbutton.xelElement.isEnabled());
	            test.log(Status.PASS, "X (Twitter) icon is displayed and clickable.");
	        } catch (Exception e) {
	            test.log(Status.FAIL, "X (Twitter) icon check failed: " + e.getMessage());
	        }

	        // Mail Icon
	        try {
	            wait.until(ExpectedConditions.visibilityOf(sbutton.mailElement));
	            wait.until(ExpectedConditions.elementToBeClickable(sbutton.mailElement));
	            Assert.assertTrue(sbutton.mailElement.isDisplayed());
	            Assert.assertTrue(sbutton.mailElement.isEnabled());
	            test.log(Status.PASS, "Mail icon is displayed and clickable.");
	        } catch (Exception e) {
	            test.log(Status.FAIL, "Mail icon check failed: " + e.getMessage());
	        }

	        // Copy Button
	        try {
	            wait.until(ExpectedConditions.visibilityOf(sbutton.copyElement));
	            wait.until(ExpectedConditions.elementToBeClickable(sbutton.copyElement));
	            Assert.assertTrue(sbutton.copyElement.isDisplayed());
	            Assert.assertTrue(sbutton.copyElement.isEnabled());
	            test.log(Status.PASS, "Copy button is displayed and clickable.");
	        } catch (Exception e) {
	            test.log(Status.FAIL, "Copy button check failed: " + e.getMessage());
	        }

	    } catch (Exception e) {
	        test.log(Status.FAIL, "Share icon interaction failed: " + e.getMessage());
	        throw e; // Mark test as failed in TestNG
	    }
	}



	//---------------------------------AnnoucementSection--------------------------------------------------------


	@Test(priority = 17)
	public void AnnouncementSection() {

	    test = reports.createTest("Announcement Section");

	    // Scroll the first element into view
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
	                     announcement.scholarshipWebElement);

	    // dynamic wait
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Scholarship available
	    try {
	        wait.until(ExpectedConditions.visibilityOf(announcement.scholarshipWebElement));
	        Assert.assertTrue(announcement.scholarshipWebElement.isDisplayed());
	        test.log(Status.PASS, "Scholarship available is visible");
	    } catch (Exception e) {
	        test.log(Status.FAIL, "Scholarship available is not visible: " + e.getMessage());
	    }

	    // Zero Cost EMI cart
	    try {
	        wait.until(ExpectedConditions.visibilityOf(announcement.zerocostemiElement));
	        Assert.assertTrue(announcement.zerocostemiElement.isDisplayed());
	        test.log(Status.PASS, "Zero cost EMI cart is visible");
	    } catch (Exception e) {
	        test.log(Status.FAIL, "Zero cost EMI cart is not visible: " + e.getMessage());
	    }

	    // Learners cart
	    try {
	        wait.until(ExpectedConditions.visibilityOf(announcement.learnersElement));
	        Assert.assertTrue(announcement.learnersElement.isDisplayed());
	        test.log(Status.PASS, "Learners cart is visible");
	    } catch (Exception e) {
	        test.log(Status.FAIL, "Learners cart is not visible: " + e.getMessage());
	    }

	    // Admission open cart
	    try {
	        wait.until(ExpectedConditions.visibilityOf(announcement.admissionopenElement));
	        Assert.assertTrue(announcement.admissionopenElement.isDisplayed());
	        test.log(Status.PASS, "Admission open cart is visible");
	    } catch (Exception e) {
	        test.log(Status.FAIL, "Admission open cart is not visible: " + e.getMessage());
	    }
	}


	@Test
	public void AnnouncementScholarship() {
	    test = reports.createTest("Scholarship Announcement Section");

	    // Scroll into view
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", announcement.scholarshipWebElement);

	    // Dynamic wait for the scholarshipWebElement to be clickable
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(announcement.scholarshipWebElement));

	    // Click the scholarship announcement
	    announcement.scholarshipAccouncement();

	    // Wait for the expected URL to load
	    wait.until(ExpectedConditions.urlToBe("https://amityonline.com/scholarship"));

	    // Validate the URL
	    String expScholarshipurl = "https://amityonline.com/scholarship";
	    if (driver.getCurrentUrl().equals(expScholarshipurl)) {
	        Assert.assertTrue(true);
	        test.log(Status.PASS, "Scholarship Available is working");
	    } else {
	        Assert.assertTrue(false);
	        test.log(Status.FAIL, "Scholarship Available is not working");
		    }
	}


//-----------------------Enhance your career with India's premier UGC-entitled Online Master of Business Administration----------------------------


	@Test
	public void Overview() throws InterruptedException {
		 test = reports.createTest("Overview Section");
		// Scroll into view
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView();", overview.enhanceElement);
		    Thread.sleep(2000);
		  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 try {
		 wait.until(ExpectedConditions.visibilityOf(overview.buildingnationcontaimner));
		 String actualtext = overview.buildingnationcontaimner.getText();
         String expectedText=overview.enhanceElement.getText();
		 Assert.assertEquals(actualtext, expectedText);
			 test.log(Status.PASS, "Building Nation container text is displayed correctly.");
		 }catch (Exception e) {
			 test.log(Status.FAIL, "Text verification failed: " + e.getMessage());
		        Assert.fail("Text not matching or element not found.");
		        throw e;
		}

			 try {
			 Assert.assertTrue(overview.buildingnationimage.isDisplayed());
	            Assert.assertTrue(overview.buildingnationimage.isEnabled());
	            test.log(Status.PASS, "Building Nation image is displayed and Clickable");
			 }catch (Exception e) {
				 test.log(Status.FAIL, "Image not found or clickable" + e.getMessage());
			        Assert.fail("Image not found or clickable");
			        throw e;
			}	 

	}

	//-----------------------------------------------Degrees To Dreams: An Amity Online Podcast | Online MBA Program----------------------------------

	@Test
	public void Podcast() throws InterruptedException {
		test = reports.createTest("Podcast Section");
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView();", podcast.podcastcontainerElement);
		    Thread.sleep(2000);

		     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOf(podcast.podcastcontainerElement));
		    String actualtext1 = podcast.podcastcontainerElement.getText();
		    String extectedtext1 = podcast.podcasttextElement.getText();
		    Assert.assertEquals(actualtext1, extectedtext1);
		    test.log(Status.PASS, "Podcast section text verified successfully.");


		 // Switch to iframe
		    WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("//iframe[contains(@src, 'youtube.com/embed')]")));
		    driver.switchTo().frame(iframe);

		    // Wait for play button
		    WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.cssSelector(".ytp-large-play-button.ytp-button")));
		    Thread.sleep(2000);
		    playButton.click();
		    Thread.sleep(3000);

		 // Verify that the play button turned into a pause button
		    WebElement pauseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.cssSelector(".ytp-play-button")));
		    String ariaLabel = pauseButton.getAttribute("aria-label");
		    Assert.assertTrue(ariaLabel.toLowerCase().contains("pause"), "Pause button not visible.");
		    test.log(Status.PASS, "Pause button is visible. Video playback confirmed.");


	}




	//--------------------------------Program Highlights & Advantages-------------------------------------------------------------


	@Test
	public void ProgramHighlights() throws InterruptedException {
		test = reports.createTest("Program Highlights Section");

		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", programhigh.programhigglightsElement);

		 Thread.sleep(2000);

		  wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		 try {
			 wait.until(ExpectedConditions.visibilityOf(programhigh.qSrankingElement));
		 Assert.assertTrue(programhigh.qSrankingElement.isDisplayed(), "QS Ranked Online MBA is not displayed");
		 test.log(Status.PASS, "QS Ranked Online MBA is displayed");
		 }catch (Exception e) {
			 test.log(Status.FAIL, "QS Ranked Online MBA not displayed");
			 throw e;
		}

		 try {
			 wait.until(ExpectedConditions.visibilityOf(programhigh.aCCAspecializationElement));
		 Assert.assertTrue(programhigh.aCCAspecializationElement.isDisplayed(), "ACCA specializations is not displayed");
		 test.log(Status.PASS, "ACCA specializations is displayed");
		 }catch (Exception e) {
			 test.log(Status.FAIL, "ACCA specializations not displayed");
			 throw e;
		}

		 try {
			 wait.until(ExpectedConditions.visibilityOf(programhigh.studyanytimElement));
			 Assert.assertTrue(programhigh.studyanytimElement.isDisplayed(), "Study anytime anywhere is not displayed");
			 test.log(Status.PASS, "Study anytime anywhere is displayed");
			 }catch (Exception e) {
				 test.log(Status.FAIL, "Study anytime anywhere is not displayed");
				 throw e;
			}

		 try {
			 wait.until(ExpectedConditions.visibilityOf(programhigh.realworldElement));
			 Assert.assertTrue(programhigh.realworldElement.isDisplayed(), "Real World Projects is not displayed");
			 test.log(Status.PASS, "Real World Projects is displayed");
			 }catch (Exception e) {
				 test.log(Status.FAIL, "Real World Projects is not displayed");
				 Assert.fail("Interest free cart is not visible");
				 throw e;
			}



	}

//----------------------------------------Fee Structure-----------------------------------------------------------------	

	@Test
	public void feeStructure() throws InterruptedException {
		test=reports.createTest("Fee Structure");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", feestructure.feeElement);

		Thread.sleep(2000);

		  wait = new WebDriverWait(driver, Duration.ofSeconds(10));


		 try {
		 wait.until(ExpectedConditions.visibilityOf(feestructure.interestfreeElement));
		 Assert.assertTrue(feestructure.interestfreeElement.isDisplayed(), "Interest free cart is not visible");
		 test.log(Status.PASS, "Interest free cart is visible");
		 }catch (Exception e) {
			test.log(Status.FAIL, "Interest free cart is not visible" + e.getMessage());
			throw e;
		}

		 try {
			 wait.until(ExpectedConditions.visibilityOf(feestructure.semisterfee));
			 Assert.assertTrue(feestructure.semisterfee.isDisplayed(), "Per Semester Fee cart is not visible");
			 test.log(Status.PASS, "Per Semester Fee cart is visible");
			 }catch (Exception e) {
				test.log(Status.FAIL, "Per Semester Fee cart is not visible" + e.getMessage());
				throw e;
			}

		 try {
			 wait.until(ExpectedConditions.visibilityOf(feestructure.fulloprogramfeeElement));
			 Assert.assertTrue(feestructure.fulloprogramfeeElement.isDisplayed(), "Full Program Fee cart is not visible");
			 test.log(Status.PASS, "Full Program Fee cart is visible");
			 }catch (Exception e) {
				test.log(Status.FAIL, "Full Program Fee cart is not visible" + e.getMessage());
				throw e;
			}


		 try {
			 wait.until(ExpectedConditions.visibilityOf(feestructure.attractivescholarshipElement));
			 Assert.assertTrue(feestructure.attractivescholarshipElement.isDisplayed(), "Attractive Scholarships Available cart is not visible");
			 test.log(Status.PASS, "Attractive Scholarships Available cart is visible");
			 }catch (Exception e) {
				test.log(Status.FAIL, "Attractive Scholarships Available cart is not visible" + e.getMessage());
				throw e;
			}



	}

	@Test
	public void feeStructureEnrollnow() throws InterruptedException {
	     test=reports.createTest("feeStructure_Enrollnow");	
	     JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("arguments[0].scrollIntoView();", feestructure.feeElement);
	     Thread.sleep(2000);

	     wait=new WebDriverWait(driver, Duration.ofSeconds(10));

		 try {
			 WebElement feestructore = wait.until(ExpectedConditions.elementToBeClickable(feestructure.exploremoWebElement));
		feestructore.click();
		wait.until(ExpectedConditions.urlToBe("https://amityonline.com/scholarship"));
		 String expurl4 = "https://amityonline.com/scholarship";
		 String acturalurl4 = driver.getCurrentUrl();
		 Assert.assertEquals(acturalurl4, expurl4);
		 test.log(Status.PASS, "Explore now button is visible and working");
		 }catch (Exception e) {
			test.log(Status.FAIL, "Explore now button is not visible and working");
			throw e;
		}


	}

	 

	//--------------------------------Why Choose Amity Online?---------------------------------------------------

	@Test
	public void whychooseamity() throws InterruptedException {
		test=reports.createTest("Why Chosee Amity");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", whychoose.whychooseamityElement);

		Thread.sleep(2000);

		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.visibilityOf(whychoose.IndustryVisits));
			Assert.assertTrue(whychoose.IndustryVisits.isDisplayed(), "Industry Visits for Real-World Exposure not displayed");
			test.log(Status.PASS, "Industry Visits for Real-World Exposure  displayed");
		}catch (Exception e) {
			test.log(Status.FAIL, "Industry Visits for Real-World Exposure not displayed");
			throw e;
		}


		try {
			List<WebElement> cartimages = driver.findElements(By.xpath("//div[@class='font-raleway WhyAmity_item__KHKMn WhyAmity_centerdItem__5vkFc']"));
			int expectedCount = 10;
			int actualCount = cartimages.size();
			if (actualCount != expectedCount) {
				test.log(Status.FAIL, "Cart element count mismatch. Expected: " + expectedCount + ", Found: " + actualCount);
				Assert.fail("Element count mismatch! Expected: " + expectedCount + ", but found: " + actualCount);
			} else {
				test.log(Status.PASS, "Cart element count matched: " + actualCount);
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Exception occurred while verifying cart element count: " + e.getMessage());
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(whychoose.decidatedacademicElement));
			Assert.assertTrue(whychoose.decidatedacademicElement.isDisplayed(), "Dedicated academic advisor not displayed");
			test.log(Status.PASS, "Dedicated academic advisor displayed");
		}catch (Exception e) {
			test.log(Status.FAIL, "Dedicated academic advisor not displayed");
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(whychoose.aIProfessorAMIelElement));
			Assert.assertTrue(whychoose.aIProfessorAMIelElement.isDisplayed(), "AI professor AMI not displayed");
			test.log(Status.PASS, "AI professor AMI displayed");
		}catch (Exception e) {
			test.log(Status.FAIL, "AI professor AMI not displayed");
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(whychoose.placementOpportunitieselElement));
			Assert.assertTrue(whychoose.placementOpportunitieselElement.isDisplayed(), "Placement opportunities not displayed");
			test.log(Status.PASS, "Placement opportunities displayed");
		}catch (Exception e) {
			test.log(Status.FAIL, "Placement opportunities not displayed");
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(whychoose.diverseLearningMediumselElement));
			Assert.assertTrue(whychoose.diverseLearningMediumselElement.isDisplayed(), "Diverse learning medinum not displayed");
			test.log(Status.PASS, "Diverse learning medinum displayed");
		}catch (Exception e) {
			test.log(Status.FAIL, "Diverse learning medinum not displayed");
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(whychoose.offlineExperienceselElement));
			Assert.assertTrue(whychoose.offlineExperienceselElement.isDisplayed(), "Offline experiences not displayed");
			test.log(Status.PASS, "Offline experiences displayed");
		}catch (Exception e) {
			test.log(Status.FAIL, "Offline experiences not displayed");
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(whychoose.beSocialStudentCommunityPlatformelElement));
			Assert.assertTrue(whychoose.beSocialStudentCommunityPlatformelElement.isDisplayed(), "beSocial-student community platform not displayed");
			test.log(Status.PASS, "beSocial-student community platform displayed");
		}catch (Exception e) {
			test.log(Status.FAIL, "beSocial-student community platform not displayed");
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(whychoose.careerServiceselElement));
			Assert.assertTrue(whychoose.careerServiceselElement.isDisplayed(), "career services not displayed");
			test.log(Status.PASS, "career services displayed");
		}catch (Exception e) {
			test.log(Status.FAIL, "career services not displayed");
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(whychoose.doorstepDeliveryOfBookselElement));
			Assert.assertTrue(whychoose.doorstepDeliveryOfBookselElement.isDisplayed(), "Door step delivery of books not displayed");
			test.log(Status.PASS, "Door step delivery of books displayed");
		}catch (Exception e) {
			test.log(Status.FAIL, "Door step delivery of books not displayed");
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(whychoose.metaverseCampuselElement));
			Assert.assertTrue(whychoose.metaverseCampuselElement.isDisplayed(), "Metaverse campus not displayed");
			test.log(Status.PASS, "Metaverse campus displayed");
		}catch (Exception e) {
			test.log(Status.FAIL, "Metaverse campus not displayed");
			throw e;
		}

	}

	@Test
	public void fasttrackyourcareer() throws InterruptedException {

		test=reports.createTest("Fast-Track your career button");

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", whychoose.whychooseamityElement);
		Thread.sleep(2000);

		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			WebElement fasttrack = wait.until(ExpectedConditions.elementToBeClickable(whychoose.fasttrackyourcareerElement));
			fasttrack.click();

			Thread.sleep(2000);

			String handle8 = driver.getWindowHandle();
			driver.switchTo().window(handle8);
			if (whychoose.connectcounsellorElement.getText().equals("Connect With Our Counsellor")) {
				Assert.assertTrue(true);
				test.log(Status.PASS, "Fast-track your career button is working");

			}else {
				test.log(Status.FAIL, "Fast-track your career button is working is not working");

			}
		}catch (Exception e) {
			test.log(Status.FAIL, "Fast-track your career button is working is not working" + e.getMessage());
			Assert.fail("Fast-track your career button is working is not working" + e.getMessage());
			throw e;
		}



	}


	//--------------------------------Accreditations & Recognitions------------------------------------------------------

	@Test
	public void Accreditations() throws InterruptedException {
		test=reports.createTest("Accreditations & Recognitions");

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", accreditations.accreditationselElement);
		Thread.sleep(2000);

		accreditations.bullet1.click();

		wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		
		
		

		try {
			wait.until(ExpectedConditions.visibilityOf(accreditations.qSelElement));
			Assert.assertTrue(accreditations.qSelElement.isDisplayed(), "India's only Online MBA ranked by QS: Asia Pacific Top 10 is not displayed");
			test.log(Status.PASS, "India's only Online MBA ranked by QS: Asia Pacific Top 10 is displayed");

		}catch (Exception e) {
			test.log(Status.FAIL, "India's only Online MBA ranked by QS: Asia Pacific Top 10 is not displayed" + e.getMessage());
			throw e;
		}


		try {
			wait.until(ExpectedConditions.visibilityOf(accreditations.firstUniversityElement));
			Assert.assertTrue(accreditations.firstUniversityElement.isDisplayed(), "First university in India to receive UGC approval for Online Degrees and Learning Platform is not displayed");
			test.log(Status.PASS, "First university in India to receive UGC approval for Online Degrees and Learning Platform is displayed");
		}catch (Exception e) {
			test.log(Status.FAIL, "First university in India to receive UGC approval for Online Degrees and Learning Platform is not displayed" + e.getMessage());
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(accreditations.firstIndianElement));
			Assert.assertTrue(accreditations.firstIndianElement.isDisplayed(), "First Indian University to be accredited by National Council for Higher Education, Africa is not displayed");
			test.log(Status.PASS, "First Indian University to be accredited by National Council for Higher Education, Africa is displayed");
		}catch (Exception e) {
			test.log(Status.FAIL, "First Indian University to be accredited by National Council for Higher Education, Africa is not displayed" + e.getMessage());
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(accreditations.degreeprogramselElement));
			Assert.assertTrue(accreditations.degreeprogramselElement.isDisplayed(), "Degree programs approved by All India Council of Technical Education is not displayed");
			test.log(Status.PASS, "Degree programs approved by All India Council of Technical Education is displayed");

		}catch (Exception e) {
			test.log(Status.FAIL, "Degree programs approved by All India Council of Technical Education is not displayed" + e.getMessage());
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(accreditations.digitaleducationcouncilElement));
			Assert.assertTrue(accreditations.digitaleducationcouncilElement.isDisplayed(), "India's first private university to be a member is not displayed");
			test.log(Status.PASS, "India's first private university to be a member is displayed");
		}catch (Exception e) {
			test.log(Status.FAIL, "India's first private university to be a member is not displayed" + e.getMessage());
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(accreditations.rankedamoungElement));
			Assert.assertTrue(accreditations.rankedamoungElement.isDisplayed(), "Ranked among Top 3% Globally is not displayed");
			test.log(Status.PASS, "Ranked among Top 3% Globally is displayed");

		}catch (Exception e) {
			test.log(Status.FAIL, "Ranked among Top 3% Globally is not displayed" + e.getMessage());
			throw e;
		}

		accreditations.bullet2.click();


		try {
			wait.until(ExpectedConditions.visibilityOf(accreditations.wesElement));
			Assert.assertTrue(accreditations.wesElement.isDisplayed(), "Accredited by the World Education Services is not displayed");
			test.log(Status.PASS, "Accredited by the World Education Services is displayed");

		}catch (Exception e) {
			test.log(Status.FAIL, "Accredited by the World Education Services is not displayed" + e.getMessage());
			throw e;
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(accreditations.wascElement));
			Assert.assertTrue(accreditations.wascElement.isDisplayed(), "Accredited by the Western Association of Schools and College is not displayed");
			test.log(Status.PASS, "Accredited by the Western Association of Schools and College is displayed");

		}catch (Exception e) {
			test.log(Status.FAIL, "Accredited by the Western Association of Schools and College is not displayed" + e.getMessage());
			throw e;
		}

		accreditations.bullet3.click();

		try {
			wait.until(ExpectedConditions.visibilityOf(accreditations.nirfElement));
			Assert.assertTrue(accreditations.nirfElement.isDisplayed(), "Ranked 32 by National Institutional Ranking Framework  is not displayed");
			test.log(Status.PASS, "Ranked 32 by National Institutional Ranking Framework  is displayed");

		}catch (Exception e) {
			test.log(Status.FAIL, "Ranked 32 by National Institutional Ranking Framework  is not displayed" + e.getMessage());
			throw e;
		}

		List<WebElement> Accrediationscount = driver.findElements(By.xpath("//div[@class='swiper swiper-grid swiper-initialized swiper-horizontal Carousel__blueBullet Carousel__hAuto swiper-backface-hidden']//div[@class='swiper-wrapper AccreditionsRecognitions_CarousalWrapper__py20P']"));
		System.out.println("Size:- " + Accrediationscount.size());
		
	}

*/
	
	//-----------------------------Program Overview & Structure-------------------------------------------------------------
	
//	@Test
//	public void programOverviewStructure() throws InterruptedException {
//		test=reports.createTest("Program Overview & Structure");
//	
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView();", programoverview.programoverviewElement);
//		Thread.sleep(2000);
//		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		try {
//			wait.until(ExpectedConditions.visibilityOf(programoverview.programoverviewElement));
//		Assert.assertTrue(programoverview.programoverviewElement.isDisplayed(), "Program Overview & Structure is not displayed");
//		test.log(Status.PASS, "Program Overview & Structure is displayed");
//		}
//		catch (Exception e) {
//			test.log(Status.FAIL, "Program Overview & Structure is not displayed" + e.getMessage());
//			throw e;
//		}
//		
//		try {
//		wait.until(ExpectedConditions.elementToBeClickable(programoverview.explorecurriculumElement));
//		Assert.assertTrue(programoverview.explorecurriculumElement.isEnabled(), "Explore curriculum is not working");
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", programoverview.explorecurriculumElement);
//
//		String handle10 = driver.getWindowHandle();
//		driver.switchTo().window(handle10);
//		if(programoverview.downloadbrochurElement.getText().equals("Download Brochure")) {
//			Assert.assertTrue(true);
//		test.log(Status.PASS, "Explore curriculum is working");
//		
//		}else {
//			Assert.assertTrue(false);
//			test.log(Status.FAIL, "Explore curriculum is not working");
//		}
//		}catch (Exception e) {
//			test.log(Status.FAIL, "Explore curriculum is not working" + e.getMessage());
//			throw e;
//		}
//		
//		
//		programoverview.closebuttonElement.click();
//		
//		Thread.sleep(1000);
//		
//		try {
//		programoverview.semister1elElement.click();
//		test.log(Status.PASS, "Semister 1 Dropdown arrrow is working");
//		}catch (Exception e) {
//			test.log(Status.FAIL, "Semister 1 Dropdown arrrow  not working");
//			throw e;
//		}
//		Thread.sleep(1000);
//		
//		try {
//		programoverview.semister2elElement.click();
//		test.log(Status.PASS, "Semister 2 Dropdown arrrow is working");
//	}catch (Exception e) {
//		test.log(Status.FAIL, "Semister 2 Dropdown arrrow  not working");
//		throw e;
//	}
//		
//		Thread.sleep(1000);
//		
//		try {
//		programoverview.semister3elElement.click();
//		test.log(Status.PASS, "Semister 3 Dropdown arrrow is working");
//	}catch (Exception e1) {
//		test.log(Status.FAIL, "Semister 3 Dropdown arrrow  not working");
//		throw e1;
//	}
//		
//		Thread.sleep(1000);
//		
//		try {
//			programoverview.seminter4elElement.click();
//			test.log(Status.PASS, "Semister 4 Dropdown arrrow is working");
//			}catch (Exception e1) {
//				test.log(Status.FAIL, "Specialization Dropdown arrrow  not working");
//				throw e1;
//			}
//		
//		Thread.sleep(1000);
//		
//		try {
//		programoverview.specializationselElement.click();
//		test.log(Status.PASS, "Specialization Dropdown arrrow is working");
//	}catch (Exception e1) {
//		test.log(Status.FAIL, "Specialization Dropdown arrrow  not working");
//		throw e1;
//	}
//		try {
//		wait.until(ExpectedConditions.visibilityOf(programoverview.certificatElement));
//		if(programoverview.certificatElement.isDisplayed()) {
//			Assert.assertTrue(true);
//			test.log(Status.PASS, "Certificate displayed");
//		}else {
//		Assert.assertTrue(false);
//		test.log(Status.FAIL, "Certificate not displayed");
//		}
//		}catch (Exception e) {
//			test.log(Status.FAIL, "Certificate not displayed" + e.getMessage());
//			throw e;
//		}
//} //*[name()='path' and contains(@d,'M18.2648 2')
	
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



@Test
    public void meet_our_top_ranked_Section() {
        test = reports.createTest("Verify All 6 Faculty Containers Are Present and Displayed 'Meet Our Top Ranked Section'");

        try {
            // Scroll to the faculty section
            WebElement sectionHeading = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[normalize-space()='Meet our top-ranked faculty']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionHeading);
            Thread.sleep(2000);
            test.log(Status.PASS, "Scrolled to the faculty section.");

            // Collect all faculty mentor cards (including odd/even classes)
            List<WebElement> facultyCards = driver.findElements(By.cssSelector(
                "div[class*='swiper-slide'] div[class*='Faculty_mentorItem__PPsFs']"));

            int totalCards = facultyCards.size();
            System.out.println("Total Faculty Containers Found: " + totalCards);

            // Assert that there are exactly 6 containers
            softAssert.assertEquals(totalCards, 6, "Expected 6 faculty containers but found " + totalCards);
            test.log(Status.PASS, "✅ All 6 faculty containers are present in the DOM.");

            // Optionally verify that each container is displayed (may depend on viewport)
            for (int i = 0; i < facultyCards.size(); i++) {
                WebElement card = facultyCards.get(i);
                boolean isVisible = card.isDisplayed();
                System.out.println("Container " + (i + 1) + " displayed: " + isVisible);
                test.log(Status.INFO, "Container " + (i + 1) + " displayed: " + isVisible);
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "❌ Error verifying faculty containers: " + e.getMessage());
            e.printStackTrace();
            softAssert.fail("Exception occurred", e);
        }
        softAssert.assertAll();
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

	    // Employees From Leading Organizations Trust Amity For Lifelong Learning
    @Test
    public void employeesFrom_Leading_Organization() {
    test = reports.createTest("Verify All Company Logos Are Present and Displayed in Carousel");

    try {
        WebElement sectionHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Employees From Leading Organizations Trust')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionHeading);
        Thread.sleep(2000);
        test.log(Status.PASS, "Scrolled to the faculty section.");

        List<String> companies = new ArrayList<>(Arrays.asList(
                "Google", "Apple", "PWC", "Reliance", "Ernest Young", "Samsung", "Amazon", "HCLTech",
                "Wipro", "KPMG", "Aditya Birla", "Dell Technologies", "Hindustan Unilever", "J.P.Morgan", "Infosys", "Accenture", "FlipKart", "Barclays", "Qatar", "GAIL", "Siemens", "Tech Mahindra", "TCS", "Cisco", "SBI", "Cognizant", "Vi", "HDFC", "ICICI", "Mahindra", "Vedanta", "Tata Steel", "Tata Power", "Cipla", "DHL", "Iffco Tokio", "Capgemini", "LTI", "Hero", "Axis Bank", "Bank of Baroda", "HSBC", "DBS", "Delhivery", "Federal Bank", "Grant Thornton", "Car Dekho", "Max Life", "Tata 1mg", "T Series", "Hitachi Vantara"
        ));

        WebElement nextArrow = driver.findElement(By.cssSelector("button[aria-label='Next'] svg"));

        Set<String> foundCompanies = new HashSet<>();

        int maxAttempts = 13; // Prevent infinite loop
        while (maxAttempts-- > 0 && foundCompanies.size() < companies.size()) {
            for (String company : companies) {
                if (!foundCompanies.contains(company)) {
                    String xpath = "//img[@title='" + company + "']";
                    List<WebElement> logos = driver.findElements(By.xpath(xpath));

                    if (!logos.isEmpty() && logos.get(0).isDisplayed()) {
                        test.log(Status.PASS, "✅ Logo found: " + company);
                        foundCompanies.add(company);
                    }
                }
            }

            // Exit early if all are found
            if (foundCompanies.size() == companies.size()) break;

            // Click next arrow if available
            if (nextArrow.isDisplayed() && nextArrow.isEnabled()) {
                try {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextArrow);
                    } catch (Exception e) {
                        nextArrow.click(); // fallback to normal click
                    }
            } else {
                break; // can't scroll further
            }
        }
        // Report missing companies
        for (String company : companies) {
            if (!foundCompanies.contains(company)) {
                test.log(Status.FAIL, "❌ Logo NOT found: " + company);
                softAssert.fail("Logo not found: " + company);
            }
        }

            } catch (Exception e) {
                test.log(Status.FAIL, "❌ Error in employeesFrom_Leading_Organization: " + e.getMessage());
                e.printStackTrace();
                softAssert.fail("Exception occurred", e);
            }

            softAssert.assertAll();
        }


		@Test
    public void videocall(){
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
