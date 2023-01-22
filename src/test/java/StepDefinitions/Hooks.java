package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    @Before
    public void before() {
        System.out.println("baslangic");
    }

    @After
    public void after(Scenario scenario) {

        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("dd_MM_YYHHmmss");


        ExcelUtility.writeToExcel("src/test/java/ApachePOI/resource/ScenarioStatus.xlsx",
                scenario, GWD.getThreadBrowserName(), time.format(tf));

        if (scenario.isFailed())
        {

            final byte[] byteHali = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(byteHali, "image/png", "screenshot name");


            GWD.quitDriver();

        }

    }
}