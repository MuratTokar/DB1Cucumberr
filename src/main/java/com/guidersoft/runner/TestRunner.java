package com.guidersoft.runner;

import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;
import org.junit.runner.JUnitCore;

import java.util.logging.Logger;

public class TestRunner {
    static Logger logger = Logger.getLogger(TestRunner.class.getName());

    public static void main(String[] args) {
        logger.info("Test Start");
        configureCucumber();
        logger.info("Cucumber Configured");
        logger.info("Test Start");
        runTest();
        logger.info("Test End");

    }

    public static void configureCucumber(){
        // bu system property cucumber optionlarinin system property den alinacagini gösterir
        System.setProperty("cucumber.publish.quite", "true");
        TestConfig config = TestConfigReader.instance().getConfig();

        String features = config.getTests().getFeatures();
        if (features.trim().length()>0)
            System.setProperty("cucumber.features", config.getTests().getFeatures());

        boolean dryRun = config.getTests().isDryRun();
        if (dryRun)
            System.setProperty("cucumber.execution.dry-run", "true");

        String tags = config.getTests().getTags();
        if (tags.trim().length()>0)
            System.setProperty("cucumber.filter.tags", tags);

    }

    public static void runTest(){
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.run(Tests.class);

    }

}
