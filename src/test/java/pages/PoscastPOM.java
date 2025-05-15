package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoscastPOM {
	
WebDriver driver;
	
	public PoscastPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//div[@class='PodcastSection_podcast_block__Hw1hz']")
	public WebElement podcastcontainerElement;
	
	@FindBy(xpath = "//div[@class='PodcastSection_content__tMY3A']")
	public WebElement podcasttextElement;
	
	@FindBy(xpath = "//iframe[contains(@src, 'youtube.com/embed')]")
	public WebElement frameElement;
	
	@FindBy(xpath = "//video[contains(@class, 'video-stream')]")
	public WebElement videocontainerElement;
	
}
