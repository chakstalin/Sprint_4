package ru.yandex.praktikum.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPageScooter {
    private WebDriver driver;

    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка Заказать вверху страницы
    private By orderButtonTop = By.xpath(".//button[@class = 'Button_Button__ra12g']");

    // Кнопка Заказать внизу страницы
    private By orderButtonBottom = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    // Кнопка согласия на куки
    private By cookieAgreementButton = By.cssSelector(".App_CookieButton__3cvqF");

    // Кнопки вопросов в разделе "Вопросы о важном"
    private By questionButtons = By.cssSelector(".accordion__button");

    // Тексты вопросов в разделе "Вопросы о важном"
    private By answersTexts = By.cssSelector(".accordion__panel");

    // Логотип "Самоката"
    private By scooterLogo = By.cssSelector(".Header_LogoScooter__3lsAR");

    // Логотип Яндекса
    private By yandexLogo = By.cssSelector(".Header_LogoYandex__3TSOI");


    public void clickCookieAgreementButton(){
        driver.findElement(cookieAgreementButton).click();
    }

    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }

    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

    public void clickQuestionButton(int index) {
        List<WebElement> buttons = driver.findElements(questionButtons);
        if (index < buttons.size()) {
            buttons.get(index).click();
        }
    }

    public String getAnswersText(int index) {
        List<WebElement> texts = driver.findElements(answersTexts);
        if (index < texts.size()) {
            return texts.get(index).getText();
        }
        return null;
    }

    public String getQuestionButtonText(int index) {
        List<WebElement> buttons = driver.findElements(questionButtons);
        if (index < buttons.size()) {
            return buttons.get(index).getText();
        }
        return null;
    }

    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }

}
