package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhySayYesToAmityOnlinePOM {
	WebDriver driver;
	public WhySayYesToAmityOnlinePOM (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[contains(text(),'Why Say')]")
	public WebElement whysayyesElement;
	
	@FindBy(xpath = "//p[@class='SectionCard_subtitle__vVqmD hidden lg:block !text-left !m-0']")
	public WebElement globallyElement;
	
	@FindBy(xpath = "//body/main[@class='relative']/div[@class='my-8']/section[@id='amityonlineadvantages']/div[@class='container']/div[@class='SectionCard_root__vJRVT SectionCard_card__76a8h']/div[@class='pt-7 lg:pt-7']/h2/div[@class='grid grid-cols-2 lg:grid-cols-4 lg:gap-x-20 gap-x-8 gap-y-12 lg:gap-y-10']/div[1]")
	public WebElement wascElement;
	
	@FindBy(xpath = "//div[@class='my-8']//div[@class='pt-7 lg:pt-7']//div[2]")
	public WebElement wesElement;
	
	@FindBy(xpath = "//div[@class='my-8']//div[3]")
	public WebElement qSelementElement;
	
	@FindBy(xpath = "//div[@class='my-8']//div[4]")
	public WebElement qAAelemElement;
	
	@FindBy(xpath = "//div[@class='my-8']//div[5]")
	public WebElement timeshighereducation;
	
	@FindBy(xpath = "//div[@class='my-8']//div[6]")
	public WebElement panindiaElement;
	
	@FindBy(xpath = "//div[@class='my-8']//div[7]")
	public WebElement amigoElement;
	
	@FindBy(xpath = "//div[@class='my-8']//div[8]")
	public WebElement profami;
	
	@FindBy(xpath = "//div[@class='my-8']//div[9]")
	public WebElement industrycertioficationElement;
	
	@FindBy(xpath = "//div[@class='my-8']//div[10]")
	public WebElement internshipElement;
	
	@FindBy(xpath = "//div[@class='my-8']//div[11]")
	public WebElement aipoweredElement;
	
	@FindBy(xpath = "//div[@class='my-8']//div[12]")
	public WebElement besocialElement;
	
	@FindBy(xpath = "//section[@id='amityonlineadvantages']//div[@class='pt-7 lg:pt-7']")
	public WebElement allwhysayyesElement;
	
	
	
	
	
	
	
	
	
	
	
}
