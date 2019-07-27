package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GoogleResultPage {
    @FindBy(className="LC20lb")
    private List<WebElement> googleResults;


    public List<String> getResultTitles(){
        List<String> results=new ArrayList<>();;
        for(WebElement element:googleResults){
            results.add(element.getText());
        }
            return results;
    }
}
