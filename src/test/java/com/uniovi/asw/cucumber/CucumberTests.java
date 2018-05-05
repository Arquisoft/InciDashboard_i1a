package com.uniovi.asw.cucumber;

import org.junit.runner.RunWith;
import cucumber.api.junit.*;
import cucumber.api.CucumberOptions; 

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/uniovi/asw/features/")
public class CucumberTests {

}
