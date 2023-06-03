package ru.netology;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;





public class DeliveryTest {
    int days = 4;
    MeetingDate meetingDate = new MeetingDate();

    @BeforeEach
    void setup() {
        open("http://localhost:9999/");
    }


    @Test
    void shouldTest() {

        SelenideElement form = $("[data-test-id=app-card-delivery]");
        $("[placeholder='Город']").setValue("Майкоп");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(meetingDate.generateDate(days));
        $("[name='name']").setValue("Бойко Дмитрий");
        $("[name='phone']").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $("[class='button__text']").click();
        $("[data-test-id='notification']")
                .shouldHave(text("Встреча успешно забронирована на " + meetingDate.generateDate(days)), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

}
