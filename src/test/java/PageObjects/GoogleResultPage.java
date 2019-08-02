package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GoogleResultPage {
    //this xpath shows only the main sites on the page and not the sites from the sections "People also ask" and
    //"Searches related to" which are also a part of class LC20lb.
    @FindBy(xpath="//h3[@class='LC20lb'][not(ancestor-or-self::div[@class='xpdopen'])]")
    private List<WebElement> googleResults;
    public List<String> getResultTitles(){
        List<String> results=new ArrayList<>();;
        for(WebElement element:googleResults){
            results.add(element.getText());
        }
            return results;
    }
}
