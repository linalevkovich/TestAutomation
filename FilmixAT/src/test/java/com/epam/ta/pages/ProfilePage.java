package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class ProfilePage extends AbstractPage
{
    private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://filmix.net/";

    @FindBy(xpath = "//div[@id='dle-content']/div[@id='breadcrumb']/span[last()]/span")
    private WebElement pageElem;

    @FindBy(xpath = "//div[@class='profile-info']/div[@class='name']")
    private WebElement profileName;

    @FindBy(xpath = "//div[@class='left']/ul/li[6]/a")
    private WebElement settingsLink;

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

	public ProfilePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String getPageTitle()
    {
        return pageElem.getText();
    }

    public String getProfileName()
    {
        return profileName.getText();
    }

    public void goToSettingsPage()
    {
        settingsLink.click();
    }

}
