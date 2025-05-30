package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sticky_Buttons_Call_whats_POM {

    WebDriver driver;
	
	public Sticky_Buttons_Call_whats_POM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath = "//img[@id='call-icon']")
    public WebElement call_icon_Element;

    @FindBy(xpath = "//img[@id='wa-icon']")
    public WebElement whatsapp_icon_Element;

    @FindBy(xpath = "//h2[contains(text(),'Journey Towards Graduation: Your Online Degree Pro')]")
    public WebElement scrollElement;

    @FindBy(xpath = "//div[@class='SideButtons_stickyApplyBtn__3Oe4V']")
    public WebElement apply_now_button;

    @FindBy(xpath = "//img[@id='engtLauncherIcon']")
    public WebElement chat_icon_Element;

}
