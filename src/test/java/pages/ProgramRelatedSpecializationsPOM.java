package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgramRelatedSpecializationsPOM {

    WebDriver driver;

    public ProgramRelatedSpecializationsPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[normalize-space()='Program Related Specializations']")
    public WebElement program_related_Specialization_Element;

    @FindBy(xpath = "//div[contains(text(),'Data Analytics')]")
    public WebElement data_Analytics_Element;

    @FindBy(xpath = "//div[contains(text(),'Cloud & Security')]")
    public WebElement cloud_Security_Element;

    @FindBy(xpath = "//div[contains(text(),'Software Engineering')]")
    public WebElement software_EngElement;

    @FindBy(xpath = "//div[contains(text(),'Data Engineering')]")
    public WebElement data_EngElement;

    @FindBy(xpath = "//*[@class='SpecializationCard_SpecializationCard__InnerTitle__QYemR font-semibold']")
    public WebElement program_rel_spe_cantrainer;

}
