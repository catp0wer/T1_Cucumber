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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GoogleSearch {
    private WebDriver driver;
    private GoogleMainPage mainPage;
    private GoogleResultPage resultPage;
    private SoftAssertions softAssertions;
    final static Logger logger = LoggerFactory.getLogger("GoogleSearch");
    @Before
    public void setUp() {
        logger.info("****** Test starts ******");
        driver = DriverManager.getWebDriver();
        mainPage = new GoogleMainPage();
        resultPage = new GoogleResultPage();
        PageFactory.initElements(driver, mainPage);
        PageFactory.initElements(driver, resultPage);
        softAssertions= new SoftAssertions();
    }

    @After
    public void tearDown(){
        driver.quit();
       List<Throwable> errors= softAssertions.errorsCollected();
       if(errors.size()==0){
           logger.info("Tests finished successfully");
       }else {
           logger.info("Number of errors {}", errors.size());
           for (Throwable failure : errors) {
               logger.error(failure.getMessage());
           }
           logger.info("Test failed");
       }
        softAssertions.assertAll();
    }

    @Given("user opens Google")
    public void userOpensGoogle() {
        driver.navigate().to("https://www.google.com/");
        logger.info("User navigates to https://www.google.com/");
    }

    @When("user enter '(.*)' in search")
    public void userEnterTextInSearch(String text) {

        mainPage.search(text);
        logger.info("User enter `"+text+"` word in search field");
    }


    @And("click on Search")
    public void clickOnSearch() {

        mainPage.performSearch();
    }

    @Then("results contain the word '(.*)'")
    public void resultsContainTheWord(String word) {
        List<String> results = resultPage.getResultTitles();
        int resultCount = 0;
        for (String text : results) {
            logger.debug("Step {} - Looking for `{}` in `{}`", resultCount, word, text);
            softAssertions.assertThat(text.contains(word)).isTrue();

            resultCount++;
            //checking the word in the first 5 results
            if (resultCount == 5) {
                logger.debug("The first 5 elements were checked");
                break;
            }
        }
    }
}



