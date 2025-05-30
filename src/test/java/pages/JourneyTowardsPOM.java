package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JourneyTowardsPOM {
	
	WebDriver driver;
	
	public JourneyTowardsPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//h2[normalize-space()='Journey Towards: Online Degree Program']")
	public WebElement journeytowardsElement;

	@FindBy(xpath = "//h2[contains(text(),'Journey Towards Graduation: Your Online Degree Pro')]")
	public WebElement journeytowardsGraduationElement;
	
	@FindBy(xpath = "//h3[normalize-space()='Online Orientation']")
	public WebElement onlineorientationElement;
	
	@FindBy(css = "svg[xmlns='http://www.w3.org/2000/svg'][viewBox='0 0 16 16'][fill='blue']")
	public WebElement arrow1;
	
	@FindBy(xpath = "//section[@id='JourneryForGraduation']//div[2]//div[1]//div[1]//span[1]//*[name()='svg']")
	public WebElement arrow2;
	
	@FindBy(xpath = "//section[@id='JourneryForGraduation']//div[3]//div[1]//div[1]//span[1]//*[name()='svg']")
	public WebElement arrow3;
	
	@FindBy(xpath = "//div[contains(@class,'lg:py-6 lg:py-6 lg:mt-0 xl:mt-0 lg:mb-0 xl:mb-0')]//span//*[name()='svg']")
	public WebElement arrow4;
	
	@FindBy(xpath = "//img[contains(@title,'Journey')]")
	public WebElement journeyforeducationElement;
	
	
	

}
