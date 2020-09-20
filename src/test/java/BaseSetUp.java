import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class BaseSetUp {

    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        if (browserName.toLowerCase().equals("chrome")) {
            String chromDriverPath = Util.CHROME_DRIVER;
            System.setProperty("webdriver.chrome.driver", chromDriverPath);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        else if (browserName.toLowerCase().equals("firefox") ){
            String firefoxDriverPath = Util.GECKO_DRIVER;
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }




}

