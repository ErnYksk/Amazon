package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void before(){
        System.out.println("baslangic");
    }

    @After
    public void after(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] ss=((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(ss, "image/png", "screenshot name");
        }
           GWD.quitDriver();

    }

}
