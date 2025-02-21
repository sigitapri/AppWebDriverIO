package com.sigit.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {
                "com.sigit.hooks",
                "com.sigit.step"
        },
        features = {"src/test/resources/features"},
        plugin = {"json:target/cucumber.json"},
        tags = "@regression"
)
public class RunCukesTest {

}
