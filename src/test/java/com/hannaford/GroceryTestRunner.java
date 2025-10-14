package com.hannaford;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(dryRun = true, plugin = {"pretty", "html:target\\output.html", "json:target\\output.json"},
					glue = "com.hannaford.step", features = "src\\test\\resources")

public class GroceryTestRunner {
	

}
