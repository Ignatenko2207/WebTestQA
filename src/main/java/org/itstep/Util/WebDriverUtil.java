package org.itstep.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverUtil {

    private static final String SEP = System.getProperty("file.separator");
    private static final String RES_DIR = "src" + SEP + "main" + SEP + "resources" + SEP;

    public static WebDriver getChromeDriver(){

        System.setProperty("webdriver.chrome.driver", RES_DIR + "chromedriver.exe");

//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
//        WebDriver chromeDriver = new ChromeDriver(options);
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return chromeDriver;
    }
}
