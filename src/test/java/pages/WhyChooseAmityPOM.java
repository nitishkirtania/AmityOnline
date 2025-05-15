package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WhyChooseAmityPOM {
	WebDriver driver;
	
	public WhyChooseAmityPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath = "//h2[normalize-space()='Why Choose Amity Online?']")
	public WebElement whychooseamityElement;
	
	@FindBy(xpath = "//div[@class='swiper-slide swiper-slide-active']//div[@class='font-raleway WhyAmity_item__KHKMn WhyAmity_centerdItem__5vkFc']")
	public WebElement IndustryVisits;
	
	@FindBy(xpath = "//div[@class='swiper-slide swiper-slide-next']//div[@class='font-raleway WhyAmity_item__KHKMn WhyAmity_centerdItem__5vkFc']")
	public WebElement decidatedacademicElement;
	
	@FindBy(xpath = "//section[@class='WhyAmity_root__q_pyH']//div[@class='pt-5 lg:pt-7']//div[3]//div[1]")
	public WebElement aIProfessorAMIelElement;
	
	@FindBy(xpath = "//section[@class='WhyAmity_root__q_pyH']//div[4]//div[1]")
	public WebElement placementOpportunitieselElement;
	
	@FindBy(xpath = "//section[@class='WhyAmity_root__q_pyH']//div[5]//div[1]")
	public WebElement diverseLearningMediumselElement;
	
	@FindBy(xpath = "//section[@class='WhyAmity_root__q_pyH']//div[6]//div[1]")
	public WebElement offlineExperienceselElement;
	
	@FindBy(xpath = "//section[@class='WhyAmity_root__q_pyH']//div[7]//div[1]")
	public WebElement beSocialStudentCommunityPlatformelElement;
	
	@FindBy(xpath = "//section[@class='WhyAmity_root__q_pyH']//div[8]//div[1]")
	public WebElement careerServiceselElement;
	
	@FindBy(xpath = "//section[@class='WhyAmity_root__q_pyH']//div[9]//div[1]")
	public WebElement doorstepDeliveryOfBookselElement;
	
	@FindBy(xpath = "//section[@class='WhyAmity_root__q_pyH']//div[10]//div[1]")
	public WebElement metaverseCampuselElement;
	
	@FindBy(xpath = "//button[@class='undefined WhyAmity_btnYellow__Kh9Rq']")
	public WebElement fasttrackyourcareerElement;
	
	@FindBy(xpath = "//h2[@class='ConnectModal_Modal__RightContainerTitle__WO56D pr-[2.3rem]']")
	public WebElement connectcounsellorElement;
	
	
	
	
	
	
}
