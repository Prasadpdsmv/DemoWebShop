package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources",
        glue = {"com.stepDefinitions","com.hooks",},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@book"

)
public class TestRunner extends AbstractTestNGCucumberTests {

        @DataProvider
        @Override
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
