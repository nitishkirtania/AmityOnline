package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrequentlyAskedQuestionPOM {
     WebDriver driver;
	
	public FrequentlyAskedQuestionPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath = "//h2[normalize-space()='Frequently Asked Questions']")
    public WebElement scroll_FAK_Element;

	@FindBy(xpath = "//div[@class='text-gray-800']//span[@class='FaqWithCategory_icon__KxkUd']//*[name()='svg']")
	public WebElement general_arrow_one;

	@FindBy(xpath = "//div[@class='md:px-0 px-4 space-y-4']//div[2]//div[1]//span[2]//*[name()='svg']")
	public WebElement general_arrow_two;

	@FindBy(xpath = "//section[@class='FaqSection_container__X78DX']//div[3]//div[1]//span[2]//*[name()='svg']")
	public WebElement general_arrow_three;

	@FindBy(xpath = "//section[@class='FaqSection_container__X78DX']//div[4]//div[1]//span[2]//*[name()='svg']")
	public WebElement general_arrow_four;

	@FindBy(xpath = "//section[@class='FaqSection_container__X78DX']//div[5]//div[1]//span[2]//*[name()='svg']")
	public WebElement general_arrow_five;

	@FindBy(xpath = "//button[normalize-space()='ACADEMICS']")
	public WebElement academic_button;

	@FindBy(xpath = "//div[@class='text-gray-800']//span[@class='FaqWithCategory_icon__KxkUd']//*[name()='svg']")
	public WebElement academic_arrow_one;

	@FindBy(xpath = "//div[@class='md:px-0 px-4 space-y-4']//div[2]//div[1]//span[2]//*[name()='svg']")
	public WebElement academic_arrow_two;

	@FindBy(xpath = "//section[@class='FaqSection_container__X78DX']//div[3]//div[1]//span[2]//*[name()='svg']")
	public WebElement academic_arrow_three;

	@FindBy(xpath = "//section[@class='FaqSection_container__X78DX']//div[4]//div[1]//span[2]//*[name()='svg']")
	public WebElement academic_arrow_four;

	@FindBy(xpath = "//button[normalize-space()='ADMISSION']")
	public WebElement admission_button;

	@FindBy(xpath = "//div[@class='text-gray-800']//span[@class='FaqWithCategory_icon__KxkUd']//*[name()='svg']")
	public WebElement admission_arrow_one;

	@FindBy(xpath = "//div[@class='md:px-0 px-4 space-y-4']//div[2]//div[1]//span[2]//*[name()='svg']")
	public WebElement admission_arrow_two;

	@FindBy(xpath = "//section[@class='FaqSection_container__X78DX']//div[3]//div[1]//span[2]//*[name()='svg']")
	public WebElement admission_arrow_three;

	@FindBy(xpath = "//section[@class='FaqSection_container__X78DX']//div[4]//div[1]//span[2]//*[name()='svg']")
	public WebElement admission_arrow_four;



}
