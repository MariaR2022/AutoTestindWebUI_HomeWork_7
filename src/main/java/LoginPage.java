import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(css = ".s-header-item__link--login")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='user']")
    private WebElement loginInput;

    @FindBy(id="lj_loginwidget_password")
    private WebElement passwordInput;

    @FindBy(name = "action:login")
    private WebElement submitButton;

    //Клик на кнопку Войти = Открываем Виджет логина
    public void clickSignInButton() {
        signInButton.click();
        //return new LoginPage(driver);
    }
    //Авторизация - ввод Логина и Пароля
    public LoginPage userLoginPassword(String login, String password) {
        signInButton.click();
        loginInput.click();
        loginInput.sendKeys(login);
        passwordInput.click();
        passwordInput.sendKeys(password);
        submitButton.click();
        return new LoginPage(driver);
    }
}