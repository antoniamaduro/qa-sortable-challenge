package testngtest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import pageobjects.SortList;
import utils.Browser;

public class TestCase {

	protected static WebDriver driverChrome;
	protected static WebDriver driverFirefox;
	protected static WebDriver driverEdge;
	protected static WebDriver driverInternetExplorer;
	protected static SortList sortList;


	@BeforeSuite
	public static void setUp() {
		driverChrome = new Browser().openChrome();
		sortList = new SortList(driverChrome);
	}

}
