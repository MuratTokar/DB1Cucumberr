package com.guidersoft.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/main/resources/features/Orgfeature.feature",
        glue = {"com/guidersoft/stepdefs"}
)
public class RunnerOrg {


}
