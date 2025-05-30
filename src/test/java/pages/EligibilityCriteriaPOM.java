package pages;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class EligibilityCriteriaPOM {
	WebDriver driver;

	public EligibilityCriteriaPOM(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//h2[contains(text(),'Eligibility')]")
	public WebElement elegibilitycriteriaElement;

	@FindBy(xpath = "//img[@title='Eligible']")
	public WebElement eligibleElement;
	
	@FindBy(xpath = "//div[@class='undefined flex-1 lg:pr-[4.4rem]']")
	public WebElement elegibilitycriteriasection;
	
	@FindBy(xpath = "//h2[normalize-space()='For Indian students']")
	public WebElement forindianstyudentsElement;
	
	@FindBy(xpath = "//div[@class='mt-9 md:mt-0 lg:mt-0']")
	public WebElement forindianstudentsection;
	
	@FindBy(xpath = "//h2[normalize-space()='For Foreign students']")
	public WebElement forforeignstudentsElement;
	
	@FindBy(xpath = "//div[@class='mt-9 lg:mt-10']")
	public WebElement forforeignstudentssection;
	
	



}
