package ru.yandex.praktikum.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;


public class OrderPageScooter {

    private WebDriver driver;

    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // Поле для ввода имени
    private By nameField = By.xpath(".//input[contains(@placeholder, 'Имя')]");

    // Поле для ввода фамилии
    private By surnameField = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");

    // Поле для ввода адреса
    private By addressField = By.xpath(".//input[contains(@placeholder, 'Адрес')]");

    // Поле для ввода номера телефона
    private By phoneField = By.xpath(".//input[contains(@placeholder, 'Телефон')]");

    // Выпадающий список станций метро
    private By metroDropdownField = By.className("select-search__input");

    // Кнопка Далее
    private By nextButton = By.cssSelector(".Button_Middle__1CSJM");


    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void fillOrderForm(String name, String surname, String address, String metro, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        selectMetroStationByName(metro);
        setPhone(phone);
    }

    public void clickMetroDropdownField(){
        driver.findElement(metroDropdownField).click();
    }

    public void selectMetroStationByName(String metroStation) {
        clickMetroDropdownField();
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(5));
        WebElement metroOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='Order_Text__2broi' and text()='" + metroStation + "']")));
        WebElement parentElement = metroOption.findElement(By.xpath(".."));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", parentElement);
        parentElement.click();
    }

}
