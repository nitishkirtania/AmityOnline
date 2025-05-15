package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPOM {

WebDriver driver;
	
	public OverviewPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[@class='BuildNation_content__d4UtI']")
	public WebElement buildingnationcontaimner;
	
	@FindBy(xpath = "//img[@alt='overview-mba']")
	public WebElement buildingnationimage;
	
	@FindBy(xpath = "//div[@class='flex flex-col w-full']")
	public WebElement enhanceElement;
	
}
