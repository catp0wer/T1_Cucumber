package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleMainPage {

    @FindBy(name="q")
    private WebElement searchField;

    public void search(String textForSearch){
        searchField.sendKeys(textForSearch);
    }
    public void performSearch(){
        //easier to press on Enter to perform a search than implementing click on button, because sometimes the button
        //is still not visible when selenium attempts to click it, thus failing the test prematurely
        //the alternative would be clicking the search button in conjunction with WebDriverWait
        searchField.sendKeys(Keys.ENTER);
    }
}