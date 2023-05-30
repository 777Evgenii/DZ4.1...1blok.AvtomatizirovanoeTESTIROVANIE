package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryTest {
    @Test
    void shouldTest() {
        open("http://127.0.0.1:9999/");
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 15 * 1000;
        $("[placeholder='Город']").setValue("Майкоп");
        $("[placeholder='Дата встречи']").setValue("02.06.2023");
        $("[name='name']").setValue("Бойко Дмитрий");
        $("[name='phone']").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $("[class='button__text']").click();

        $x("//div[contains(text(), 'Встреча успешно забронирована')]").shouldBe(Condition.visible);
    }
}
