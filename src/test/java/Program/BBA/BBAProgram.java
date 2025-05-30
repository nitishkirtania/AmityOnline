package Program.BBA;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.lang.Thread;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import base.HeaderBaseClass;
import pages.ApplyNowPOM;
import screenshot.HeaderScreenShot;

public class BBAProgram extends HeaderBaseClass {

	@Test(priority = 1)
	public void Header_Section() throws InterruptedException {
		test = reports.createTest("Amity Logo");
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
			if (hPom.amitylogoElement.isDisplayed()) {
				softAssert.assertTrue(true);
				test.log(Status.PASS, "Amity Logo Visible");
			} else {
				softAssert.assertTrue(false);
				test.log(Status.FAIL, "Amity Logo Not Visible");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Amity Logo Not Visible");
			softAssert.fail("Logo Not Displayed" + " " + e.getMessage());

		}

		// ------------program-----------------
		try {
			wait.until(ExpectedConditions.elementToBeClickable(hPom.programsElement));
			js.executeScript("arguments[0].click();", hPom.programsElement);
			if (hPom.allProgramElement.getText().equals("All Programs")) {
				softAssert.assertTrue(true);
				test.log(Status.PASS, "Program Working");

			} else {
				softAssert.assertTrue(false);
				test.log(Status.FAIL, "Program not Working");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Program not Working");
			softAssert.fail("Program not working" + " " + e.getMessage());

		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@alt='close']")).click();

		Thread.sleep(1000);

		// --------------Career Services-----------------------------------
		String parentWindow = driver.getWindowHandle();
		try {
			hPom.Career();
			Set<String> allwindows = driver.getWindowHandles();
			Iterator<String> itr = allwindows.iterator();
			while (itr.hasNext()) {
				String childWindow = itr.next();

				if (!parentWindow.equals(childWindow)) {
					driver.switchTo().window(childWindow);
				}
			}

			String expectecUrl = "https://amityonline.com/career-services";
			softAssert.assertEquals(driver.getCurrentUrl(), expectecUrl);
			test.log(Status.PASS, "Career services working");

		} catch (Exception e) {
			test.log(Status.FAIL, "Career Services not Working" + e.getMessage());
			softAssert.fail("Career Services not working" + " " + e.getMessage());
		}

		driver.close(); // Close the child window
		driver.switchTo().window(parentWindow); // Switch back to parent window

		// ---------------Advantages---------------------------------
		try {
			wait.until(ExpectedConditions.elementToBeClickable(hPom.advantagesElement));
			js.executeScript("arguments[0].click();", hPom.advantagesElement);
			String exUrl = "https://amityonline.com/amity-online-advantage";
			if (exUrl.equals(driver.getCurrentUrl())) {
				softAssert.assertTrue(true);
				test.log(Status.PASS, "Advantages Working");

			} else {
				softAssert.assertTrue(false);
				test.log(Status.FAIL, "Advantages not Working");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Advantages not Working");
			softAssert.fail("Advantage not working" + " " + e.getMessage());
		}
		driver.navigate().back();

		Thread.sleep(1000);

		// ---------------- Search--------------------
		try {

			js.executeScript("arguments[0].click();", hPom.searchbuttotElement);
			hPom.searchbuttoncontentElement.sendKeys("bachelor of computer");
			Actions act = new Actions(driver);
			act.moveToElement(hPom.mbaElement).click().perform();
			String expbbaElement = "https://amityonline.com/bachelor-of-computer-applications-online";
			if (expbbaElement.equals(driver.getCurrentUrl())) {
				softAssert.assertTrue(true);
				test.log(Status.PASS, "Search option Working");

			} else {
				softAssert.assertTrue(false);
				test.log(Status.FAIL, "Search option not Working");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Search option not Working");
			softAssert.fail("Search option not Working" + " " + e.getMessage());

		}
		driver.navigate().back();
		Thread.sleep(3000);

		// -----------------Call Us--------------------------------
		try {
			wait.until(ExpectedConditions.elementToBeClickable(hPom.callusElement));
			js.executeScript("arguments[0].click();", hPom.callusElement);
			Thread.sleep(1000);
			String handle1 = driver.getWindowHandle();
			driver.switchTo().window(handle1);
			if (hPom.calluspopcontentElement.getText().equals("Share Your Details And Get A Free Counseling Session")) {
				softAssert.assertTrue(true);
				test.log(Status.PASS, "Call Us button Working");

			} else {
				softAssert.assertTrue(false);
				test.log(Status.FAIL, "Call Us button not Working");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Call Us button not Working");
			softAssert.fail("Call Us button not Working" + " " + e.getMessage());
		}
		Thread.sleep(1000);
		// Click on close buttton
		driver.findElement(By.cssSelector(".Modal_close__C0ggP")).click();

		Thread.sleep(1000);

		// ------------Video call--------------------------
		String Parentwindow1 = driver.getWindowHandle();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(hPom.videcallElement));
			hPom.VideoCall();
			Set<String> allWindow = driver.getWindowHandles();
			Iterator<String> itr1 = allWindow.iterator();
			while (itr1.hasNext()) {
				String childWindow1 = itr1.next();
				if (!Parentwindow1.equals(childWindow1)) {
					driver.switchTo().window(childWindow1);
				}
			}
			wait.until(ExpectedConditions.urlToBe("https://widget01.popin.to/share/12338"));
			String expVideourl = "https://widget01.popin.to/share/12338";
			if (expVideourl.equals(driver.getCurrentUrl())) {
				softAssert.assertTrue(true);
				test.log(Status.PASS, "Video Call button Working");

			} else {
				softAssert.assertTrue(false);
				test.log(Status.FAIL, "Video Call button not Working");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Video Call button not Working");
			softAssert.fail("Video Call button not Working" + " " + e.getMessage());

		}
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(Parentwindow1);
		Thread.sleep(1000);

		// -----------------student login--------------------------
		try {
			wait.until(ExpectedConditions.elementToBeClickable(hPom.existingstudentloginElement));
			js.executeScript("arguments[0].click();", hPom.existingstudentloginElement);
			String handle2 = driver.getWindowHandle();
			driver.switchTo().window(handle2);
			if (hPom.existingstudentloginContentElement.getText().equals("Student Login")) {
				softAssert.assertTrue(true);
				test.log(Status.PASS, "Existing Student Login Working");
			} else {
				softAssert.assertTrue(false);
				test.log(Status.FAIL, "Existing Student Login not Working");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Existing Student Login not Working" + e.getMessage());
			softAssert.fail("Existing Student Login not Working" + " " + e.getMessage());
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M18.2648 2')]")).click();
		Thread.sleep(1000);

		// -------- Apply Now-------------------------------
		try {
			wait.until(ExpectedConditions.elementToBeClickable(hPom.applyNowHeaderElement));
			js.executeScript("arguments[0].click();", hPom.applyNowHeaderElement);
			String handle3 = driver.getWindowHandle();
			driver.switchTo().window(handle3);

			if (hPom.applynowcontentElement.getText().equals("Connect With Our Counsellor")) {
				softAssert.assertTrue(true);
				test.log(Status.PASS, "Header Apply Now Working");

			} else {
				softAssert.assertTrue(false);
				test.log(Status.FAIL, "Header Apply Now not Working");
			}
		} catch (Exception e) {
			test.log(Status.FAIL,
					"Header Apply Now not Working " + e.getMessage());
			softAssert.fail("Header Apply Now not working" + " " + e.getMessage());
		}
		Thread.sleep(1000);
		// Click on close buttton
		driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M18.2648 2')]")).click();
		Thread.sleep(1000);
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void Apply_Now_India_International() throws Exception {

		test = reports.createTest("Apply_Now_India_International");

		String originalWindow = driver.getWindowHandle();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement ApplynowBTN = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath(
						"//div[contains(@class,'header_menuContainer__00BgW')]//span[contains(@class,'ClientSideButton_btnText__5gMgu')][normalize-space()='APPLY NOW']")));

		ApplynowBTN.click();

		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Re-initialize POM and Wait in new window context
		Apom = new ApplyNowPOM(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		Thread.sleep(3000);

		Apom.indianBTN.click();
		// Apom.countrycodeElement.sendKeys("+91");
		try {
			// Generate and Log Random Data
			String randomMobileNumber = "23" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			Apom.mobiElement.sendKeys(randomMobileNumber);
			Apom.nameElement.sendKeys(randomName);
			Apom.emailElement.sendKeys(randomEmail);
			Apom.submitElement.click();

			Thread.sleep(3000);
			try {
				String handle = driver.getWindowHandle();
				driver.switchTo().window(handle);
				wait.until(ExpectedConditions.elementToBeClickable(Apom.degreeElement)).sendKeys("PG");
				wait.until(ExpectedConditions.elementToBeClickable(Apom.prograElement))
						.sendKeys("MASTER OF COMPUTER APPLICATIONS WITH SPECIALIZATION IN CYBER SECURITY");

				Apom.submit2elElement.click();

				Thread.sleep(6000);

				test.info("Degree and Program selection completed successfully.");
			} catch (Exception e) {
				// test.warning("Degree/Program selection step skipped: " + e.getMessage());
				System.out.println("Skipped degree/program step: " + e.getMessage());
			}
			Apom.OTPCell1.sendKeys(random.GetOTP());
			Apom.OTPCell2.sendKeys(random.GetOTP());
			Apom.OTPCell3.sendKeys(random.GetOTP());
			Apom.OTPCell4.sendKeys(random.GetOTP());
			Apom.OTPCell5.sendKeys(random.GetOTP());
			Apom.OTPCell6.sendKeys(random.GetOTP());

			Apom.VerifyOTP.click();

			Thread.sleep(7000);

			if (Apom.startapplicationElement.isEnabled()) {
				test.log(Status.PASS, "Apply Now Indian Journey is Successful");
				softAssert.assertTrue(true, "Apply Now Indian Journey is Successful");

			} else {
				test.log(Status.FAIL, "Apply Now Journey is Failed");
				softAssert.fail("Apply Now Journey is Failed");
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Apply Now Indian Journey is Failed: " + e.getMessage());
			softAssert.fail("Apply Now Journey is Failed" + e.getMessage());
		}

		driver.navigate().back();
		Thread.sleep(1000);
		// ----------Apply Now international--------------------------

		String originalWindow1 = driver.getWindowHandle();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement ApplynowBTN2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[contains(@class,'header_menuContainer__00BgW')]//span[contains(@class,'ClientSideButton_btnText__5gMgu')][normalize-space()='APPLY NOW']")));
		ApplynowBTN2.click();
		for (String windowHandle1 : driver.getWindowHandles()) {
			if (!windowHandle1.equals(originalWindow1)) {
				driver.switchTo().window(windowHandle1);
				break;
			}
			// 👇 Re-initialize POM and Wait in new window context
			Apom = new ApplyNowPOM(driver);
			Thread.sleep(2000);
			try {
				Apom.internationalElement.click();
				Apom.countrycodeElement.click();
				Thread.sleep(1000);
				WebElement unitedElement = driver
						.findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownItem__Qu0Dw'][1]"));
				Actions codeActions = new Actions(driver);
				codeActions.moveToElement(unitedElement).click().perform();

				String randomMobileNumber = "23" + random.getRandomMobileNumber();
				String randomName = "TestQA" + " " + random.GetRandomName();
				String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

				test.info("Random Name: " + randomName);
				test.info("Random Email: " + randomEmail);
				test.info("Random Mobile Number: " + randomMobileNumber);

				Apom.nameElement.sendKeys(randomName);
				Apom.mobiElement.sendKeys(randomMobileNumber);
				Apom.emailElement.sendKeys(randomEmail);
				Apom.submitElement.click();

				Thread.sleep(2000);
				test.info("Degree and Program selection completed successfully.");
				try {
					String handle2 = driver.getWindowHandle();
					driver.switchTo().window(handle2);

					wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(Apom.degreeElement)).sendKeys("PG");

					wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(Apom.prograElement))
							.sendKeys("MASTER OF COMPUTER APPLICATIONS WITH SPECIALIZATION IN CYBER SECURITY");

					Apom.submit2elElement.click();

					Thread.sleep(3000);
				} catch (Exception e) {
					// test.warning("Degree/Program selection step skipped: " + e.getMessage());
					System.out.println("Skipped degree/program step: " + e.getMessage());
				}

				if (Apom.startapplicationElement.isEnabled()) {

					test.log(Status.PASS, "Apply Now International Journey is Successful");
					softAssert.assertTrue(true, "Apply Now International Journey is Successful");

				} else {
					test.log(Status.FAIL, "Apply Now Journey is Failed");
					softAssert.fail("Apply Now Journey is Failed");

				}
			} catch (Exception e) {
				test.log(Status.FAIL, "Apply Now International Journey is Failed" + e.getMessage());
				softAssert.fail("Apply Now Journey is Failed" + e.getMessage());
			}
		}
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void yelloStrip() {
		test = reports.createTest("Yellow Strip");

		int maxAttempts = 2;
		boolean success = false;

		for (int attempt = 1; attempt <= maxAttempts; attempt++) {
			try {
				System.out.println("Attempt " + attempt + ": Checking Yellow Strip");

				hPom.YStrip(); // Your click/trigger to open modal

				String handle4 = driver.getWindowHandle();
				driver.switchTo().window(handle4);

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement yellowText = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//h2[@class='ConnectModal_Modal__RightContainerTitle__WO56D pr-[2.3rem]']")));

				if (yellowText.getText().trim().equals("Connect With Our Counsellor")) {
					test.log(Status.PASS, "Yellow Strip is Working on attempt " + attempt);
					Assert.assertTrue(true);
					success = true;
					break;
				} else {
					test.log(Status.FAIL, "Yellow Strip text mismatch on attempt " + attempt);
				}

			} catch (Exception e) {
				System.out.println("Attempt " + attempt + " failed: " + e.getMessage());
				if (attempt == maxAttempts) {
					test.log(Status.FAIL, "Yellow Strip is not Working after " + maxAttempts + " attempts");
					Assert.fail("Yellow Strip is not Working: " + e.getMessage());
				} else {
					try {
						Thread.sleep(2000); // wait before retry
						closePopupIfPresent(); // if popup interferes
					} catch (InterruptedException ignored) {
					}
				}
			}
		}
	}

	@Test(priority = 4)
	public void Open_form_BBA_India_International() throws InterruptedException {

		test = reports.createTest("Open_form_BBA_India_International");
		try {

			String bbaName = "TestQA" + " " + random.GetRandomName();
			String mbaMobileNumber = "23" + random.getRandomMobileNumber();
			String bbaEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + bbaName);
			test.info("Random Mobile Number: " + mbaMobileNumber);
			test.info("Random Email: " + bbaEmail);

			openformbba.name.sendKeys(bbaName);
			// openformmba.selectdropdown();
			openformbba.mobile.sendKeys(mbaMobileNumber);
			openformbba.email.sendKeys(bbaEmail);
			openformbba.clicksubmit();

			Thread.sleep(6000);

			openformbba.OTPCell1.sendKeys(random.GetOTP());
			openformbba.OTPCell2.sendKeys(random.GetOTP());
			openformbba.OTPCell3.sendKeys(random.GetOTP());
			openformbba.OTPCell4.sendKeys(random.GetOTP());
			openformbba.OTPCell5.sendKeys(random.GetOTP());
			openformbba.OTPCell6.sendKeys(random.GetOTP());

			openformbba.VerifyOTP.click();

			Thread.sleep(7000);

			if (openformbba.startapplicationElement.isEnabled()) {

				test.log(Status.PASS, "BBA Open form for India is submitted successfully");
				softAssert.assertTrue(true, "BBA Open form is submitted successfully");

			} else {
				test.log(Status.FAIL, "BBA Open form is failed");
				softAssert.fail("BBA Open form is failed");
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "BBA Open form is failed" + e.getMessage());
			softAssert.fail("BBA Open form is failed");

		}
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);

		// ---------------BBA open form for international----------------------------

		try {

			String bbaName = "TestQA" + " " + random.GetRandomName();
			String bbaMobileNumber = "23" + random.getRandomMobileNumber();
			String bbaEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + bbaName);
			test.info("Random Mobile Number: " + bbaMobileNumber);
			test.info("Random Email: " + bbaEmail);

			openformbba.name.sendKeys(bbaName);
			driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
			Actions codeActions1 = new Actions(driver);
			WebElement unitedstate = driver
					.findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
			codeActions1.moveToElement(unitedstate).click().perform();
			openformbba.mobile.sendKeys(bbaMobileNumber);
			openformbba.email.sendKeys(bbaEmail);
			openformbba.clicksubmit();
			Thread.sleep(7000);

			if (openformbba.startapplicationElement.isEnabled()) {
				test.log(Status.PASS, "BBA Open form for international is submitted successfully");
				softAssert.assertTrue(true, "BBA Open form for international is submitted successfully");
			} else {
				test.log(Status.FAIL, "BBA Open form for international is failed");
				softAssert.fail("BBA Open form for international is failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "BBA Open form for international is failed" + e.getMessage());
			softAssert.fail("BBA Open form for international is failed" + e.getMessage());

		}
		softAssert.assertAll();
	}

	// ---------------------------Download---Brochure--------------------------------------------------------------

	@Test(priority = 5)
	public void Download_Brochure_India_International() throws Exception {

		test = reports.createTest("Download_Brochure_India_International");
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		dbrochure.clickbrochure();
		String handle4 = driver.getWindowHandle();
		driver.switchTo().window(handle4);
		try {
			String dname = "TestQA" + " " + random.GetRandomName();
			String dmobilenumber = "23" + random.getRandomMobileNumber();
			String demailid = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + dname);
			test.info("Random Mobile Number: " + dmobilenumber);
			test.info("Random Email: " + demailid);

			// dbrochure.selectdropdown();
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

			Thread.sleep(2000);

			// dbrochure.switchwindow();
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> iterator = handles.iterator();

			while (iterator.hasNext()) {
				String currentHandle = iterator.next();
				if (!currentHandle.equals(handle4)) {
					driver.switchTo().window(currentHandle);
					break;
				}
			}

			Thread.sleep(2000);

			if (dbrochure.startapplicationElement.isEnabled()) {

				test.log(Status.PASS, "Download Brochure for india is working");
				softAssert.assertTrue(true, "Download Brochure for india is working");

			} else {
				test.log(Status.FAIL, "Download Brochure for india is not working");
				softAssert.fail("Download Brochure for india is not working");

			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Download Brochure for india is not working" + e.getMessage());
			softAssert.fail("Download Brochure for india is not working");
		}

		driver.close(); // closes the current child window
		driver.switchTo().window(handle4);
		Thread.sleep(1000);

		// -------------------Close pop-up
		driver.findElement(By.xpath("//div[@class='bg-white Modal_dialog__e3Pgf']//*[name()='svg']")).click();

		Thread.sleep(1000);

		// -------------download brochure for international--------------------------

		try {

			dbrochure.clickbrochure();
			String handle5 = driver.getWindowHandle();
			driver.switchTo().window(handle5);

			String dname = "TestQA" + " " + random.GetRandomName();
			String dmobilenumber = "23" + random.getRandomMobileNumber();
			String demailid = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + dname);
			test.info("Random Mobile Number: " + dmobilenumber);
			test.info("Random Email: " + demailid);

			driver.findElement(By.xpath(
					"//div[@class='flex gap-2']//div//div[contains(@class,'CustomDropdownGlobal_countryCode__yswjf')][normalize-space()='IN +91']"))
					.click();
			Actions codeActions2 = new Actions(driver);
			WebElement unitedstate = driver
					.findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
			codeActions2.moveToElement(unitedstate).click().perform();
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

				test.log(Status.PASS, "Download Brochure for International is working");
				softAssert.assertTrue(true, "Download Brochure is working");

			} else {
				test.log(Status.FAIL, "Download Brochure for International is not working");
				softAssert.fail("Download Brochure for International is not working");
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Download Brochure for International is not working" + e.getMessage());
			softAssert.fail("Download Brochure for International is not working" + e.getMessage());

		}
		softAssert.assertAll();
	}

	// -----------------------------------Share--button-----------------------------------------------------------

	@Test(priority = 6)
	public void sharebutton() throws Exception {
		closePopupIfPresent();
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
				softAssert.assertTrue(sbutton.whatsappElement.isDisplayed(), "WhatsApp icon is not displayed");
				softAssert.assertTrue(sbutton.whatsappElement.isEnabled(), "WhatsApp icon is not enabled");
				test.log(Status.PASS, "WhatsApp icon is displayed and clickable.");
			} catch (Exception e) {
				test.log(Status.FAIL, "WhatsApp icon check failed: " + e.getMessage());
				softAssert.fail("WhatsApp icon check failed: " + e.getMessage());
			}

			// LinkedIn Icon
			try {
				wait.until(ExpectedConditions.visibilityOf(sbutton.linkediElement));
				wait.until(ExpectedConditions.elementToBeClickable(sbutton.linkediElement));
				softAssert.assertTrue(sbutton.linkediElement.isDisplayed(), "LinkedIn icon is not displayed");
				softAssert.assertTrue(sbutton.linkediElement.isEnabled(), "LinkedIn icon is not enabled");
				test.log(Status.PASS, "LinkedIn icon is displayed and clickable.");
			} catch (Exception e) {
				test.log(Status.FAIL, "LinkedIn icon check failed: " + e.getMessage());
				softAssert.fail("LinkedIn icon check failed: " + e.getMessage());
			}

			// Facebook Icon
			try {
				wait.until(ExpectedConditions.visibilityOf(sbutton.facebookElement));
				wait.until(ExpectedConditions.elementToBeClickable(sbutton.facebookElement));
				softAssert.assertTrue(sbutton.facebookElement.isDisplayed(), "Facebook icon is not displayed");
				softAssert.assertTrue(sbutton.facebookElement.isEnabled(), "Facebook icon is not enabled");
				test.log(Status.PASS, "Facebook icon is displayed and clickable.");
			} catch (Exception e) {
				test.log(Status.FAIL, "Facebook icon check failed: " + e.getMessage());
				softAssert.fail("Facebook icon check failed: " + e.getMessage());
			}

			// X (Twitter) Icon
			try {
				wait.until(ExpectedConditions.visibilityOf(sbutton.xelElement));
				wait.until(ExpectedConditions.elementToBeClickable(sbutton.xelElement));
				softAssert.assertTrue(sbutton.xelElement.isDisplayed(), "X (Twitter) icon is not displayed");
				softAssert.assertTrue(sbutton.xelElement.isEnabled(), "X (Twitter) icon is not enabled");
				test.log(Status.PASS, "X (Twitter) icon is displayed and clickable.");
			} catch (Exception e) {
				test.log(Status.FAIL, "X (Twitter) icon check failed: " + e.getMessage());
				softAssert.fail("X (Twitter) icon check failed: " + e.getMessage());
			}

			// Mail Icon
			try {
				wait.until(ExpectedConditions.visibilityOf(sbutton.mailElement));
				wait.until(ExpectedConditions.elementToBeClickable(sbutton.mailElement));
				softAssert.assertTrue(sbutton.mailElement.isDisplayed(), "Mail icon is not displayed");
				softAssert.assertTrue(sbutton.mailElement.isEnabled(), "Mail icon is not enabled");
				test.log(Status.PASS, "Mail icon is displayed and clickable.");
			} catch (Exception e) {
				test.log(Status.FAIL, "Mail icon check failed: " + e.getMessage());
				softAssert.fail("Mail icon check failed: " + e.getMessage());
			}

			// Copy Button
			try {
				wait.until(ExpectedConditions.visibilityOf(sbutton.copyElement));
				wait.until(ExpectedConditions.elementToBeClickable(sbutton.copyElement));
				softAssert.assertTrue(sbutton.copyElement.isDisplayed(), "Copy button is not displayed");
				softAssert.assertTrue(sbutton.copyElement.isEnabled(), "Copy button is not enabled");
				test.log(Status.PASS, "Copy button is displayed and clickable.");
			} catch (Exception e) {
				test.log(Status.FAIL, "Copy button check failed: " + e.getMessage());
				softAssert.fail("Copy button check failed: " + e.getMessage());
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Share icon interaction failed: " + e.getMessage());
			softAssert.fail("Share icon interaction failed: " + e.getMessage());
		}

		softAssert.assertAll(); // Required to trigger any failures at the end
	}

	// ---------------------------------AnnoucementSection--------------------------------------------------------

	@Test(priority = 7)
	public void AnnouncementSection() {

		test = reports.createTest("Announcement Section");
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Scroll the first element into view
		js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
				announcement.scholarshipWebElement);

		// Scholarship available
		try {
			wait.until(ExpectedConditions.visibilityOf(announcement.scholarshipWebElement));
			softAssert.assertTrue(announcement.scholarshipWebElement.isDisplayed(), "Scholarship is not displayed");
			test.log(Status.PASS, "Scholarship available is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Scholarship available is not visible: " + e.getMessage());
			softAssert.fail("Scholarship available visibility check failed: " + e.getMessage());
		}

		// Zero Cost EMI cart
		try {
			wait.until(ExpectedConditions.visibilityOf(announcement.zerocostemiElement));
			softAssert.assertTrue(announcement.zerocostemiElement.isDisplayed(), "Zero cost EMI is not displayed");
			test.log(Status.PASS, "Zero cost EMI cart is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Zero cost EMI cart is not visible: " + e.getMessage());
			softAssert.fail("Zero cost EMI visibility check failed: " + e.getMessage());
		}

		// Learners cart
		try {
			wait.until(ExpectedConditions.visibilityOf(announcement.learnersElement));
			softAssert.assertTrue(announcement.learnersElement.isDisplayed(), "Learners cart is not displayed");
			test.log(Status.PASS, "Learners cart is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Learners cart is not visible: " + e.getMessage());
			softAssert.fail("Learners cart visibility check failed: " + e.getMessage());
		}

		// Admission open cart
		try {
			wait.until(ExpectedConditions.visibilityOf(announcement.admissionopenElement));
			softAssert.assertTrue(announcement.admissionopenElement.isDisplayed(),
					"Admission open cart is not displayed");
			test.log(Status.PASS, "Admission open cart is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Admission open cart is not visible: " + e.getMessage());
			softAssert.fail("Admission open cart visibility check failed: " + e.getMessage());
		}

		// Announcement Scholarship --------------------------------------

		// Scroll into view
		WebElement scholler_button = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector(".PageCard_content__jSoV9.underline.cursor-pointer")));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", scholler_button);

		try {
			scholler_button.click();
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			// Fallback to JavaScript click
			System.out.println("Click intercepted — falling back to JS click.");
			js.executeScript("arguments[0].click();", scholler_button);
		}
		// scholler_button.click();

		// js.executeScript("arguments[0].scrollIntoView();",
		// announcement.scholarshipWebElement);
		// wait.until(ExpectedConditions.elementToBeClickable(announcement.scholarshipWebElement));

		// // Click the scholarship announcement
		// announcement.scholarshipAccouncement();

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
		// Final assert to report all soft assertion failures
		softAssert.assertAll();
	}

	@Test(priority = 8)
	public void Overview() throws InterruptedException {
		test = reports.createTest("Overview Section");
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
				overview.enhanceElement);
		Thread.sleep(2000);

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		closePopupIfPresent();
		try {
			wait.until(ExpectedConditions.visibilityOf(overview.buildingnationcontainer));
			String actualtext = overview.buildingnationcontainer.getText();
			String expectedText = overview.enhanceElement.getText();
			System.out.println("Actual Text: " + actualtext);
			System.out.println("Expected Text: " + expectedText);
			softAssert.assertEquals(actualtext, expectedText, "Building Nation container text mismatch");
			test.log(Status.PASS, "Building Nation container text is displayed correctly.");
		} catch (Exception e) {
			test.log(Status.FAIL, "Text verification failed: " + e.getMessage());
			softAssert.fail("Text verification failed: " + e.getMessage());
		}

		try {
			softAssert.assertTrue(overview.buildingnationBBAImage.isDisplayed(),
					"Building Nation image is not displayed");
			softAssert.assertTrue(overview.buildingnationBBAImage.isEnabled(),
					"Building Nation image is not clickable");
			test.log(Status.PASS, "Building Nation image is displayed and clickable.");
		} catch (Exception e) {
			test.log(Status.FAIL, "Image not found or clickable: " + e.getMessage());
			softAssert.fail("Image not found or clickable: " + e.getMessage());
		}

		// Report all assertion failures at the end of the test
		softAssert.assertAll();
	}

	// -----------------------------------------------Degrees To Dreams: An Amity
	// Online Podcast | Online BBA Program----------------------------------

	@Test(priority = 9)
	public void Podcast() throws InterruptedException {
		test = reports.createTest("Podcast Section");

		js.executeScript("arguments[0].scrollIntoView();", podcast.podcastcontainerElement);
		Thread.sleep(2000);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Use soft assert instead of hard assert
		try {
			wait.until(ExpectedConditions.visibilityOf(podcast.podcastcontainerElement));
			String actualtext1 = podcast.podcastcontainerElement.getText();
			String expectedtext1 = podcast.podcasttextElement.getText();
			softAssert.assertEquals(actualtext1, expectedtext1, "Podcast section text mismatch");
			test.log(Status.PASS, "Podcast section text verified successfully.");
		} catch (Exception e) {
			test.log(Status.FAIL, "Podcast section text verification failed: " + e.getMessage());
			softAssert.fail("Podcast section text verification failed: " + e.getMessage());
		}

		try {
			// Switch to iframe with YouTube embed
			WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//iframe[contains(@src, 'youtube.com/embed')]")));
			driver.switchTo().frame(iframe);

			WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector(".ytp-large-play-button.ytp-button")));
			Thread.sleep(2000);
			playButton.click();
			Thread.sleep(3000);

			WebElement pauseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector(".ytp-play-button")));
			String ariaLabel = pauseButton.getAttribute("aria-label");
			softAssert.assertTrue(ariaLabel.toLowerCase().contains("pause"), "Pause button not visible.");
			test.log(Status.PASS, "Pause button is visible. Video playback confirmed.");

			// Switch back to default content after iframe interaction
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			test.log(Status.FAIL, "Video playback verification failed: " + e.getMessage());
			softAssert.fail("Video playback verification failed: " + e.getMessage());
			try {
				driver.switchTo().defaultContent();
			} catch (Exception ignore) {
			}
		}

		// Assert all at the end to report failures collectively
		softAssert.assertAll();
	}

	// --------------------------------Program Highlights &
	// Advantages-------------------------------------------------------------

	@Test(priority = 10)
	public void ProgramHighlights() throws InterruptedException {
		test = reports.createTest("Program Highlights Section");
		js.executeScript("arguments[0].scrollIntoView();", programhigh.programhigglightsBBAElement);
		Thread.sleep(2000);

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			wait.until(ExpectedConditions.visibilityOf(programhigh.qSrankingElement));
			softAssert.assertTrue(programhigh.qSrankingElement.isDisplayed(), "QS Ranked Online MBA is not displayed");
			test.log(Status.PASS, "QS Ranked Online MBA is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "QS Ranked Online MBA not displayed: " + e.getMessage());
			softAssert.fail("QS Ranked Online MBA not displayed: " + e.getMessage());
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(programhigh.aCCAspecializationElement));
			softAssert.assertTrue(programhigh.aCCAspecializationElement.isDisplayed(),
					"ACCA specializations is not displayed");
			test.log(Status.PASS, "ACCA specializations is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "ACCA specializations not displayed: " + e.getMessage());
			softAssert.fail("ACCA specializations not displayed: " + e.getMessage());
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(programhigh.studyanytimElement));
			softAssert.assertTrue(programhigh.studyanytimElement.isDisplayed(),
					"Study anytime anywhere is not displayed");
			test.log(Status.PASS, "Study anytime anywhere is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Study anytime anywhere is not displayed: " + e.getMessage());
			softAssert.fail("Study anytime anywhere is not displayed: " + e.getMessage());
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(programhigh.realworldElement));
			softAssert.assertTrue(programhigh.realworldElement.isDisplayed(), "Real World Projects is not displayed");
			test.log(Status.PASS, "Real World Projects is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Real World Projects is not displayed: " + e.getMessage());
			softAssert.fail("Real World Projects is not displayed: " + e.getMessage());
		}

		// Assert all at the end to report collected failures
		softAssert.assertAll();
	}

	// ----------------------------------------Fee--Structure------------------------------------------------------

	@Test(priority = 11)
	public void feeStructure() throws InterruptedException {
		test = reports.createTest("Fee Structure");
		js.executeScript("arguments[0].scrollIntoView();", feestructure.feeElement);
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			wait.until(ExpectedConditions.visibilityOf(feestructure.interestfreeElement));
			softAssert.assertTrue(feestructure.interestfreeElement.isDisplayed(), "Interest free cart is not visible");
			test.log(Status.PASS, "Interest free cart is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Interest free cart is not visible: " + e.getMessage());
			softAssert.fail("Interest free cart is not visible: " + e.getMessage());
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(feestructure.semisterfee));
			softAssert.assertTrue(feestructure.semisterfee.isDisplayed(), "Per Semester Fee cart is not visible");
			test.log(Status.PASS, "Per Semester Fee cart is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Per Semester Fee cart is not visible: " + e.getMessage());
			softAssert.fail("Per Semester Fee cart is not visible: " + e.getMessage());
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(feestructure.fullprogramfeeElement));
			softAssert.assertTrue(feestructure.fullprogramfeeElement.isDisplayed(),
					"Full Program Fee cart is not visible");
			test.log(Status.PASS, "Full Program Fee cart is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Full Program Fee cart is not visible: " + e.getMessage());
			softAssert.fail("Full Program Fee cart is not visible: " + e.getMessage());
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(feestructure.attractivescholarshipElement));
			softAssert.assertTrue(feestructure.attractivescholarshipElement.isDisplayed(),
					"Attractive Scholarships Available cart is not visible");
			test.log(Status.PASS, "Attractive Scholarships Available cart is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Attractive Scholarships Available cart is not visible: " + e.getMessage());
			softAssert.fail("Attractive Scholarships Available cart is not visible: " + e.getMessage());
		}

		Thread.sleep(200);

		try {
			WebElement feestructore = wait
					.until(ExpectedConditions.elementToBeClickable(feestructure.exploremoWebElement));
			feestructore.click();
			wait.until(ExpectedConditions.urlToBe("https://amityonline.com/scholarship"));
			String expurl4 = "https://amityonline.com/scholarship";
			String acturalurl4 = driver.getCurrentUrl();
			softAssert.assertEquals(acturalurl4, expurl4);
			test.log(Status.PASS, "Explore now button is visible and working");
		} catch (Exception e) {
			test.log(Status.FAIL, "Explore now button is not visible and working");
			softAssert.fail("Explore now button is not visible and working");
		}
		// Collect all assertion results and report failures here
		softAssert.assertAll();
	}

	// -----------------------Why Say Yes To
	// Amity--Online------------------------------
	@Test(priority = 12)
	public void WhySayYesToAmityOnline() throws InterruptedException {
		test = reports.createTest("Why Say Yes To Amity Online");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js.executeScript("arguments[0].scrollIntoView();", waysayyes.whysayyesElement);
		Thread.sleep(2000);

		try {
			wait.until(ExpectedConditions.visibilityOf(waysayyes.globallyElement));
			softAssert.assertTrue(waysayyes.globallyElement.isDisplayed(),
					"Globally recognised | Digitally advanced | Deeply personalised is not visible");
			test.log(Status.PASS, "Globally recognised | Digitally advanced | Deeply personalised is visible");
		} catch (Exception e) {
			test.log(Status.FAIL,
					"Globally recognised | Digitally advanced | Deeply personalised is not visible" + e.getMessage());
			softAssert.fail(
					"Globally recognised | Digitally advanced | Deeply personalised is not visible" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(waysayyes.wascElement));
			softAssert.assertTrue(waysayyes.wascElement.isDisplayed(), "WASC Accreditation (USA) is not visible");
			test.log(Status.PASS, "WASC Accreditation (USA) is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "WASC Accreditation (USA) is not visible" + e.getMessage());
			softAssert.fail("WASC Accreditation (USA) is not visible" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(waysayyes.wesElement));
			softAssert.assertTrue(waysayyes.wesElement.isDisplayed(), "WES Recognition is not visible");
			test.log(Status.PASS, "WES Recognition is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "WES Recognition is not visible" + e.getMessage());
			softAssert.fail("WES Recognition is not visible" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(waysayyes.qSelementElement));
			softAssert.assertTrue(waysayyes.qSelementElement.isDisplayed(), "QS Ranked Online MBA not visible");
			test.log(Status.PASS, "QS Ranked Online MBA is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "QS Ranked Online MBA is not visible" + e.getMessage());
			softAssert.fail("QS Ranked Online MBA is not visible" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(waysayyes.qAAelemElement));
			softAssert.assertTrue(waysayyes.qAAelemElement.isDisplayed(), "QAA (UK) Accreditation not visible");
			test.log(Status.PASS, "QAA (UK) Accreditation is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "QAA (UK) Accreditation is not visible" + e.getMessage());
			softAssert.fail("QAA (UK) Accreditation is not visible" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(waysayyes.timeshighereducation));
			softAssert.assertTrue(waysayyes.timeshighereducation.isDisplayed(),
					"Times Higher Education Employability Rankings not visible");
			test.log(Status.PASS, "Times Higher Education Employability Rankings is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Times Higher Education Employability Rankings is not visible" + e.getMessage());
			softAssert.fail("Times Higher Education Employability Rankings is not visible" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(waysayyes.panindiaElement));
			softAssert.assertTrue(waysayyes.panindiaElement.isDisplayed(),
					"Pan-India Campus Access & Offline Events not visible");
			test.log(Status.PASS, "Pan-India Campus Access & Offline Events is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Pan-India Campus Access & Offline Events is not visible" + e.getMessage());
			softAssert.fail("Pan-India Campus Access & Offline Events is not visible" + e.getMessage());
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(waysayyes.amigoElement));
			softAssert.assertTrue(waysayyes.amigoElement.isDisplayed(), "Amigo: Learning On-the-Go is not visible");
			test.log(Status.PASS, "Amigo: Learning On-the-Go is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Amigo: Learning On-the-Go is not visible" + e.getMessage());
			softAssert.fail("Amigo: Learning On-the-Go is not visible" + e.getMessage());
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(waysayyes.profami));
			softAssert.assertTrue(waysayyes.profami.isDisplayed(),
					"Prof. Ami: Your AI-Powered Personal Tutor is not visible");
			test.log(Status.PASS, "Prof. Ami: Your AI-Powered Personal Tutor is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Prof. Ami: Your AI-Powered Personal Tutor is not visible" + e.getMessage());
			softAssert.fail("Prof. Ami: Your AI-Powered Personal Tutor is not visible" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(waysayyes.industrycertioficationElement));
			softAssert.assertTrue(waysayyes.industrycertioficationElement.isDisplayed(),
					"Industry Certifications for Better Employability is not visible");
			test.log(Status.PASS, "Industry Certifications for Better Employability is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Industry Certifications for Better Employability is not visible" + e.getMessage());
			softAssert.fail("Industry Certifications for Better Employability is not visible" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(waysayyes.internshipElement));
			softAssert.assertTrue(waysayyes.internshipElement.isDisplayed(), "Internship Opportunities is not visible");
			test.log(Status.PASS, "Internship Opportunities is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Internship Opportunities is not visible" + e.getMessage());
			softAssert.fail("Internship Opportunities is not visible" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(waysayyes.aipoweredElement));
			softAssert.assertTrue(waysayyes.aipoweredElement.isDisplayed(),
					"AI-Powered Career Discovery Platform is not visible");
			test.log(Status.PASS, "AI-Powered Career Discovery Platform is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "AI-Powered Career Discovery Platform is not visible" + e.getMessage());
			softAssert.fail("AI-Powered Career Discovery Platform is not visible" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(waysayyes.besocialElement));
			softAssert.assertTrue(waysayyes.besocialElement.isDisplayed(),
					"beSocial App for Campus Life is not visible");
			test.log(Status.PASS, "beSocial App for Campus Life is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "beSocial App for Campus Life is not visible" + e.getMessage());
			softAssert.fail("beSocial App for Campus Life is not visible" + e.getMessage());
		}

		List<WebElement> allwhysayyes = driver.findElements(
				By.xpath("//div[@class='font-raleway WhyAmity_item__pvzfz WhyAmity_centerdItem__WF7S_']"));
		try {
			int Actualcount = allwhysayyes.size();
			int expectedcount = 12;
			softAssert.assertEquals(Actualcount, expectedcount);
			test.log(Status.PASS, "Why Say Yes To Amity Online count matched ");
		} catch (Exception e) {
			test.log(Status.FAIL, "Why Say Yes To Amity Online count mismatched ");
			softAssert.fail("Why Say Yes To Amity Online count mismatched");
		}
		softAssert.assertAll();

	}

	// -----------------------------Program Overview &
	// Structure-------------------------------------------------------------

	@Test(priority = 13)
	public void programOverviewStructure() throws InterruptedException {
		test = reports.createTest("Program Overview & Structure");
		js.executeScript("arguments[0].scrollIntoView();", programoverview.programoverviewElement);
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOf(programoverview.programoverviewElement));
			softAssert.assertTrue(programoverview.programoverviewElement.isDisplayed(),
					"Program Overview & Structure is not displayed");
			test.log(Status.PASS, "Program Overview & Structure is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Program Overview & Structure is not displayed: " + e.getMessage());
		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(programoverview.explorecurriculumElement));
			softAssert.assertTrue(programoverview.explorecurriculumElement.isEnabled(),
					"Explore curriculum is not working");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					programoverview.explorecurriculumElement);

			String handle10 = driver.getWindowHandle();
			driver.switchTo().window(handle10);
			if (programoverview.downloadbrochurElement.getText().equals("Download Brochure")) {
				softAssert.assertTrue(true);
				test.log(Status.PASS, "Explore curriculum is working");
			} else {
				softAssert.fail("Explore curriculum is not working");
				test.log(Status.FAIL, "Explore curriculum is not working");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Explore curriculum is not working: " + e.getMessage());
			softAssert.fail("Explore curriculum is not working");
		}

		programoverview.closebuttonElement.click();
		Thread.sleep(1000);

		try {
			programoverview.semister1elElement.click();
			test.log(Status.PASS, "Semister 1 Dropdown arrow is working");
			softAssert.assertTrue(true);
		} catch (Exception e) {
			test.log(Status.FAIL, "Semister 1 Dropdown arrow not working: " + e.getMessage());
			softAssert.fail();
		}
		Thread.sleep(1000);

		try {
			programoverview.semister2elElement.click();
			test.log(Status.PASS, "Semister 2 Dropdown arrow is working");
			softAssert.assertTrue(true);
		} catch (Exception e) {
			test.log(Status.FAIL, "Semister 2 Dropdown arrow not working: " + e.getMessage());
			softAssert.fail();
		}
		Thread.sleep(1000);

		try {
			programoverview.semister3elElement.click();
			test.log(Status.PASS, "Semister 3 Dropdown arrow is working");
			softAssert.assertTrue(true);
		} catch (Exception e) {
			test.log(Status.FAIL, "Semister 3 Dropdown arrow not working: " + e.getMessage());
			softAssert.fail();
		}
		Thread.sleep(1000);

		try {
			programoverview.seminter4elElement.click();
			test.log(Status.PASS, "Semister 4 Dropdown arrow is working");
			softAssert.assertTrue(true);
		} catch (Exception e) {
			test.log(Status.FAIL, "Semister 4 Dropdown arrow not working: " + e.getMessage());
			softAssert.fail();
		}
		Thread.sleep(1000);

		try {
			programoverview.specializationselElement.click();
			test.log(Status.PASS, "Specialization Dropdown arrow is working");
			softAssert.assertTrue(true);
		} catch (Exception e) {
			test.log(Status.FAIL, "Specialization Dropdown arrow not working: " + e.getMessage());
			softAssert.fail();
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(programoverview.certificatElement));
			if (programoverview.certificatElement.isDisplayed()) {
				softAssert.assertTrue(true);
				test.log(Status.PASS, "Certificate displayed");
			} else {
				softAssert.fail("Certificate not displayed");
				test.log(Status.FAIL, "Certificate not displayed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Certificate not displayed: " + e.getMessage());
			softAssert.fail("Certificate not displayed");
		}
		// Assert all soft assertions here to collect any failures
		softAssert.assertAll();
	}

	// --------------------Eligibility Criteria---------------------------
	@Test(priority = 14)
	public void EligibilityCriteria() throws InterruptedException {
		test = reports.createTest("Eligibility Criteria");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js.executeScript("arguments[0].scrollIntoView();", criteria.elegibilitycriteriaElement);
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.visibilityOf(criteria.elegibilitycriteriaElement));
			softAssert.assertTrue(criteria.elegibilitycriteriaElement.isDisplayed(),
					"Elegibility criteria not displayed");
			test.log(Status.PASS, "Elegibility Criteria Displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Elegibility Criteria not Displayed" + e.getMessage());
			softAssert.fail("Elegibility Criteria not Displayed" + e.getMessage());

		}

		try {
			wait.until(ExpectedConditions.visibilityOf(criteria.eligibleElement));
			softAssert.assertTrue(criteria.eligibleElement.isDisplayed(), "Eligible icon not displayed");
			test.log(Status.PASS, "Eligible icon Displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Eligible icon not Displayed" + e.getMessage());
			softAssert.fail("Eligible icon not Displayed" + e.getMessage());

		}

		try {
			wait.until(ExpectedConditions.visibilityOf(criteria.elegibilitycriteriasection));
			softAssert.assertTrue(criteria.elegibilitycriteriasection.isDisplayed(),
					"Eligible criteria section not displayed");
			test.log(Status.PASS, "Eligible criteria section Displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Eligible criteria section not Displayed" + e.getMessage());
			softAssert.fail("Eligible criteria section not Displayed" + e.getMessage());

		}

		try {
			wait.until(ExpectedConditions.visibilityOf(criteria.forindianstyudentsElement));
			softAssert.assertTrue(criteria.forindianstyudentsElement.isDisplayed(),
					"For Indian students not displayed");
			test.log(Status.PASS, "For Indian students Displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "For Indian students not Displayed" + e.getMessage());
			softAssert.fail("For Indian students not Displayed" + e.getMessage());

		}

		try {
			wait.until(ExpectedConditions.visibilityOf(criteria.forindianstudentsection));
			softAssert.assertTrue(criteria.forindianstudentsection.isDisplayed(),
					"For Indian students section not displayed");
			test.log(Status.PASS, "For Indian students section Displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "For Indian students section not Displayed" + e.getMessage());
			softAssert.fail("For Indian students section not Displayed" + e.getMessage());

		}

		try {
			wait.until(ExpectedConditions.visibilityOf(criteria.forforeignstudentsElement));
			softAssert.assertTrue(criteria.forforeignstudentsElement.isDisplayed(),
					"For Foreign students not displayed");
			test.log(Status.PASS, "For Foreign students Displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "For Foreign students not Displayed" + e.getMessage());
			softAssert.fail("For Foreign students not Displayed" + e.getMessage());

		}

		try {
			wait.until(ExpectedConditions.visibilityOf(criteria.forforeignstudentssection));
			softAssert.assertTrue(criteria.forforeignstudentssection.isDisplayed(),
					"For Foreign students section not displayed");
			test.log(Status.PASS, "For Foreign students section Displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "For Foreign students section not Displayed" + e.getMessage());
			softAssert.fail("For Foreign students section not Displayed" + e.getMessage());

		}
		softAssert.assertAll();
	}

	// -------------Admission Process------------------------------------

	@Test(priority = 15)
	public void AdmissionProcess() throws InterruptedException {
		test = reports.createTest("Admission Process");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js.executeScript("arguments[0].scrollIntoView();", admissionprocess.admissionprocessElement);
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.visibilityOf(admissionprocess.selectyourprogramElement));
			softAssert.assertTrue(admissionprocess.admissionprocessElement.isDisplayed(),
					"Admission Process not Displayed");
			test.log(Status.PASS, "Admission Process Displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Admission Process not Displayed" + e.getMessage());
			softAssert.fail("Admission Process not Displayed" + e.getMessage());
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(admissionprocess.selectyourprogramElement));
			softAssert.assertTrue(admissionprocess.selectyourprogramElement.isDisplayed(),
					"Select your program not Displayed");
			test.log(Status.PASS, "Select your program Displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Select your program not Displayed" + e.getMessage());
			softAssert.fail("Select your program not Displayed" + e.getMessage());
		}

		try {
			wait.until(ExpectedConditions.visibilityOf(admissionprocess.completeyourapplicationElement));
			softAssert.assertTrue(admissionprocess.completeyourapplicationElement.isDisplayed(),
					"Complete your application not Displayed");
			test.log(Status.PASS, "Complete your application Displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Complete your application not Displayed" + e.getMessage());
			softAssert.fail("Complete your application not Displayed" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(admissionprocess.payyourprogramfeeElement));
			softAssert.assertTrue(admissionprocess.payyourprogramfeeElement.isDisplayed(),
					"Pay your program fee not Displayed");
			test.log(Status.PASS, "Pay your program fee Displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Pay your program fee not Displayed" + e.getMessage());
			softAssert.fail("Pay your program fee not Displayed" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(admissionprocess.submitandregisterElement));
			softAssert.assertTrue(admissionprocess.submitandregisterElement.isDisplayed(),
					"Submit & register not Displayed");
			test.log(Status.PASS, "Submit & register Displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Submit & register not Displayed" + e.getMessage());
			softAssert.fail("Submit & register not Displayed" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(admissionprocess.awaitenrollmentElement));
			softAssert.assertTrue(admissionprocess.awaitenrollmentElement.isDisplayed(),
					"Await Enrollment details not Displayed");
			test.log(Status.PASS, "Await Enrollment details Displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Await Enrollment details not Displayed" + e.getMessage());
			softAssert.fail("Await Enrollment details not Displayed" + e.getMessage());
		}
		softAssert.assertAll();
	}

	// --------------Journey Towards: Online
	// Degree__Program------------------------------
	@Test(priority = 16)
	public void journettowards() throws InterruptedException {
		test = reports.createTest("Journey Towards: Online Degree Program");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js.executeScript("arguments[0].scrollIntoView();", journeytowards.journeytowardsGraduationElement);
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.visibilityOf(journeytowards.journeytowardsGraduationElement));
			softAssert.assertTrue(journeytowards.journeytowardsGraduationElement.isDisplayed(),
					"Journey Towards Graduation: Your Online Degree Program Experience not Displayed");
			test.log(Status.PASS, "Journey Towards Graduation: Your Online Degree Program Experience Display");
		} catch (Exception e) {
			test.log(Status.FAIL, "Journey Towards Graduation: Your Online Degree Program Experience not Displayed");
			softAssert.fail("Journey Towards Graduation: Your Online Degree Program Experience not Displayed");
		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(journeytowards.arrow1));
			journeytowards.arrow1.click();
			test.log(Status.PASS, "Online Orientation dropdown arrow is working");
		} catch (Exception e) {
			test.log(Status.FAIL, "Online Orientation dropdown arrow is not working" + e.getMessage());
			softAssert.fail("Online Orientation dropdown arrow is not working" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(journeytowards.arrow2));
			journeytowards.arrow2.click();
			test.log(Status.PASS, "On-Campus Meet dropdown arrow is working");
		} catch (Exception e) {
			test.log(Status.FAIL, "On-Campus Meet dropdown arrow is not working" + e.getMessage());
			softAssert.fail("On-Campus Meet dropdown arrow is not working" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(journeytowards.arrow3));
			journeytowards.arrow3.click();
			test.log(Status.PASS, "Academic Progress dropdown arrow is working");
		} catch (Exception e) {
			test.log(Status.FAIL, "Academic Progress dropdown arrow is not working" + e.getMessage());
			softAssert.fail("Academic Progress dropdown arrow is not working" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(journeytowards.arrow4));
			journeytowards.arrow4.click();
			test.log(Status.PASS, "Utilize Resources dropdown arrow is working");
		} catch (Exception e) {
			test.log(Status.FAIL, "Utilize Resources dropdown arrow is not working" + e.getMessage());
			softAssert.fail("Utilize Resources dropdown arrow is not working" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(journeytowards.journeyforeducationElement));
			softAssert.assertTrue(journeytowards.journeyforeducationElement.isDisplayed(),
					"Journey for Education is not visible");
			test.log(Status.PASS, "Journey for Education is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Journey for Education is not visible" + e.getMessage());
			softAssert.fail("Journey for Education is not visible" + e.getMessage());
		}
		softAssert.assertAll();
	}

	// ----------------------Holistic Career Services: How we help you build your
	// dream career

	@Test(priority = 17)
	public void HolisticCareerServices() throws InterruptedException {
		test = reports.createTest("Holistic Career Services: How we help you build your dream career");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js.executeScript("arguments[0].scrollIntoView();", holisticcaareer.careerexplorationtoolElement);
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.visibilityOf(holisticcaareer.holisticcareertextElement));
			softAssert.assertTrue(holisticcaareer.holisticcareertextElement.isDisplayed(),
					"Holistic Career Services: How we help you build your dream career is not visible");
			test.log(Status.PASS, "Holistic Career Services: How we help you build your dream career is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Holistic Career Services: How we help you build your dream career is not visible"
					+ e.getMessage());
			softAssert.fail("Holistic Career Services: How we help you build your dream career is not visible"
					+ e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(holisticcaareer.ourwiderangElement));
			softAssert.assertTrue(holisticcaareer.ourwiderangElement.isDisplayed(),
					"Our wide range of services are designed to meet your specific needs for career is not visible");
			test.log(Status.PASS,
					"Our wide range of services are designed to meet your specific needs for career is visible");
		} catch (Exception e) {
			test.log(Status.FAIL,
					"Our wide range of services are designed to meet your specific needs for career is not visible"
							+ e.getMessage());
			softAssert.fail(
					"Our wide range of services are designed to meet your specific needs for career is not visible"
							+ e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(holisticcaareer.careerexplorationtoolElement));
			softAssert.assertTrue(holisticcaareer.careerexplorationtoolElement.isDisplayed(),
					"Career exploration tools is not visible");
			test.log(Status.PASS, "Career exploration tools is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Career exploration tools is not visible" + e.getMessage());
			softAssert.fail("Career exploration tools is not visible" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(holisticcaareer.resumElement));
			softAssert.assertTrue(holisticcaareer.resumElement.isDisplayed(), "Resume/CV assistance is not visible");
			test.log(Status.PASS, "Resume/CV assistance is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Resume/CV assistance not visible" + e.getMessage());
			softAssert.fail("Resume/CV assistance is not visible" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(holisticcaareer.virtualjobElement));
			softAssert.assertTrue(holisticcaareer.virtualjobElement.isDisplayed(),
					"Virtual job search support is not visible");
			test.log(Status.PASS, "Virtual job search support is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Virtual job search support not visible" + e.getMessage());
			softAssert.fail("Virtual job search support is not visible" + e.getMessage());
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(holisticcaareer.careercouncellingElement));
			softAssert.assertTrue(holisticcaareer.careercouncellingElement.isDisplayed(),
					"Career counselling & advising is not visible");
			test.log(Status.PASS, "Career counselling & advising is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Career counselling & advising is not visible" + e.getMessage());
			softAssert.fail("Career counselling & advising is not visible" + e.getMessage());
		}
		softAssert.assertAll();
	}

	// ------------------------Potential Job
	// roles--------------------------------------

	@Test(priority = 18)
	public void Potential_Job_roles() throws InterruptedException {
		test = reports.createTest("Potential Job roles");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement potential_job_Scroll = driver
				.findElement(By.cssSelector("section[id='PotentialJobRoles'] div[class='pt-7 lg:pt-7']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", potential_job_Scroll);
		Thread.sleep(2000);

		try {
			List<WebElement> three_Container = driver.findElements(
					By.xpath("//div[@class='JobRolesSection_JobRolesSection__cardContainer__hBWOQ']/child::div"));

			int container_count = three_Container.size();

			if (container_count == 3) {
				test.log(Status.PASS, "Correct numbers of container found 3");
			} else {
				test.log(Status.FAIL, "Not get correct container size.." + container_count);
				softAssert.fail("Miss match count in potential job roles " + container_count);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to Potential_Job_roles section: " + e.getMessage());
			softAssert.fail("Scroll to Potential_Job_roles section failed", e);
		}
		softAssert.assertAll();
	}

	// ---------------Open & Honest Reviews by our Learners-------------------------
	@Test(priority = 19)
	public void TestimonialStudent() throws InterruptedException {
		test = reports.createTest("Open_Honest_Reviews_by_our_Learners");
		closePopupIfPresent();

		// Check if the testimonial section is present
		List<WebElement> reviewSection = driver
				.findElements(By.xpath("//h2[normalize-space()='Open & Honest Reviews by our Learners']"));

		if (!reviewSection.isEmpty()) { // =======> ✅ HIGHLIGHTED: Check for review section
			WebElement Open_Honest_Scroll = reviewSection.get(0);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Open_Honest_Scroll);
			Thread.sleep(2000);

			try {
				List<WebElement> testimonialSlides = driver.findElements(By.cssSelector(
						"div[class='swiper swiper-initialized swiper-horizontal swiper-backface-hidden'] div[class='swiper-wrapper'] div[class*='swiper-slide']"));

				int actualCount = testimonialSlides.size();

				if (actualCount == 8) {
					test.log(Status.PASS, "Correct number of testimonial slides found: 8");
					softAssert.assertTrue(true, "Correct number of testimonial slides found: 8");
				} else {
					test.log(Status.FAIL, "Expected 8 testimonial slides but found: " + actualCount);
					softAssert.fail("Mismatch in testimonial slide count. Expected: 8, Found: " + actualCount);
				}
			} catch (Exception e) {
				test.log(Status.FAIL, "Unable to fetch testimonial slides: " + e.getMessage());
				softAssert.fail("Fetching testimonial slides failed", e);
			}
		} else {
			test.log(Status.INFO, "Testimonial section not found, proceeding to video section");
		}

		Thread.sleep(2000);
		// ---------videos------------------

		WebElement video_scroll = driver.findElement(By.xpath("//img[@title='Ruchir']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", video_scroll);
		Thread.sleep(2000);

		try {
			// Thread.sleep(2000);
			WebElement play1_button = driver.findElement(By.xpath(
					"//div[@class='swiper-slide swiper-slide-active']//div[@class='VideoCard_playBtnOverlay__AojHz']"));
			play1_button.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Video 1 played successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Error in Video 1 play: " + e.getMessage());
			softAssert.fail("Video 1 play failed" + e.getMessage());
		}

		try {
			WebElement play2_button = driver.findElement(By.xpath(
					"//div[@class='swiper-slide swiper-slide-next']//div[@class='VideoCard_playBtnOverlay__AojHz']//*[name()='svg']//*[name()='path' and contains(@d,'M481.6 270')]"));
			play2_button.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Video 2 played successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Error in Video 2 play: " + e.getMessage());
			softAssert.fail("Video 2 play failed" + e.getMessage());
		}

		try {
			WebElement play3_button = driver.findElement(By.xpath(
					"//div[@class='StudentTestimonial_testimonialContainer__fqCLy']//div[3]//div[1]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M481.6 270')]"));
			play3_button.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Video 3 played successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Error in Video 3 play: " + e.getMessage());
			e.printStackTrace();
			softAssert.fail("Video 3 play failed" + e.getMessage());
		}

		try {
			WebElement play4_button = driver.findElement(By.xpath(
					"//div[@class='StudentTestimonial_testimonialContainer__fqCLy']//div[4]//div[1]//div[1]//div[1]//div[1]"));
			play4_button.click();
			Thread.sleep(3000);
			test.log(Status.PASS, "Video 4 played successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Error in Video 4 play: " + e.getMessage());
			e.printStackTrace();
			softAssert.fail("Video 4 play failed" + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			WebElement alumini = driver.findElement(By.xpath("//a[normalize-space()='See Alumni Success Stories']"));
			js.executeScript("arguments[0].scrollIntoView();", alumini);
			js.executeScript("arguments[0].click();", alumini);
			wait.until(ExpectedConditions.urlToBe("https://amityonline.com/student-story"));
			String expectedurlstudentstory = "https://amityonline.com/student-story";
			softAssert.assertEquals(driver.getCurrentUrl(), expectedurlstudentstory);
			test.log(Status.PASS, "Student story url verified");
		} catch (Exception e) {
			test.log(Status.FAIL, "Student story url not verified");
			softAssert.fail("Student story url not verified" + e.getMessage());
		}
		softAssert.assertAll();
	}

	// ------Employees From Leading Organizations Trust Amity For Lifelong
	// Learning-----------------

	@Test(priority = 20)
	public void employeesFrom_Leading_Organization() throws InterruptedException {
		test = reports.createTest("Employees From Leading Organizations Trust Amity For Lifelong Learning");
		// closePopupIfPresent();

		WebElement sectionHeading = wait
				.until(ExpectedConditions.visibilityOf(EmployeesFromLeadingOrg.scroll_EmployeesFromLeadingOrg_Element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionHeading);
		Thread.sleep(2000);

		try {
			// Get all logo elements
			List<WebElement> logos = driver.findElements(By.xpath(
					"//div[@class='swiper swiper-initialized swiper-horizontal swiper-grid']//div[@class='swiper-wrapper']/div"));
			int actualCount = logos.size();
			// Verify count
			if (actualCount == 51) {
				test.log(Status.PASS, "✅ Correct number of logos found: 51");
				softAssert.assertTrue(true);
			} else {
				test.log(Status.FAIL, "❌ Incorrect number of logos found. Expected: 51, Found: " + actualCount);
				softAssert.fail("Logo count mismatch: Found " + actualCount + " instead of 51");
			}

			// // Verify all logos are visible
			// int index = 1;
			// for (WebElement logo : logos) {
			// if (logo.isDisplayed()) {
			// test.log(Status.PASS, "✅ Logo " + index + " is visible");
			// } else {
			// test.log(Status.FAIL, "❌ Logo " + index + " is NOT visible");
			// softAssert.fail("Logo at index " + index + " not visible");
			// }
			// index++;
			// }
		} catch (Exception e) {
			test.log(Status.FAIL, "❌ Exception occurred while verifying logos: " + e.getMessage());
			softAssert.fail("Exception occurred" + e.getMessage());
		}
		softAssert.assertAll();
	}

	// ---------Meet our top-ranked faculty-----------------------------

	@Test(priority = 21)
	public void meet_our_top_ranked_faculty_Section() {
		test = reports.createTest("Meet our top-ranked faculty");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Scroll into view
		wait.until(ExpectedConditions.visibilityOf(MeetOurTopRankedFaculty.Meet_our_top_ranked_faculty_Element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				MeetOurTopRankedFaculty.Meet_our_top_ranked_faculty_Element);

		try {
			Thread.sleep(2000);
			// First bullet (1st 3 cards)
			wait.until(ExpectedConditions.elementToBeClickable(MeetOurTopRankedFaculty.bullet_button_one));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					MeetOurTopRankedFaculty.bullet_button_one);
			Thread.sleep(500);
			// test.log(Status.INFO, "🔍 Checking first 3 faculty");
			// Faculty 1
			try {
				WebElement one_container = wait
						.until(ExpectedConditions.visibilityOf(MeetOurTopRankedFaculty.DrCoralJasmineBarboza));
				softAssert.assertTrue(one_container.isDisplayed(), "Dr. Coral Jasmine Barboza not displayed");
				test.log(Status.PASS, "✅ Dr. Coral Jasmine Barboza displayed");
			} catch (Exception e) {
				test.log(Status.FAIL, "❌ Dr. Coral Jasmine Barboza not found/displayed: " + e.getMessage());
				softAssert.fail("Dr. Coral Jasmine Barboza not found" + e.getMessage());
			}
			// Faculty 2
			try {
				WebElement two_container = wait
						.until(ExpectedConditions.visibilityOf(MeetOurTopRankedFaculty.DrRashmiSaxena));
				softAssert.assertTrue(two_container.isDisplayed(), "Dr. Rashmi Saxena not displayed");
				test.log(Status.PASS, "✅ Dr. Rashmi Saxena displayed");
			} catch (Exception e) {
				test.log(Status.FAIL, "❌ Dr. Rashmi Saxena not found/displayed: " + e.getMessage());
				softAssert.fail("Dr. Rashmi Saxena not found" + e.getMessage());
			}
			// Faculty 3
			try {
				WebElement three_container = wait
						.until(ExpectedConditions.visibilityOf(MeetOurTopRankedFaculty.MonaChaudhary));
				softAssert.assertTrue(three_container.isDisplayed(), "Mona Chaudhary not displayed");
				test.log(Status.PASS, "✅ Mona Chaudhary displayed");
			} catch (Exception e) {
				test.log(Status.FAIL, "❌ Mona Chaudhary not found/displayed: " + e.getMessage());
				softAssert.fail("Mona Chaudhary not found" + e.getMessage());
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "❌ Meet our top-ranked faculty first group: " + e.getMessage());
			softAssert.fail("Meet our top-ranked faculty first group: " + e.getMessage());
		}

		try {
			Thread.sleep(2000);
			// Second bullet (next 3 cards)
			WebElement bullet4 = wait
					.until(ExpectedConditions.elementToBeClickable(MeetOurTopRankedFaculty.bullet_button_two));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", bullet4);
			Thread.sleep(500);
			// test.log(Status.INFO, "🔍 Checking next 3 faculty");

			// Faculty 4
			try {
				WebElement four_container = wait
						.until(ExpectedConditions.visibilityOf(MeetOurTopRankedFaculty.NehaTandon));
				softAssert.assertTrue(four_container.isDisplayed(), "Neha Tandon  not displayed");
				test.log(Status.PASS, "✅ Neha Tandon  displayed");
			} catch (Exception e) {
				test.log(Status.FAIL, "❌ Neha Tandon  not found/displayed: " + e.getMessage());
				softAssert.fail("Neha Tandon  not found" + e.getMessage());
			}
			// Faculty 5
			try {
				WebElement five_container = wait
						.until(ExpectedConditions.visibilityOf(MeetOurTopRankedFaculty.PragatiSahai));
				softAssert.assertTrue(five_container.isDisplayed(), "Dr. Pragati Sahai not displayed");
				test.log(Status.PASS, "✅ Dr. Pragati Sahai displayed");
			} catch (Exception e) {
				test.log(Status.FAIL, "❌ Dr. Pragati Sahai not found/displayed: " + e.getMessage());
				softAssert.fail("Dr. Pragati Sahai not found" + e.getMessage());
			}
			// Faculty 6
			try {
				WebElement six_container = wait
						.until(ExpectedConditions.visibilityOf(MeetOurTopRankedFaculty.DrHarshita));
				softAssert.assertTrue(six_container.isDisplayed(), "Dr. Harshita not displayed");
				test.log(Status.PASS, "✅ Dr. Harshita displayed");
			} catch (Exception e) {
				test.log(Status.FAIL, "❌ Dr. Harshita not found/displayed: " + e.getMessage());
				softAssert.fail("Dr. Harshita not found" + e.getMessage());
			}
			// Second bullet (next 3 cards)
			wait.until(ExpectedConditions.elementToBeClickable(MeetOurTopRankedFaculty.bullet_button_three));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					MeetOurTopRankedFaculty.bullet_button_three);
			Thread.sleep(500);
			// Faculty 7
			try {
				WebElement six_container = wait
						.until(ExpectedConditions.visibilityOf(MeetOurTopRankedFaculty.DrMaitriSavarn));
				softAssert.assertTrue(six_container.isDisplayed(), "Dr. Maitri Savarn not displayed");
				test.log(Status.PASS, "✅ Dr. Maitri Savarn displayed");
			} catch (Exception e) {
				test.log(Status.FAIL, "❌ Dr. Maitri Savarn not found/displayed: " + e.getMessage());
				softAssert.fail("Dr. Maitri Savarn not found" + e.getMessage());
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "❌ Meet our top-ranked faculty second group: " + e.getMessage());
			softAssert.fail("Meet our top-ranked faculty second group: " + e.getMessage());
		}
		softAssert.assertAll();
	}

	// -------------------------Are you ready to take the next step in your career
	// ?--------------------------------

	@Test(priority = 22)
	public void next_step_in_your_career() throws InterruptedException {
		test = reports.createTest("Are you ready to take the next step in your career ?");

		wait.until(ExpectedConditions.visibilityOf(AreYouReadytoTakeTheNextStep.scroll_are_you_ready));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				AreYouReadytoTakeTheNextStep.scroll_are_you_ready);
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AreYouReadytoTakeTheNextStep.apply_now_button));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					AreYouReadytoTakeTheNextStep.apply_now_button);
			String handle11 = driver.getWindowHandle();
			driver.switchTo().window(handle11);
			WebElement testelement = wait
					.until(ExpectedConditions.visibilityOf(AreYouReadytoTakeTheNextStep.tesElement));
			if (testelement.getText().equals("Connect With Our Counsellor")) {
				test.log(Status.PASS, "Apply Now button working");
				softAssert.assertTrue(true);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Apply Now button not working" + e.getMessage());
			softAssert.fail("Apply Now button not working" + e.getMessage());
		}

		try {
			WebElement bannercardimage = wait
					.until(ExpectedConditions.visibilityOf(AreYouReadytoTakeTheNextStep.banner_image));
			wait.until(ExpectedConditions.visibilityOf(bannercardimage));
			softAssert.assertTrue(bannercardimage.isDisplayed());
			test.log(Status.PASS, "Banner card image is visible");
		} catch (Exception e) {
			test.log(Status.FAIL, "Banner card image is failed" + e.getMessage());
			softAssert.fail("Banner card image is failed" + e.getMessage());
		}
		softAssert.assertAll();
	}

	// -----------------Frequently Asked Questions------------------------

	@Test(priority = 23)
	public void Frequently_Asked_Questions() throws InterruptedException {
		test = reports.createTest("Frequently Asked Questions");
		// --- Frequently Asked Questions Section ---
		wait.until(ExpectedConditions.elementToBeClickable(FrequentlyAskedQuestion.scroll_FAK_Element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				FrequentlyAskedQuestion.scroll_FAK_Element);
		Thread.sleep(2000);

		try {
			test.log(Status.INFO, "GENERAL section interaction started");
			clickArrow(FrequentlyAskedQuestion.general_arrow_one);
			clickArrow(FrequentlyAskedQuestion.general_arrow_two);
			clickArrow(FrequentlyAskedQuestion.general_arrow_three);
			clickArrow(FrequentlyAskedQuestion.general_arrow_four);
			clickArrow(FrequentlyAskedQuestion.general_arrow_five);
			test.log(Status.PASS, "GENERAL section interaction Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "GENERAL section interaction failed: " + e.getMessage());
			softAssert.fail("GENERAL section interaction failed.");
		}
		Thread.sleep(1000);

		// --- ACADEMICS Section ---
		try {
			wait.until(ExpectedConditions.elementToBeClickable(FrequentlyAskedQuestion.academic_button));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					FrequentlyAskedQuestion.academic_button);
			test.log(Status.PASS, "ACADEMICS section interaction Pass");
			Thread.sleep(2000);

			clickArrow(FrequentlyAskedQuestion.academic_arrow_one);
			clickArrow(FrequentlyAskedQuestion.academic_arrow_two);
			clickArrow(FrequentlyAskedQuestion.academic_arrow_three);
			clickArrow(FrequentlyAskedQuestion.academic_arrow_four);
			Thread.sleep(2000);
		} catch (Exception e) {
			test.log(Status.FAIL, "ACADEMICS section interaction failed" + e.getMessage());
			softAssert.fail("ACADEMICS section interaction failed.");
		}
		Thread.sleep(1000);
		// --- ADMISSION Section ---
		try {
			wait.until(ExpectedConditions.elementToBeClickable(FrequentlyAskedQuestion.admission_button));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					FrequentlyAskedQuestion.admission_button);
			test.log(Status.PASS, "ADMISSION section interaction Passed");
			Thread.sleep(2000);

			clickArrow(FrequentlyAskedQuestion.admission_arrow_one);
			clickArrow(FrequentlyAskedQuestion.admission_arrow_two);
			clickArrow(FrequentlyAskedQuestion.admission_arrow_three);
			clickArrow(FrequentlyAskedQuestion.admission_arrow_four);
			Thread.sleep(2000);
		} catch (Exception e) {
			test.log(Status.FAIL, "ADMISSION section interaction failed" + e.getMessage());
			softAssert.fail("ADMISSION section interaction failed.");
		}
		softAssert.assertAll();
	}

	// // Helper method for clicking an arrow element
	private void clickArrow(WebElement arrow) {
		try {
			WebElement clickableArrow = wait.until(ExpectedConditions.elementToBeClickable(arrow));
			clickableArrow.click();
			test.log(Status.PASS, "Arrow clicked successfully.");
		} catch (Exception e) {
			test.log(Status.WARNING, "Arrow click failed: " + e.getMessage());
		}
	}

	// ---------------------------Footer
	// section---------------------------------------------------------------
	public void Showmore() {

		// Click 'SHOW MORE'
		WebElement showMoreBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='show more']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", showMoreBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", showMoreBtn);
	}

	// --------------Are you ready to take the next step in
	// yourcareer?----------Blue RFI----------------------------------

	@Test(priority = 24)
	public void BlueRFI() throws InterruptedException {
		test = reports.createTest("Blue RFI Indian & International");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(BlueRFI.applynowtextElement));
		js.executeScript("arguments[0].scrollIntoView();", BlueRFI.applynowtextElement);
		Thread.sleep(2000);
		closePopupIfPresent();

		try {
			// Generate and Log Random Data
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomMobileNumber = "239" + random.getRandomMobileNumber2();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			BlueRFI.fullnamElement.sendKeys(randomName);
			BlueRFI.phonenumberElement.sendKeys(randomMobileNumber);
			BlueRFI.emailidElement.sendKeys(randomEmail);
			BlueRFI.submitbuttonElement.click();

			Thread.sleep(2000);
			try {
				String handle = driver.getWindowHandle();
				driver.switchTo().window(handle);

				wait.until(ExpectedConditions.elementToBeClickable(BlueRFI.degreeElement)).sendKeys("PG");
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(BlueRFI.programElement))
						.sendKeys("MASTER OF COMPUTER APPLICATIONS WITH SPECIALIZATION IN CYBER SECURITY");

				BlueRFI.submittbutton2.click();

				Thread.sleep(3000);

				test.info("Degree and Program selection completed successfully.");
			} catch (Exception e) {
				// test.warning("Degree/Program selection step skipped: " + e.getMessage());
				System.out.println("Skipped degree/program step: " + e.getMessage());
			}
			BlueRFI.OTPCell1.sendKeys(random.GetOTP());
			BlueRFI.OTPCell2.sendKeys(random.GetOTP());
			BlueRFI.OTPCell3.sendKeys(random.GetOTP());
			BlueRFI.OTPCell4.sendKeys(random.GetOTP());
			BlueRFI.OTPCell5.sendKeys(random.GetOTP());
			BlueRFI.OTPCell6.sendKeys(random.GetOTP());

			BlueRFI.VerifyOTP.click();

			Thread.sleep(5000);

			if (BlueRFI.startapplicationElement.isEnabled()) {
				test.log(Status.PASS, "Blue RFI Apply Now Indian Journey is Successful");
				softAssert.assertTrue(true, "Blue RFI Apply Now Indian Journey is Successful");
				System.out.println("Blue RFI Apply Now Indian journey is Successful");
			} else {
				test.log(Status.FAIL, "Blue RFI Apply Now Indian Journey is failed");
				System.out.println("Blue RFI Apply Now Indian Journey is failed");
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Blue RFI Apply Now Indian Journey is Failed: " + e.getMessage());
			softAssert.fail("Blue RFI Apply Now Indian Journey is failed");

		}

		Thread.sleep(2000);
		driver.navigate().back();

		// --------------------------------For
		// International------------------------------

		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(BlueRFI.applynowtextElement));
		js.executeScript("arguments[0].scrollIntoView();", BlueRFI.applynowtextElement);
		Thread.sleep(2000);

		try {
			// Generate and Log Random Data
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomMobileNumber = "239" + random.getRandomMobileNumber2();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			BlueRFI.fullnamElement.sendKeys(randomName);
			BlueRFI.countrycodElement.click();
			Actions act11 = new Actions(driver);
			act11.moveToElement(BlueRFI.internationalunitedstatElement).click().perform();
			BlueRFI.phonenumberElement.sendKeys(randomMobileNumber);
			BlueRFI.emailidElement.sendKeys(randomEmail);
			BlueRFI.submitbuttonElement.click();

			Thread.sleep(3000);
			try {
				String handle11 = driver.getWindowHandle();
				driver.switchTo().window(handle11);
				wait.until(ExpectedConditions.elementToBeClickable(BlueRFI.degreeElement)).sendKeys("PG");
				wait.until(ExpectedConditions.elementToBeClickable(BlueRFI.programElement))
						.sendKeys("MASTER OF COMPUTER APPLICATIONS WITH SPECIALIZATION IN CYBER SECURITY");
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView();", BlueRFI.submittbutton2);
				Thread.sleep(1000);
				js.executeScript("arguments[0].click();", BlueRFI.submittbutton2);

				Thread.sleep(6000);

				test.info("Blue RFI Degree and Program selection completed successfully.");
				softAssert.assertTrue(true, "Blue RFI Degree and Program selection completed successfully");
			} catch (Exception e) {
				// test.warning("Degree/Program selection step skipped: " + e.getMessage());
				System.out.println("Skipped degree/program step: " + e.getMessage());
			}

			Thread.sleep(7000);

			if (BlueRFI.startapplicationElement.isEnabled()) {
				test.log(Status.PASS, "Blue RFI Apply Now International Journey is Successful");
				softAssert.assertTrue(true, "Blue RFI Apply Now International Journey is Successful");
				System.out.println("Blue RFI Apply Now International journey is Successful");
			} else {
				test.log(Status.FAIL, "Blue RFI Apply Now International Journey is failed");
				softAssert.fail("Blue RFI Apply Now International Journey is failed");
				System.out.println("Blue RFI Apply Now International Journey is failed");
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Blue RFI Apply Now International Journey is Failed: " + e.getMessage());
			softAssert.fail("Blue RFI Apply Now International Journey is failed");
		}
		softAssert.assertAll();
	}

	// ----------------------------------------------Footer Section----------
	@Test(priority = 25)
	public void FooterSection() throws InterruptedException {
		test = reports.createTest("Footer Section");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Showmore();
		Thread.sleep(2000);
		try {

			// Click 'About us'
			WebElement aboutUs = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='About us']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutUs);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", aboutUs);
			wait.until(ExpectedConditions.urlContains("about-us"));
			String aboutUrl = driver.getCurrentUrl();
			// System.out.println("Current URL after navigating to About us: " + aboutUrl);
			softAssert.assertEquals(aboutUrl, "https://amityonline.com/about-us", "About Us URL mismatch");
			test.log(Status.PASS, "Navigation to About Us page successful " + aboutUrl);
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
			WebElement careerServices = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Career services']")));
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
			test.log(Status.PASS, "Navigation to Career Services page successful " + careerUrl);
			// Optional: Close new tab and return to original
			driver.close();
			driver.switchTo().window(originalWindow);

		} catch (Exception e) {
			test.log(Status.FAIL, "Career Services navigation failed: " + e.getMessage());
			softAssert.fail("Career Services navigation failed: " + e.getMessage());
		}
		Thread.sleep(2000);
		try {
			// Click 'Student stories'
			WebElement studentstories = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Student stories']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", studentstories);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", studentstories);
			wait.until(ExpectedConditions.urlContains("student-story"));
			String studentstoriesUrl = driver.getCurrentUrl();
			// System.out.println("Current URL after navigating to Student Stories: " +
			// studentstoriesUrl);
			softAssert.assertEquals(studentstoriesUrl, "https://amityonline.com/student-story",
					"URL does not contain 'student-story'");
			test.log(Status.PASS, "Navigation to Student stories page successful " + studentstoriesUrl);
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Student stories page failed: " + e.getMessage());
			softAssert.fail("Navigation to Student stories page failed: " + e.getMessage());
		}

		driver.navigate().back();

		// Click 'SHOW MORE' and navigate to 'Leadership'
		try {
			Showmore();
			WebElement leadership = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Leadership']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", leadership);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", leadership);
			wait.until(ExpectedConditions.urlContains("leadership"));
			String leadershipUrl = driver.getCurrentUrl();
			// System.out.println("Current URL after navigating to Leadership: " +
			// leadershipUrl);
			softAssert.assertEquals(leadershipUrl, "https://amityonline.com/leadership",
					"URL does not contain 'leadership'");
			test.log(Status.PASS, "Navigation to Leadership page successful " + leadershipUrl);
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Leadership page failed: " + e.getMessage());
			softAssert.fail("Navigation to Leadership page failed: " + e.getMessage());
		}
		driver.navigate().back();

		// Click 'SHOW MORE' and navigate to 'Corporate'
		try {
			Showmore();
			WebElement corporate = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Corporate']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", corporate);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", corporate);
			wait.until(ExpectedConditions.urlContains("corporates"));
			String corporateUrl = driver.getCurrentUrl();
			// System.out.println("Current URL after navigating to Corporate: " +
			// corporateUrl);
			softAssert.assertEquals(corporateUrl, "https://amityonline.com/corporates",
					"URL does not contain 'corporate'");
			test.log(Status.PASS, "Navigation to Corporate page successful " + corporateUrl);
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Corporate page failed: " + e.getMessage());
			softAssert.fail("Navigation to Corporate page failed: " + e.getMessage());
		}
		driver.navigate().back();

		// Click 'SHOW MORE' and navigate to 'Contact us'
		try {
			Showmore();
			WebElement contactUs = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Contact us']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactUs);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", contactUs);
			wait.until(ExpectedConditions.urlContains("contact-us"));
			String contactUrl = driver.getCurrentUrl();
			// System.out.println("Current URL after navigating to Contact Us: " +
			// contactUrl);
			softAssert.assertEquals(contactUrl, "https://amityonline.com/contact-us",
					"URL does not contain 'contact-us'");
			test.log(Status.PASS, "Navigation to Contact Us page successful " + contactUrl);
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Contact Us page failed: " + e.getMessage());
			softAssert.fail("Navigation to Contact Us page failed: " + e.getMessage());
		}
		driver.navigate().back();

		// Click 'SHOW MORE' and navigate to 'Privacy Policy'
		try {
			Showmore();
			WebElement privacyPolicy = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[@target='_self'][normalize-space()='Privacy Policy']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", privacyPolicy);
			wait.until(ExpectedConditions.urlContains("privacy-policy"));
			String privacyPolicyUrl = driver.getCurrentUrl();
			// System.out.println("Current URL after navigating to Privacy Policy: " +
			// privacyPolicyUrl);
			softAssert.assertEquals(privacyPolicyUrl, "https://amityonline.com/privacy-policy",
					"URL does not contain 'privacy-policy'");
			test.log(Status.PASS, "Navigation to Privacy Policy page successful " + privacyPolicyUrl);
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Privacy Policy page failed: " + e.getMessage());
			softAssert.fail("Navigation to Privacy Policy page failed: " + e.getMessage());
		}
		driver.navigate().back();

		try {
			Showmore();
			// Click 'Student Support'
			WebElement studentSupport = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Student support']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", studentSupport);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", studentSupport);
			wait.until(ExpectedConditions.urlContains("home"));
			String studentSupportUrl = driver.getCurrentUrl();
			// System.out.println("Current URL after navigating to Student Support: " +
			// studentSupportUrl);
			softAssert.assertEquals(studentSupportUrl, "https://amitysupport.freshdesk.com/support/home",
					"URL does not contain 'home'");
			test.log(Status.PASS, "Navigation to Student Support page successful " + studentSupportUrl);
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Student Support page failed: " + e.getMessage());
			softAssert.fail("Navigation to Student Support page failed: " + e.getMessage());
		}

		driver.navigate().back();

		try {
			Showmore();
			// Click 'Intellectual Properties'
			WebElement intellectualPro = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='Intellectual Properties']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", intellectualPro);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", intellectualPro);
			wait.until(ExpectedConditions.urlContains("ip-listing"));
			String intellectualProUrl = driver.getCurrentUrl();
			// System.out.println("Current URL after navigating to Intellectual Properties:
			// " + intellectualProUrl);
			softAssert.assertEquals(intellectualProUrl, "https://amityonline.com/ip-listing",
					"URL does not contain 'ip-listing'");
			test.log(Status.PASS, "Navigation to Intellectual Properties page successful " + intellectualProUrl);
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Intellectual Properties page failed: " + e.getMessage());
			softAssert.fail("Navigation to Intellectual Properties page failed: " + e.getMessage());
		}

		driver.navigate().back();

		try {
			Showmore();
			// Click 'UGC Approvals'
			WebElement ugcApprovals = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='UGC Approvals']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ugcApprovals);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ugcApprovals);
			wait.until(ExpectedConditions.urlContains("ugc_regulations"));
			String ugcApprovalsUrl = driver.getCurrentUrl();
			// System.out.println("Current URL after navigating to UGC Approvals: " +
			// ugcApprovalsUrl);
			softAssert.assertEquals(ugcApprovalsUrl, "https://amityonline.com/ugc_regulations",
					"URL does not contain 'ugc_regulations'");
			test.log(Status.PASS, "Navigation to UGC Approvals page successful " + ugcApprovalsUrl);
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to UGC Approvals page failed: " + e.getMessage());
			softAssert.fail("Navigation to UGC Approvals page failed: " + e.getMessage());
		}

		driver.navigate().back();
		Showmore();
		Thread.sleep(1000);

		// Call assertAll at the end to mark test failed if any soft assertion failed
		softAssert.assertAll();
	}

	// Resource section
	@Test(priority = 26)
	public void resourcesSection() throws InterruptedException {
		test = reports.createTest("'Resources' → Blog → Media");
		// Step 1: Click 'SHOW MORE' and navigate to Blog
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			Showmore();
			WebElement resource = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Resources']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resource);
			softAssert.assertTrue(resource.isEnabled());
			test.log(Status.PASS, "Resource page is enabled");
		} catch (Exception e) {
			test.log(Status.FAIL, "Resource page is not enabled" + e.getMessage());
			softAssert.fail("Resource page is not enabled" + e.getMessage());
		}

		Thread.sleep(1000);
		try {
			// Showmore();
			WebElement blog = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Blog']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", blog);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", blog);
			wait.until(ExpectedConditions.urlContains("blog"));
			String blogUrl = driver.getCurrentUrl();
			// System.out.println("Current URL after navigating to Blog: " + blogUrl);
			softAssert.assertEquals(blogUrl, "https://amityonline.com/blog", "URL does not contain 'blog'");
			test.log(Status.PASS, "Navigation to Blog page successful " + blogUrl);
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Blog page failed: " + e.getMessage());
			softAssert.fail("Navigation to Blog page failed: " + e.getMessage());
		}

		driver.navigate().back();
		// Step 2: Click 'SHOW MORE' and navigate to Media
		Thread.sleep(1000);

		try {
			Showmore();
			WebElement media = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Media']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", media);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", media);
			wait.until(ExpectedConditions.urlContains("news"));
			String mediaUrl = driver.getCurrentUrl();
			// System.out.println("Current URL after navigating to Media: " + mediaUrl);
			softAssert.assertEquals(mediaUrl, "https://amityonline.com/news", "URL does not contain 'news'");
			test.log(Status.PASS, "Navigation to Media page successful " + mediaUrl);
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Media page failed: " + e.getMessage());
			softAssert.fail("Navigation to Media page failed: " + e.getMessage());
		}
		driver.navigate().back();
		Showmore();
		WebElement media = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Media']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", media);
		Thread.sleep(1000);

		softAssert.assertAll();
	}

	// ----------------------UG
	// Programs-----------------------------------------------------------

	@Test(priority = 27)
	public void ugProgramSection() {
		test = reports.createTest("UG Program");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Step 1: Navigate to 'Bachelor of Computer Applications'
		try {
			Showmore();
			WebElement bcaLink = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Computer Applications']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bcaLink);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", bcaLink);

			wait.until(ExpectedConditions.urlContains("bachelor-of-computer-applications-online"));
			String currentUrl = driver.getCurrentUrl();
			System.out.println("Navigated URL: " + currentUrl);
			softAssert.assertEquals(currentUrl, "https://amityonline.com/bachelor-of-computer-applications-online",
					"URL mismatch after clicking BCA.");
			test.log(Status.PASS, "Navigated to BCA page: " + currentUrl);
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to BCA page failed: " + e.getMessage());
			softAssert.fail("Navigation to BCA page failed: " + e.getMessage());
		}

		driver.navigate().back();

		// Step 2: Navigate to 'BCA with specialization in Cloud & Security'
		try {
			Showmore();

			WebElement bcaWithCloudSecurity = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//a[normalize-space()='BCA with specialization in Cloud & Security']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bcaWithCloudSecurity);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", bcaWithCloudSecurity);
			wait.until(ExpectedConditions.urlContains("bca-cloud-security-online"));
			String bcaWithCloudSecurityUrl = driver.getCurrentUrl();
			System.out.println("Current URL after navigating to BCA with specialization in Cloud & Security: "
					+ bcaWithCloudSecurityUrl);
			softAssert.assertEquals(bcaWithCloudSecurityUrl, "https://amityonline.com/bca-cloud-security-online",
					"URL does not contain 'bca-cloud-security-online'");
			test.log(Status.PASS,
					"Navigated to BCA with specialization in Cloud & Security page: " + bcaWithCloudSecurityUrl);
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to BCA with Cloud & Security failed: " + e.getMessage());
			softAssert.fail("Navigation to BCA with Cloud & Security failed: " + e.getMessage());
		}
		driver.navigate().back();

		try {
			Showmore();
			// Click 'BCA with specialization in Data Analytics'
			WebElement bcaWithDataAnalytics = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//a[normalize-space()='BCA with specialization in Data Analytics']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bcaWithDataAnalytics);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", bcaWithDataAnalytics);
			wait.until(ExpectedConditions.urlContains("bca-data-analytics-online"));
			String bcaWithDataAnalyticsUrl = driver.getCurrentUrl();
			System.out.println("Current URL after navigating to BCA with specialization in Data Analytics: "
					+ bcaWithDataAnalyticsUrl);
			softAssert.assertEquals(bcaWithDataAnalyticsUrl, "https://amityonline.com/bca-data-analytics-online",
					"URL does not contain 'bca-data-analytics-online'");
			test.log(Status.PASS,
					"Navigated to BCA with specialization in Data Analytics page: " + bcaWithDataAnalyticsUrl);

			driver.navigate().back();
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to BCA with Data Analytics failed: " + e.getMessage());
			softAssert.fail("Navigation to BCA with Data Analytics failed: " + e.getMessage());
		}

		try {
			Showmore();

			// Click 'Bachelor of Business Administration'
			WebElement bba = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Business Administration']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bba);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", bba);
			wait.until(ExpectedConditions.urlContains("bachelor-of-business-administration-online"));
			String bbaUrl = driver.getCurrentUrl();
			System.out.println("Current URL after navigating to Bachelor of Business Administration: " + bbaUrl);
			softAssert.assertEquals(bbaUrl, "https://amityonline.com/bachelor-of-business-administration-online",
					"URL does not contain 'bachelor-of-business-administration-online'");
			test.log(Status.PASS, "Navigated to Bachelor of Business Administration: " + bbaUrl);

			// driver.navigate().back();

		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Bachelor of Business Administration failed: " + e.getMessage());
			softAssert.fail("Navigation to Bachelor of Business Administration failed: " + e.getMessage());
		}

		try {
			Showmore();

			// Click 'Bachelor of Arts (Journalism and Mass communication)'
			WebElement baJMC = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//a[contains(text(),'Bachelor of Arts (Journalism and Mass communicatio')]")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baJMC);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", baJMC);
			wait.until(ExpectedConditions.urlContains("bachelor-of-arts-journalism-and-mass-communication-online"));
			String baJMCUrl = driver.getCurrentUrl();
			System.out.println("Current URL after navigating to Bachelor of Arts: " + baJMCUrl);
			softAssert.assertEquals(baJMCUrl,
					"https://amityonline.com/bachelor-of-arts-journalism-and-mass-communication-online",
					"URL does not contain 'bachelor-of-arts-journalism-and-mass-communication-online'");
			test.log(Status.PASS, "Navigated to Bachelor of Arts: " + baJMCUrl);

			driver.navigate().back();

		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Bachelor of Arts (JMC) failed: " + e.getMessage());
			softAssert.fail("Navigation to Bachelor of Arts (JMC) failed: " + e.getMessage());
		}

		try {
			Showmore();

			// Click 'Bachelor of Commerce'
			WebElement boc = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Commerce']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", boc);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", boc);
			wait.until(ExpectedConditions.urlContains("bachelor-of-commerce-online"));
			String bocUrl = driver.getCurrentUrl();
			System.out.println("Current URL after navigating to Bachelor of Commerce: " + bocUrl);
			softAssert.assertEquals(bocUrl, "https://amityonline.com/bachelor-of-commerce-online",
					"URL does not contain 'bachelor-of-commerce-online'");
			test.log(Status.PASS, "Navigated to Bachelor of Commerce: " + bocUrl);

			driver.navigate().back();

		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Bachelor of Commerce failed: " + e.getMessage());
			softAssert.fail("Navigation to Bachelor of Commerce failed: " + e.getMessage());
		}

		try {
			Showmore();

			// Click 'Bachelor of Arts'
			WebElement ba = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ba);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ba);
			wait.until(ExpectedConditions.urlContains("bachelor-of-arts-online"));
			String baUrl = driver.getCurrentUrl();
			System.out.println("Current URL after navigating to Bachelor of Arts: " + baUrl);
			softAssert.assertEquals(baUrl, "https://amityonline.com/bachelor-of-arts-online",
					"URL does not contain 'bachelor-of-arts-online'");
			test.log(Status.PASS, "Navigated to Bachelor of Arts: " + baUrl);

			driver.navigate().back();

		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Bachelor of Arts failed: " + e.getMessage());
			softAssert.fail("Navigation to Bachelor of Arts failed: " + e.getMessage());
		}

		try {
			Showmore();
			// Click 'Bachelor of Art (Kannada Medium)'
			WebElement baKM = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Art (Kannada Medium)']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baKM);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", baKM);
			wait.until(ExpectedConditions.urlContains("bachelor-of-arts-kannada-online"));
			String baKMUrl = driver.getCurrentUrl();
			System.out.println("Current URL after navigating to Bachelor of Art (Kannada Medium): " + baKMUrl);
			softAssert.assertEquals(baKMUrl, "https://amityonline.com/bachelor-of-arts-kannada-online",
					"URL does not contain 'bachelor-of-arts-kannada-online");
			test.log(Status.PASS, "Navigated to Bachelor of Art (Kannada Medium): " + baKMUrl);

			driver.navigate().back();

		} catch (Exception e) {
			test.log(Status.FAIL, "URL does not contain 'bachelor-of-arts-kannada-online" + e.getMessage());
			softAssert.fail("URL does not contain 'bachelor-of-arts-kannada-online" + e.getMessage());
		}

		try {
			Showmore();
			// Click 'Bachelor of Arts (Malayalam Medium)'
			WebElement baMM = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts (Malayalam Medium)']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baMM);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", baMM);
			wait.until(ExpectedConditions.urlContains("bachelor-of-arts-malayalam-online"));
			String baMMUrl = driver.getCurrentUrl();
			System.out.println("Current URL after navigating to Bachelor of Arts (Malayalam Medium): " + baMMUrl);
			softAssert.assertEquals(baMMUrl, "https://amityonline.com/bachelor-of-arts-malayalam-online",
					"URL does not contain 'bachelor-of-arts-malayalam-online");
			test.log(Status.PASS, "Navigated to Bachelor of Arts (Malayalam Medium): " + baMMUrl);

			driver.navigate().back();

		} catch (Exception e) {
			test.log(Status.FAIL, "URL does not contain 'bachelor-of-arts-malayalam-online" + e.getMessage());
			softAssert.fail("URL does not contain 'bachelor-of-arts-malayalam-online" + e.getMessage());
		}

		try {
			Showmore();
			// Click 'Bachelor of Arts (Tamil Medium)'
			WebElement baTM = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts (Tamil Medium)']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baTM);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", baTM);
			wait.until(ExpectedConditions.urlContains("bachelor-of-arts-tamil-online"));
			String baTMUrl = driver.getCurrentUrl();
			System.out.println("Current URL after navigating to Bachelor of Arts (Tamil Medium): " + baTMUrl);
			softAssert.assertEquals(baTMUrl, "https://amityonline.com/bachelor-of-arts-tamil-online",
					"URL does not contain 'bachelor-of-arts-tamil-online");
			test.log(Status.PASS, "Navigated to Bachelor of Arts (Tamil Medium): " + baTMUrl);

			driver.navigate().back();

		} catch (Exception e) {
			test.log(Status.FAIL, "URL does not contain 'bachelor-of-arts-tamil-online" + e.getMessage());
			softAssert.fail("URL does not contain 'bachelor-of-arts-tamil-online" + e.getMessage());
		}

		try {
			Showmore();
			// Click 'Bachelor of Arts (Telugu Medium)'
			WebElement baTeluguMedium = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts (Telugu Medium)']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baTeluguMedium);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", baTeluguMedium);
			wait.until(ExpectedConditions.urlContains("bachelor-of-arts-telugu-online"));
			String baTeluguMediumUrl = driver.getCurrentUrl();
			System.out
					.println("Current URL after navigating to Bachelor of Arts (Telugu Medium): " + baTeluguMediumUrl);
			softAssert.assertEquals(baTeluguMediumUrl, "https://amityonline.com/bachelor-of-arts-telugu-online",
					"URL does not contain 'bachelor-of-arts-telugu-online");
			test.log(Status.PASS, "Navigated to Bachelor of Arts (Telugu Medium): " + baTeluguMediumUrl);

			driver.navigate().back();

		} catch (Exception e) {
			test.log(Status.FAIL, "URL does not contain 'bachelor-of-arts-telugu-online" + e.getMessage());
			softAssert.fail("URL does not contain 'bachelor-of-arts-telugu-online" + e.getMessage());
		}

		try {
			Showmore();

			// Click 'Bachelor of Arts (Hindi Medium)'
			WebElement baHindiMedium = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor of Arts (Hindi Medium)']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", baHindiMedium);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", baHindiMedium);
			wait.until(ExpectedConditions.urlContains("bachelor-of-arts-hindi-medium-online"));
			String baHindiMediumUrl = driver.getCurrentUrl();
			System.out.println("Current URL after navigating to Bachelor of Arts (Hindi Medium): " + baHindiMediumUrl);
			softAssert.assertEquals(baHindiMediumUrl, "https://amityonline.com/bachelor-of-arts-hindi-medium-online",
					"URL does not contain 'bachelor-of-arts-hindi-medium-online");
			test.log(Status.PASS, "Navigated to Bachelor of Arts (Hindi Medium): " + baHindiMediumUrl);

			driver.navigate().back();

		} catch (Exception e) {
			test.log(Status.FAIL, "URL does not contain 'bachelor-of-arts-hindi-medium-online" + e.getMessage());
			softAssert.fail("URL does not contain 'bachelor-of-arts-hindi-medium-online" + e.getMessage());
		}

		try {
			Showmore();

			// Click 'B.Com with Specialization in International Finance & Accounting'
			WebElement bComHindiMedium = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//a[contains(text(),'B.Com with Specialization in International Finance')]")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bComHindiMedium);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", bComHindiMedium);
			wait.until(ExpectedConditions.urlContains("bcom-internationalfinance"));
			String bComHindiMediumUrl = driver.getCurrentUrl();
			System.out.println(
					"Current URL after navigating to B.Com with Specialization in International Finance & Accounting: "
							+ bComHindiMediumUrl);
			softAssert.assertEquals(bComHindiMediumUrl, "https://amityonline.com/bcom-internationalfinance",
					"URL does not contain 'bcom-internationalfinance'");
			test.log(Status.PASS, "Navigated to B.Com with Specialization in International Finance & Accounting: "
					+ bComHindiMediumUrl);

			driver.navigate().back();

		} catch (Exception e) {
			test.log(Status.FAIL, "URL does not contain 'bcom-internationalfinance'" + e.getMessage());
			softAssert.fail("URL does not contain 'bcom-internationalfinance'" + e.getMessage());
		}

		try {
			Showmore();

			// Click 'Bachelor Of Commerce (Honours)'
			WebElement bachelorOfCH = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='Bachelor Of Commerce (Honours)']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bachelorOfCH);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", bachelorOfCH);
			wait.until(ExpectedConditions.urlContains("bachelor-of-commerce-honours"));
			String bachelorOfCHUrl = driver.getCurrentUrl();
			System.out.println("Current URL after navigating to Bachelor Of Commerce (Honours): " + bachelorOfCHUrl);
			softAssert.assertEquals(bachelorOfCHUrl, "https://amityonline.com/bachelor-of-commerce-honours",
					"URL does not contain 'bachelor-of-commerce-honours'");
			test.log(Status.PASS, "Navigated to Bachelor Of Commerce (Honours): " + bachelorOfCHUrl);

			driver.navigate().back();

		} catch (Exception e) {
			test.log(Status.FAIL, "URL does not contain 'bachelor-of-commerce-honours'\"" + e.getMessage());
			softAssert.fail("URL does not contain 'bachelor-of-commerce-honours'\"" + e.getMessage());
		}

		try {
			Showmore();

			// Click 'UG + PG Degree Program'
			WebElement ugPgDegree = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='UG + PG Degree Program']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ugPgDegree);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ugPgDegree);
			wait.until(ExpectedConditions.urlContains("ug-pg-degree-set"));
			String ugPgDegreeUrl = driver.getCurrentUrl();
			System.out.println("Current URL after navigating to UG + PG Degree Program: " + ugPgDegreeUrl);
			softAssert.assertEquals(ugPgDegreeUrl, "https://amityonline.com/ug-pg-degree-set",
					"URL does not contain 'ug-pg-degree-set'");
			test.log(Status.PASS, "Navigated to UG + PG Degree Program: " + ugPgDegreeUrl);

			driver.navigate().back();

		} catch (Exception e) {
			test.log(Status.FAIL, "URL does not contain 'ug-pg-degree-set'" + e.getMessage());
			softAssert.fail("URL does not contain 'ug-pg-degree-set'" + e.getMessage());
		}

		try {
			Showmore();

			// Wait until the UG Program heading is visible
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[2]")));

			// Collect all course links under UG Program
			List<WebElement> courseElements = driver
					.findElements(By.xpath("//footer[@class='container mb-8 footer_root__az0w0']//ul[2]//li"));

			for (int i = 0; i < courseElements.size(); i++) {
				String courseName = courseElements.get(i).getText();
				System.out.println("  ▶ Course " + (i + 1) + ": " + courseName);
			}

			// Verify the count matches expectation
			int expectedCount = 15;
			int actualCount = courseElements.size() - 1;

			softAssert.assertEquals(actualCount, expectedCount,
					"❌ Mismatch in course count. Expected: " + expectedCount + ", Found: " + actualCount);
			test.log(Status.PASS, "UG programs count matched");
			// System.out.println("✅ Course count validation passed.");
			System.out.println("✅ UG Program course count verified successfully: " + actualCount);

		} catch (Exception e) {
			test.log(Status.FAIL, "UG programs count mismatch" + e.getMessage());

			softAssert.fail("UG programs count mismatch" + e.getMessage()); // Preserve original error
		}
		softAssert.assertAll();
	}

	// ----------------------PG
	// Programs-----------------------------------------------------------

	@Test(priority = 28)
	public void pgProgramSection() {
		test = reports.createTest("Click 'PG Program'");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			Showmore();
			WebElement mca = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//a[normalize-space()='Master of Computer Applications']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mca);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", mca);
			wait.until(ExpectedConditions.urlContains("master-of-computer-applications-online"));
			String url = driver.getCurrentUrl();
			System.out.println("Navigated to: " + url);
			softAssert.assertEquals(url, "https://amityonline.com/master-of-computer-applications-online");
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
			softAssert.assertEquals(url, "https://amityonline.com/mca-blockchain-online");
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
			softAssert.assertEquals(url,
					"https://amityonline.com/mca-machine-learning-and-artificial-intelligence-online");
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
			softAssert.assertEquals(url, "https://amityonline.com/mca-machine-learning-online");
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
			softAssert.assertEquals(url, "https://amityonline.com/mca-virtualreality-online");
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
			softAssert.assertEquals(url, "https://amityonline.com/master-of-business-administration-online");
			test.log(Status.PASS, "Navigated to MBA: " + url);
			driver.navigate().back();
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
			softAssert.assertEquals(url, "https://amityonline.com/mba-digital-marketing-management-online");
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
			softAssert.assertEquals(url, "https://amityonline.com/mba-human-resources-hr-analytics-online");
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
			softAssert.assertEquals(url, "https://amityonline.com/mba-data-science-online");
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
			softAssert.assertEquals(url, "https://amityonline.com/mba-business-analytics-online");
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
			softAssert.assertEquals(url, "https://amityonline.com/mba-digital-entrepreneurship-online");
			test.log(Status.PASS, "Navigated to Digital Entrepreneurship: " + url);
			driver.navigate().back();
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation to Digital Entrepreneurship failed: " + e.getMessage());
			softAssert.fail("Navigation to Digital Entrepreneurship failed: " + e.getMessage());
		}

		// ************** SHOW MORE BUTTON - 12 **************
		try {
			Showmore();

			WebElement MA_Jour_Mass_Comm = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//a[normalize-space()='Master of Arts (Journalism and Mass communication)']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MA_Jour_Mass_Comm);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", MA_Jour_Mass_Comm);
			wait.until(ExpectedConditions.urlContains("master-of-arts-journalism-and-mass-communication-online"));
			String url = driver.getCurrentUrl();
			softAssert.assertEquals(url,
					"https://amityonline.com/master-of-arts-journalism-and-mass-communication-online",
					"URL mismatch after clicking MA Journalism and Mass Communication.");
			test.log(Status.PASS, "Navigated to MA Journalism and Mass Communication page: " + url);
		} catch (Exception e) {
			test.log(Status.FAIL, "MA Journalism and Mass Communication section failed: " + e.getMessage());
			softAssert.fail("Interaction failed for MA Journalism and Mass Communication.");
		}
		driver.navigate().back();

		// ************** SHOW MORE BUTTON - 13 **************
		try {
			Showmore();

			WebElement M_Com_Fintech = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='M.Com with specialization in Fintech']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", M_Com_Fintech);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", M_Com_Fintech);
			wait.until(ExpectedConditions.urlContains("mcom-fintech-online"));
			String url = driver.getCurrentUrl();
			softAssert.assertEquals(url, "https://amityonline.com/mcom-fintech-online",
					"URL mismatch after clicking M.Com Fintech.");
			test.log(Status.PASS, "Navigated to M.Com Fintech page: " + url);
		} catch (Exception e) {
			test.log(Status.FAIL, "M.Com Fintech section failed: " + e.getMessage());
			softAssert.fail("Interaction failed for M.Com Fintech.");
		}
		driver.navigate().back();

		// ************** SHOW MORE BUTTON - 14 **************
		try {
			Showmore();

			WebElement M_Com_FM = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//a[normalize-space()='M.Com with specialization in Financial Management']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", M_Com_FM);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", M_Com_FM);
			wait.until(ExpectedConditions.urlContains("master-of-commerce-financial-management-online"));
			String url = driver.getCurrentUrl();
			softAssert.assertEquals(url, "https://amityonline.com/master-of-commerce-financial-management-online",
					"URL mismatch after clicking M.Com Financial Management.");
			test.log(Status.PASS, "Navigated to M.Com Financial Management page: " + url);
		} catch (Exception e) {
			test.log(Status.FAIL, "M.Com Financial Management section failed: " + e.getMessage());
			softAssert.fail("Interaction failed for M.Com Financial Management.");
		}
		driver.navigate().back();

		// ************** SHOW MORE BUTTON - 15 **************
		try {
			Showmore();

			WebElement MA_PPG = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//a[normalize-space()='Master of Arts in Public Policy & Governance']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MA_PPG);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", MA_PPG);
			wait.until(ExpectedConditions.urlContains("ma-public-policy"));
			String url = driver.getCurrentUrl();
			softAssert.assertEquals(url, "https://amityonline.com/ma-public-policy",
					"URL mismatch after clicking MA Public Policy & Governance.");
			test.log(Status.PASS, "Navigated to MA Public Policy & Governance page: " + url);
		} catch (Exception e) {
			test.log(Status.FAIL, "MA Public Policy & Governance section failed: " + e.getMessage());
			softAssert.fail("Interaction failed for MA Public Policy & Governance.");
		}
		driver.navigate().back();

		// ************** SHOW MORE BUTTON - 16 **************
		try {
			Showmore();

			WebElement MA_Psych = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='Master of Arts in Psychology']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MA_Psych);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", MA_Psych);
			wait.until(ExpectedConditions.urlContains("ma-in-psychology"));
			String url = driver.getCurrentUrl();
			softAssert.assertEquals(url, "https://amityonline.com/ma-in-psychology",
					"URL mismatch after clicking MA Psychology.");
			test.log(Status.PASS, "Navigated to MA Psychology page: " + url);
		} catch (Exception e) {
			test.log(Status.FAIL, "MA Psychology section failed: " + e.getMessage());
			softAssert.fail("Interaction failed for MA Psychology.");
		}
		driver.navigate().back();

		// ************** SHOW MORE BUTTON - 17 **************
		try {
			Showmore();

			WebElement MSc_DS = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='Master of Science in Data Science']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MSc_DS);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", MSc_DS);
			wait.until(ExpectedConditions.urlContains("msc-in-data-science"));
			String url = driver.getCurrentUrl();
			softAssert.assertEquals(url, "https://amityonline.com/msc-in-data-science",
					"URL mismatch after clicking MSc Data Science.");
			test.log(Status.PASS, "Navigated to MSc Data Science page: " + url);
		} catch (Exception e) {
			test.log(Status.FAIL, "MSc Data Science section failed: " + e.getMessage());
			softAssert.fail("Interaction failed for MSc Data Science.");
		}
		driver.navigate().back();

		// ************** SHOW MORE BUTTON - 18 **************
		try {
			Showmore();

			WebElement MBA_Dual = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[normalize-space()='MBA With Dual Specialization']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MBA_Dual);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", MBA_Dual);
			wait.until(ExpectedConditions.urlContains("mba-dual-specialization"));
			String url = driver.getCurrentUrl();
			softAssert.assertEquals(url, "https://amityonline.com/mba-dual-specialization",
					"URL mismatch after clicking MBA Dual Specialization.");
			test.log(Status.PASS, "Navigated to MBA Dual Specialization page: " + url);
		} catch (Exception e) {
			test.log(Status.FAIL, "MBA Dual Specialization section failed: " + e.getMessage());
			softAssert.fail("Interaction failed for MBA Dual Specialization.");
		}
		driver.navigate().back();

		// ************** SHOW MORE BUTTON - 19 **************
		try {
			Showmore();

			WebElement MBA_GM = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//a[contains(text(),'Master of Business Administration in General Manag')]")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MBA_GM);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", MBA_GM);
			wait.until(ExpectedConditions.urlContains("mba-general-management"));
			String url = driver.getCurrentUrl();
			softAssert.assertEquals(url, "https://amityonline.com/mba-general-management",
					"URL mismatch after clicking MBA General Management.");
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
			List<WebElement> courseElements = driver
					.findElements(By.xpath("//footer[@class='container mb-8 footer_root__az0w0']//ul[3]//li"));
			int actualCount = courseElements.size() - 1; // Adjusting if last element is non-course (e.g. 'View All')
			int expectedCount = 19;

			// Logging course names
			for (int i = 0; i < courseElements.size(); i++) {
				String courseName = courseElements.get(i).getText();
				System.out.println("  ▶ Course " + (i + 1) + ": " + courseName);
			}

			// Validate course count
			softAssert.assertEquals(actualCount, expectedCount,
					"❌ Course count mismatch. Expected: " + expectedCount + ", Found: " + actualCount);
			test.log(Status.PASS, "✅ PG Program course count matched expected value: " + actualCount);
		} catch (Exception e) {
			test.log(Status.FAIL, "PG Program section failed: " + e.getMessage());

			softAssert.fail("Interaction failed for PG Program course list.");
		}
		softAssert.assertAll();
	}

	// Right side sticky buttons
	@Test(priority = 29)
	public void sticky_buttons() {
		test = reports.createTest("BCA Page sticky button");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Phone sticky icon start here
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Sticky_Buttons_Call_whats.call_icon_Element));
			js.executeScript("arguments[0].click();", Sticky_Buttons_Call_whats.call_icon_Element);
			Thread.sleep(2000);
			WebElement close_icon = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[name()='path' and contains(@d,'M18.2648 2')]")));
			close_icon.click();

			test.log(Status.PASS, "Call stickey button successfully clicked and closed");
			softAssert.assertTrue(true, "Call stickey button successfully clicked and closed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Call stickey button is not visible or working" + e.getMessage());
			softAssert.fail("Call stickey button is not visible or working" + e.getMessage());
		}
		// Whatsapp sticky icon start here
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(Sticky_Buttons_Call_whats.whatsapp_icon_Element));
			softAssert.assertTrue(Sticky_Buttons_Call_whats.whatsapp_icon_Element.isDisplayed());
			softAssert.assertTrue(Sticky_Buttons_Call_whats.whatsapp_icon_Element.isEnabled());
			test.log(Status.PASS, "Whatsapp icon is displayed & is enabled");
			softAssert.assertTrue(true, "Whatsapp icon is displayed & is enabled");
		} catch (Exception e) {
			test.log(Status.FAIL, "WhatsApp icon is not visible or working" + e.getMessage());
			softAssert.fail("WhatsApp icon is not visible or working" + e.getMessage());
		}
		// Apply now sticky button start here
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(Sticky_Buttons_Call_whats.scrollElement));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					Sticky_Buttons_Call_whats.scrollElement);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(Sticky_Buttons_Call_whats.apply_now_button));
			js.executeScript("arguments[0].click();", Sticky_Buttons_Call_whats.apply_now_button);
			Thread.sleep(2000);
			WebElement close_icon_pop = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[name()='path' and contains(@d,'M18.2648 2')]")));
			close_icon_pop.click();
			test.log(Status.PASS, "Apply now sticky button successfully clicked and closed");
			softAssert.assertTrue(true, "Apply now sticky button successfully clicked and closed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Apply now sticky button not visible or working" + e.getMessage());
			softAssert.fail("Apply now sticky button not visible or working" + e.getMessage());
		}
		// Chat sticky icon
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(Sticky_Buttons_Call_whats.chat_icon_Element));
			softAssert.assertTrue(Sticky_Buttons_Call_whats.chat_icon_Element.isDisplayed());
			softAssert.assertTrue(Sticky_Buttons_Call_whats.chat_icon_Element.isEnabled());
			test.log(Status.PASS, "Chat sticky icon is display & is enabled");
			softAssert.assertTrue(true);
		} catch (Exception e) {
			test.log(Status.FAIL, "Chat sticky button failed" + e.getMessage());
			softAssert.fail("Chat sticky button failed" + e.getMessage());
		}
		softAssert.assertAll();
	}

	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException {
		String testname = result.getName();
		String myscreenshot = HeaderScreenShot.takeScreenshot(driver, testname);
		if (result.getStatus() == ITestResult.FAILURE) {
			test.addScreenCaptureFromPath(myscreenshot);
			test.log(Status.FAIL, "Test failed: " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.addScreenCaptureFromPath(myscreenshot);
			test.log(Status.PASS, "Test passed");

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.addScreenCaptureFromPath(myscreenshot);
			test.log(Status.SKIP, "Test Skip");

		}
		driver.quit();
	}
}
