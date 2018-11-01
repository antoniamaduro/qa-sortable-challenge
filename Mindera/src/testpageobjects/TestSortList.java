package testpageobjects;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import testngtest.TestCase;

public class TestSortList extends TestCase {
	
	@Test
	public void Test1OrderItem() {
		sortList.openPage();
		sortList.searchingItem();
	}
	
	@Test
	public void Test2VerifyListOrdered() {
		assertTrue(sortList.verifyList());
	}

	@AfterClass
	public void finish() {
//		 driverChrome.quit();
	}

}
