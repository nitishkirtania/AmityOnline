package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KeySpecializationsPOM {
	
	WebDriver driver;
	
	public KeySpecializationsPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//h2[@class='ProgramSpecialization_ProgramSpecialization__ContainerTitle__u0Bop']")
	public WebElement keyspecializationElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/div[1]/img[1]")
	public WebElement mbawithdualspecializationelElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]/div[1]/img[1]")
	public WebElement mbaingeneralmanagementelElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1]/div[1]/img[1]")
	public WebElement internationalfinancelElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[2]/a[1]/div[1]/img[1]")
	public WebElement digitalentreprenuershipelElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[2]/a[1]/div[1]/img[1]")
	public WebElement businessanalyticselElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[1]/div[6]/div[1]/div[2]/a[1]/div[1]/img[1]")
	public WebElement datasciencelElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/div[2]/a[1]/div[1]/img[1]")
	public WebElement hranalyticselElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[1]/div[8]/div[1]/div[2]/a[1]/div[1]/img[1]")
	public WebElement digitalmarketingelElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[2]/div[1]")
	public WebElement bulletbutton1elElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[2]/div[2]")
	public WebElement bulletbutton2elElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[2]/div[3]")
	public WebElement bulletbutton3elElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[2]/div[4]")
	public WebElement bulletbutton4elElement;
	
	@FindBy(xpath = "/html[1]/body[1]/main[1]/section[4]/div[1]/div[2]/div[1]/div[2]/div[5]")
	public WebElement bulletbutton5elElement;
	
	
	public void mbadual() {
		bulletbutton1elElement.click();
		mbawithdualspecializationelElement.click();
	}
	
	public void mbageneral() {
	bulletbutton1elElement.click();
	mbaingeneralmanagementelElement.click();
		
	}
	
	public void internationalf() {
	bulletbutton1elElement.click();
	 internationalfinancelElement.click();
	}
	
	public void digitalentrepreneurshipmethods() {
		bulletbutton1elElement.click();
		digitalentreprenuershipelElement.click();
	}
	
	public void businessA() {
		bulletbutton2elElement.click();
		businessanalyticselElement.click();
	}
	
	public void datascience() {
		bulletbutton3elElement.click();
		datasciencelElement.click();
	}
	
	public void HRanalytics() {
		bulletbutton4elElement.click();
		hranalyticselElement.click();
	}
	
	public void digitalmarketing() {
		bulletbutton5elElement.click();
		digitalmarketingelElement.click();
	}

}
