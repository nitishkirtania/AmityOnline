package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgramhighlightsPOM {
	
WebDriver driver;
	
	public ProgramhighlightsPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//h2[normalize-space()='Program Highlights & Advantages']")
	public WebElement programhigglightsElement;
	
	@FindBy(xpath = "//div[contains(@class,'ProgramHighlights_ProgramHighlights__cardContainer__RMc3h')]//div[1]//div[2]")
	public WebElement qSrankingElement;
	
	@FindBy(xpath = "//section[@id='ProgramHighlights']//div[2]//div[2]")
	public WebElement aCCAspecializationElement;
	
	@FindBy(xpath = "//div[contains(@class,'pt-7 lg:pt-7')]//div[3]//div[2]")
	public WebElement studyanytimElement;
	
	@FindBy(xpath = "//section[@id='ProgramHighlights']//div[4]//div[2]")
	public WebElement realworldElement;
	
	
	
	
	
}
