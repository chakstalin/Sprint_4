package ru.yandex.praktikum.webdriverparams;

import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.POM.MainPageScooter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTestParameters {
    protected WebDriver driver;
    protected MainPageScooter mainPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPageScooter(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
