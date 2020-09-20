import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class HomePage {

    /*
     * Time to create a more professional Script
     * 1) All parameters will will be saved in File Util.java - Helps in easy code maintenance
     * 2) We will move the code to launch Webdriver in a separate method as SetUp. Helps in code understanding
     */

    // BaseSetup base = new BaseSetup();
    // WebDriver driver = base.getDriver("chrome"); // Selenium control driver
    private static String BASE_URL; // baseUrl of Website Guru99

    // This method SetUp will read initialization parameters from the class Util.java & launch Firefox

    public static void NavigateToUrl(WebDriver driver) throws Exception {

        // WebDriver firefoxDriver = BaseSetup.getDriver("firefox");
        /*
         * Tells the Selenium client library to connect to the Webdriver
         * service using firefox
         *
         * In some PC's, Selenium can not find the binary file of Firefox because
         * user doesn't install Firefox at its default location. We need to tell
         * Selenium where the firefox.exe is
         */
        //File pathToBinary = new File(Utils.FIREFOX_PATH);
        // FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);

        /*
         * Create new firefoxProfile for Testing
         *
         * A profile in Firefox is a collection of bookmarks, browser settings,
         * extensions, passwords, and history; in short, all of your personal
         * settings. Firefox uses a DEFAULT profile to store all of your
         * personal settings.
         *
         * In this case, we use Firefox for "testing" purpose not as an "end user".
         * We need to create NEW firefoxProfile because we want to separate the
         * Firefox profile for testing purpose and that of an end user. If
         * something wrong happens with the testing, you still have your DEFAULT
         * profile to fall back to (your personal data still safe).
         */
        //FirefoxProfile firefoxProfile = new FirefoxProfile();
        // driver = new FirefoxDriver();

        // Setting Base URL of website Guru99
        BASE_URL = Util.BASE_URL;
        // Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
        // Refer - http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html
        // driver.manage().timeouts()
        //   .implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
        // Go to http://www.demo.guru99.com/V4/
        driver.get(BASE_URL + "/V4/");


    }

}



