package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleMainPage {

    @FindBy(name="q")
    private WebElement searchField;

    @FindBy(name="btnK")
    private WebElement searchButton;

    public void search(String textForSearch){
        searchField.sendKeys(textForSearch);
    }

    public void clickSearchButton(){
        searchButton.click();
    }
}