import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import io.qameta.allure.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class MainMenuPageTest extends AbstractTest {
    static Logger logger = LoggerFactory.getLogger(MainMenuPageTest.class);

    @Test
    @DisplayName("Выбор категории -Путешествия-")
    @Description("Выбираем категорию -Путешествия- в меню на главной странице")
    @Link("http://yandex.ru")
    @Issue("https://www.livejournal.com")
    @Severity(SeverityLevel.NORMAL)
    void itemVoyagesTest() throws InterruptedException, IOException {
        logger.info("Тест на открытие категории/темы -Путешествия- начат");

        MainMenuPage itemVoyages = new MainMenuPage(getWebDriver());
        itemVoyages.navigateToVoyages();
        Thread.sleep(5000);
        UtilsScreenshotBrowserLogs.makeScreenshot(getWebDriver(),"livejournal.MainMenuPageTest.testVoyagesTrue" + System.currentTimeMillis() + ".png");
        Assertions.assertEquals("Блоги о путешествиях и самостоятельном туризме — Живой Журнал — ЖЖ", getWebDriver().getTitle(), "Данная категория отсутствует");
        logger.info("Тест на открытие категории/темы -Путешествия- завершен");
    }

    @Test
    @DisplayName("Выбор категории -Работа-")
    @Description("Выбираем категорию -Работа- в меню на главной странице")
    @Link("http://yandex.ru")
    @Issue("https://www.livejournal.com")
    @Severity(SeverityLevel.NORMAL)
    void itemWorkTest() throws InterruptedException, IOException {
        logger.info("Тест на открытие категории/темы -Работа- начат");

        MainMenuPage itemWork = new MainMenuPage(getWebDriver());
        itemWork.navigateToWork();
        Thread.sleep(5000);
        UtilsScreenshotBrowserLogs.makeScreenshot(getWebDriver(),"livejournal.MainMenuPageTest.testWorkTrue" + System.currentTimeMillis() + ".png");
        Assertions.assertEquals("Статьи и блоги про работу — Живой Журнал — ЖЖ",getWebDriver().getTitle(),"Данная категория отсутствует");
        logger.info("Тест на открытие категории/темы -Работа- завершен");
    }

    @Test
    @DisplayName("Выбор языка")
    @Description("Выбираем язык в выпадающем меню на главной странице")
    @Link("http://yandex.ru")
    @Issue("https://www.livejournal.com")
    @Severity(SeverityLevel.NORMAL)
    void setLanguageMenuTest()throws InterruptedException {
        logger.info("Тест на установку языка -Русский- начат");

        MainMenuPage setLanguage = new MainMenuPage(getWebDriver());
        setLanguage.toSetLanguage();
        Thread.sleep(5000);
        String itemName = getWebDriver().findElement(By.cssSelector(".s-header-sub-list__item:nth-child(2) > .s-header-sub-list-item__link")).getText();
        Assertions.assertTrue(itemName.contains(getWebDriver().findElement(By.cssSelector(".s-header-sub-list__item:nth-child(2) > .s-header-sub-list-item__link")).getText()));

        logger.info("Тест на установку языка -Русский- завершен");
    }

    @Test
    @DisplayName("Логи браузера")
    @Description("Создаем логи")
    @Link("http://yandex.ru")
    @Issue("https://www.livejournal.com")
    @Severity(SeverityLevel.NORMAL)
    void testBrowserLogs(){
        LogEntries browserLogs = getWebDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
       /* Assertions.assertEquals(0,allLogRows.size());*/
        Assertions.assertFalse(allLogRows.isEmpty());
        if (allLogRows.size() > 0 ) {
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });
        }
    }
}
