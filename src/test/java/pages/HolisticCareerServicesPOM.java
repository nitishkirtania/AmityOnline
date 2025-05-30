package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HolisticCareerServicesPOM {
	
	WebDriver driver;
	
	public HolisticCareerServicesPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[contains(text(),'Holistic Career Services: How we help you build yo')]")
	public WebElement holisticcareertextElement;
	
	@FindBy(xpath = "//p[contains(@class,'SectionCard_subtitle__PNeGb hidden lg:block')]")
	public WebElement ourwiderangElement;
	
	@FindBy(xpath = "//div[@class='swiper-slide swiper-slide-active']//img[@title='Amity Online']")
	public WebElement careerexplorationtoolElement;
	
	@FindBy(xpath = "//div[@class='swiper-slide swiper-slide-next']//img[@title='Amity Online']")
	public WebElement resumElement;
	
	@FindBy(xpath = "//div[@class='swiper-wrapper styles_CarousalWrapper__hIXvk']//div[1]//div[1]//img[1]")
	public WebElement virtualjobElement;
	
	@FindBy(xpath = "//div[@id='CareerImpact']//div[4]//div[1]//img[1]")
	public WebElement careercouncellingElement;
	
	
	
}
