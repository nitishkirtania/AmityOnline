package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AreYouReadytoTakeTheNextStepPOM {
    WebDriver driver;
	
	public AreYouReadytoTakeTheNextStepPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath = "//h2[contains(text(),'Are you ready to take the next step in your career')]")
    public WebElement scroll_are_you_ready;

    @FindBy(xpath = "//div[@class='BannerCard_content__gyu4c']//div//span[@class='ClientSideButton_btnText__5gMgu'][normalize-space()='APPLY NOW']")
    public WebElement apply_now_button;

    @FindBy(xpath = "//h2[normalize-space()='Connect with our counsellor']")
    public WebElement tesElement;

    @FindBy(xpath = "//img[@class='BannerCard_image__Bt4tu']")
    public WebElement banner_image;
}
