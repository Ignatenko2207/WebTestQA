package org.itstep;

import org.itstep.Util.TimerUtil;
import org.itstep.Util.WebDriverUtil;
import org.itstep.model.User;
import org.itstep.service.DataExtraction;
import org.itstep.service.PromDataExtraction;
import org.itstep.service.PromUserBotService;
import org.openqa.selenium.WebDriver;


public class App 
{
    public static void main( String[] args )
    {

//        String url = "https://prom.ua/p843085994-noutbuk-omen-dc0047ur.html";
//        DataExtraction promExtraction = new PromDataExtraction();
//
//        System.out.println( promExtraction.getItemFromProductUrl(url).getName() );

        WebDriver driver = WebDriverUtil.getChromeDriver();
        TimerUtil.waitSeconds(3);

        User user = new User("Alex Ignatenko",
                "lipoviy.email.852963@gmail.com", "AwSeDrFt56789");
        PromUserBotService.registerPromUser(user, driver);

        TimerUtil.waitSeconds(10);
        driver.quit();
    }
}
