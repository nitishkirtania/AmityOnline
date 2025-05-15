package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnnouncementSection {
	
WebDriver driver;
	
	public AnnouncementSection(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[@class='PageCard_announcementCard__H9UQW PageCard_isScholarshipCard__tsrNn cursor-pointer']//div[@class='PageCard_announcementItem__dXeyt']")
	public WebElement scholarshipWebElement;
	
	@FindBy(xpath = "//body/main[@class='relative']/section[@class='container mt-5 lg:mt-0']/div[@class='AnnoucementSection_root__5KTH0']/div[2]/div[1]/div[1]")
	public WebElement zerocostemiElement;
	
	@FindBy(xpath = "//body/main[@class='relative']/section[@class='container mt-5 lg:mt-0']/div[@class='AnnoucementSection_root__5KTH0']/div[3]/div[1]/div[1]")
	public WebElement learnersElement;
	
	@FindBy(xpath = "//body/main[@class='relative']/section[@class='container mt-5 lg:mt-0']/div[@class='AnnoucementSection_root__5KTH0']/div[4]/div[1]/div[1]")
	public WebElement admissionopenElement;
	
	public void scholarshipAccouncement() {
		scholarshipWebElement.click();
	}
	

}
