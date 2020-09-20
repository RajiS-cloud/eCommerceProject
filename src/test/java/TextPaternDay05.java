/*

1. Setup  - Open Browser Operation
2. Login  - Loginto the page
3. Close  - Quit / Close Browser

*/


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;


public class TextPaternDay05 {

    WebDriver firefoxDriver;


        // @BeforeTest
        @Test(priority=1)

        void setup() {
            firefoxDriver = BaseSetUp.getDriver("firefox");
            System.out.println(" Test Run 1: Before test<<<Firefox>>>");
        }

        @Test (priority=2)

        void login(){
            System.out.println("  Test Run 2: Test for a Datadriven Login Test");

            try {
                MainLoginPage.LoginFromArrayData(firefoxDriver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("<<<Firefox>>>");

        }

        // @AfterTest

        @Test (priority=3)

        void teardown(){

            System.out.println(" Test Run 3: After test - Close the browser driver");

            firefoxDriver.close();
        }



}
