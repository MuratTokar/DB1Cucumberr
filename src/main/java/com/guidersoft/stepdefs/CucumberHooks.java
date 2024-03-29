package com.guidersoft.stepdefs;

import com.guidersoft.webdriver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CucumberHooks {
    @Before  // senaryo oncesi calisir
    public void beforeScenario() {
        Driver.getDriver();
    }
    @AfterStep
    public void afterStep(Scenario scenario){
        if (scenario.isFailed()){
            byte[] resim = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            /*
            // resim olarak kaydedilen byte[] i allurede teardown kismina ekler
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(resim));
             */

            // bu kisim hem allure report hem de extent report'a yansitilir
            scenario.attach(resim, "image/png", "Screenshot");
            scenario.log(scenario.getName() + " is failed");
        }
    }


    @After // senaryo sonrasi calisir
    public void afterScenario() {
      //  Driver.quit();
    }
}
