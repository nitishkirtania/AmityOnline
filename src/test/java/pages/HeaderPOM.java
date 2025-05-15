package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HeaderPOM {

	WebDriver driver;

	public HeaderPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[@alt='amity-logo']")

	public WebElement amitylogoElement;

	@FindBy(xpath = "//span[@class='mr-1 uppercase laptop:font-medium headFootSprite serviceMenu pr-5 header_menuText__KlhzO flex gap-1 items-center']")
	public WebElement programsElement;

	@FindBy(xpath = "//span[@class='mr-1 uppercase laptop:font-medium header_menuText__KlhzO'][normalize-space()='CAREER SERVICES']")

	public WebElement careerservicElement;

	@FindBy(xpath = "//span[@class='mr-1 uppercase laptop:font-medium header_menuText__KlhzO'][normalize-space()='ADVANTAGES']")
	public WebElement advantagesElement;

	@FindBy(xpath = "//div[@class='header_searchIcon__bLdgL header_searchIconNew__5aGyK']")
	public WebElement searchbuttotElement;

	@FindBy(xpath = "//div[@id='searchContainer']//input[@type='text']")
	public WebElement searchbuttoncontentElement;

	@FindBy(xpath = "//button[@class='header_callUs__CyuCp']")
	public WebElement callusElement;

	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/*[name()='svg'][1]/*[name()='g'][1]/*[name()='path'][1]")
	public WebElement callusCloseElement;

	@FindBy(xpath = "//div[contains(@class,'header_menuContainer__00BgW')]//div[contains(@class,'VideoCall_videoIcon__XrpxN')]//*[name()='svg']//*[name()='g' and contains(@clip-path,'url(#clip0')]//*[name()='path'][1]")
	public WebElement videcallElement;


	@FindBy(xpath = "//button[@class='header_login__wzVUA']")
	public WebElement existingstudentloginElement;

	@FindBy(xpath = "//div[@class='text-blu font-baskervville font-normal capitalize mb-3 lg:mb-4 LoginModal_header__Nk7pU']")
	public WebElement existingstudentloginContentElement;

	@FindBy(xpath = "//div[contains(@class,'header_menuContainer__00BgW')]//span[contains(@class,'ClientSideButton_btnText__5gMgu')][normalize-space()='APPLY NOW']")
	public WebElement applyNowHeaderElement;

	@FindBy(xpath = "//h2[@class='ConnectModal_Modal__RightContainerTitle__WO56D pr-[2.3rem]']")
	public WebElement applynowcontentElement;

	@FindBy(xpath = "//span[contains(text(),'July’25 Session Admissions Open Now')]")
	public WebElement yellowstripElement;
	
	@FindBy(xpath = "//h2[@class='ConnectModal_Modal__RightContainerTitle__WO56D pr-[2.3rem]']")
	public WebElement yellowstripcontentElement;

	@FindBy(xpath = "//body/header[contains(@class,'container z-[1]')]/div[contains(@class,'mt-2 bg-primary-blue text-white mb-3 xl:mt-5 xl:flex xl:justify-between xl:items-center header_containerRadius__HLowV')]/div[contains(@class,'header_desktopMenu__TgI48')]/div[contains(@class,'header_menuContainer__00BgW')]/div[contains(@class,'flex items-center group w-max header_menuItem__2qruK')]/div[contains(@class,'container w-full fixed header_programMenu__D5RVR')]/div[contains(@class,'ProgramsMenu_container__RPdmP program-menu rounded-2xl relative')]/div[2]/div[1]")

	public WebElement allProgramElement;

	@FindBy(xpath = "//div[@id='searchContainer']//a[contains(@title,'Online MBA )')][contains(text(),'Master of Business Administration (')]")
	public WebElement mbaElement;

	@FindBy(xpath = "//h2[@class='ConnectModal_Modal__RightContainerTitleCallUs__0NOrs pr-[2.3rem]']")
	public WebElement calluspopcontentElement;

	@FindBy(xpath = "//a[normalize-space()='With Attractive Scholarships']")
	public WebElement AttractiveScholarship;
	
	@FindBy(xpath = "//span[normalize-space()='MBA']")
	public WebElement mbaHerocart;
	
	@FindBy(xpath = "//span[normalize-space()='BBA']")
	WebElement bbaHerocart;
	
	@FindBy(xpath = "//span[normalize-space()='MCA']")
	WebElement mcaHerocart;
	
	@FindBy(xpath = "//span[normalize-space()='BCA']")
	WebElement bcaHerocart;
	
	@FindBy(xpath = "//div[@class='swiper-button-prev']")
	WebElement leftCarousElement;
	
	public void Career() {
		careerservicElement.click();
	}

	public void VideoCall() {
		videcallElement.click();
	}

	public void YStrip() {
		JavascriptExecutor js3=((JavascriptExecutor)driver);
		js3.executeScript("arguments[0].click();", yellowstripElement);
	}
//-------------------------------------------Handling Carousel--------------------------------------------------	
	public void clickCarouselLeft() {
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", leftCarousElement);
	        Thread.sleep(1500); // wait for the slide to finish
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to click carousel left: " + e.getMessage());
	    }
	}
	
	public void clickIfPresentOrSwitchThenClick(WebElement elementToClick) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    try {
	        if (elementToClick.isDisplayed()) {
	            js.executeScript("arguments[0].scrollIntoView(true);", elementToClick);
	            js.executeScript("arguments[0].click();", elementToClick);
	        } else {
	            clickCarouselLeft(); // move to the other slide
	            if (elementToClick.isDisplayed()) {
	                js.executeScript("arguments[0].scrollIntoView(true);", elementToClick);
	                js.executeScript("arguments[0].click();", elementToClick);
	            } else {
	                throw new RuntimeException("Element not found on either slide.");
	            }
	        }
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to click element: " + e.getMessage());
	    }
	}
//----------------------------------------------------------------------------------------------------------------------	
	
	public void AScholarship() {
		clickIfPresentOrSwitchThenClick(AttractiveScholarship);
	}
	
	public void heroMBA() {
		clickIfPresentOrSwitchThenClick(mbaHerocart);
	}

	public void heroBBA() {
		clickIfPresentOrSwitchThenClick(bbaHerocart);
	}
	
	public void heroMCA() {
		clickIfPresentOrSwitchThenClick(mcaHerocart);
	}
	
	public void heroBCA() {
		clickIfPresentOrSwitchThenClick(bcaHerocart);
	}
	
}
