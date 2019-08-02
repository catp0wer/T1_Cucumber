package StepDefinitions;
import cucumber.api.java.After;
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
import org.assertj.core.api.SoftAssertions;
import java.util.List;

public class GoogleSearch {
    private WebDriver driver;
    private GoogleMainPage mainPage;
    private GoogleResultPage resultPage;
    private SoftAssertions softAssertions;
    @Before
    public void setUp() {
        driver = DriverManager.getWebDriver();
        mainPage = new GoogleMainPage();
        resultPage = new GoogleResultPage();
        PageFactory.initElements(driver, mainPage);
        PageFactory.initElements(driver, resultPage);
        softAssertions= new SoftAssertions();
    }

    @After
    public void tearDown(){
        softAssertions.assertAll();
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

        mainPage.performSearch();
    }

    @Then("results contain the word '(.*)'")
    public void resultsContainTheWord(String word) {
        List<String> results = resultPage.getResultTitles();
        int resultCount = 0;
        System.out.println(results.size());
        System.out.println(results);
        for (String text : results) {
          System.out.println(text);
          softAssertions.assertThat(text.contains(word)).isTrue();
            resultCount++;
            //checking the word in the first 5 results
            if (resultCount == 5) {
                break;
            }
        }
    }
}



