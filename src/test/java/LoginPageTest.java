import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class LoginPageTest extends AbstractTest {
    static Logger logger = LoggerFactory.getLogger(LoginPageTest.class);

    @Test
    @DisplayName("Виджет логина")
    @Description("Тест на открытие виджета логина")
    @Link("http://yandex.ru")
    @Issue("https://www.livejournal.com")
    @Severity(SeverityLevel.CRITICAL)
    void openLoginWidgetTest() throws InterruptedException {
        logger.info("Тест на открытие виджета логина начат");

        LoginPage loginWidget = new LoginPage(getWebDriver());
        loginWidget.clickSignInButton();
        Thread.sleep(5000);
        UtilsScreenshotBrowserLogs.makeScreenshot(getWebDriver(),"livejournal.LoginPageTest.testLoginWidgetTrue" + System.currentTimeMillis() + ".png");
        String itemName = getWebDriver().findElement(By.cssSelector(".s-header-item__link--login")).getText();
        Assertions.assertTrue(itemName.contains(getWebDriver().findElement(By.cssSelector(".s-header-item__link--login")).getText()));
        logger.info("Тест на открытие виджета логина завершен");
    }

    @Test
    @DisplayName("Авторизация")
    @Description("Тест по авторизации: открытие виджета логина, ввод логина и ввод пароля, подтверждение")
    @Link("http://yandex.ru")
    @Issue("https://www.livejournal.com")
    @Severity(SeverityLevel.CRITICAL)
    void userLoginTest() throws InterruptedException, IOException {
        logger.info("Тест по авторизации начат");

        LoginPage userLogin = new LoginPage(getWebDriver());
        userLogin.userLoginPassword("MariyaMarusya", "567Rjvgjn");
        Thread.sleep(5000);
        UtilsScreenshotBrowserLogs.makeScreenshot(getWebDriver(),"livejournal.LoginPageTest.testUserLoginTrue" + System.currentTimeMillis() + ".png");
        String itemName = getWebDriver().findElement(By.xpath("//a[contains(@href, 'https://mariyamarusya.livejournal.com/')]")).getText();
        Assertions.assertEquals(true, itemName.contains(getWebDriver().findElement(By.xpath("//a[contains(@href, 'https://mariyamarusya.livejournal.com/')]")).getText()));
        logger.info("Тест по авторизации завершен");
    }
}