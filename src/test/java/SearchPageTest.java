import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchPageTest extends AbstractTest {
    static Logger logger = LoggerFactory.getLogger(SearchPageTest.class);

    @Test
    @DisplayName("Поиск по теме")
    @Description("Тест на поиск блогов и статей по заданной теме")
    @Link("http://yandex.ru")
    @Issue("https://www.livejournal.com")
    @Severity(SeverityLevel.NORMAL)
    void searchInformationTest() throws InterruptedException, IOException {
        logger.info("Тест на поиск информации о моде начат");

        String itemForSearch = "мода";
        SearchPage searchPage = new SearchPage(getWebDriver());
        searchPage.toSearch("мода");
        Thread.sleep(5000);
        UtilsScreenshotBrowserLogs.makeScreenshot(getWebDriver(),"livejournal.SearchPageTest.testTrue" + System.currentTimeMillis() + ".png");
        List<WebElement> items = new ArrayList<>(getWebDriver().findElements(By.xpath("//a[contains(@href, 'https://www.livejournal.com/rsearch?q=%D0%BC%D0%BE%D0%B4%D0%B0&sort=_score&searchArea=post')]")));
        assertTrue(items.stream().allMatch(s -> s.getText().contains(itemForSearch)));

        logger.info("Тест на поиск информации о моде завершен");

    }

}
