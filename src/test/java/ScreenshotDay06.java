//import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.Files;
import org.apache.commons.io.FileUtils;


import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ScreenshotDay06 {

/* Test Script for Day 5
 * In this script we will be using @DataProvider annotation of TestNG
 */

/*

1. Setup  - Open Browser Operation
2. Login  - Loginto the page
3. Capture the Login user ID
4. Use DataProvider data
5. Take Screenshot of the page once logged in
6. Close  - Quit / Close Browser

*/

    WebDriver firefoxDriver;
   // private Files FileUtils;

    /**
     * create test data for testing The test data include set of username,
     * password
     *
     * @return
     */

    @DataProvider(name= "GuruTest")

    public Object[][] testData() {

        Object[] [] data = new Object[4][2];

        // ist Row Username valid  and Password valid

            data[0][0] =Util.USER_NAME;
            data[0][1] =Util.PASSWD;
            System.out.println("TestData 1 - Valid Username and InValid Password ");

        //2nd Row Username invalid  and Password valid

            data[1][0] = "invalid";
            data[1][1] = Util.PASSWD;
            System.out.println("TestData 2 - InValid Username and Valid Password ");

        //3rd Row  Username valid  and Password invalid

            data[2][0] = Util.USER_NAME;
            data[2][1] = "invalid";
            System.out.println("TestData 3 - Valid Username and InValid Password ");

        //4tb Row Username invalid  and Password invalid

            data[3][0] = "invalid";
            data[3][1] = "invalid";
            System.out.println("TestData 4 - InValid Username and InValid Password ");
            return data;

    }


    @BeforeTest
    //@Test(priority=1)

    void setup() {
        firefoxDriver = BaseSetUp.getDriver("firefox");
        System.out.println(" Test Run 1: Before test<<<Firefox>>>");
    }

    @Test(dataProvider = "GuruTest")
    public  void testCase05(String username, String password) throws Exception {
            String actualTitle;
            String actualBoxMsg;
        // Navigate to Home Page
        // HomePage.NavigateToUrl(chromedriver);
            try {
                HomePage.NavigateToUrl(firefoxDriver);
                } catch (Exception e) {
                e.printStackTrace();
        }
        //  Enter a valid UserId
                firefoxDriver.findElement(By.name("uid")).clear();
                firefoxDriver.findElement(By.name("uid")).sendKeys(username);
        // Enter valid Password
                firefoxDriver.findElement(By.name("password")).clear();
                firefoxDriver.findElement(By.name("password")).sendKeys(password);
        // Click Login
                firefoxDriver.findElement(By.name("btnLogin")).click();

                try{

                    Alert alt = firefoxDriver.switchTo().alert();
                    actualBoxMsg = alt.getText(); // get content of the Alter Message
                    alt.accept();
            // Compare Error Text with Expected Error Value
                    assertEquals(actualBoxMsg,Util.EXPECT_ERROR);
                }
                catch (NoAlertPresentException Ex){

            // Get text displays on login page
                    System.out.println("Valid Username : " + username);
                    System.out.println("Valid Password: " + password);
                    String pageText = firefoxDriver.findElement(By.tagName("tbody")).getText();

            // Extract the dynamic text mngrXXXX on page
                    String[] parts = pageText.split(Util.PATTERN);
                    String dynamicText = parts[1]; System.out.println("Display the Dynamic text: " + dynamicText);
                    System.out.println("Display the Dynamic Substring  text: " + dynamicText.substring(1, 5));
                    System.out.println("Display the Dynamic Substring  text: " + dynamicText.substring(1, 4));
                    System.out.println("Display the Dynamic Substring  text: " + dynamicText.substring(1, 3));
                    System.out.println("Display the Dynamic Substring  text: " + dynamicText.substring(1, 6));

            // Check that the dynamic text is of pattern mngrXXXX
            // First 4 characters must be "mngr"
                    assertTrue(dynamicText.substring(1, 5).equals(Util.FIRST_PATTERN));
                    System.out.println("Remaim matches the First patern:  mngr ");

            // remain stores the "XXXXXX" in pattern mngrXXXXXX
                    System.out.println("Display the total length of dynamic text:  " + dynamicText.length() );
                    String remain = dynamicText.substring(dynamicText.length() - 6);
                    System.out.println("Display the Remaining text or numeric value: " + remain);

            // Check remain string must be numbers;
                    assertTrue(remain.matches(Util.SECOND_PATTERN));
                    System.out.println("Remaim matches the second patern [0-9]");
                    Thread.sleep(500);

            // Code to take Screenshot
                    System.out.println("Take Screenshot");
                    File scrFile = ((TakesScreenshot)firefoxDriver).getScreenshotAs(OutputType.FILE);
                    Thread.sleep(300);
                    System.out.println("Screenshot exists >>>>>" + scrFile);
                    scrFile.exists();

            // Code to save screenshot at desired location
            //        D:\Raji_Selenium\Day03\target


                    FileUtils.copyFile(scrFile, new File("D:\\Raji_Selenium\\screenshot.png"));




                }


    }


    /* @Test (priority=2)

        void login(){
            System.out.println("  Test Run 2: Test for a Datadriven Login Test");

         try {
             MainLoginPage.LoginFromArrayData(firefoxDriver);
         } catch (Exception e) {
             e.printStackTrace();
         }
         System.out.println("<<<Firefox>>>");
     }
 */
    @AfterTest
    // @Test (priority=3)
        void teardown(){
            System.out.println(" Test Run 3: After test - Close the browser driver");
            firefoxDriver.close();
        }
    }
