package org.itstep.service;

import org.itstep.Util.TimerUtil;
import org.itstep.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class PromUserBotService {

    private static final String PROM_REGISTER_URL = "https://prom.ua/join-customer";

    public static WebDriver registerPromUser(User user, WebDriver webDriver){
        webDriver.get(PROM_REGISTER_URL);

        TimerUtil.waitSeconds(3);
        List<WebElement> inputElements = webDriver.findElements(By.tagName("input"));
        for (WebElement inputelement : inputElements) {
            if (inputelement.getAttribute("name") != null && inputelement.getAttribute("name").equals("vertical-name")){
                inputelement.sendKeys(user.getFullName());
            }

            if (inputelement.getAttribute("name") != null && inputelement.getAttribute("name").equals("vertical-email")){
                inputelement.sendKeys(user.getEmail());
            }

            if (inputelement.getAttribute("name") != null && inputelement.getAttribute("name").equals("vertical-password")){
                inputelement.sendKeys(user.getPassword());
            }

            TimerUtil.waitSeconds(3);
        }

        Optional<WebElement> optionalElement = webDriver.findElements(By.tagName("button")).stream().filter(webElement ->
                webElement.getAttribute("type") != null && webElement.getAttribute("type").equals("submit") &&
                webElement.getAttribute("data-qaid") != null && webElement.getAttribute("data-qaid").equals("submit")
                ).findFirst();

        if (optionalElement.isPresent()){
            WebElement buttonElement = optionalElement.get();
            buttonElement.submit();
        }

        TimerUtil.waitSeconds(6);

        String currentUrl = webDriver.getCurrentUrl();
        webDriver.get(currentUrl);

        TimerUtil.waitSeconds(5);

        return webDriver;
    }

}
