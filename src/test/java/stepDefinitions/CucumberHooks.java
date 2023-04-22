package stepDefinitions;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;

public class CucumberHooks {
    Base base=new Base();
    @Before
    public void beforeScenario(Scenario scenario) throws MalformedURLException {

        System.out.println(scenario.getName());
        String browserName="";
        if(scenario.getName().contains("findStoresWithLocation")||scenario.getName().contains("findProduct")){
            browserName="chrome";
        } else  {
            browserName="firefox";
        }


        System.out.println("This will run before the Scenario");
        base.initializeDriver(browserName);
        base.initializeLogger(scenario.getName());
    }

    @After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
        base.tearDownDriver();
    }
}
