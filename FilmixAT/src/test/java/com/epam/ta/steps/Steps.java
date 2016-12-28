package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.reporters.jq.Main;

public class Steps
{
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		driver.quit();
	}

	public void loginFilmix(String login, String password){
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.authorize();
		mainPage.setLogin(login);
		mainPage.setPassword(password);
		mainPage.login();
	}

	public boolean isLogedIn(String expected)
	{
		MainPage mainPage = new MainPage(driver);
		return mainPage.getUsername().equals(expected);
	}

	public void logout()
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.showUserDetailsMenu();
		mainPage.logout();
	}

	public void goToProfilePage()
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.goToProfilePage();
	}

	public boolean isInProfilePage(String expected)
	{
		ProfilePage profilePage = new ProfilePage(driver);
		String s = profilePage.getPageTitle();
		return s.equals(expected);
	}

	public void goToSettingsPage()
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.showUserDetailsMenu();
		mainPage.showUserDetailsMenu();
		mainPage.goToSettingsPage();
	}

	public void changeName(String sample)
	{
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.setName(sample);
		settingsPage.save();
	}

	public boolean isNameChanged(String expected)
	{
		ProfilePage profilePage = new ProfilePage(driver);
		String s = profilePage.getProfileName();
		return s.equals(expected);

	}

	public void goToComedyGenre()
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.showFilmsMenu();
		mainPage.clickComedyLink();
	}

	public boolean isInComedy(String expected)
	{

		GenrePage genrePage = new GenrePage(driver);
		String s = genrePage.getGenreHeading();
		logger.info(s);
		logger.info(expected);
		return s.equals(expected);
	}

	public void search(String sample)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.search(sample);
	}

	public boolean isSearched()
	{
		MainPage mainPage = new MainPage(driver);
		int count = mainPage.getCount();
		if(count!=1){
			return false;
		}else{
			return true;
		}
	}

}
