package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeetOurTopRankedFacultyPOM {

     WebDriver driver;
	
	public MeetOurTopRankedFacultyPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath = "//div[@class='SectionCard_hr__WSBKM']")
    public WebElement Meet_our_top_ranked_faculty_Element;

    @FindBy(xpath = "//div[@id='MeetFacultySection']//span[1]")
    public WebElement bullet_button_one;

    @FindBy(xpath = "//h3[normalize-space()='Dr. Coral Jasmine Barboza']")
    public WebElement DrCoralJasmineBarboza;

    @FindBy(xpath = "//h3[normalize-space()='Dr. Rashmi Saxena']")
    public WebElement DrRashmiSaxena;

    @FindBy(xpath = "//h3[normalize-space()='Mona Chaudhary']")
    public WebElement MonaChaudhary;

    @FindBy(xpath = "//div[@id='MeetFacultySection']//span[4]")
    public WebElement bullet_button_two;

    @FindBy(xpath = "//div[contains(@class,'swiper-slide swiper-slide-active')]//h3[1]")
    public WebElement NehaTandon;

    @FindBy(xpath = "//h3[normalize-space()='Dr. Pragati Sahai']")
    public WebElement PragatiSahai;

    @FindBy(xpath = "//h3[normalize-space()='Dr. Harshita']")
    public WebElement DrHarshita;

    @FindBy(xpath = "//div[@id='MeetFacultySection']//span[5]")
    public WebElement bullet_button_three;

    @FindBy(xpath = "//h3[normalize-space()='Dr. Maitri Savarn']")
    public WebElement DrMaitriSavarn;
    
}
