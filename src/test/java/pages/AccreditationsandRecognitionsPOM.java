package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccreditationsandRecognitionsPOM {

	WebDriver driver;

	public AccreditationsandRecognitionsPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h2[normalize-space()='Accreditations & Recognitions']")
	public WebElement accreditationselElement;
	
	@FindBy(xpath = "//div[@class='swiper-slide swiper-slide-active']//div[@class='AccreditionsRecognitions_item__hi0ak']")
	public WebElement qSelElement;
	
	@FindBy(xpath = "//div[@class='swiper-slide swiper-slide-next']//div[@class='AccreditionsRecognitions_item__hi0ak']")
	public WebElement firstUniversityElement;
	
	@FindBy(xpath = "//section[@class='AccreditionsRecognitions_root__13ho8']//div[@class='pt-7 lg:pt-7']//div[3]//div[1]")
	public WebElement firstIndianElement;
	
	@FindBy(xpath = "//section[@class='AccreditionsRecognitions_root__13ho8']//div[6]//div[1]")
	public WebElement degreeprogramselElement;
	
	@FindBy(xpath = "//section[@class='AccreditionsRecognitions_root__13ho8']//div[7]//div[1]")
	public WebElement digitaleducationcouncilElement;
	
	@FindBy(xpath = "//section[@class='AccreditionsRecognitions_root__13ho8']//div[8]//div[1]")
	public WebElement rankedamoungElement;
	
	
	@FindBy(xpath = "//section[@class='AccreditionsRecognitions_root__13ho8']//div[4]//div[1]")
	public WebElement wesElement;
	
	@FindBy(xpath = "//section[@class='AccreditionsRecognitions_root__13ho8']//div[9]//div[1]")
	public WebElement wascElement;
	
	@FindBy(xpath = "//section[@class='AccreditionsRecognitions_root__13ho8']//div[5]//div[1]")
	public WebElement nirfElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[5]/div[1]/div[1]/div[3]/div[1]/div[2]/span[1]")
	public WebElement bullet1;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[5]/div[1]/div[1]/div[3]/div[1]/div[2]/span[2]")
	public WebElement bullet2;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[5]/div[1]/div[1]/div[3]/div[1]/div[2]/span[3]")
	public WebElement bullet3;
	
	@FindBy(xpath = "//div[@class='swiper-wrapper AccreditionsRecognitions_CarousalWrapper__py20P']")
	WebElement accreditationscountElement;
	
	
	


}
