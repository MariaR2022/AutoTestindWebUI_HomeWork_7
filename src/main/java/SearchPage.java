import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage extends AbstractPage{

    @FindBy(css = ".s-do-item-search-btn .svgicon")
    private WebElement search;

    @FindBy(css = ".s-header-search__input-wrapper > #SearchText")
    private WebElement searchLineInput;

    @FindBy(css = ".s-do-item-search-btn .svgicon")
    private WebElement searchSubmit;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void toSearch (String value){
        search.click();
        searchLineInput.sendKeys(value);
        searchSubmit.submit();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}