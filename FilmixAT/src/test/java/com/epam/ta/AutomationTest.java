package com.epam.ta;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;

import com.epam.ta.steps.Steps;

import javax.print.attribute.standard.MediaSize;

public class AutomationTest
{
	private final Logger logger = LogManager.getRootLogger();
	private Steps steps;

	private Random rand = new Random();
	private int num = rand.nextInt(10);
	private final String NAME = "username1";
	private final String PASSWORD = "123456";
	private final String EXPECTED_TITLE = "Мой профиль";
	private final String SAMPLE_NAME = "Test"+ num;
	private final String EXPECTED_GENRE = "СМОТРЕТЬ КОМЕДИЙНЫЕ ФИЛЬМЫ ОНЛАЙН В ХОРОШЕМ КАЧЕСТВЕ";
	private final String SEARCH_SAMPLE = "qwe";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Login to Filmix")
	public void oneCanLoginFilmix()
	{
		steps.loginFilmix(NAME, PASSWORD);
		Assert.assertTrue(steps.isLogedIn(NAME));
		steps.logout();
	}

	@Test(description="Go to Profile Page")
	public void oneCanGoToProfilePage()
	{
		steps.loginFilmix(NAME, PASSWORD);
		steps.goToProfilePage();
		Assert.assertTrue(steps.isInProfilePage(EXPECTED_TITLE ));
		steps.logout();

	}

	@Test(description = "Change Name")
	public void oneCanChangeName()
	{
		steps.loginFilmix(NAME, PASSWORD);
		steps.goToSettingsPage();
		steps.changeName(SAMPLE_NAME);
		steps.goToProfilePage();
		Assert.assertTrue(steps.isNameChanged(SAMPLE_NAME));
		steps.logout();
	}

	@Test(description = "Go to Comedy Films Genre")
	public void oneCanGoToComedyFilmsGenre(){
		steps.loginFilmix(NAME,PASSWORD);
		steps.goToComedyGenre();
		Assert.assertTrue(steps.isInComedy(EXPECTED_GENRE));
		steps.logout();
	}

	@Test(description = "Search(sample:qwe , expected_count:1)")
	public void oneCanSearch()
	{
		steps.loginFilmix(NAME,PASSWORD);
		steps.search(SEARCH_SAMPLE);
		Assert.assertTrue(steps.isSearched());
		steps.logout();
	}




	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
