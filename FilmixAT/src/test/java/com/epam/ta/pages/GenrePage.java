package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenrePage extends AbstractPage
{
    private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://filmix.net/";

    @FindBy(xpath = "//div[@class='subtitle']/h1")
    private WebElement genreHeading;


    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

	public GenrePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

    public String getGenreHeading()
    {
        return genreHeading.getText().toString();
    }

}
