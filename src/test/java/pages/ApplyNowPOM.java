package pages;

import org.openqa.selenium.WebDriver;
import Random.RandomDetails;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Random.RandomDetails;

public class ApplyNowPOM {

	WebDriver driver;
	RandomDetails random;

	// Constructor to initialize WebDriver and PageFactory elements
	public ApplyNowPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory elements
	}

	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/button[1]")
	public WebElement ApplynowBTN;

	@FindBy(xpath = "//button[@class='NationalInternational_national__FBIVx']")
	public WebElement indianBTN;

	@FindBy(xpath = "//button[@class='NationalInternational_interNational__RKrPp NationalInternational_notSelectedButton__lh0q7']")
	public WebElement internationalElement;

	@FindBy(xpath = "//div[@class='basis-1/2']//input[@placeholder='Enter your full name']")

	public WebElement nameElement;

	@FindBy(xpath = "//select[@class='appearance-none lining-nums false text-stone-500 bg-white text-lg leading-loose tracking-tight outline-none pr-10 false Input_selectDropdown__rRnfH']")
	public WebElement countrycodeElement;

	@FindBy(xpath = "//div[@class='w-full']//input[@placeholder='Enter your no.']")
	public WebElement mobiElement;

	@FindBy(xpath = "//div[@class='basis-1/2']//input[@placeholder='abc@xyz.com']")
	public WebElement emailElement;

	@FindBy(xpath = "//form[@class='ConnectModalForm_root__zYe2H pr-[2rem]']//button[@type='submit'][normalize-space()='Submit']")
	public WebElement submitElement;

	@FindBy(xpath ="//div[@class='basis-1/2']//select[@class='appearance-none lining-nums w-full text-stone-500 bg-white text-lg leading-loose tracking-tight outline-none pr-10 false Input_selectDropdown__rRnfH']")
	public WebElement degreeElement;


	@FindBy(xpath = "//div[@class='ConnectModalForm_commonMargins__efaYq w-full']//select[@class='appearance-none lining-nums w-full text-stone-500 bg-white text-lg leading-loose tracking-tight outline-none pr-10 false Input_selectDropdown__rRnfH']")
	public WebElement prograElement;

	@FindBy(xpath = "//form[@class='ConnectModalForm_root__zYe2H pr-[2rem]']//button[@type='submit'][normalize-space()='Submit']")
	public WebElement submit2elElement;

	@FindBy(xpath = "//input[@id='otp_0']")
	public WebElement OTPCell1;

	@FindBy(xpath = "//input[@id='otp_1']")
	public WebElement OTPCell2;

	@FindBy(xpath = "//input[@id='otp_2']")
	public WebElement OTPCell3;

	@FindBy(xpath = "//input[@id='otp_3']")
	public WebElement OTPCell4;

	@FindBy(xpath = "//input[@id='otp_4']")
	public WebElement OTPCell5;

	@FindBy(xpath = "//input[@id='otp_5']")
	public WebElement OTPCell6;

	@FindBy(xpath = "//span[normalize-space()='VERIFY OTP']")
	public WebElement VerifyOTP;

	@FindBy(xpath = "//button[@id='startApplicationgta']")
	public WebElement startapplicationElement;



}
