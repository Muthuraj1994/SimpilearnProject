package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Hello world!
 *
 */
public class Base
{
   static WebDriver driver;
   static Logger logger;


    public void initializeDriver(String browser) throws MalformedURLException {

        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            desiredCapabilities.setBrowserName("firefox");
        } else  {
            WebDriverManager.chromedriver().setup();
            desiredCapabilities.setBrowserName("chrome");
        }

           //

            desiredCapabilities.setPlatform(Platform.WINDOWS);
            desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
           driver=new RemoteWebDriver(new URL("http://192.168.1.5:4444"),desiredCapabilities);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get("https://www.swiggy.com/");


    }

    public void tearDownDriver(){
        driver.close();
    }



    public void initializeLogger(String testName){
        logger= LogManager.getLogger(testName);
    }
}
