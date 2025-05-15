package pages;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeeStructurePOM {
	
WebDriver driver;
	
	public FeeStructurePOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//h2[@class='FeesSection_feeStructure__OM_FM']")
	public WebElement feeElement;
	
	@FindBy(xpath = "//div[contains(@class,'justify-between lining-nums FeesCard_root__xigma FeesSection_fees_card__VMiiu')]")
	public WebElement interestfreeElement;
	
	@FindBy(xpath = "//body/main[contains(@class,'relative')]/div/div[contains(@class,'FeesSection_container__Oy46m')]/div[contains(@class,'lg:grid gap-y-4 lg:grid-cols-4 lg:gap-x-6 md:grid gap-y-4 md:grid-cols-2 md:gap-6 pt-7')]/div[2]/div[1]")
	public  WebElement semisterfee;
	
	@FindBy(xpath = "//div[contains(@class,'lg:col-span-1 mt-4 lg:mt-0 md:mt-0')]//div[contains(@class,'justify-between lining-nums FeesCard_root__xigma FeesSection_hoverEffectCard__mXqIN')]")
	public WebElement fulloprogramfeeElement;
	
	@FindBy(xpath = "//div[contains(@class,'mb-4 mt-4 lg:m-0 md:m-0')]//div[contains(@class,'text-raleway h-full flex flex-col justify-between FeesCard_FeesCard__Container__okcL1')]")
	public WebElement attractivescholarshipElement;
	
	@FindBy(xpath = "//a[@class='FeesCard_cus_btn__A_UQH FeesCard_customBackground__gLd18']")
	public WebElement exploremoWebElement;
	
	@FindBy(xpath = "//div[contains(@class,'lg:grid gap-y-4 lg:grid-cols-4 lg:gap-x-6 md:grid gap-y-4 md:grid-cols-2 md:gap-6 pt-7')]")
	public WebElement cartcountElement;

	
	
	

}
