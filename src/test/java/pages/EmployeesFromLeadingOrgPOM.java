package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeesFromLeadingOrgPOM {

    WebDriver driver;
	
	public EmployeesFromLeadingOrgPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
    }

        @FindBy(xpath = "//h2[contains(text(),'Employees From Leading Organizations Trust')]")
        public WebElement scroll_EmployeesFromLeadingOrg_Element;

        // @FindBy(xpath = "//div[@class='swiper swiper-initialized swiper-horizontal swiper-grid']//div[@class='swiper-wrapper']/div")
	    // public By logo_Size;


	

}
