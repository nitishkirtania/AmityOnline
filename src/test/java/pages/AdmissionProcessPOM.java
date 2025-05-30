package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdmissionProcessPOM {
	WebDriver driver;
	
	public AdmissionProcessPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='Admission Process']")
	public WebElement admissionprocessElement;

	@FindBy(xpath = "//div[@class='flex-col lg:flex-row flex lg:items-start lg:justify-between']//div[1]")
	public WebElement selectyourprogramElement;
	
	@FindBy(xpath = "//section[@id='AdmissionProcess']//div[@class='pt-7 lg:pt-7']//div[2]")
	public WebElement completeyourapplicationElement;
	
	@FindBy(xpath = "//section[@id='AdmissionProcess']//div[3]")
	public WebElement payyourprogramfeeElement;
	
	@FindBy(xpath = "//section[@id='AdmissionProcess']//div[4]")
	public WebElement submitandregisterElement;
	
	@FindBy(xpath = "//section[@id='AdmissionProcess']//div[5]")
	public WebElement awaitenrollmentElement;
	
	
	
	
	
	
	
}
