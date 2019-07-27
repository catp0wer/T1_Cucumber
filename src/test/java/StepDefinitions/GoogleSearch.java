package StepDefinitions;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;

import junit.framework.AssertionFailedError;
import org.openqa.selenium.WebDriver;
import DriverManager.DriverManager;
import PageObjects.GoogleMainPage;
import PageObjects.GoogleResultPage;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearch {
    private WebDriver driver;
    private GoogleMainPage mainPage;
    private GoogleResultPage resultPage;

    @Before
    public void setUp() {
        driver = DriverManager.getWebDriver();
        mainPage = new GoogleMainPage();
        resultPage = new GoogleResultPage();
        PageFactory.initElements(driver, mainPage);
        PageFactory.initElements(driver, resultPage);
    }

    @Given("user opens Google")
    public void userOpensGoogle() {
        driver.navigate().to("https://www.google.com/");
    }

    @When("user enter '(.*)' in search")
    public void userEnterTextInSearch(String text) {
        mainPage.search(text);
    }

    @And("click on Search")
    public void clickOnSearch() {
        mainPage.clickSearchButton();
    }

    @Then("results contain the word '(.*)'")
    public boolean resultsContainTheWord(String word) {
        List<String> results = resultPage.getResultTitles();
        int resultCount = 0;


        for (String text : results) {
            System.out.println(resultCount+" " +text);
            if (!text.contains(word)) {
                throw new AssertionFailedError("Word is not contained in the list of search results");
            }
            resultCount++;
            //checking the word in the first 5 results
            if (resultCount == 5) {
                break;
            }
        }
        return true;
    }
}



