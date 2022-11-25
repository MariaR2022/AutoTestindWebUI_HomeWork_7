import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainMenuPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@href, 'https://www.livejournal.com/category/puteshestviya/')]")
    private WebElement itemVoyages;

    @FindBy(xpath = "//a[contains(@href, 'https://www.livejournal.com/category/rabota/')]")
    private WebElement itemWork;

    @FindBy(css = ".s-header-item__link--lang")
    private WebElement menuOfLanguages;

    @FindBy(css = ".s-header-sub-list__item:nth-child(2) > .s-header-sub-list-item__link")
    private WebElement russianLanguage;

    public MainMenuPage(WebDriver driver) {
        super(driver);
    }

    //Клик на категорию Путешествия
    public void navigateToVoyages() {
        this.itemVoyages.click();
    }

    //Клик на категорию Работа
    public void navigateToWork() {
        this.itemWork.click();
    }

    //Выбор языка - Русский
    public MainMenuPage toSetLanguage() {
        menuOfLanguages.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(russianLanguage));
        russianLanguage.click();
        return new MainMenuPage(driver);
    }

}
