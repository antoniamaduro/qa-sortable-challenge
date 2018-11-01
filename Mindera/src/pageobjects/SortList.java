package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SortList {

	// ***********************************************************************************
	// Attributes
	// ***********************************************************************************
	private WebDriver driver;

	// ***********************************************************************************
	// Initializing WebElements
	// ***********************************************************************************

	@FindBy(id = "app")
	private WebElement elementsToOrder;

	@FindBy(css = "li:nth-child(1)")
	private WebElement position1;

	@FindBy(css = "li:nth-child(2)")
	private WebElement position2;

	@FindBy(css = "li:nth-child(3)")
	private WebElement position3;

	@FindBy(css = "li:nth-child(4)")
	private WebElement position4;

	@FindBy(css = "li:nth-child(5)")
	private WebElement position5;

	@FindBy(css = "li:nth-child(6)")
	private WebElement position6;

	// ***********************************************************************************
	// Constructor
	// ***********************************************************************************

	public SortList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ***********************************************************************************
	// Methods
	// ***********************************************************************************

	public void openPage() {
		String baseUrl = "http://localhost:3000";
		driver.navigate().to(baseUrl);
	}

	// Array of current position
	public WebElement[] positionList() {
		WebElement[] listPosition = new WebElement[6];
		listPosition[0] = position1;
		listPosition[1] = position2;
		listPosition[2] = position3;
		listPosition[3] = position4;
		listPosition[4] = position5;
		listPosition[5] = position6;

		return listPosition;
	}

	// Searching an item by author
	public void searchingItem() {
		Actions action = new Actions(driver);
		WebElement[] listPosition = new WebElement[6];
		listPosition = positionList();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		try {
			isElementPresent(elementsToOrder);
			wait(3000);

			for (int i = 0; i <= 5; i++) {
				for (int j = 0; j <= 5; j++) {
					String element = listPosition[j].getText();
					String elementFound = "Item " + i;
					if (element.contains(elementFound)) {
						action.click(listPosition[j]).clickAndHold().moveToElement(listPosition[i]).moveByOffset(0, 10)
								.release().build().perform();
					}

				}
			}

		} catch (Exception e) {
			System.out.println("Element is not found");
		} finally {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	public boolean verifyList() {
		boolean ordered = false;
		WebElement[] currentListPosition = new WebElement[6];
		currentListPosition = positionList();
		for (int i = 0; i <= 5; i++) {
			if (currentListPosition[i].getText().contains("Item " + i)) {
				ordered = true;
			}

		}
		return ordered;
	}

	// Timeout of some milliseconds
	public void wait(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Verify if the web element is present and enabled
	public boolean isElementPresent(WebElement element) {
		try {
			wait(1500);
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			System.out.println("Element does not exist.");
			return false;
		}
	}
}
