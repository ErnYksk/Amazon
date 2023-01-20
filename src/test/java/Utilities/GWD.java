package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();


    public static WebDriver getDriver() {
        Logger.getLogger("").setLevel(Level.SEVERE);

        if (threadBrowserName.get() == null) {
            threadBrowserName.set("chrome");
        }

        if (threadDriver.get() == null) {
            switch (threadBrowserName.get()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver());
                default:
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver());


            }
        }

        return threadDriver.get();
    }

    public static void quitDriver(){
        if(threadDriver.get()!=null)
            threadDriver.get().quit();
        WebDriver driver= threadDriver.get();
        driver=null;
        threadDriver.set(driver);

        //localden bosalt sonra ata
    }

    public static void setThreadBrowserName (String browserName) {
        GWD.threadBrowserName.set(browserName);

    }

    public static String getThreadBrowserName() {
        return GWD.threadBrowserName.get();
    }
}
