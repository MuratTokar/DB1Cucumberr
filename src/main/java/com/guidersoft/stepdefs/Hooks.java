package com.guidersoft.stepdefs;

import com.guidersoft.webdriver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before  // senaryo oncesi calisir
    public void beforeScenario() {
        Driver.getDriver();
    }

    @After // senaryo sonrasi calisir
    public void afterScenario() {
        Driver.quit();
    }
}
