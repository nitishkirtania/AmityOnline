package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShareButton {
	
	WebDriver driver;
	
	public ShareButton(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[@class='BannerWithImageNew_shareIconDiv__yMviw']//img")
	public WebElement shareincoElement;
	
	@FindBy(xpath = "//img[@alt='whatsapp icon']")
	public WebElement whatsappElement;
	
	@FindBy(xpath = "//img[@alt='linkedIn icon']")
	public WebElement linkediElement;
	
	@FindBy(xpath = "//img[@alt='facebook icon']")
	public WebElement facebookElement;
	
	@FindBy(xpath = "//img[@alt='x icon']")
	public WebElement xelElement;
	
	
	@FindBy(xpath = "//img[@alt='mail icon']")
	public WebElement mailElement;
	
	@FindBy(xpath = "//span[normalize-space()='Copy']")
	public WebElement copyElement;
	
	public void shareincon() {
		shareincoElement.click();
	}
	
	

}
