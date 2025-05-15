package Program.MBA;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
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
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
	
	// @Test
	// public void ShowMoreButtonAboutUsSection() {
	//     test = reports.createTest("Click 'Show More' → About Us → Career Services → Student Stores → Leadership → Corporate → Contact Us → Privacy Policy → Student support → Intellectual Properties → UGC Approvals");

	//     try {
	//         // Click 'SHOW MORE'
	//         WebElement showMoreBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (1st time, scroll).");
	//         // Click 'About us'
	//         WebElement aboutUs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='About us']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutUs);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", aboutUs);
	//         wait.until(ExpectedConditions.urlContains("about-us"));
	//         String aboutUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to About us: " + aboutUrl);
	//         Assert.assertTrue(aboutUrl.contains("about-us"), "URL does not contain 'about-us'");
	//         test.log(Status.PASS, "Navigated to About Us page: " + aboutUrl);

	//         // Go back to previous page
	//         driver.navigate().back();

	//         // Wait and click 'SHOW MORE' again (scroll now-2)
	//         WebElement showMoreBtn2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn2);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn2);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (2nd time, scroll).");
	//         // Click 'Career services' (opens in new tab)
	//         String originalWindow = driver.getWindowHandle();
	//         WebElement careerServices = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Career services']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", careerServices);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", careerServices);

	//         // Wait for new tab
	//         wait.until(driver -> driver.getWindowHandles().size() > 1);

	//         // Switch to new tab
	//         for (String handle : driver.getWindowHandles()) {
	//             if (!handle.equals(originalWindow)) {
	//                 driver.switchTo().window(handle);
	//                 break;
	//             }
	//         }

	//         wait.until(ExpectedConditions.urlContains("career-services"));
	//         String careerUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Career services: " + careerUrl);
	//         Assert.assertTrue(careerUrl.contains("career-services"), "URL does not contain 'career-services'");
	//         test.log(Status.PASS, "Navigated to Career Services page: " + careerUrl);
	//         // Optional: Close new tab and return to original
	//         driver.close();
	//         driver.switchTo().window(originalWindow);
	        
	//         // Click 'Student stories'
	//         WebElement studentstories = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Student stories']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", studentstories);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", studentstories);
	//         wait.until(ExpectedConditions.urlContains("student-story"));
	//         String studentstoriesUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Student Stories: " + studentstoriesUrl);
	//         Assert.assertTrue(studentstoriesUrl.contains("student-story"), "URL does not contain 'student-story'");
	//         test.log(Status.PASS, "Navigated to Student stories page: " + studentstoriesUrl);
	        
	//         driver.navigate().back();
	//         // Wait and click 'SHOW MORE' again (scroll now-3)
	//         WebElement showMoreBtn3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn3);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn3);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (3nd time, scroll)."); 
	//         // Click 'Leadership'
	//         WebElement leadership = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Leadership']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", leadership);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", leadership);
	//         wait.until(ExpectedConditions.urlContains("leadership"));
	//         String leadershipUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Leadership: " + leadershipUrl);
	//         Assert.assertTrue(leadershipUrl.contains("leadership"), "URL does not contain 'leadership'");
	//         test.log(Status.PASS, "Navigated to Leadership page: " + leadershipUrl);
	        
	//         driver.navigate().back();
	//         // Wait and click 'SHOW MORE' again (scroll now-4)
	//         WebElement showMoreBtn4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn4);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn4);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (4nd time, scroll).");
	//         // Click 'Corporate'
	//         WebElement corporate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Corporate']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", corporate);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", corporate);
	//         wait.until(ExpectedConditions.urlContains("corporates"));
	//         String corporateUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to corporates: " + corporateUrl);
	//         Assert.assertTrue(corporateUrl.contains("corporates"), "URL does not contain 'corporate'");
	//         test.log(Status.PASS, "Navigated to corporates page: " + corporateUrl);
	        
	//         driver.navigate().back();
	//         // Wait and click 'SHOW MORE' again (scroll now-5)
	//         WebElement showMoreBtn5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn5);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn5);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (5th time, scroll).");
	//         // Click 'Contact Us'
	//         WebElement contactUs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Contact us']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactUs);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", contactUs);
	//         wait.until(ExpectedConditions.urlContains("contact-us"));
	//         String contactUrl = driver.getCurrentUrl();
	//         System.out.println("Currect URl after navigating to contact us: " + contactUrl);
	//         Assert.assertTrue(contactUrl.contains("contact-us"), "URL does not contain 'contact-us'");
	//         test.log(Status.PASS, "Navigated to contact us page: " + contactUrl);
	        
	//         driver.navigate().back();
	//         // Wait and click 'SHOW MORE' again (scroll now-6)
	//         WebElement showMoreBtn6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn6);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn6);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (6th time, scroll).");
	//         // Click Privacy Policy
	//         WebElement privacyPlicy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@target='_self'][normalize-space()='Privacy Policy']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPlicy);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", privacyPlicy);
	//         wait.until(ExpectedConditions.urlContains("privacy-policy"));
	//         String privacyPlicyUrl = driver.getCurrentUrl();
	//         System.out.println("Currect URl after navigating to privacy-policy: " + privacyPlicyUrl);
	//         Assert.assertTrue(privacyPlicyUrl.contains("privacy-policy"), "URL does not contain 'privacy-policy'");
	//         test.log(Status.PASS, "Navigated to privacy-policy page: " + privacyPlicyUrl);
	        
	//         driver.navigate().back();
	//         // Wait and click 'SHOW MORE' again (scroll now-7)
	//         WebElement showMoreBtn7 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn7);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn7);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (7th time, scroll).");
	//         // Click Student support
	//         WebElement studentSupport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Student support']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", studentSupport);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", studentSupport);
	//         wait.until(ExpectedConditions.urlContains("home"));
	//         String studentSupportUrl = driver.getCurrentUrl();
	//         System.out.println("Currect URl after navigating to studentSupport: " + studentSupportUrl);
	//         Assert.assertTrue(studentSupportUrl.contains("home"), "URL does not contain 'studentSupport'");
	//         test.log(Status.PASS, "Navigated to studentSupport page: " + studentSupportUrl);
	        
	//         driver.navigate().back();
	//         // Wait and click 'SHOW MORE' again (scroll now-8)
	//         WebElement showMoreBtn8 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn8);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn8);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (8th time, scroll).");
	//         // Click Intellectual Properties
	//         WebElement intellectualPro = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Intellectual Properties']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", intellectualPro);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", intellectualPro);
	//         wait.until(ExpectedConditions.urlContains("ip-listing"));
	//         String intellectualProUrl = driver.getCurrentUrl();
	//         System.out.println("Currect URl after navigating to Intellectual Properties: " + intellectualProUrl);
	//         Assert.assertTrue(intellectualProUrl.contains("ip-listing"), "URL does not contain 'Intellectual Properties'");
	//         test.log(Status.PASS, "Navigated to Intellectual Properties page: " + intellectualProUrl);
	        
	//         driver.navigate().back();
	//         // Wait and click 'SHOW MORE' again (scroll now-9)
	//         WebElement showMoreBtn9 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn9);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn9);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (9th time, scroll).");
	//         // Click UGC Approvals
	//         WebElement ugcApprovals = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='UGC Approvals']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ugcApprovals);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ugcApprovals);  
	//         wait.until(ExpectedConditions.urlContains("ugc_regulations"));
	//         String ugcApprovalsUrl = driver.getCurrentUrl();
	//         System.out.println("Currect URl after navigating to UGC Approvals: " + ugcApprovalsUrl);
	//         Assert.assertTrue(ugcApprovalsUrl.contains("ugc_regulations"), "URL does not contain 'UGC Approvals'");
	//         test.log(Status.PASS, "Navigated to UGC Approvals page: " + ugcApprovalsUrl);
	        
	//         driver.navigate().back();
	        

	//     } catch (Exception e) {
	//         test.log(Status.FAIL, "Test failed with exception: " + e.getMessage());
	//         Assert.fail("Test failed due to exception.");
	//     }    
	// }
	
	// @Test
	// public void resourcesSection() {
	//     test = reports.createTest("Click 'Resources' → Blog → Media");

	//     try {
	//         // Click 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (1st time, scroll).");
	//         // Click 'BLOG'
	//         WebElement blog = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Blog']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", blog);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", blog);
	//         wait.until(ExpectedConditions.urlContains("blog"));
	//         String blogUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Blog: " + blogUrl);
	//         Assert.assertTrue(blogUrl.contains("blog"), "URL does not contain 'blog'");
	//         test.log(Status.PASS, "Navigated to Blog page: " + blogUrl);
			
	//         // Go back to previous page
	//         driver.navigate().back();
	        
	//         // Click 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn2);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn2);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (1st time, scroll).");
	//         // Click 'MEDIA'
	//         WebElement media = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Media']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", media);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", media);
	//         wait.until(ExpectedConditions.urlContains("news"));
	//         String mediaUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Media: " + mediaUrl);
	//         Assert.assertTrue(mediaUrl.contains("news"), "URL does not contain 'news'");
	//         test.log(Status.PASS, "Navigated to Media page: " + mediaUrl);
			
	//         // Go back to previous page
	//         driver.navigate().back();
	        
	//     } catch (Exception e) {
	//         test.log(Status.FAIL, "Test failed with exception: " + e.getMessage());
	//         Assert.fail("Test failed due to exception.");
	//     }   
	    
	// }
	
	
	// @Test
	// public void ugProgramSection() {
	//     test = reports.createTest("Click 'UG Program'");

	//     try {
	//         // Click 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn);
	// 		test.log(Status.PASS, "'SHOW MORE' clicked via JS.");
	//         // Click 'Bachelor of Computer Applications'
	//         WebElement bcaLink = wait.until(ExpectedConditions.elementToBeClickable(
    //         By.xpath("//a[normalize-space()='Bachelor of Computer Applications']")));
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bcaLink);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", bcaLink);
	// 		// Verify URL
	// 		wait.until(ExpectedConditions.urlContains("bachelor-of-computer-applications-online"));
	// 		String currentUrl = driver.getCurrentUrl();
	// 		System.out.println("Navigated URL: " + currentUrl);
	// 		Assert.assertTrue(currentUrl.contains("bachelor-of-computer-applications-online"), "URL mismatch after clicking BCA.");
	// 		test.log(Status.PASS, "Navigated to BCA page: " + currentUrl);

	// 		// Go back to previous page
	// 		driver.navigate().back();
	        
	//         // Click 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn2);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn2);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (1st time, scroll).");
	//         // Click 'BCA with specialization in Cloud & Security'
	//         WebElement bcaWithCloudSecurity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='BCA with specialization in Cloud & Security']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bcaWithCloudSecurity);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", bcaWithCloudSecurity);
	//         wait.until(ExpectedConditions.urlContains("bca-cloud-security-online"));
	//         String bcaWithCloudSecurityUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to BCA with specialization in Cloud & Security: " + bcaWithCloudSecurityUrl);
	//         Assert.assertTrue(bcaWithCloudSecurityUrl.contains("bca-cloud-security-online"), "URL does not contain 'bca-cloud-security-online'");
	//         test.log(Status.PASS, "Navigated to BCA with specialization in Cloud & Security page: " + bcaWithCloudSecurityUrl);

	//         // Go back to previous page
	//         driver.navigate().back();
	        
	//         // Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn3);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn3);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (3rd time, scroll).");   
	//         // Click 'BCA with specialization in Data Analytics'
	//         WebElement bcaWithDataAnalytics = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='BCA with specialization in Data Analytics']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bcaWithDataAnalytics);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", bcaWithDataAnalytics);
	//         wait.until(ExpectedConditions.urlContains("bca-data-analytics-online"));
	//         String bcaWithDataAnalyticsUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to BCA with specialization in Data Analytics: " + bcaWithDataAnalyticsUrl);
	//         Assert.assertTrue(bcaWithDataAnalyticsUrl.contains("bca-data-analytics-online"), "URL does not contain 'bca-data-analytics-online'");
	//         test.log(Status.PASS, "Navigated to BCA with specialization in Data Analytics page: " + bcaWithDataAnalyticsUrl);

	//         // Go back to previous page
	//         driver.navigate().back();
	        
	//         // Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn4);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn4);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (4rd time, scroll).");
	//         // Click 'Bachelor of Business Administration'
	//         WebElement bba = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Business Administration']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bba);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", bba);
	//         wait.until(ExpectedConditions.urlContains("bachelor-of-business-administration-online"));
	//         String bbaUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Bachelor of Business Administration: " + bbaUrl);
	//         Assert.assertTrue(bbaUrl.contains("bachelor-of-business-administration-online"), "URL does not contain 'bachelor-of-business-administration-online'");
	//         test.log(Status.PASS, "Navigated to Bachelor of Business Administration: " + bbaUrl);
	        
	//         // Go back to previous page
	//         driver.navigate().back();
	        
	//         // Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn5);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn5);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (5rd time, scroll).");
	//         // Click 'Bachelor of Arts (Journalism and Mass communication)'
	//         WebElement baJMC = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Bachelor of Arts (Journalism and Mass communicatio')]")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baJMC);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", baJMC);
	//         wait.until(ExpectedConditions.urlContains("bachelor-of-arts-journalism-and-mass-communication-online"));
	//         String baJMCUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Bachelor of Arts: " + baJMCUrl);
	//         Assert.assertTrue(baJMCUrl.contains("bachelor-of-arts-journalism-and-mass-communication-online"), "URL does not contain 'bachelor-of-arts-journalism-and-mass-communication-online'");
	//         test.log(Status.PASS, "Navigated to Bachelor of Arts: " + baJMCUrl);
	        
	//         // Go back to previous page 
	//         driver.navigate().back();
	        
	//         // Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn6);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn6);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (6rd time, scroll).");
	//         // Click 'Bachelor of Commerce'
	//         WebElement boc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Commerce']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", boc);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", boc);
	//         wait.until(ExpectedConditions.urlContains("bachelor-of-commerce-online"));
	//         String bocUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Bachelor of Commerce: " + bocUrl);
	//         Assert.assertTrue(bocUrl.contains("bachelor-of-commerce-online"), "URL does not contain 'bachelor-of-commerce-online'");
	//         test.log(Status.PASS, "Navigated to Bachelor of Commerce: " + bocUrl);
	        
	//         // Go back to previous page
	//         driver.navigate().back();
	        
	//         // Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn7 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn7);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn7);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (7rd time, scroll).");
	//         // Click 'Bachelor of Arts'
	//         WebElement ba = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ba);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ba);
	//         wait.until(ExpectedConditions.urlContains("bachelor-of-arts-online"));
	//         String baUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Bachelor of Arts: " + baUrl);
	//         Assert.assertTrue(baUrl.contains("bachelor-of-arts-online"), "URL does not contain 'bachelor-of-arts-online'");
	//         test.log(Status.PASS, "Navigated to Bachelor of Arts: " + baUrl);
	        
	//         // Go back to previous page
	//         driver.navigate().back();
	        
	//         // Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn8 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn8);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn8);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (8rd time, scroll).");
	//         // Click 'Bachelor of Art (Kannada Medium)'
	//         WebElement baKM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Art (Kannada Medium)']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baKM);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", baKM);
	//         wait.until(ExpectedConditions.urlContains("bachelor-of-arts-kannada-online"));
	//         String baKMUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Bachelor of Art (Kannada Medium): " + baKMUrl);
	//         Assert.assertTrue(baKMUrl.contains("bachelor-of-arts-kannada-online"), "URL does not contain 'bachelor-of-arts-kannada-online'");
	//         test.log(Status.PASS, "Navigated to Bachelor of Art (Kannada Medium): " + baKMUrl);
	        
	//         // Go back to previous page
	//         driver.navigate().back();
	        
	//         // Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn9 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn9);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn9);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (9th time, scroll).");
	//         // Click 'Bachelor of Arts (Malayalam Medium)'
	//         WebElement baMM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts (Malayalam Medium)']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baMM);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", baMM);
	//         wait.until(ExpectedConditions.urlContains("bachelor-of-arts-malayalam-online"));
	//         String baMMUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Bachelor of Arts (Malayalam Medium): " + baMMUrl);
	//         Assert.assertTrue(baMMUrl.contains("bachelor-of-arts-malayalam-online"), "URL does not contain 'bachelor-of-arts-malayalam-online'");
	//         test.log(Status.PASS, "Navigated to Bachelor of Arts (Malayalam Medium): " + baMMUrl);
	        
	//         // Go back to previous page
	//         driver.navigate().back();
	        
	//         // Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn10 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn10);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn10);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (10th time, scroll).");
	//         // Click 'Bachelor of Arts (Tamil Medium)'
	//         WebElement baTM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts (Tamil Medium)']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baTM);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", baTM);
	//         wait.until(ExpectedConditions.urlContains("bachelor-of-arts-tamil-online"));
	//         String baTMUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Bachelor of Arts (Tamil Medium): " + baTMUrl);
	//         Assert.assertTrue(baTMUrl.contains("bachelor-of-arts-tamil-online"), "URL does not contain 'bachelor-of-arts-tamil-online'");
	//         test.log(Status.PASS, "Navigated to Bachelor of Arts (Tamil Medium): " + baTMUrl);
	        
	//         // Go back to previous page
	//         driver.navigate().back();
	        
	//         // Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn11);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn11);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (11th time, scroll).");
	//         // Click 'Bachelor of Arts (Telugu Medium)'
	//         WebElement baTeluguMedium = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts (Telugu Medium)']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baTeluguMedium);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", baTeluguMedium);
	//         wait.until(ExpectedConditions.urlContains("bachelor-of-arts-telugu-online"));
	//         String baTeluguMediumUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Bachelor of Arts (Telugu Medium): " + baTeluguMediumUrl);
	//         Assert.assertTrue(baTeluguMediumUrl.contains("bachelor-of-arts-telugu-online"), "URL does not contain 'bachelor-of-arts-telugu-online'");
	//         test.log(Status.PASS, "Navigated to Bachelor of Arts (Telugu Medium): " + baTeluguMediumUrl);
	        
	//         // Go back to previous page
	//         driver.navigate().back();
	        
	//         // Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn12 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn12);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn12);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (12th time, scroll).");
	//         // Click 'Bachelor of Arts (Hindi Medium)'
	//         WebElement baHindiMedium = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts (Hindi Medium)']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baHindiMedium);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", baHindiMedium);
	//         wait.until(ExpectedConditions.urlContains("bachelor-of-arts-hindi-medium-online"));
	//         String baHindiMediumUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Bachelor of Arts (Hindi Medium): " + baHindiMediumUrl);
	//         Assert.assertTrue(baHindiMediumUrl.contains("bachelor-of-arts-hindi-medium-online"), "URL does not contain 'bachelor-of-arts-hindi-medium-online'");
	//         test.log(Status.PASS, "Navigated to Bachelor of Arts (Hindi Medium): " + baHindiMediumUrl);
	        
	// 		// Go back to previous page
	// 		driver.navigate().back();

	// 		// Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn13 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn13);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn13);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (12th time, scroll).");
	//         // Click 'B.Com with Specialization in International Finance & Accounting'
	//         WebElement bComHindiMedium = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'B.Com with Specialization in International Finance')]")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bComHindiMedium);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", bComHindiMedium);
	//         wait.until(ExpectedConditions.urlContains("bcom-internationalfinance"));
	//         String bComHindiMediumUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to B.Com with Specialization in International Finance & Accounting: " + bComHindiMediumUrl);
	//         Assert.assertTrue(bComHindiMediumUrl.contains("bcom-internationalfinance"), "URL does not contain 'bcom-internationalfinance'");
	//         test.log(Status.PASS, "Navigated to B.Com with Specialization in International Finance & Accounting: " + bComHindiMediumUrl);
	        
	// 		// Go back to previous page
	// 		driver.navigate().back();

	// 		// Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn14 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn14);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn14);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (12th time, scroll).");
	//         // Click 'Bachelor Of Commerce (Honours)'
	//         WebElement bachelorOfCH = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor Of Commerce (Honours)']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bachelorOfCH);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", bachelorOfCH);
	//         wait.until(ExpectedConditions.urlContains("bachelor-of-commerce-honours"));
	//         String bachelorOfCHUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to Bachelor Of Commerce (Honours): " + bachelorOfCHUrl);
	//         Assert.assertTrue(bachelorOfCHUrl.contains("bachelor-of-commerce-honours"), "URL does not contain 'bachelor-of-commerce-honours'");
	//         test.log(Status.PASS, "Navigated to Bachelor Of Commerce (Honours): " + bachelorOfCHUrl);
	        
	// 		// Go back to previous page
	// 		driver.navigate().back();

	// 		// Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn15 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn15);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn15);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (12th time, scroll).");
	//         // Click 'UG + PG Degree Program'
	//         WebElement ugPgDegree = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='UG + PG Degree Program']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ugPgDegree);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ugPgDegree);
	//         wait.until(ExpectedConditions.urlContains("ug-pg-degree-set"));
	//         String ugPgDegreeUrl = driver.getCurrentUrl();
	//         System.out.println("Current URL after navigating to UG + PG Degree Program: " + ugPgDegreeUrl);
	//         Assert.assertTrue(ugPgDegreeUrl.contains("ug-pg-degree-set"), "URL does not contain 'ug-pg-degree-set'");
	//         test.log(Status.PASS, "Navigated to UG + PG Degree Program: " + ugPgDegreeUrl);
	        
	// 		// Go back to previous page
	// 		driver.navigate().back();

	// 		// Click to 'SHOW MORE BUTTON'
	//         WebElement showMoreBtn16 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
	//         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn16);
	// 		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn16);
	//         test.log(Status.PASS, "'SHOW MORE' button clicked (16th time, scroll).");

	// 		// Wait until the UG Program heading is visible
	// 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[2]")));
	// 		// System.out.println("✅ 'UG Program' section found.");

	// 		// Collect all course links under UG Program
	// 		List<WebElement> courseElements = driver.findElements(By.xpath("//footer[@class='container mb-8 footer_root__az0w0']//ul[2]//li"));
	// 		// System.out.println("✅ Found " + courseElements.size() + " course(s).");

	// 		// Print out course names
	// 		for (int i = 0; i < courseElements.size(); i++) {
	// 			String courseName = courseElements.get(i).getText();
	// 			System.out.println("  ▶ Course " + (i + 1) + ": " + courseName);
	// 		}

	// 		// Verify the count matches expectation
	// 		int expectedCount = 15;
	// 		int actualCount = courseElements.size() - 1;

	// 		Assert.assertEquals(actualCount, expectedCount,
	// 				"❌ Mismatch in course count. Expected: " + expectedCount + ", Found: " + actualCount);
	// 		// System.out.println("✅ Course count validation passed.");
	// 		System.out.println("✅ UG Program course count verified successfully: " + actualCount);

	        
	//     }catch (Exception e) {
	// 			test.log(Status.FAIL, "Test failed with exception: " + e.getMessage());
	// 			e.printStackTrace(); // Console output
	// 			Assert.fail("Test failed due to exception.", e); // Preserve original error
	// 		} 
	    
	// }

	@Test
	public void pgProgramSection() {
	    test = reports.createTest("Click 'PG Program'");

	    try {
	        // Click 'SHOW MORE BUTTON-1'
	        WebElement showMoreBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn);
			test.log(Status.PASS, "'SHOW MORE' clicked via JS.");
	        // Click 'Master of Computer Applications'
	        WebElement mcaLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Master of Computer Applications']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mcaLink);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", mcaLink);
			wait.until(ExpectedConditions.urlContains("master-of-computer-applications-online"));
			String mcaUrl = driver.getCurrentUrl();
			System.out.println("Navigated URL: " + mcaUrl);
			Assert.assertTrue(mcaUrl.contains("master-of-computer-applications-online"), "URL mismatch after clicking 'master-of-computer-applications-online'");
			test.log(Status.PASS, "Navigated to Master of Computer Applications page: " + mcaUrl);

			// Go back to previous page
			driver.navigate().back();

			// Click 'SHOW MORE BUTTON-2'
	        WebElement showMoreBtn2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn2);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn2);
			test.log(Status.PASS, "'SHOW MORE' clicked via JS.");
	        // Click 'MCA with specialization in Blockchain'
	        WebElement mcaBlockchain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='MCA with specialization in Blockchain']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mcaBlockchain);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", mcaBlockchain);
			wait.until(ExpectedConditions.urlContains("mca-blockchain-online"));
			String mcaBlockchainURL = driver.getCurrentUrl();
			System.out.println("Navigated URL: " + mcaBlockchainURL);
			Assert.assertTrue(mcaBlockchainURL.contains("mca-blockchain-online"), "URL mismatch after clicking MCA with specialization in Blockchain");
			test.log(Status.PASS, "Navigated to MCA with specialization in Blockchain page: " + mcaBlockchainURL);

			// Go back to previous page
			driver.navigate().back();

			// Click 'SHOW MORE BUTTON-3'
	        WebElement showMoreBtn3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn3);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn3);
			test.log(Status.PASS, "'SHOW MORE' clicked via JS.");
	        // Click 'MCA with specialization in ML & Al'
	        WebElement mcaMLAI = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='MCA with specialization in ML & Al']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mcaMLAI);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", mcaMLAI);
			wait.until(ExpectedConditions.urlContains("mca-machine-learning-and-artificial-intelligence-online"));
			String mcaMLAIURL = driver.getCurrentUrl();
			System.out.println("Navigated URL: " + mcaMLAIURL);
			Assert.assertTrue(mcaMLAIURL.contains("mca-machine-learning-and-artificial-intelligence-online"), "URL mismatch after clicking MCA with specialization in ML & Al");
			test.log(Status.PASS, "Navigated to MCA with specialization in ML & Al page: " + mcaMLAIURL);

			// Go back to previous page
			driver.navigate().back();

			// Click 'SHOW MORE BUTTON-4'
	        WebElement showMoreBtn4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn4);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn4);
			test.log(Status.PASS, "'SHOW MORE' clicked via JS.");
	        // Click 'MCA with specialization in Machine Learning'
	        WebElement mcaML = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='MCA with specialization in Machine Learning']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mcaML);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", mcaML);
			wait.until(ExpectedConditions.urlContains("mca-machine-learning-online"));
			String mcaMLURL = driver.getCurrentUrl();
			System.out.println("Navigated URL: " + mcaMLURL);
			Assert.assertTrue(mcaMLURL.contains("mca-machine-learning-online"), "URL mismatch after clicking MCA with specialization in Machine Learning");
			test.log(Status.PASS, "Navigated to MCA with specialization in Machine Learning page: " + mcaMLURL);

			// Go back to previous page
			driver.navigate().back();

			// Click 'SHOW MORE BUTTON-5'
	        WebElement showMoreBtn5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn5);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn5);
			test.log(Status.PASS, "'SHOW MORE' clicked via JS.");
	        // Click 'MCA with specialization in AR & VR'
	        WebElement mca_ARVR = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='MCA with specialization in AR & VR']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mca_ARVR);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", mca_ARVR);
			wait.until(ExpectedConditions.urlContains("mca-virtualreality-online"));
			String mca_ARVR_URL = driver.getCurrentUrl();
			System.out.println("Navigated URL: " + mcaMLURL);
			Assert.assertTrue(mca_ARVR_URL.contains("mca-virtualreality-online"), "URL mismatch after clicking MCA with specialization in AR & VR");
			test.log(Status.PASS, "Navigated to MCA with specialization in AR & VR page: " + mca_ARVR_URL);

			// Go back to previous page
			driver.navigate().back();

			// Click 'SHOW MORE BUTTON-6'
	        WebElement showMoreBtn6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn6);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn6);
			test.log(Status.PASS, "'SHOW MORE' clicked via JS.");
	        // Click 'Master of Business Administration'
	        WebElement mba = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Master of Business Administration']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mba);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", mba);
			wait.until(ExpectedConditions.urlContains("master-of-business-administration-online"));
			String mba_URL = driver.getCurrentUrl();
			System.out.println("Navigated URL: " + mba_URL);
			Assert.assertTrue(mba_URL.contains("master-of-business-administration-online"), "URL mismatch after clicking Master of Business Administration");
			test.log(Status.PASS, "Navigated to Master of Business Administration page: " + mba_URL);

			// Go back to previous page
			driver.navigate().back();

			



			
			 }catch (Exception e) {
				test.log(Status.FAIL, "Test failed with exception: " + e.getMessage());
				e.printStackTrace();
				Assert.fail("Test failed due to exception.", e);
			} 
	    
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
