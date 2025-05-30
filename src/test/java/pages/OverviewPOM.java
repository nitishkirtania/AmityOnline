package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPOM {

WebDriver driver;
	
	public OverviewPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[@class='flex flex-col w-full']")
	public WebElement buildingnationcontainer;

	@FindBy(xpath = "//img[@alt='overview-Bachelor of Business Administration']")
	public WebElement buildingnationBBAImage;
	
	@FindBy(xpath = "//div[@class='flex flex-col w-full']")
	public WebElement enhanceElement;

	@FindBy(xpath = "//h2[contains(text(),'Become an Industry Leader with UGC-entitled')]")
	public WebElement scrollbecomeAnIndustry;	
	
}
