package com.guidersoft.pageobjects;

import com.guidersoft.base.BaseTest;
import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;
import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseTest {

    public void goTopage(){
        TestConfig config=TestConfigReader.instance().getConfig();
        Driver.getDriver().get(config.getApplication().getUrl());
        try {
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            String win=driver.getWindowHandle();
            String newWinn=driver.getWindowHandles()
                    .stream()
                    .filter(wh -> !wh.equals(win))
                    .findFirst().get();
            driver.switchTo().window(newWinn).close();
            driver.switchTo().window(win);
        }catch (Exception ignored){

        };

    }

}
