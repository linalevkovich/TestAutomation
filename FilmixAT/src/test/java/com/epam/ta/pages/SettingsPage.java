package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

public class SettingsPage extends AbstractPage
{
    private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://filmix.net/";

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(className = "save-profile")
    private WebElement saveButton;


    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

	public SettingsPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void setName(String sample)
    {
        nameInput.sendKeys(Keys.CONTROL + "a");
        nameInput.sendKeys(Keys.DELETE);
        nameInput.sendKeys(sample);
    }

    public void save()
    {
        saveButton.click();
    }

}
