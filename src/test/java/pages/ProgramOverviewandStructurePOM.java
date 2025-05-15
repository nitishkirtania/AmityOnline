package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgramOverviewandStructurePOM {
	
	WebDriver driver;
	
	public ProgramOverviewandStructurePOM(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[normalize-space()='Program Overview & Structure']")
	public WebElement programoverviewElement;
	
	@FindBy(xpath = "//span[normalize-space()='EXPLORE CURRICULUM']")
	public WebElement explorecurriculumElement;
	
	@FindBy(xpath = "//body//main[@class='relative']//div[@id='CourseCurriculum']//div//div//div[1]//div[1]//div[1]//span[1]//*[name()='svg']")
	public WebElement semister1elElement;
	
	@FindBy(xpath = "//div[@id='CourseCurriculum']//div//div[2]//div[1]//div[1]//span[1]//*[name()='svg']")
	public WebElement semister2elElement;
	
	@FindBy(xpath = "//div[@class='CourseCurriculum_CourseCurriculum__cardContainer__M6oML']//div[3]//div[1]//div[1]//span[1]//*[name()='svg']")
	public WebElement semister3elElement;
	
	@FindBy(xpath = "//div[@class='CourseCurriculum_CourseCurriculum__cardContainer__M6oML']//div[4]//div[1]//div[1]//span[1]//*[name()='svg']")
	public WebElement seminter4elElement;
	
	@FindBy(xpath = "//div[@class='container']//div[5]//div[1]//div[1]//span[1]//*[name()='svg']")
	public WebElement specializationselElement;
	
	@FindBy(xpath = "//img[@title='Degree Offered By Us']")
	public WebElement certificatElement;
	
	@FindBy(xpath = "//p[@class='font-raleway text-secondary-gray DegreeOfferedCarousel_DegreeOffered__subtitle__xLYJX']")
	public WebElement certificatecontentElement;
	
	@FindBy(xpath = "//div[@class='text-blu font-baskervville font-normal capitalize mb-3 lg:mb-4 Modal_header__h0gLo']")
	public WebElement downloadbrochurElement;
	
	@FindBy(xpath = "//div[@class='bg-white Modal_dialog__e3Pgf']//*[name()='svg']")
	public WebElement closebuttonElement;
	
	

}
