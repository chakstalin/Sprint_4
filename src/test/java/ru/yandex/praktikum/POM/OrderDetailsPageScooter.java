package ru.yandex.praktikum.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderDetailsPageScooter {
    private WebDriver driver;


    public OrderDetailsPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // Поле для вызова календаря и заполнения даты
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // Выпадающий список для выбора срока аренды
    private By rentalPeriodDropdown = By.className("Dropdown-root");

    // Чекбокс для выбора черного самоката
    private By blackScooterCheckbox = By.id("black");

    // Чекбокс для выбора серого самоката
    private By greyScooterCheckbox = By.id("grey");

    // Поле для ввода комментария для курьера
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Кнопка из формы - Заказать
    private By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(),'Заказать')]");

    // Кнопка подтверждения заказа на попапе подтверждения
    private By confirmButton = By.xpath(".//button[text() = 'Да']");

    // Всплывающее окно успешного создания заказа
    private By successPopup = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");


    public void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateField).sendKeys(Keys.ENTER);;
    }

    public void selectRentalPeriod(String period) {
        driver.findElement(rentalPeriodDropdown).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='Dropdown-option' and text()='" + period + "']")));
        option.click();
    }

    public void selectScooterColor(String color) {
        if (color.equalsIgnoreCase("black")) {
            driver.findElement(blackScooterCheckbox).click();
        } else if (color.equalsIgnoreCase("grey")) {
            driver.findElement(greyScooterCheckbox).click();
        }
    }

    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void submitOrder() {
        driver.findElement(orderButton).click();
    }

    public void clickConfirmButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(confirmButton))).click();
    }

   /*public void waitForSuccessPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(successPopup))).click();
    } */
   public boolean isOrderSuccessful(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       return wait.until(ExpectedConditions.visibilityOf(driver.findElement(successPopup))).isDisplayed();
   }

}

