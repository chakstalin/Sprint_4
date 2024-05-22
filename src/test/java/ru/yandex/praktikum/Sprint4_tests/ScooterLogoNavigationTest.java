package ru.yandex.praktikum.Sprint4_tests;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import ru.yandex.praktikum.webdriverparams.BaseTestParameters;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class ScooterLogoNavigationTest extends BaseTestParameters {


    @Test
    public void testScooterLogoNavigation() {
        mainPage.clickScooterLogo();
        assertEquals("Неверная навигация по ссылке на логотипе", "https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }

    @Test
    public void testYandexLogoNavigation() {
        String originalWindow = driver.getWindowHandle();
        mainPage.clickYandexLogo();

        assertTrue("Новое окно не открылось", driver.getWindowHandles().size() > 1);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        new WebDriverWait(driver, Duration.ofSeconds(5)).until((ExpectedCondition<Boolean>) driver ->
                driver.getCurrentUrl().contains("yandex.ru") || driver.getCurrentUrl().contains("dzen.ru"));

        assertTrue("Ссылка не ведёт на 'yandex.ru' или 'dzen.ru'", driver.getCurrentUrl().contains("dzen.ru") || driver.getCurrentUrl().contains("yandex.ru"));
    }
}

