package ru.yandex.praktikum.Sprint4_tests;

import ru.yandex.praktikum.POM.*;
import ru.yandex.praktikum.webdriverparams.BaseTestParameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ScooterOrderPositiveFlow extends BaseTestParameters {
    private OrderPageScooter orderPage;
    private OrderDetailsPageScooter orderDetailsPage;

    private String name;
    private String surname;
    private String address;
    private String phone;
    private String metro;
    private String date;
    private String period;
    private String color;
    private String comment;

    public ScooterOrderPositiveFlow(String name, String surname, String address, String metro, String phone, String date, String period, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.metro = metro;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Иван", "Иванов", "ул Иванова", "89991234567", "Лубянка", "25.05.2024", "двое суток", "black", "Спасибо"},
                {"Петр", "Петров", "ул. Петрова, д. 1", "89991234568", "Арбатская", "26.05.2024", "сутки", "grey", "123"},
                {"Анна", "Аннова", "ул. Анновы", "89991234569", "Красносельская", "27.05.2024", "трое суток", "black", ""},
                {"Мария", "Мариева", "ул. д.3", "+7991234570", "Павелецкая", "28.12.2025", "четверо суток", "grey", "Оставьте самокат себе"},
                {"Дмитрий", "Дмитриев", "г. Дмитриев, ул. Дмитриева", "89991234571", "Таганская", "29.05.2024", "пятеро суток", "black", "Когда-то и меня вела дорога приключений"}
        };
    }

    @Before
    public void setUpOrderPages() {
        orderPage = new OrderPageScooter(driver);
        orderDetailsPage = new OrderDetailsPageScooter(driver);
    }

    @Test
    public void testPositiveScooterOrderFromTopButton() {
        mainPage.clickOrderButtonTop();
        orderPage.fillOrderForm(name, surname, address, phone, metro);
        orderPage.clickNextButton();
        orderDetailsPage.setDate(date);
        orderDetailsPage.selectRentalPeriod(period);
        orderDetailsPage.selectScooterColor(color);
        orderDetailsPage.setComment(comment);
        orderDetailsPage.submitOrder();
        orderDetailsPage.clickConfirmButton();

        assertTrue("Попап успешно оформленного заказа не появился", orderDetailsPage.isOrderSuccessful());
    }

    @Test
    public void testPositiveScooterOrderFromBottomButton() {
        mainPage.clickCookieAgreementButton();
        mainPage.clickOrderButtonBottom();
        orderPage.fillOrderForm(name, surname, address, phone, metro);
        orderPage.clickNextButton();
        orderDetailsPage.setDate(date);
        orderDetailsPage.selectRentalPeriod(period);
        orderDetailsPage.selectScooterColor(color);
        orderDetailsPage.setComment(comment);
        orderDetailsPage.submitOrder();
        orderDetailsPage.clickConfirmButton();

        assertTrue("Попап успешно оформленного заказа не появился", orderDetailsPage.isOrderSuccessful());
    }

}
