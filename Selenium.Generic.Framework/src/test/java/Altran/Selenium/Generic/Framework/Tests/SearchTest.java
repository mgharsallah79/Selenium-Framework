package Altran.Selenium.Generic.Framework.Tests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Altran.Selenium.Generic.Framework.Pages.SearchPage;

public class SearchTest extends BaseTest {

    private SearchPage google;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        super.setUp();
        google = new SearchPage(driver);
    }

    @Test(dataProvider = "search-keywords")
    public void googleTest(String searchKeyword) {
        google.goTo();
        google.searchFor(searchKeyword);
        Assert.assertTrue(google.getResults().size()>0);
    }
   
    @DataProvider(name = "search-keywords")
    public static Object[][] credentials() {
          return new Object[][] {
              { "selenium webdriver" },
              { "dockerized selenium grid" },             
          };
    }

}
