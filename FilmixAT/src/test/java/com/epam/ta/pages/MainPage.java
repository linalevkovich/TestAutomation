package com.epam.ta.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
    private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "http://filmix.net/";

	@FindBy(id="auth")
	private WebElement authorizationButton;

    @FindBy(id="login_name")
    private WebElement loginInput;

    @FindBy(id="login_password")
    private WebElement passwordInput;

    @FindBy(className = "enter")
    private WebElement loginButton;

    @FindBy(className = "user-name")
    private WebElement userNameSpan;

    @FindBy(className = "user-details")
    private WebElement userDetailsMenuButton;

    @FindBy(className = "logoute")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[@class='login-items']/a[1]")
    private WebElement settingsButton;

    @FindBy(xpath = "//span[contains(text(),'Фильмы')]")
    private WebElement filmsMenuButton;

    @FindBy(xpath = "//a[contains(text(),'Комедии')]")
    private WebElement comedyButton;

    @FindBy(id = "search")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='result']/h2[@class='result-title']/span")
    private WebElement countOfSearchedElems;




    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

    public void authorize()
    {
        authorizationButton.click();
    }

    public void setLogin(String login)
    {
        loginInput.sendKeys(login);
    }

    public void setPassword(String password)
    {
        passwordInput.sendKeys(password);
    }

    public void login()
    {
        loginButton.click();
    }

    public String getUsername()
    {
        return userNameSpan.getText().toString();
    }

    public void showUserDetailsMenu()
    {
        userDetailsMenuButton.click();
    }

    public void logout()
    {
        logoutButton.click();
    }

    public void goToProfilePage()
    {
        userNameSpan.click();
    }

    public void goToSettingsPage()
    {
        WebElement wait = new WebDriverWait(driver,300)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("panel-admin")));
        settingsButton.click();

    }

    public void showFilmsMenu()
    {
        filmsMenuButton.click();
        filmsMenuButton.click();
    }

    public void clickComedyLink()
    {
        comedyButton.click();
    }

    public void search(String sample)
    {
        searchInput.sendKeys(sample);
        searchInput.sendKeys(Keys.ENTER);
    }

    public int getCount()
    {
        return Integer.parseInt(countOfSearchedElems.getText());
    }







}
