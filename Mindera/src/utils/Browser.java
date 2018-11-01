package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	public ChromeDriver openChrome() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anton\\Documents\\automation\\SeleniumTrials\\driver\\chromedriver_2.43\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public FirefoxDriver openFirefox() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\anton\\Documents\\automation\\SeleniumTrials\\driver\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.useDownloadDir", false);
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public EdgeDriver openEdge() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\anton\\Documents\\automation\\SeleniumTrials\\driver\\MicrosoftEdge_3.14393\\MicrosoftWebDriver.exe");
		EdgeDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public InternetExplorerDriver abrirIE() {
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\anton\\Documents\\automation\\SeleniumTrials\\driver\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
}
